package player.ai;

import com.nocompanyyet.asset.BotNames;
import com.nocompanyyet.asset.Card;
import com.nocompanyyet.asset.State;
import player.Player;

public class BotMedium extends Player {
    public BotMedium() {
        this.name = BotNames.MEDIUM_AI.get((int)(BotNames.MEDIUM_AI.size() * Math.random()));
    }

    public Card requestCard(State state) {
        Card card = ownDeck.get((int)(Math.random() * ownDeck.size()));
        System.out.printf("%s made his move\n", name);
        return card;
    }
}
