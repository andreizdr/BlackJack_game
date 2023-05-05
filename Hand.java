import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();
    Deck deck;
    int points = 0;
    public Hand() {
        for (int i = 0; i < 2; i++) {      // Hand is being populated
           cards.add(deck.draw());
        }
    }

    public void addCard() {             // Add a card to the desired hand
        cards.add(deck.draw());
    }

    public int getPoints() {            // Calculate points of each hand
        for (int i = 0; i < cards.size(); i++) {
            points += cards.get(i).getRank();
        }
        return points;
    }
}
