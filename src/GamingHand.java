import java.util.ArrayList;
import java.util.Scanner;

public class GamingHand {
    ArrayList<Card> hand;
    int sum = 0;
    final int pot;

    public GamingHand(int pot) {
        this.pot = pot;
        this.hand = new ArrayList<Card>();
    }

    public void GetCard(Card c){
        if(c.getValues().get("value") == 1){
            System.out.println("value as: \n 1. 1 \n 2. 11\n");
            Scanner scanner = new Scanner(System.in);
            int co = scanner.nextInt();
            this.sum += (co == 1?1:11);
        }
        else{
            this.sum += c.getValues().get("value");
        }
        this.hand.add(c);
    }

    public int getSum() {
        return sum;
    }

    public void flashCards(){
        for(int i = 0; i<hand.size(); i++){
            System.out.println(hand.get(i));
        }
    }
}
