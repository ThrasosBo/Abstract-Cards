import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    private int numofplayers;
    private int ppoints;
    private ArrayList<PLayer> players;
    private SolitaireDeck deck;

    Dealer dealer;

    public BlackJack(int numofplayers, int ppoints) {
        this.numofplayers = numofplayers;
        this.ppoints = ppoints;
        this.players = new ArrayList<PLayer>();
        this.CreatePlayers();
        this.dealer = new Dealer("Dealer");
        this.deck = new SolitaireDeck();

    }

    private void CreatePlayers() {
        for (int i = 0; i < numofplayers; i++) {
            System.out.println("Player Name:");
            Scanner scanner = new Scanner(System.in);
            String p = scanner.nextLine();
            this.players.add(new PLayer(p, this.ppoints));
        }
    }

    public void setRound() {
        this.deck.ResetDeck();
        this.deck.CreateDeck();
        this.deck.Shuffle();
        for (int i = 0; i < numofplayers; i++) {
            System.out.println("Add bet:");
            Scanner scanner = new Scanner(System.in);
            int co = scanner.nextInt();
            PLayer p = this.players.get(i);
            p.setHand(new GamingHand(co));
            p.hand.GetCard(this.deck.DrawCard());
            System.out.printf("player: %s has total of: %d\n", p.name, p.hand.getSum());
            p.hand.flashCards();
        }
        this.dealer.setHand(new GamingHand(0));
        this.dealer.hand.GetCard(this.deck.DrawCard());
        System.out.printf("player: %s has total of: %d\n", this.dealer.name, this.dealer.hand.getSum());
        this.dealer.getHand().flashCards();
    }

    public void PlayGame() {
        for (int i = 0; i < numofplayers; i++) {
            PLayer p = this.players.get(i);
            boolean flag = true;
            while (flag) {
                Scanner scanner = new Scanner(System.in);
                System.out.printf("Player: %s has a total of: %d", p.getName(), p.getHand().getSum());
                System.out.println("1. Hit\n2. Stop\n");
                int c = scanner.nextInt();
                if (c == 1) {
                    p.getHand().GetCard(this.deck.DrawCard());
                } else {
                    System.out.println("User Passed");
                    flag = false;
                }
            }
        }
        while (this.dealer.getHand().getSum() <= 17) {
            this.dealer.getHand().GetCard(this.deck.DrawCard());
        }
        System.out.println(this.dealer.getHand().getSum());
        for (int i = 0; i < this.numofplayers; i++) {
            PLayer p = this.players.get(i);
            p.getHand().flashCards();
            if(p.getHand().getSum() > this.dealer.getHand().getSum()){

            }
        }
    }
}
