import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

abstract class Deck {

    private List<Card> DecksCards;
    private List<Card> DisposePile;
    public Deck(){
        this.DecksCards = new ArrayList<>();
        this.DisposePile = new ArrayList<>();
    }
    protected void Shuffle(){
        int max = this.DecksCards.size();
        int swaptimes = ThreadLocalRandom.current().nextInt(max*100, max*150);
        for(int i = 0; i<=swaptimes; i++) {
            int thesisA = ThreadLocalRandom.current().nextInt(0, max);
            int thesisb = ThreadLocalRandom.current().nextInt(0, max);
            Collections.swap(this.DecksCards, thesisA,thesisb);
        }
    }


    protected void Merge(Deck d){
        this.DecksCards.addAll(d.DecksCards);
    }

    protected Card DrawCard(){
        Card c = this.DecksCards.remove(0);
        this.DisposePile.add(c);
        return c;
    }

    protected void AddtoDeck(Card card){
        this.DecksCards.add(card);
    }

    protected Integer size(){
        return this.DecksCards.size();
    }

    protected void ResetDeck(){
        this.DecksCards.addAll(this.DisposePile);
    }

    abstract public void CreateDeck();
}
