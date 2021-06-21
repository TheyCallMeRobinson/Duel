package player.ai;

import com.nocompanyyet.asset.BotNames;
import com.nocompanyyet.asset.Card;
import com.nocompanyyet.asset.State;
import player.Player;

public class BotEasy extends Player {
    public BotEasy() {
        this.name = BotNames.EASY_AI.get((int)(BotNames.EASY_AI.size() * Math.random()));
    }

    public Card requestCard(State state) {
        Card card = ownDeck.get(ownDeck.size() - 1);
        System.out.printf("%s made his move\n", name);
        return card;
    }
}
