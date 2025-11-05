package LinkedList;
import java.util.Scanner;

// Node for Doubly Linked List
class DNode {
    int data;
    DNode prev, next;
    DNode(int data) { this.data = data; }
}

// Doubly Linked List implementation
class DoublyLinkedList {
    DNode head;

    void insertAtBeginning(int data) {
        DNode newNode = new DNode(data);
        if (head != null) head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    void insertAtPosition(int data, int pos) {
        if (pos <= 1) {
            insertAtBeginning(data);
            return;
        }
        DNode newNode = new DNode(data);
        DNode temp = head;
        int count = 1;
        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            insertAtEnd(data);
        } else {
            newNode.next = temp.next;
            if (temp.next != null) temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    void deleteByValue(int key) {
        if (head == null) return;
        if (head.data == key) {
            head = head.next;
            if (head != null) head.prev = null;
            return;
        }
        DNode temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp != null) {
            if (temp.next != null) temp.next.prev = temp.prev;
            if (temp.prev != null) temp.prev.next = temp.next;
        }
    }

    void deleteAtPosition(int pos) {
        if (head == null || pos < 1) return;
        if (pos == 1) {
            head = head.next;
            if (head != null) head.prev = null;
            return;
        }
        DNode temp = head;
        int count = 1;
        while (temp != null && count < pos) {
            temp = temp.next;
            count++;
        }
        if (temp != null) {
            if (temp.next != null) temp.next.prev = temp.prev;
            if (temp.prev != null) temp.prev.next = temp.next;
        }
    }

    void traverseForward() {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    void traverseBackward() {
        if (head == null) {
            System.out.println("NULL");
            return;
        }
        DNode temp = head;
        while (temp.next != null) temp = temp.next; // Move to tail
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    void search(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        DNode temp = head;
        int pos = 1;
        boolean found = false;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Value " + key + " found at position " + pos);
                found = true;
            }
            temp = temp.next;
            pos++;
        }
        if (!found) {
            System.out.println("Value " + key + " not found in the list.");
        }
    }
}
