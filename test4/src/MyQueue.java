import java.util.Stack;

public class MyQueue {

    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 要保证所有元素都在 A 中, 然后再把 x 插入到 A 中.
        if(!B.isEmpty()) {
            int cur = B.pop();
            A.push(cur);
        }
        A.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public Integer pop() {
        // 先把 A 中的元素都往 B 中倒腾, 再取 B 的栈顶元素出栈即可.
        if(A.isEmpty() && B.isEmpty()) {
            return null;
        }
        while(!A.isEmpty()) {
            int cur = A.pop();
            B.push(cur);
        }
        return B.pop();

    }

    /** Get the front element. */
    public Integer peek() {
        if(A.isEmpty() && B.isEmpty()) {
            return null;
        }
        while(!A.isEmpty()) {
            int cur = A.pop();
            B.push(cur);
        }
        return B.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);


        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());

        System.out.println("=================");
        System.out.println(myQueue.empty());

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

        System.out.println(myQueue.pop());

        System.out.println(myQueue.empty());

    }

}
