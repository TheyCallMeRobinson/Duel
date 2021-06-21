package service;

import com.nocompanyyet.asset.Card;
import player.Player;

import java.util.Scanner;

// simple handlers for exceptions that may be (or may be not) detected throw program process
public class ExceptionHandlingService {
    // warn player about the mistake and offer him another try until he enters a correct value
    public static Card handleWrongCardInputException(Player player, Card card) {
        Scanner scn = new Scanner(System.in);
        while(!player.getOwnDeck().contains(card)) {
            System.err.println("There's no such card in your deck! Please, try again: ");
            try {
                Integer temp = scn.nextInt();
                card.setValue(temp);
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
