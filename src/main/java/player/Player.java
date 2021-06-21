package player;

import com.nocompanyyet.asset.Card;
import com.nocompanyyet.asset.State;

import java.util.List;
// abstract class for player, which can be any of the bots or the human player himself
public abstract class Player {
    protected String name;
    protected Integer ownScore = 0;
    protected Integer opponentScore = 0;
    protected List<Card> ownDeck;
    protected List<Card> knownOpponentDeck;

    public abstract Card requestCard(State state);

    public void setOwnScore(Integer ownScore) {
        this.ownScore = ownScore;
    }
    public void setOwnDeck(List<Card> ownDeck) {
        this.ownDeck = ownDeck;
    }
    public void setKnownOpponentDeck(List<Card> knownOpponentDeck) {
        this.knownOpponentDeck = knownOpponentDeck;
    }
    public Integer getOwnScore() {
        return ownScore;
    }
    public List<Card> getOwnDeck() {
        return ownDeck;
    }
    public List<Card> getKnownOpponentDeck() {
        return knownOpponentDeck;
    }
    public String getName() {
        return name;
    }
}
