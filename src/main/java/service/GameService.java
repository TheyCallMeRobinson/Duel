package service;

import com.nocompanyyet.asset.Pair;
import player.Human;
import player.Player;
import com.nocompanyyet.asset.State;
import player.ai.BotEasy;
import player.ai.BotHard;
import player.ai.BotMedium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class GameService {
    public static void createNewGame() {
        Player first, second;
        Pair<Player> pair = choosePlayers();
        first = pair.getFirst();
        second = pair.getSecond();
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
            IOService.printCurrentMove(attacking, defending, attack, defend);
            attacking.getOwnDeck().remove(attack);
            defending.getOwnDeck().remove(defend);
            attacking.getKnownOpponentDeck().remove(defend);
            defending.getKnownOpponentDeck().remove(attack);
            Player temp = attacking;
            attacking = defending;
            defending = temp;
        }
        IOService.printFinalScores(attacking, defending);
    }

    private static void fillDeck(Player player) {
        player.setOwnDeck(new ArrayList<>());
        player.setKnownOpponentDeck(new ArrayList<>());
        for(int i = 0; i < 12; i++) {
            player.getOwnDeck().add(i);
            player.getKnownOpponentDeck().add(i);
        }
    }

    private static Pair<Player> choosePlayers() {
        Integer firstPlayerType = IOService.requestPlayerType("first");
        Integer secondPlayerType = IOService.requestPlayerType("second");
        Pair<Player> pair = new Pair<>();
        switch (firstPlayerType){
            case 1:
                pair.setFirst(new BotEasy());
                break;
            case 2:
                pair.setFirst(new BotMedium());
                break;
            case 3:
                pair.setFirst(new BotHard());
                break;
            case 4:
                pair.setFirst(new Human());
                break;
        }
        switch (secondPlayerType) {
            case 1:
                pair.setSecond(new BotEasy());
                break;
            case 2:
                pair.setSecond(new BotMedium());
                break;
            case 3:
                pair.setSecond(new BotHard());
                break;
            case 4:
                pair.setSecond(new Human());
                break;
        }
        return pair;
    }
}
