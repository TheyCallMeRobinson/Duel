package player;

import com.nocompanyyet.asset.State;
import service.ExceptionHandlingService;
import service.IOService;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Human extends Player {
    public Human() {
        this.name = IOService.requestPlayerName();
    }

    public Integer requestCard(State state) {
        Scanner scn = new Scanner(System.in);
        Integer card = null;
        System.out.printf("%s's turn:\n", this.name);
        try {
            card = scn.nextInt();
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
