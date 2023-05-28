import javax.swing.ImageIcon;

public class Card {
        Rank rank;
        Suit suit;
        boolean isFaceDown;
        String imagePath;
        ImageIcon image;


        public Card(Rank rank, Suit suit, String imagePath) {
            this.rank = rank;
            this.suit = suit;
            this.imagePath = imagePath;
            this.image = new ImageIcon(imagePath);
        }

        public int getRank() {
            return rank.getRank();
        }

        @Override
        public String toString() {
            String str = rank.getRankName() + " " + "of" + " " + suit.getSuit();
            return str;
        }
    }
