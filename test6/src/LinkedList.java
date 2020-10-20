class Node {
    private int val;
    private Node next;

    public Node(int val){
        setVal(val);
        setNext(null);
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class LinkedList {

    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head  = node;
            return;
        }
        node.setNext(this.head);
        this.head = node;
    }
    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(node);
    }

    private int findIndex(int index) {
       Node cur = this.head;
       int count = 0;
       while (count < index-1) {
           cur = cur.getNext();
           count++;
       }
       return count;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {

        Node node = new Node(data);
        Node prev = this.head;
        if(index < 0 || index > size()) {
            System.out.println("输入的index不合适");
            return;
        }

        if(index == size()) {
            addLast(data);
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        for (int i = 0; i < findIndex(index) ; i++) {
            prev = prev.getNext();
        }
        node.setNext(prev.getNext());
        prev.setNext(node);
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contain(int key) {
        Node node = this.head;
        while(node != null) {
            if(node.getVal() == key) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }
    //删除第一次出现关键字为key的节点方法一
    public void removeAKey(int key) {
        Node node = this.head;

        if(this.head != null  && this.head.getVal() == key) {
            this.head = this.head.getNext();
            return;
        }

        while(node.getNext() != null) {
            if(node.getNext().getVal() == key) {
                node.setNext(node.getNext().getNext());
                return;
            }
            node = node.getNext();
        }

    }

    //删除所有值为key的节点,只需要遍历一次
    public void removeAllKeys(int key) {
        Node cur = this.head;
        Node last = this.head.getNext();

        while(last != null) {
            if(last.getVal() == key) {
                cur.setNext(last.getNext());
                last = last.getNext();
            } else {
                cur = cur.getNext();
                last = last.getNext();
            }
        }

        if (this.head.getVal() == key) {
           this.head = this.head.getNext();
        }
    }

    //得到单链表的长度
    public int size() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            cur = cur.getNext();
            count++;
        }
        return count;
    }

    //打印单链表
    public void display() {
        Node node = this.head;
        if(node == null) {
            System.out.println("链表为空");
            return;
        }
        while(node != null) {
            System.out.print(node.getVal() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
    //单链表置零

    public void clear() {
        this.head = null;
    }
}
