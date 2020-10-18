public class MyStackTwo {
    static class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
        public Node() {

        }
    }

    Node head = new Node();

    public void push(int data) {

        Node cur = new Node(data);
        if(this.head == null) {
            this.head = cur;
            return;
        }
        cur.next = this.head;
        this.head = cur;
    }

    public Integer pop() {

        Node node = new Node();
        node = this.head;
        if (node == null) {
            return null;
        }
        this.head = this.head.next;
        return node.val;
    }

    public Integer peek() {
        Node node = new Node();
        if (this.head == null) {
            return null;
        }
        node = this.head;
        return node.val;
    }

    public boolean empty() {
        if(this.head == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyStackTwo stackTwo = new MyStackTwo();
        stackTwo.push(1);
        stackTwo.push(2);
        stackTwo.push(3);
        stackTwo.push(4);
        stackTwo.push(5);

        while(true) {
            Integer cur = stackTwo.pop();
            if(cur == null){
                break;
            }
            System.out.println(cur);
        }
    }

}
