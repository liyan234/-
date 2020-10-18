public class MyQueueTwo {
    int[] arrays = new int[100];
    int userSize = 0;
    int head = 0;
    int tail = 0;

    public boolean offer(int data) {
        if(this.userSize == this.arrays.length) {
            return false;
        }
        this.arrays[this.tail] = data;
        this.tail++;
        this.tail = this.tail % this.arrays.length;
        this.userSize++;
        return true;
    }

    public Integer poll() {
        if (this.userSize == 0) {
            return null;
        }
        Integer num = this.arrays[this.head];
        this.head++;
        this.head = this.head % this.arrays.length;
        this.userSize--;
        return num;
    }

    public Integer peek() {
        if (this.userSize == 0) {
            return null;
        }
        return this.arrays[this.head];
    }

    public boolean empty() {
        if(this.userSize == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyQueueTwo queueTwo = new MyQueueTwo();
        queueTwo.offer(1);
        queueTwo.offer(2);
        queueTwo.offer(3);
        queueTwo.offer(4);
        queueTwo.offer(5);

        while (true) {
            Integer num = queueTwo.poll();
            if(num == null) {
                break;
            }
            System.out.println(num);
        }
    }
}
