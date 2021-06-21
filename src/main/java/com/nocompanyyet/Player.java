package com.nocompanyyet;

import java.util.List;

public abstract class Player {
    protected String name;
    protected Integer ownScore = 0;
    protected Integer opponentScore = 0;
    protected List<Integer> ownDeck;
    protected List<Integer> knownOpponentDeck;

    public Player(String name) {
        this.name = name;
    }

    public abstract Integer requestCard(State state);



    public void setOwnScore(Integer ownScore) {
        this.ownScore = ownScore;
    }
    public void setOwnDeck(List<Integer> ownDeck) {
        this.ownDeck = ownDeck;
    }
    public void setKnownOpponentDeck(List<Integer> knownOpponentDeck) {
        this.knownOpponentDeck = knownOpponentDeck;
    }
    public Integer getOwnScore() {
        return ownScore;
    }
    public List<Integer> getOwnDeck() {
        return ownDeck;
    }
    public List<Integer> getKnownOpponentDeck() {
        return knownOpponentDeck;
    }
    public String getName() {
        return name;
    }
}
