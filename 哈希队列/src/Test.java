

public class Test {
    static class Node {

        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] array = new Node[101];
    private int size = 0;

    private int hasFun(int key) {
        return key % array.length;
    }

    //插入
    public void put(int key, int val) {
        int index = hasFun(key);
        Node head = array[index];

        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
        }
        Node newNode = new Node(key,val);
        newNode.next = head;
        array[index] = newNode;
        size++;
    }

    //寻找
    public Node find(int key) {
        int index = hasFun(key);
        Node head = array[index];

        for (Node cur = head; cur != null ; cur = cur.next) {

            if (cur.key == key) {
                return cur;
            }

        }
        return null;
    }

    //删除
    public void remove (int key) {
        int index = hasFun(key);
        Node head = array[index];

        if (head.key == key) {
            array[index] = head.next;
            return;
        }

        for (Node prev = head; prev.next != null; prev = prev.next) {
            if (prev.next.key == key) {
                prev.next = prev.next.next;
            }
        }
    }


}
