public class MyQueue {
    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
        public Node() {

        }
    }

    Node head = new Node(-1);
    Node tail = head;
    public void offer(int val) {
        Node node = new Node(val);
        this.tail.next = node;
        tail = tail.next;
    }

    public Integer poll() {

        if(this.head.next == null) {
            return null;
        }

        Node node = new Node();
        node = this.head.next;
        this.head.next = node.next;
        if(this.head.next == null) {
            this.tail = this.head;
        }
        return node.val;
    }

    public Integer peek() {
        if(this.head.next == null) {
            return null;
        }
        return this.head.next.val;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        while(true) {
            Integer cur = queue.poll();
            if(cur == null) {
                break;
            }
            System.out.println(cur);
        }

    }
}
