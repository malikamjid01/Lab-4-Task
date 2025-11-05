package LinkedList;

import java.util.Scanner;

// Node for Circular Linked List (Singly)
class CNode {
    int data;
    CNode next;
    CNode(int data) { this.data = data; }
}

// Circular Singly Linked List implementation
class CircularLinkedList {
    CNode head;

    void insertAtBeginning(int data) {
        CNode newNode = new CNode(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }
        CNode temp = head;
        while (temp.next != head) temp = temp.next;
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    void insertAtEnd(int data) {
        CNode newNode = new CNode(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }
        CNode temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }

    void insertAtPosition(int data, int pos) {
        if (pos <= 1) {
            insertAtBeginning(data);
            return;
        }
        CNode newNode = new CNode(data);
        CNode temp = head;
        int count = 1;
        while (temp.next != head && count < pos - 1) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteByValue(int key) {
        if (head == null) return;
        if (head.data == key) {
            if (head.next == head) {
                head = null;
                return;
            }
            CNode temp = head;
            while (temp.next != head) temp = temp.next;
            head = head.next;
            temp.next = head;
            return;
        }
        CNode curr = head, prev = null;
        do {
            prev = curr;
            curr = curr.next;
            if (curr.data == key) {
                prev.next = curr.next;
                return;
            }
        } while (curr != head);
    }

    void deleteAtPosition(int pos) {
        if (head == null || pos < 1) return;
        if (pos == 1) {
            if (head.next == head) {
                head = null;
                return;
            }
            CNode temp = head;
            while (temp.next != head) temp = temp.next;
            head = head.next;
            temp.next = head;
            return;
        }
        CNode curr = head, prev = null;
        int count = 1;
        do {
            prev = curr;
            curr = curr.next;
            count++;
            if (count == pos) {
                prev.next = curr.next;
                return;
            }
        } while (curr != head);
    }

    void traverse() {
        if (head == null) return;
        CNode temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    void search(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        CNode temp = head;
        int pos = 1;
        boolean found = false;
        do {
            if (temp.data == key) {
                System.out.println("Value " + key + " found at position " + pos);
                found = true;
            }
            temp = temp.next;
            pos++;
        } while (temp != head);
        if (!found) System.out.println("Value " + key + " not found.");
    }
}

// Node for Circular Doubly Linked List
class CDNode {
    int data;
    CDNode next, prev;
    CDNode(int data) { this.data = data; }
}

// Circular Doubly Linked List implementation
class CircularDoublyLinkedList {
    CDNode head;

    void insertAtBeginning(int data) {
        CDNode newNode = new CDNode(data);
        if (head == null) {
            head = newNode;
            head.next = head.prev = head;
            return;
        }
        CDNode tail = head.prev;
        newNode.next = head;
        newNode.prev = tail;
        tail.next = head.prev = newNode;
        head = newNode;
    }

    void insertAtEnd(int data) {
        CDNode newNode = new CDNode(data);
        if (head == null) {
            head = newNode;
            head.next = head.prev = head;
            return;
        }
        CDNode tail = head.prev;
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
    }

    void insertAtPosition(int data, int pos) {
        if (pos <= 1) {
            insertAtBeginning(data);
            return;
        }
        CDNode newNode = new CDNode(data);
        CDNode temp = head;
        int count = 1;
        while (temp.next != head && count < pos - 1) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    void deleteByValue(int key) {
        if (head == null) return;
        CDNode curr = head;
        do {
            if (curr.data == key) {
                if (curr.next == curr) { // only one node
                    head = null;
                    return;
                }
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                if (curr == head) head = curr.next;
                return;
            }
            curr = curr.next;
        } while (curr != head);
    }

    void deleteAtPosition(int pos) {
        if (head == null || pos < 1) return;
        CDNode curr = head;
        int count = 1;
        do {
            if (count == pos) {
                if (curr.next == curr) { // only one node
                    head = null;
                    return;
                }
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                if (curr == head) head = curr.next;
                return;
            }
            curr = curr.next;
            count++;
        } while (curr != head);
    }

    void traverseForward() {
        if (head == null) return;
        CDNode temp = head;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    void traverseBackward() {
        if (head == null) return;
        CDNode temp = head.prev; // start from tail
        CDNode tail = temp;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != tail);
        System.out.println("(back to tail)");
    }

    void search(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        CDNode temp = head;
        int pos = 1;
        boolean found = false;
        do {
            if (temp.data == key) {
                System.out.println("Value " + key + " found at position " + pos);
                found = true;
            }
            temp = temp.next;
            pos++;
        } while (temp != head);
        if (!found) System.out.println("Value " + key + " not found.");
    }
}
