package service;

import com.nocompanyyet.asset.Card;
import player.Player;

import java.io.IOException;
import java.util.Scanner;

public class IOService {
    // I pass this method a text variable to print who's deck have printed now
    public static void printPlayerDeck(String text, Player player) {
        System.out.println(text);
        for (Card i: player.getOwnDeck())
            System.out.print(i.getValue() + " ");
        System.out.println();
    }

    public static void printCurrentMove(Player attacking, Player defending, Card attackersCard, Card defendersCard) {
        System.out.println("Attack points: " + attackersCard.getValue());
        System.out.println("Defend points: " + defendersCard.getValue());
        printPlayerDeck("Attacker's deck: ", attacking);
        printPlayerDeck("Defender's deck: ", defending);
        System.out.printf("%s's score: %d\n", attacking.getName(), attacking.getOwnScore());
        System.out.printf("%s's score: %d\n", defending.getName(), defending.getOwnScore());
        System.out.println("\n");
    }

    public static void printFinalScores(Player first, Player second) {
        if (first.getOwnScore() < second.getOwnScore())
            System.out.printf("The winner is %s with final score of: %d", first.getName(), first.getOwnScore());
        else if (first.getOwnScore() > second.getOwnScore())
            System.out.printf("The winner is %s with final score of: %d", second.getName(), second.getOwnScore());
        else
            System.out.println("Tie");
    }

    public static String requestPlayerName() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your name: ");
        return scn.nextLine();
    }

    public static Integer requestPlayerType(String text) {
        Scanner scn = new Scanner(System.in);
        Integer playerType = -1;
        System.out.printf(
                "Enter number to place this player as %s:\n" +
                "1) Easy AI\n" +
                "2) Medium AI\n" +
                "3) Hard AI\n" +
                "4) Human player\n", text
        );
        try {
            playerType = scn.nextInt();
            if(!(playerType >= 1 && playerType <= 4))
                throw new IOException();
        }
        catch(Exception e) {
            playerType = ExceptionHandlingService.handleWrongIntegerInputException(playerType, 1, 4);
        }
        return playerType;
    }
}
