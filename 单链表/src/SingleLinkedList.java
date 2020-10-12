import com.sun.deploy.net.proxy.ProxyUnavailableException;

class Node {//节点类

    public int data;
    public Node next;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SingleLinkedList {
    //单链表本身是一种类
    //由节点来构成单链表，

    public Node head;//头节点

    public SingleLinkedList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
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
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    private int findIndex(int index) {
        int count = 0;
        Node node = new Node();
        node = this.head;
        while(count < index-1) {
            node = node.next;
            count++;
        }
        return count;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {

        Node node = new Node(data);
        Node prev = this.head;

        if(index < 0 || index >size()) {
            throw new RuntimeException("位置不合法");
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        //先让pre走到index-1处
        for (int i = 0; i < findIndex(index); i++) {
            prev = prev.next;
        }
        //然后先连接后面的，再连接前面的
        node.next = prev.next;
        prev.next = node;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while(cur != null) {
           if(cur.data == key) {
               return true;
           }
           cur = cur.next;
       }
       return false;
    }

    //删除第一次出现关键字为key的节点方法一
    private Node findPrev(int key) {
        Node prev = this.head;
        while (prev.next != null) {
            if(prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    public void remove(int key) {

        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }

        Node prev = findPrev(key);
        if(prev == null) {
            System.out.println("链表中没有这个节点");
            return;
        }
        Node del = prev.next;
        prev.next = del.next;
    }
    //删除第一次出现关键字为key的节点方法二
    public void remove1(int key) {
        Node node = this.head;

        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        while(node.next.data != key) {
            node = node.next;
            if(node.next == null) {
                System.out.println("链表中没有这个节点");
                return;
            }
        }
        node.next = node.next.next;
    }

    //删除所有值为key的节点,只需要遍历一次
    public void removeAllKey(int key) {
        Node prev = this.head;
        Node cur = this.head.next;

        while(cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        //判断头节点是否为关键字
        if(this.head.data == key) {
            this.head = this.head.next;
        }
    }
    //得到单链表的长度
    public int size() {
        int count = 0;
        Node cur = this.head;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    //打印单链表
    public void display() {
        Node cur = this.head;
        if(this.head == null) {
            System.out.println("没有存放数据");
        }
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
    //单链表置零
    public void clear() {
        this.head = null;
    }

    public Node reverseSingleLinkList() {
        //反转一个单链表，遍历一次
        Node cur = this.head;
        if(cur == null) {
            return null;
        }
        if(cur.next == null) {
            return cur;
        }

        Node prev = null;
        Node newHead = null;

        while(cur != null) {
            Node curNext = cur.next;
            if(cur.next == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public Node reverseSingleLinkList2() {
        //利用头插法来反转单链表

        if(this.head == null) {
            return null;
        }
        if(this.head.next == null) {
            return this.head;
        }

        Node node = this.head.next;
        this.head.next = null;
        while (node != null ) {
           addFirst(node.data);
           node = node.next;
        }
        return this.head;
    }
    //重写一个单链表的打印，用来测试单链表的反转
    public void display2(Node newHead) {
        Node cur = newHead;
        if(this.head == null) {
            System.out.println("没有存放数据");
        }
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    // 给定一个带有头结点 head 的非空单链表，
    // 返回链表的中间结点。如果有两个中间结点，
    // 则返回第二个中间结点
    public Node retCentreList() {

        Node slow = this.head;
        Node fast = this.head;
        if(slow == null) {
            return null;
        }
        if(slow.next == null) {
            return slow;
        }
        if(slow.next.next == null) {
            return slow.next;
        }

        while ( fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //输入一个链表，输出该链表中倒数第k个结点。
    public int findKPoint(SingleLinkedList list,int k) {

        Node slow = list.head;
        Node fast = list.head;
        if(k < 0 || k > list.size() ) {
            throw new RuntimeException("k值输入不规范");
        }
        while( k-1 > 0 ) {
            fast = fast.next;
            k--;
        }

        while( fast.next != null ) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    //编写代码，以给定值x为基准将链表分割成两部分，
    // 所有小于x的结点排在大于或等于x的结点之前

    public Node partXList(SingleLinkedList list,int x) {

        Node node = list.head;

        Node left_before = null;
        Node left_after =null;

        Node right_before = null;
        Node right_after = null;

        while(node != null) {
        //比x小
            if(node.data < x) {

               if(left_before == null) {
                   left_before = node;
                   left_after = left_before;
               } else {
                   left_after.next = node;
                   left_after = left_after.next;
               }
         //比x大
            } else {

                if(right_before == null) {
                    right_before = node;
                    right_after = right_before;
                } else {
                    right_after.next = node;
                    right_after = right_after.next;
                }

            }
            node = node.next;
        }

        if(left_before == null) {
            return right_before;
        }

        left_after.next = right_before;

        if(right_after.next != null) {
            right_after.next = null;
        }

        return left_before;
    }

    /**
     * 在一个排序的链表中，存在重复的结点，
     *重复的结点不保留，返回链表头指针。
     *例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */
    public Node deleteListSame(SingleLinkedList list) {

        if (list.head == null) {
            return null;
        }
        if (list.head.next == null) {
            return list.head;
        }

        Node cur = list.head;
        Node node = new Node(-1);
        Node tmp = node;

        while (cur != null) {
            if ( cur.next != null && cur.next.data == cur.data) {
                while (cur.next != null && cur.next.data == cur.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {

                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;

            }
        }
        tmp.next = null;
        return node.next;
    }

   //构成环；
    public void roundList () {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next;
    }

    /**
     * 请返回一个bool值，
     * 代表其是否为回文结构
     */
    /**思路：先找到中间节点
     * 从中间节点局部反转
     * 然后开始从前从后反转
     */
    public boolean judgeListSymmetry() {
        Node slow = this.head;
        Node fast = this.head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow 为中间接节点

        Node slowNext = slow.next;
        while(slowNext != null) {
          Node slowNextN = slowNext.next;
            slowNext.next = slow;
            slow = slow.next;
            slowNext = slowNextN;
        }
        while(slow != this.head ) {
            if(slow.data != this.head.data) {
                return false;
            }
            //对于偶数的判断
            if(this.head.next == slow) {
                return true;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;
    }
}



