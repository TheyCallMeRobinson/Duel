package com.nocompanyyet;

import java.util.List;

public abstract class Player {
    protected Integer score = 0;
    protected List<Integer> ownDeck;
    protected List<Integer> knownOpponentDeck;

    public abstract Integer requestCard() throws Exception;

    public void setScore(Integer score) {
        this.score = score;
    }
    public void setOwnDeck(List<Integer> ownDeck) {
        this.ownDeck = ownDeck;
    }
    public void setKnownOpponentDeck(List<Integer> knownOpponentDeck) {
        this.knownOpponentDeck = knownOpponentDeck;
    }
    public Integer getScore() {
        return score;
    }
    public List<Integer> getOwnDeck() {
        return ownDeck;
    }
    public List<Integer> getKnownOpponentDeck() {
        return knownOpponentDeck;
    }
}
