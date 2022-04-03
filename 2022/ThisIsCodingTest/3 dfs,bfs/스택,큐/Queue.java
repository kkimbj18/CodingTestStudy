interface QueueForm {
    boolean isEmpty();

    boolean isFull();

    void enqueue(char item);

    char dequeue();
}

public class Queue implements QueueForm{
    private int queueSize;
    private char queueArr[];
    private int front;
    private int rear;

    public Queue(int queueSize) {
        front = -1;
        rear = -1;
        this.queueSize = queueSize;
        queueArr = new char[queueSize];
    }

    public boolean isEmpty() {
        return (front == rear) ? true : false;
    }

    public boolean isFull() {
        if (rear > front) {
            if (rear - front == queueSize)
                return true;
            else
                return false;
        } else {
            if (front - rear == 1)
                return true;
            else
                return false;
        }
    }

    public void enqueue(char item) {
        if (isFull()) {
            System.out.println("Queue is full!");
        } else {
            rear = (rear + 1) % queueSize;
            queueArr[rear] = item;
        }
    }

    public char dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return 0;
        } else {
            front = (front + 1) % queueSize;
            return queueArr[front];
        }
    }

    public void printQueue() {
        if (rear > front) {
            for (int i = front+1; i <= rear; i++)
                System.out.print(queueArr[i] + " ");
        } else {
            for (int i = front + 1; i < queueSize; i++)
                System.out.print(queueArr[i] + " ");
            for (int i = 0; i <= rear; i++)
                System.out.print(queueArr[i] + " ");
        }
        
        System.out.println("");
    }

    public static void main(String[] args) {
        int queueSize = 5;
        Queue arrQueue = new Queue(queueSize);
        
        arrQueue.enqueue('A');
        arrQueue.printQueue();
        
        arrQueue.enqueue('B');
        arrQueue.printQueue();
        
        arrQueue.enqueue('C');
        arrQueue.printQueue();
        
        arrQueue.enqueue('D');
        arrQueue.printQueue();
        
        arrQueue.enqueue('E');
        arrQueue.printQueue();
        
        arrQueue.dequeue();
        arrQueue.printQueue();
        
        arrQueue.dequeue();
        arrQueue.printQueue();
        
        arrQueue.dequeue();
        arrQueue.printQueue();
        
        arrQueue.dequeue();
        arrQueue.printQueue();
    }
}
