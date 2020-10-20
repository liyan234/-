import java.util.*;

public class Poker {

    static class Card {
        public String suit;//花色
        public String num;//数字值

        public Card(String suit, String num) {
            this.suit = suit;
            this.num = num;
        }

        @Override
        public String toString() {
            return "("+ suit + " " + num +")";
        }
    }

    //构建一副牌
    public static List<Card> buyPoker() {
        String[] suits = {"♥","♣","♦","♠"};

        List<Card> poker = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            poker.add(new Card(suits[i],"A"));
            for (int j = 2; j < 11 ; j++) {
                Card card = new Card(suits[i],String.valueOf(j));
                poker.add(card);
            }
            poker.add(new Card(suits[i],"j"));
            poker.add(new Card(suits[i],"Q"));
            poker.add(new Card(suits[i],"K"));
        }
        return poker;
    }

    public static void shuffle(List<Card> poker) {
        Random random = new Random();
        for(int i = poker.size() - 1; i > 0; i--) {
            int j = random.nextInt(i);
            swap(poker,i,j);
        }
    }

    private static void swap(List<Card> card ,int i ,int j) {
        Card tmp = card.get(i);
        card.set(i,card.get(j));
        card.set(j,tmp);
    }


    public static void main(String[] args) {
        List<Card> poker = buyPoker();
        System.out.println(poker);
        //洗牌
        //shuffle(poker);
        Collections.shuffle(poker);
        System.out.println("=======================");
        System.out.println(poker);

        ArrayList<ArrayList<Card>> players = new ArrayList<>();

        ArrayList<Card> p1 = new ArrayList<>();//三个玩家
        ArrayList<Card> p2 = new ArrayList<>();
        ArrayList<Card> p3 = new ArrayList<>();

        players.add(p1);//加入到这个顺序表中
        players.add(p2);
        players.add(p3);

        for(int i = 0; i < 5; i++) {//一人发发五张牌
            for (int j = 0; j < 3; j++) {//三个玩家
                Card firstCard = poker.remove(0);//去除牌顶上的牌
                players.get(j).add(firstCard);//第j个玩家获得牌
            }
        }
        System.out.println();
        System.out.print("玩家1:");
        System.out.println(players.get(0));
        System.out.print("玩家2:");
        System.out.println(players.get(1));
        System.out.print("玩家3:");
        System.out.println(players.get(2));
    }
}
