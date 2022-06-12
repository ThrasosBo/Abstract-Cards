public class Dealer {
    String name;
    GamingHand hand;

    public Dealer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GamingHand getHand() {
        return hand;
    }

    public void setHand(GamingHand hand) {
        this.hand = hand;
    }
}
