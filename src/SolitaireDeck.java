import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SolitaireDeck extends Deck {
    @Override
    public void CreateDeck() {
    List<String> name = Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K");
    List<String> type = Arrays.asList("Clubs","Diamonds","Hearts","Spades");
    for(int i = 0; i < type.size(); i++){
        for(int j= 0; j < name.size(); j++){
            HashMap<String,Integer> value = new HashMap<>();
            value.put("value", j>10? 10:j+1);
           this.AddtoDeck(new Card(name.get(j),type.get(i),value));
        }
    }
    }
}
