package LinkedList;

import java.util.Scanner;


    // Main menu driver
    public class LinkedListMenu {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            SinglyLinkedList sll = new SinglyLinkedList();


            while (true) {
                System.out.println("\n--- MAIN MENU ---");
                System.out.println("1. Singly Linked List");
                System.out.println("2. Doubly Linked List");
                System.out.println("3. Circular Linked List");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        singlyMenu(sc, sll);
                        break;
                    case 2:
//                    doublyMenu(sc, dll);
                        break;
                    case 3:
//                    circularMenu(sc, cll);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }

        // Submenu for Singly Linked List
        static void singlyMenu(Scanner sc, SinglyLinkedList sll) {
            while (true) {
                System.out.println("\n--- Singly Linked List Menu ---");
                System.out.println("1. Insert at Beginning");
                System.out.println("2. Insert at End");
                System.out.println("3. Insert at Position");
                System.out.println("4. Delete by Value");
                System.out.println("5. Search");
                System.out.println("6. Traverse Iterative");
                System.out.println("7. Traverse Recursive");
                System.out.println("8. Back to Main Menu");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter value: ");
                        sll.insertAtBeginning(sc.nextInt());
                        break;
                    case 2:
                        System.out.print("Enter value: ");
                        sll.insertAtEnd(sc.nextInt());
                        break;
                    case 3:
                        System.out.print("Enter value and position: ");
                        int val = sc.nextInt();
                        int pos = sc.nextInt();
                        sll.insertAtPosition(val, pos);
                        break;
                    case 4:
                        System.out.print("Enter value to delete: ");
                        sll.deleteByValue(sc.nextInt());
                        break;
                    case 5:
                        System.out.print("Enter value to search: ");
                        System.out.println(sll.search(sc.nextInt()) ? "Found" : "Not Found");
                        break;
                    case 6:
                        sll.traverseIterative();
                        break;
                    case 7:
                        sll.traverseRecursive(sll.head);
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }

    }

