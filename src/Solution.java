

public class Solution {
    public static class Queue {
        public Node front;
        public Node rear;
    }

    public static class Node {
        public int data;
        public Node link;
    }

    public static void enQueue(Queue q, int value) {
        Node temp = new Node();
        temp.data = value;
        if (q.front == null)
            q.front = temp;
        else
            q.rear.link = temp;
        q.rear = temp;
        q.rear.link = q.front;
    }

    public static int deQueue(Queue q) {
        if (q.front == null) {
            System.out.printf("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int value;
        if (q.front == q.rear) {
            value = q.front.data;
            q.front = null;
            q.rear = null;
        } else {
            Node temp = q.front;
            value = temp.data;
            q.front = q.front.link;
            q.rear.link = q.front;
        }
        return value;
    }

    public static void displayQueue(Queue q) {
        Node temp = q.front;
        System.out.printf("Elements in Circular Queue are: ");
        while (temp.link != q.front) {
            System.out.printf("%d ", temp.data);
            temp = temp.link;
        }
        System.out.printf("%d", temp.data);
    }


        public static void main(String[] args) {
            Queue queue = new Queue();
            queue.front = queue.rear = null;

            enQueue(queue, 14);
            enQueue(queue, 22);
            enQueue(queue, 6);

            displayQueue(queue);
            System.out.println("\n");

            System.out.println(("Deleted value " + deQueue(queue)));

            displayQueue(queue);
            System.out.println("\n");
            enQueue(queue, 9);
            enQueue(queue, 20);
            enQueue(queue, 21);
            displayQueue(queue);

        }


}
