import javax.swing.*;
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


        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(2000,2000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BlackJack");

        deck = new Deck();
        deck.shuffle();
        playerHand = new Hand(deck);
        houseHand = new Hand(deck);
        houseHand.hideCard();
        play();
    }

    public void hit()  {
        playerHand.addCard();
        playerPoints = playerHand.getPoints();
        if (playerPoints <= 11 && playerHand.hasAce) {
            playerPoints += 10;
            System.out.println("You now have the cards :" + playerHand + " and have " + playerPoints + " points!");
        }
        else if (playerPoints > 21) {
            System.out.println("You now have the cards :" + playerHand + " and have " + playerPoints + " points!");
            System.out.println("Player has busted!");
            playerHand.clear();
            houseHand.clear();
        }
        else if (playerPoints <= 21) {
            System.out.println("You now have the cards :" + playerHand + " and have " + playerHand.getPoints() + " points!");
        }
    }

    public void stay()  {
        playerPoints = playerHand.getPoints();
        houseHand.showCard();
        housePoints = houseHand.getPoints();
        if (housePoints >= playerPoints) {
            System.out.println("The house has the cards: " + houseHand + " and has " + houseHand.getPoints() + " points!");
            System.out.println("The house has won the game!");
        }
        while (housePoints < playerPoints)  {
            houseHand.addCard();
            housePoints = houseHand.getPoints();
           if (housePoints <= 11 && houseHand.hasAce) {
                housePoints += 10;
                System.out.println("The house, now has the cards: " + houseHand + " and has " + houseHand.getPoints() + " points!");
            }
           else if (housePoints > 21) {
                System.out.println("The house, now has the cards: " + houseHand + "and has busted " + "with " + houseHand.getPoints());
                System.out.println("You have won the game!");
                playerHand.clear();
                houseHand.clear();
                break;

            }
           else if (housePoints >= playerPoints) {
                System.out.println("The house, now has the cards: " + houseHand + " and has " + houseHand.getPoints() + " points!");
                System.out.println("The house has won the game!");
                playerHand.clear();
                houseHand.clear();
                break;
            }
        }
    }

    public void play() throws IOException {
        playerPoints = playerHand.getPoints();
        housePoints = houseHand.getPoints();
        if (playerHand.hasAce && playerPoints <= 11) {
            playerPoints = playerPoints + 10;
        }
        if (houseHand.hasAce && housePoints <= 11) {
            housePoints = housePoints + 10;
        }
        System.out.println("The house has the cards :" + houseHand + " and has " + housePoints + " points!");
        System.out.println("You have the cards :" + playerHand + " and have " + playerPoints + " points!");
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
