package com.nocompanyyet;

public class Bot extends Player {
    public Bot(String name) {
        super(name);
    }

    /*
        My bot game tactic is based on probability of possible chance of opponent usage of a certain card.
        So when being attacked, AI tries to predict opponent card by linear probability density for each card in his
        deck, this corresponds to card's value like this:
        the junior card gets the least % of appearing and the high card gets the most % of appearing,
        and so he gets some quadratic probability distribution, and from that it can predict the most probable card
        opponent would use in current case;
        That way AI gets some card and tries to pick the best available card for protection.
        Almost the same tactic goes when AI attacks, but from now it can think that the opponent wouldn't use it's
        junior cards for the cause of not getting any extra penalty points, so probability density is 0% for each card
        that lays below the middle of the deck and then probability density starts growing linearly just as in previous
        case;
        So he gets some card that opponent would probably use to defend himself and then AI gets the most suitable card
        for his attack
     */

    public Integer requestCard(State state) {
        Integer card = this.getOwnDeck().get(0);

        if(state == State.ATTACKING) {
            Integer opponentCard = predictPossibleOpponentDefence();
            if(this.ownScore > this.opponentScore || this.getOwnDeck().get(this.getOwnDeck().size() - 1) < opponentCard) {
                card = this.getOwnDeck().get(0);
            }
            else {
                for(Integer bestCard : this.getOwnDeck()) {
                    if(bestCard > opponentCard) {
                        card = bestCard;
                        break;
                    }
                }
            }
        }
        else {
            Integer opponentCard = predictPossibleOpponentAttack();
            if(this.ownScore > this.opponentScore) {
                int difference = this.ownScore - this.opponentScore;
                for(Integer bestCard : this.getOwnDeck()) {
                    if(bestCard + difference > opponentCard) {
                        card = bestCard;
                        break;
                    }
                }
            }
            else  {
                card = this.getOwnDeck().get(this.getOwnDeck().size() - 1);
            }
        }
        ownDeck.remove(card);
        System.out.printf("%s made his move\n", name);
        return card;
    }

    private Integer predictPossibleOpponentDefence() {
        int halfDeckSize = knownOpponentDeck.size() / 2;
        int predictedPositionOfCard = (int)Math.sqrt(Math.random() * halfDeckSize * halfDeckSize);
        return knownOpponentDeck.get(halfDeckSize + predictedPositionOfCard);
    }

    // quadratic probability distribution
    private Integer predictPossibleOpponentAttack() {
        int predictedPositionOfCard = (int)Math.sqrt(Math.random() * knownOpponentDeck.size() * knownOpponentDeck.size());
        return knownOpponentDeck.get(predictedPositionOfCard);
    }
}
