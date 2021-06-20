package com.nocompanyyet;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Human extends Player {
    public Integer requestCard() {
        Scanner scn = new Scanner(System.in);
        Integer card = null;
        System.out.println("Your choice: ");
        try {
            card = scn.nextInt();
            if(!this.getOwnDeck().contains(card))
                throw new NoSuchElementException();
        }
        catch (NoSuchElementException e1) {
            card = handleWrongCardInputException(card);
        }
        System.out.println("You made your choice");
        return card;
    }

    private Integer handleWrongCardInputException(Integer card) {
        Scanner scn = new Scanner(System.in);
        while(!this.getOwnDeck().contains(card)) {
            System.err.println("There's no such card in your deck! Try again: ");
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
}
