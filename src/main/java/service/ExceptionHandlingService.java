package service;

import player.Player;

import java.util.Scanner;

public class ExceptionHandlingService {
    public static Integer handleWrongCardInputException(Player player, Integer card) {
        Scanner scn = new Scanner(System.in);
        while(!player.getOwnDeck().contains(card)) {
            System.err.println("There's no such card in your deck! Please, try again: ");
            try {
                card = scn.nextInt();
            }
            catch(Exception ignored) {
                // clear error buffer and flush input
                scn.nextLine();
            }
        }
        return card;
    }

    public static Integer handleWrongIntegerInputException(Integer result, Integer lowerBorder, Integer upperBorder) {
        Scanner scn = new Scanner(System.in);
        while(result < lowerBorder || result > upperBorder) {
            System.err.println("There's no such item in this list! Please, try again: ");
            try {
                result = scn.nextInt();
            }
            catch(Exception ignored) {
                // clear error buffer and flush input
                scn.nextLine();
            }
        }
        return result;
    }
}
