public class LinkedListTest {

    private static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Function to print nodes in a given linked list */
    private static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        /* The constructed linked list is:
         1->2->3->4->5->6->7 */
        LinkedListTest list = new LinkedListTest();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        System.out.println("Linked list before calling pairwiseSwap() ");
        list.printList(head);
        System.out.println("Linked list after calling pairwiseSwap() ");
        swap(head);

    }

    private static void swap(Node node) {
        Node finalList = swap(node, 2);
        printList(finalList);
    }

    private static Node swap(Node node, int k) {
        Node prev = null;
        Node next = null;
        Node curr = node;
        int count = 0;
        while(curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            node.next = swap(next, 2);
        }
        return prev;
    }
}
