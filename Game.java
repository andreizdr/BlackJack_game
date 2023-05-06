
public class Game {
        private Deck deck;
        private Hand playerHand;
        private Hand houseHand;


    public Game() {
        deck = new Deck();
        deck.shuffle();
        playerHand = new Hand(deck);
        houseHand = new Hand(deck);
        System.out.println(playerHand);  // Just for testing purposes
        System.out.println(houseHand);   // Just for testing purposes
    }
}