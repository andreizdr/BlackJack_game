import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
        private Deck deck;
        private Hand playerHand;
        private Hand houseHand;
        private static int playerPoints;
        private static int housePoints;



    public Game() throws IOException {
        deck = new Deck();
        deck.shuffle();
        playerHand = new Hand(deck);
        houseHand = new Hand(deck);
        houseHand.hideCard();
        play();
    }

    public void hit() {
        playerHand.addCard();
        System.out.println("You now have the cards :" + playerHand + " and have " + playerHand.getPoints() + " points!");
        playerPoints = playerHand.getPoints();
        if (playerHand.getPoints() > 21) {
            System.out.println("Player has busted!");
            playerHand.clear();
            houseHand.clear();
        }
    }

    public void stay() {
        playerPoints = playerHand.getPoints();
        houseHand.showCard();
        housePoints = houseHand.getPoints();
        while (housePoints < playerPoints) {
            houseHand.addCard();
            housePoints = houseHand.getPoints();
            if (housePoints > 21) {
                System.out.println("The house, now has the cards: " + houseHand + "and has busted " + "with " + houseHand.getPoints());
                System.out.println("You have won the game!");
                playerHand.clear();
                houseHand.clear();
                break;
            }
            else if (housePoints > playerPoints) {
                System.out.println("The house, now has the cards: " + houseHand + " and has " + houseHand.getPoints() + " points!");
                System.out.println("The house has won the game!");
                playerHand.clear();
                houseHand.clear();
                break;
            }
        }
        if (housePoints > playerPoints && housePoints < 21) {
            System.out.println("The house has the cards: " + houseHand + "and has " + houseHand.getPoints() + " points!");
            System.out.println("The house has won the game!");   // To ask why does this not execute before the while
            playerHand.clear();
            houseHand.clear();
        }
    }

   public void play() throws IOException {
        System.out.println("The house has the cards :" + houseHand + " and has " + houseHand.getPoints() + " points!");
        System.out.println("You have the cards :" + playerHand + " and have " + playerHand.getPoints() + " points!");
        System.out.println("What is your choice?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = reader.readLine();
            if (s.equals("Hit")) {
                hit();
            }
            else if (s.equals("Stay")) {
                stay();
                break;
            }

            else {
                System.out.println("Please enter a valid choice!");
            }
        }
    }
}