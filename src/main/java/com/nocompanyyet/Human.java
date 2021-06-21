package com.nocompanyyet;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Human extends Player {
    public Human(String name) {
        super(name);
    }

    public Integer requestCard(State state) {
        Scanner scn = new Scanner(System.in);
        Integer card = null;
        System.out.println("Your turn: ");
        try {
            card = scn.nextInt();
            if(!this.getOwnDeck().contains(card))
                throw new NoSuchElementException();
        }
        catch (NoSuchElementException e1) {
            card = handleWrongCardInputException(card);
        }
        this.getOwnDeck().remove(card);
        return card;
    }

    private Integer handleWrongCardInputException(Integer card) {
        Scanner scn = new Scanner(System.in);
        while(!this.getOwnDeck().contains(card)) {
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
}
