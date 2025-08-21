import java.util.*;

class CircularQueueADT {
    int[] q;
    int front, rear, size, capacity;

    public CircularQueueADT(int capacity) {
        this.capacity = capacity;
        q = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Counter Full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
            q[rear] = x;
        } else {
            rear = (rear + 1) % capacity;
            q[rear] = x;
        }
        size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Counter Empty");
            return;
        }
        System.out.println(q[front] + " served");
        if (size == 1) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
    }

    public void status() {
        if (isEmpty()) {
            System.out.println("Counter Empty");
            return;
        }
        int i = front;
        for (int cnt = 0; cnt < size; cnt++) {
            System.out.print(q[i]);
            if (cnt < size - 1) System.out.print(" ");
            i = (i + 1) % capacity;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // capacity of counter
        int q = sc.nextInt(); // number of operations
        sc.nextLine(); // consume newline

        CircularQueueADT cq = new CircularQueueADT(n);

        for (int i = 0; i < q; i++) {
            String command = sc.next();
            if (command.equals("ARRIVE")) {
                int id = sc.nextInt();
                cq.enqueue(id);
            } else if (command.equals("SERVE")) {
                cq.dequeue();
            } else if (command.equals("STATUS")) {
                cq.status();
            }
        }
        sc.close();
    }
}
