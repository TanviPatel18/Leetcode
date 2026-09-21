public class leet622 {

    static class MyCircularQueue {

        int arr[];
        int size;
        int front;
        int rear;

        // Constructor
        public MyCircularQueue(int k) {
            arr = new int[k];
            this.size = k;
            rear = -1;
            front = -1;
        }

        // Insert element
        public boolean enQueue(int value) {

            if (isFull()) {
                System.out.println("Queue is full");
                return false;
            }

            // first element
            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = value;

            return true;
        }

        // Delete element
        public boolean deQueue() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return false;
            }

            // single element
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }

            return true;
        }

        // Get front
        public int Front() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[front];
        }

        // Get rear
        public int Rear() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[rear];
        }

        // Check empty
        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // Check full
        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Display queue
        public void display() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            int i = front;

            while (i != rear) {
                System.out.print(arr[i] + " ");
                i = (i + 1) % size;
            }

            System.out.print(arr[rear]);
            System.out.println();
        }
    }

    // Main Method
    public static void main(String[] args) {

        MyCircularQueue q = new MyCircularQueue(5);

        System.out.println(q.enQueue(10));
        System.out.println(q.enQueue(20));
        System.out.println(q.enQueue(30));
        System.out.println(q.enQueue(40));
        System.out.println(q.enQueue(50));

        q.display();

        System.out.println("Front: " + q.Front());
        System.out.println("Rear: " + q.Rear());

        System.out.println("Is Full: " + q.isFull());

        q.deQueue();
        q.deQueue();

        q.display();

        q.enQueue(60);
        q.enQueue(70);

        q.display();

        System.out.println("Front: " + q.Front());
        System.out.println("Rear: " + q.Rear());
    }
}