public class Compare {

    static class Card implements Comparable<Card>{
        public String rank;
        public String suit;

        public Card(String rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }

        @Override
        //比较四步走
        public boolean equals(Object obj) {
            //看看this和obj的身份是否相同
            if(this == obj) {
                return true;
            }
            //如果obj为null，肯定不相等
            if(obj == null) {
                return false;
            }
            //obj是否可以强转
            if(!(obj instanceof Card)) {
                return false;
            }
            //类型转换，把参数转化成Card类型
            Card x = (Card) obj;
            return this.rank.equals(x.rank);
        }

        @Override
        public int compareTo(Card o) {
            return this.convertRank() - o.convertRank();
        }

        public int convertRank(){
            if("A".equals(rank)) {
                return 14;
            }
            if("K".equals(rank)) {
                return 13;
            }
            if("Q".equals(rank)) {
                return 12;
            }
            if("J".equals(rank)) {
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

    public static void main(String[] args) {
        Card card1 = new Card("A","♥");
        Card card2 = new Card("K","黑桃");


    }



}
