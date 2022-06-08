import java.util.HashMap;

public class Card {

    String name;
    String type;
    HashMap<String , Integer> values;

    public Card(String name, String type, HashMap values) {
        this.name = name;
        this.type = type;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public HashMap<String, Integer> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return getType() + ' '+getName();
    }
}
