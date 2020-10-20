public class LMain {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);

      //  linkedList.display();

        LinkedList linkedList1 = new LinkedList();

        linkedList1.addLast(1);
        linkedList1.addLast(1);
        linkedList1.addLast(1);
        linkedList1.addLast(4);
        linkedList1.addLast(1);

        linkedList1.display();
        System.out.println(linkedList.size());


        linkedList1.addIndex(5,0);
        linkedList1.display();

        linkedList1.removeAKey(0);
        linkedList1.display();

        linkedList1.removeAllKeys(1);
        linkedList1.display();


    }
}
