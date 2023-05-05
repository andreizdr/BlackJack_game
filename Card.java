public class Card {
    Rank rank;
    Suit suit;
    boolean isFaceUp;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {

        return rank.getRank();
    }
    public String getRankName() {

        return rank.getRankName();
    }

    @Override
    public String toString() {
        String str = rank.getRankName() + " " + "of" + " " + suit.getSuit();
        return str;
    }
}
