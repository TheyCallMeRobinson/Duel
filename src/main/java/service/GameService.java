package service;

import com.nocompanyyet.Player;

import java.util.ArrayList;

public class GameService {

    public static void createNewGame(Player first, Player second) {
        first.setScore(0);
        second.setScore(0);
        fillDeck(first);
        fillDeck(second);
        gameCycle(first, second);
    }

    public static void gameCycle(Player attacking, Player defending) {
        while (attacking.getOwnDeck().size() > 0 && defending.getOwnDeck().size() > 0) {
            Integer attack = -1;
            Integer defend = -1;
            try {
                attack = attacking.requestCard();
                defend = defending.requestCard();
            }
            catch (Exception ignored) {}
            defending.setScore(defending.getScore() + Math.max(attack - defend, 0));
            printCurrentMove(attacking, defending, attack, defend);
            Player temp = attacking;
            attacking = defending;
            defending = temp;
        }
    }

    private static void printCurrentMove(Player attacking, Player defending, Integer attackersCard, Integer defendersCard) {
        System.out.println("Attack points: " + attackersCard);
        System.out.println("Defend points: " + defendersCard);
        System.out.println("Attacker's deck: ");
        for (Integer i: attacking.getOwnDeck())
            System.out.print(i + " ");
        System.out.println("\nDefender's deck: ");
        for (Integer i: defending.getOwnDeck())
            System.out.print(i + " ");
        System.out.println("\n");
    }

    private static void fillDeck(Player player) {
        player.setOwnDeck(new ArrayList<>());
        player.setKnownOpponentDeck(new ArrayList<>());
        for(int i = 0; i < 12; i++) {
            player.getOwnDeck().add(i);
            player.getKnownOpponentDeck().add(i);
        }
    }

    private static void swapPlayers(Player attacking, Player defending) {

    }
}
