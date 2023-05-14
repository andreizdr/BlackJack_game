import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();
    Deck deck;
    int tempPoints = 0;
    int points = 0;
    boolean hasAce;
    public Hand(Deck deck) {
        this.deck = deck;
        for (int i = 0; i < 2; i++) {      // Hand is being populated
           cards.add(this.deck.draw());
        }
    }

    public void addCard() {             // Add a card to the desired hand

        cards.add(deck.draw());
    }
    public void hideCard() {
        cards.get(0).isFaceDown = true;
    }

    public void showCard() {
        cards.get(0).isFaceDown = false;
    }

    public int getPoints() {            // Calculate points of each hand
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).rank.equals(Rank.ACE)) {
                hasAce = true;
            }
            if (!cards.get(i).isFaceDown) {
                tempPoints += cards.get(i).getRank();
            }
        }
        points = tempPoints;
        tempPoints = 0;
        return points;
    }

    public void clear() {               // Clearing the hand after game is over
        cards.clear();
        points = 0;
    }

    @Override
    public String toString() {
        String str = "";
        for (Card card : cards) {
            str += card.rank.getRankName() + " " + "of" + " " + card.suit.getSuit() + " ";
        }
        return str;
    }
}
