package LinkedList;

// Node for Singly Linked List
class SNode {
    int data;
    SNode next;
    SNode(int data) { this.data = data; }
}

// Singly Linked List implementation
class SinglyLinkedList {
    SNode head;

    // Insert at beginning
    void insertAtBeginning(int data) {
        SNode newNode = new SNode(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    void insertAtEnd(int data) {
        SNode newNode = new SNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        SNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    // Insert at position (1-based index)
    void insertAtPosition(int data, int pos) {
        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }
        SNode newNode = new SNode(data);
        SNode temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null)
            return;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by value
    void deleteByValue(int key) {
        if (head == null)
            return;
        if (head.data == key) {
            head = head.next;
            return;
        }
        SNode temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Search element
    boolean search(int key) {
        SNode temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    // Traversal Iterative
    void traverseIterative() {
        SNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Traversal Recursive
    void traverseRecursive(SNode node) {
        if (node == null) {
            System.out.print("NULL\n");
            return;
        }
        System.out.print(node.data + " -> ");
        traverseRecursive(node.next);
    }
}