public class Circular_Queue {
    static class Queue {
        static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;

        Queue(int n) {
            arr = new int[n];
            size = n;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void enqueue(int data) {
            if (isFull()) {
                System.out.println("Full Queue");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size; // We use it to re-use the indices in the queue.
            arr[rear] = data;
        }

        public static int dequeue() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            int result = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;  // We use it to re-use the indices in the queue.
            }
            return result;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(0);
        q.dequeue();

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.dequeue();
        }
    }
}
