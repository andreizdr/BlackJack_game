import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
     private ArrayList<Card> deck = new ArrayList<>(52);
    Card card;

    // Constructor
    public Deck() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                card = new Card(rank, suit);
                deck.add(card);
            }
        }
    }
    // Deck shuffling
    public ArrayList<Card> shuffle() {
        Collections.shuffle(deck);
        return deck;
    }
    // Deck card draw
    public Card draw() {
        Random rand = new Random();
        int index = rand.nextInt(deck.size());
        Card randomCard = deck.get(index);
        deck.remove(randomCard);
        return randomCard;
    }
}
