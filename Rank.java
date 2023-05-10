public enum Rank {
    ACE(11,"Ace"), TWO(2,"Two"), THREE(3,"Three"), FOUR(4,"Four"),
    FIVE(5,"Five"), SIX(6,"Six"), SEVEN(7,"Seven"), EIGHT(8,"Eight"),
    NINE(9,"Nine"), TEN(10,"Ten"), JACK(10,"Jack"),
    QUEEN(10,"Queen"), KING(10,"King");

    private  int value;
    private final String name;

    Rank(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getRank() {

        return value;
    }

    public String getRankName() {
        return name;
    }

    public void setAceValue() {
        this.value = 1;
    }
}
