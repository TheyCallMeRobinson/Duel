package player.ai;

import com.nocompanyyet.asset.State;
import player.Player;

public class BotMedium extends Player {
    public BotMedium(String name) {
        super(name);
    }

    public Integer requestCard(State state) {
        Integer card = ownDeck.get((int)(Math.random() * ownDeck.size()));
        System.out.printf("%s made his move\n", name);
        return card;
    }
}
