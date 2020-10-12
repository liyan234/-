public class DMain {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleLinkedList doubleLinkedList1 = new DoubleLinkedList();

        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(4);
        doubleLinkedList.addFirst(5);
        doubleLinkedList.addFirst(6);
       // doubleLinkedList.display();

        doubleLinkedList1.addLast(1);
        doubleLinkedList1.addLast(2);
        doubleLinkedList1.addLast(1);
        doubleLinkedList1.addLast(4);
        doubleLinkedList1.addLast(1);
        doubleLinkedList1.addLast(1);
        doubleLinkedList1.addIndex(6,1);

        /*doubleLinkedList1.addIndex(1,7);
        doubleLinkedList1.display();
        doubleLinkedList1.addIndex(1,1);
        doubleLinkedList1.display();
        doubleLinkedList1.addIndex(2,1);
        doubleLinkedList1.display();*/
        doubleLinkedList1.removeAllKey(1);
        doubleLinkedList1.display();


    }


}
