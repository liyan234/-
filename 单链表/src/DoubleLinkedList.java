



class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }
}

public class DoubleLinkedList {
    //无头双向非循环链表

    public ListNode head;//头
    public ListNode last;//尾巴

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null && this.last == null) {
            this.head = node;
            this.last = node;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;

    }
    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null && this.last == null) {
            this.head = node;
            this.last = node;
            return;
        }
        node.prev = this.last;
        this.last.next= node;
        this.last = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {

        ListNode node = new ListNode(data);
        ListNode cur = this.head;

        if(index < 0 || index > size()) {
            //System.out.println("输入index不规范");
            throw new RuntimeException("输入index不合法");
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        while(index > 0) {
            cur = cur.next;
            index --;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;

    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode node = this.head;

        while(node != null) {
            if(node.val == key) {
                if(node == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else if(node == this.last) {
                    this.last = this.last.prev;
                    this.last.next = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                return;
            } else {
                node = node.next;
            }
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode node = this.head;

        while(node != null) {
            if(node.val == key) {

                if(node == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    node.prev.next = node.next;
                    if( node.next != null) {
                        node.next.prev = node.prev;
                    } else {
                        this.last = node.prev;
                    }
                }
            }
            node = node.next;
        }
    }
    //得到单链表的长度
    public int size() {
        ListNode node = this.head;
        int count  = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }
    public void display() {

        ListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();

    }
    public void clear() {
        this.head = null;
        this.last = null;
    }



}
