package player.ai;

import com.nocompanyyet.asset.State;
import player.Player;

public class BotEasy extends Player {
    public BotEasy(String name) {
        super(name);
    }

    public Integer requestCard(State state) {
        Integer card = ownDeck.get(ownDeck.size() - 1);
        System.out.printf("%s made his move\n", name);
        return card;
    }
}
