import java.util.*;

class Card {
    public String rank;
    public String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int convertRank() {

        if ("A".equals(rank)) {
            return 14;
        }
        if ("K".equals(rank)) {
            return 13;
        }
        if ("Q".equals(rank)) {
            return 12;
        }
        if ("J".equals(rank)) {
            return 11;
        }
        return Integer.parseInt(rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}


public class CompareTwo {
    private static Object CardComparator;

    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("A", "红桃"));
        cards.add(new Card("J", "红桃"));
        cards.add(new Card("K", "红桃"));
        cards.add(new Card("10", "红桃"));


        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o2.convertRank() - o1.convertRank();
            }
        });
        System.out.println(cards);
    }

}
