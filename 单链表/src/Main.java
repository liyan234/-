public class Main {

    public static SingleLinkedList mergeTwoLists(SingleLinkedList list1,SingleLinkedList list2) {
        SingleLinkedList list = new SingleLinkedList();
        list.head = new Node(-1);
        Node tmp = list.head;

        while (list1.head != null && list2.head != null) {
            if(list1.head.data > list2.head.data) {
                tmp.next = list1.head;
                list1.head = list.head.next;
            } else {
                tmp.next = list2.head;
                list2.head = list2.head.next;
            }
            tmp = tmp.next;
        }
        if(list1.head != null) {
            tmp.next = list1.head;
        }
        if(list2.head != null) {
            tmp.next = list2.head;
        }
        list.head = list.head.next;
        return list;
    }

    public static Node mergeTwoLists(Node headA, Node headB) {
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
            } else {
                tmp.next = headB;
                headB = headB.next;
            }
            tmp = tmp.next;
        }
        if(headA != null) {
            tmp.next = headA;
        }
        if(headB != null) {
            tmp.next = headB;
        }
        return newHead.next;
    }

    //为了表示给定链表中的环，
    // 我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）
    /*public static boolean judgeRoundList(Node head) {

        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast != null && slow == fast) {
                break;
            }
        }

        if(fast == null || fast.next == null) {
            return false;
        }
        return true;
    }*/


    //返回这个入口点
    public static Node judgeRoundListNode(Node head) {

        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if(fast != null && slow == fast) {
               break;
            }
        }

        if(fast == null || fast.next == null) {
            return null;
        }

        fast = head;
        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

   //输入两个链表，找出它们的第一个公共结点
    public static Node meetNode(Node aHead,Node bHead) {

        Node curA = aHead;
        Node curB = bHead;

        int lenA = 0;
        int lenB = 0;

        while( curA != null) {
            curA = curA.next;
            lenA ++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB ++;
        }

        curA = aHead;
        curB = bHead;

        int len = lenA - lenB;
        //判断那个单链表的长度长
        if(len < 0) {
            curA = bHead;
            curB = aHead;
            len = -len;
        }

        while(len > 0) {
            curA = curA.next;
            len--;
        }
        while(curB != null && curA != null && curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        SingleLinkedList list1 = new SingleLinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(5);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(8);
        list1.addLast(9);
        list1.addLast(10);

        SingleLinkedList list2 = mergeTwoLists(list1,list);
        list2.display2(list2.head);
        /*Node ret = mergeTwoLists (list.head,list1.head);
        list.display2(ret);*/


       /* list1.head.next.next.next.next.next = list.head.next.next;

        list.display();
        System.out.println();
        list1.display();
        System.out.println();

        Node ret = meetNode(list1.head,list.head);
        int a = 0;
        if(ret != null) {
            a = ret.data;
        }
        System.out.println(a);
*/
    }

    public static void main1(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        /*list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.display();
        System.out.println();*/

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        //list.addIndex(2,4);//第一个数据点为零号下标
        //System.out.println(list.size());

        //每次删除一个节点
        /*list.display();
        System.out.println();

        list.remove(1);
        list.display();
        System.out.println();

        list.remove(2);
        list.display();
        System.out.println();

        list.remove(3);
        list.display();
        System.out.println();

        list.remove(4);
        list.display();
        System.out.println();*/

        //删除全部相同的节点
        /*list.display();
        System.out.println();
        list.removeAllKey(1);
        list.display();*/

        //单链表反转测试
        /*Node ret1 = list.reverseSingleLinkList();
        list.display2(ret1);*/

        //头插法反转单链表
        /*Node ret2 = list.reverseSingleLinkList2();
        list.display2(ret2);*/

        //找到单链表的中间节点
        /*Node ret3 = list.retCentreList();
        list.addFirst(ret3.data);
        list.display();*/

        /*int ret = list.findKPoint(list,2);
        System.out.println(ret);*/

       /*Node ret4 = list.partXList(list,4);
       list.display2(ret4);*/


       /*Node ret5 = list.deleteListSame(list);
       list.display2(ret5);*/

      /* list.roundList();
       System.out.println(judgeRoundList(list.head));*/

        /*System.out.println(list.judgeListSymmetry());*/

        /*list.roundList();
        Node ret6 = judgeRoundListNode(list.head);
        int a = 0;
        if(ret6 != null) {
            a = ret6.data;
        }
        System.out.println(a);*/
    }
}
