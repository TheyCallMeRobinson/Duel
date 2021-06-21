package player;

import com.nocompanyyet.asset.Card;
import com.nocompanyyet.asset.State;
import service.ExceptionHandlingService;
import service.IOService;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Human extends Player {
    public Human() {
        this.name = IOService.requestPlayerName();
    }

    // asking human player for his card on current move
    public Card requestCard(State state) {
        Scanner scn = new Scanner(System.in);
        Card card = new Card(-1);
        System.out.printf("%s's turn:\n", this.name);
        // if he's entered some wrong input or non-existing card in his deck, we throw an exception and immediately
        // warn him about the mistake and offer him another try
        try {
            Integer temp = scn.nextInt();
            card.setValue(temp);
            if(!this.getOwnDeck().contains(card))
                throw new NoSuchElementException();
        }
        catch (NoSuchElementException e1) {
            card = ExceptionHandlingService.handleWrongCardInputException(this, card);
        }
        this.getOwnDeck().remove(card);
        return card;
    }
}
