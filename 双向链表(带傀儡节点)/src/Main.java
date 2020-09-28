public class Main {
    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        DoubleLinkedList linkedList1 = new DoubleLinkedList();

        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);

        linkedList.display();

        linkedList1.addLast(0);
        linkedList1.addLast(2);
        linkedList1.addLast(0);
        linkedList1.addLast(4);
        linkedList1.addLast(0);

        linkedList1.display();

        linkedList1.addIndex(0,0);

        linkedList1.display();

        System.out.println(linkedList1.contains(6));

        //linkedList1.remove(5);
        //linkedList1.display();

        System.out.println(linkedList1.size());

        linkedList1.removeAllKey(0);
        linkedList1.display();

    }
}
