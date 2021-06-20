package com.nocompanyyet;

import java.util.List;

public class Bot extends Player {
    public Integer requestCard() {
        Integer card = ownDeck.get(ownDeck.size() - 1);
        ownDeck.remove(card);
        System.out.println("Player made his choice");
        return card;
    }
}
