package com.nocompanyyet;

public class BotHard extends Player {
    public BotHard(String name) {
        super(name);
    }

    /*
        So, as far as after every move players overturn their used cards, it is possible for AI to "memorise" and
        simulate opponent's card deck, so for the purposes of my algorithm I just made class field called
        'knownOpponentDeck'.
        My AI game tactic is based on probability of possible chance of opponent usage of a certain card.
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
        for his attack.
        It is not the best game tactic against other AIs, but I think it is quite effective against
        human players and their unpredictability.
     */

    public Integer requestCard(State state) {
        // in case we won't find any suitable card, better not to waste a good one
        Integer card = this.getOwnDeck().get(0);
        Integer ownHighCard = this.getOwnDeck().get(this.getOwnDeck().size() - 1);
        Integer opponentHighCard = this.getKnownOpponentDeck().size() > 1 ? this.getKnownOpponentDeck().get(this.getKnownOpponentDeck().size() - 1) : this.getKnownOpponentDeck().get(0);

        if(state == State.ATTACKING) {
            Integer predictedOpponentCard = predictPossibleOpponentDefence();
            if(this.ownScore < this.opponentScore) {
                card = this.getOwnDeck().get(0);
            }
            else {
                Integer differenceInScores = this.ownScore - this.opponentScore;
                for(Integer bestCard : this.getOwnDeck()) {
                    if(bestCard > predictedOpponentCard + differenceInScores) {
                        card = bestCard;
                        break;
                    }
                }
            }
        }
        else {
            Integer predictedOpponentCard = predictPossibleOpponentAttack();
            if(this.ownScore > this.opponentScore) {
                if(ownHighCard > opponentHighCard) {
                    card = ownHighCard;
                } else {
                    for (Integer bestCard : this.getOwnDeck()) {
                        if (bestCard >= predictedOpponentCard) {
                            card = bestCard;
                            break;
                        }
                    }
                }
            }
            else {
                for(Integer bestCard : this.getOwnDeck()) {
                    if(bestCard >= opponentHighCard) {
                        card = bestCard;
                        break;
                    }
                }
            }
        }
        System.out.printf("%s made his move\n", name);
        return card;
    }

    private Integer predictPossibleOpponentDefence() {
        int halfDeckSize = knownOpponentDeck.size() / 2;
        // quadratic probability distribution
        int predictedPositionOfCard = (int)Math.sqrt(Math.random() * halfDeckSize * halfDeckSize);
        return knownOpponentDeck.get(halfDeckSize + predictedPositionOfCard);
    }

    private Integer predictPossibleOpponentAttack() {
        // quadratic probability distribution
        int predictedPositionOfCard = (int)Math.sqrt(Math.random() * knownOpponentDeck.size() * knownOpponentDeck.size());
        return knownOpponentDeck.get(predictedPositionOfCard);
    }
}
