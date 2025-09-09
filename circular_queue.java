class MyCircularQueue {
    int front;
    int rear;
    int[] arr;
    int size;
    
    public MyCircularQueue(int k) {
        this.size = k;
        arr = new int[k];
        front = -1;
        rear = -1;
    }
    
    //insert the element from rear
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        arr[rear] = value;
        return true;
    }
    
    //delete the element from front
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return true;
    }
    
    //return the element at front
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    //return the element at rear
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[rear];   
    }
    
    //checks if the queue is empty or not
    public boolean isEmpty() {
        return front == -1;
    }
    
    //checks if the queue is full or not
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    //print the whole queue
    // Print all elements in circular order
    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int temp = front;
        while (true) {
            System.out.print(arr[temp] + " -> ");
            if (temp == rear) break;  // stop after printing rear
            temp = (temp + 1) % size;
        }
        System.out.println();
    }

}

class Main_queue{
    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(5);
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);
        q.enQueue(50);
        q.print(); //Output: 10 -> 20 -> 30 -> 40 -> 50

        q.deQueue();
        q.deQueue();
        q.print(); //Output: 30 -> 40 -> 50

        q.enQueue(60);
        q.print(); //Outpur: 30 -> 40 -> 50 -> 60
    }
}
