package service;

import com.nocompanyyet.Player;

public class PrintService {
    public static void printPlayerDeck(String text, Player player) {
        System.out.println(text);
        for (Integer i: player.getOwnDeck())
            System.out.print(i + " ");
        System.out.println();
    }

    public static void printCurrentMove(Player attacking, Player defending, Integer attackersCard, Integer defendersCard) {
        System.out.println("Attack points: " + attackersCard);
        System.out.println("Defend points: " + defendersCard);
        printPlayerDeck("Attacker's deck: ", attacking);
        printPlayerDeck("Defender's deck: ", defending);
        System.out.printf("%s's score: %d\n", attacking.getName(), attacking.getOwnScore());
        System.out.printf("%s's score: %d\n", defending.getName(), defending.getOwnScore());
        System.out.println("\n");
    }
}
