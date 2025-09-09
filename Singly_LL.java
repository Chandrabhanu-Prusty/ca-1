class LL {

    private Node head;

    private class Node {

        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    // Insert at the beginning
    public void insert_first(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    public void insert_last(int val) {
        if (head == null) {
            insert_first(val);  // If the list is empty, insert at the beginning
            return;
        }

        Node newNode = new Node(val);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Delete the first node
    public void delete_first() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("Deleted: " + head.val);
        head = head.next;
    }

    // Delete the last node
    public void delete_last() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {    // single element in the list
            System.out.println("Deleted: " + head.val);
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        System.out.println("Deleted: " + temp.next.val);
        temp.next = null;
    }

    // Insert a node in the middle after a specific node
    public void insert_mid(int val, int pre_val) {
        Node newNode = new Node(val);
        Node temp = head;

        // Traverse until we find the node with pre_val
        while (temp != null && temp.val != pre_val) {
            temp = temp.next;
        }

        // If the node with pre_val was found, insert newNode after it
        if (temp != null) {
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.out.println("Node with value " + pre_val + " not found.");
        }
    }

    // Delete a node from the middle (any specific node)
    public void delete_mid(int del_val) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        // If we need to delete the first node
        if (temp.val == del_val) {
            delete_first();
            return;
        }

        // Traverse the list to find the node with del_val
        while (temp != null && temp.next != null && temp.next.val != del_val) {
            temp = temp.next;
        }

        // If we found the node to delete
        if (temp != null && temp.next != null) {
            System.out.println("Deleted: " + temp.next.val);
            temp.next = temp.next.next;  // Remove the node from the list
        } else {
            System.out.println("Node with value " + del_val + " not found.");
        }
    }

    // Print the linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}

class Main_LL {

    public static void main(String[] args) {
        LL obj = new LL();
        obj.insert_first(1);
        obj.insert_first(2);
        obj.insert_last(3);
        obj.print();            // Output: 2 -> 1 -> 3 -> END

        obj.insert_last(4);
        obj.insert_first(5);
        obj.delete_first();     // Deletes 5
        obj.delete_last();      // Deletes 4
        obj.print();            // Output: 2 -> 1 -> 3 -> END

        obj.insert_mid(100, 1);
        obj.print();            // Output: 2 -> 1 -> 100 -> 3 -> END

        obj.delete_mid(1);
        obj.print();            // Output: 2 -> 100 -> 3 -> END
    }
}
