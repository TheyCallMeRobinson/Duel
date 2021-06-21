package service;

import com.nocompanyyet.Player;
import com.nocompanyyet.State;

import java.util.ArrayList;

public class GameService {
    public static void createNewGame(Player first, Player second) {
        first.setOwnScore(0);
        second.setOwnScore(0);
        fillDeck(first);
        fillDeck(second);
        gameCycle(first, second);
    }

    public static void gameCycle(Player attacking, Player defending) {
        while (attacking.getOwnDeck().size() > 0 && defending.getOwnDeck().size() > 0) {
            Integer attack = -1;
            Integer defend = -1;
            try {
                attack = attacking.requestCard(State.ATTACKING);
                defend = defending.requestCard(State.DEFENDING);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            defending.setOwnScore(defending.getOwnScore() + Math.max(attack - defend, 0));
            PrintService.printCurrentMove(attacking, defending, attack, defend);
            attacking.getOwnDeck().remove(attack);
            defending.getOwnDeck().remove(defend);
            attacking.setKnownOpponentDeck(defending.getOwnDeck());
            defending.setKnownOpponentDeck(attacking.getOwnDeck());
            Player temp = attacking;
            attacking = defending;
            defending = temp;
        }
        PrintService.printFinalScores(attacking, defending);
    }

    private static void fillDeck(Player player) {
        player.setOwnDeck(new ArrayList<>());
        player.setKnownOpponentDeck(new ArrayList<>());
        for(int i = 0; i < 12; i++) {
            player.getOwnDeck().add(i);
            player.getKnownOpponentDeck().add(i);
        }
    }
}
