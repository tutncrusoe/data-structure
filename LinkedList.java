// Linked list operations in Java
// https://www.geeksforgeeks.org/insertion-in-linked-list/
// https://www.programiz.com/dsa/linked-list
class LinkedList {
    Node head;

    // Create a node
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Insert at the beginning
    /*
    Complexity Analysis:
    Time Complexity: O(1), We have a pointer to the head and we can directly attach a node and change the pointer. So the Time complexity of inserting a node at the head position is O(1) as it does a constant amount of work.
    Auxiliary Space: O(1)
     */
    public void insertAtBeginning(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // Insert after a node
    /*
    Complexity Analysis:
    Time complexity: O(1), since prev_node is already given as argument in a method, no need to iterate over list to find prev_node
    Auxiliary Space: O(1) since using constant space to modify pointers
     */
    public void insertAfter(Node prev_node, int new_data) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    // Insert at the end
    /*
    Complexity Analysis:
    Time complexity: O(N), where N is the number of nodes in the linked list. Since there is a loop from head to end, the function does O(n) work.
    This method can also be optimized to work in O(1) by keeping an extra pointer to the tail of the linked list/
    Auxiliary Space: O(1)
     */
    public void insertAtEnd(int new_data) {
        if (head == null) {
            head = new Node(new_data);
            return;
        }

        Node end_node = new Node(new_data);
        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = end_node;
    }

    // Delete a node
    /*
    Time Complexity: O(n)
    Auxiliary Space: O(1)
     */
    void deleteNode(int position) {
        if (head == null)
            return;
        if (position == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null)
            return;
        temp.next = temp.next.next;
    }

    // Search a node
    /*
    Time Complexity: O(N), Where N is the number of nodes in the LinkedList
    Auxiliary Space: O(1)
     */
    boolean search(Node head, int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key)
                return true;
            current = current.next;
        }
        return false;
    }

    // Sort the linked list
    /*
    
     */
    void sortLinkedList(Node head) {
        Node current = head;
        Node index = null;
        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                // index points to the node next to current
                index = current.next;

                while (index != null) {
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    // Print the linked list
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }

    }

    /*
    Time Complexity:
    Time Complexity/Worst Case/Average Case
    Search/O(n)/O(n)
    Insertion/O(1)/O(1)
    Deletion/O(1)/O(1)

    Search is O(n) because as data is not stored in contiguous memory locations so we have to traverse one by one.
    Insertion and Deletion are O(1) because we have to just link new nodes for Insertion with the previous and next node and dislink exist nodes for deletion from the previous and next nodes without any traversal.
    Auxiliary Space: O(N) [To store dynamic memory]
     */
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        llist.insertAtEnd(1);
        llist.insertAtBeginning(2);
        llist.insertAtBeginning(3);
        llist.insertAtEnd(4);
        llist.insertAfter(llist.head.next, 5);

        System.out.println("Linked list: ");
        llist.printList();

        System.out.println("\nAfter deleting an element: ");
        llist.deleteNode(3);
        llist.printList();

        System.out.println();
        int item_to_find = 3;
        if (llist.search(llist.head, item_to_find))
            System.out.println(item_to_find + " is found");
        else
            System.out.println(item_to_find + " is not found");

        llist.sortLinkedList(llist.head);
        System.out.println("\nSorted List: ");
        llist.printList();
    }
}