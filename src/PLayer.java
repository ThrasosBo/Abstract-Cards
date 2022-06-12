public class PLayer extends Dealer {

    private int money;

    public PLayer(String name, int money) {
        super(name);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    final public void setMoney(int money) {
        this.money = money;
    }

    public void AddWinnings(int wins) {
        this.money += wins;
    }

    public boolean Bet(int bet) {
        if (bet < this.money) {
            return true;
        }else{
            return false;
        }
    }
}
