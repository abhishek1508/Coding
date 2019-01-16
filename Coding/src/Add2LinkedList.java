public class Add2LinkedList {

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
        Add2LinkedList list = new Add2LinkedList();

        Node head1 = new Node(5);
        head1.next = new Node(5);
        head1.next.next = new Node(5);

        Node head2 = new Node(5);
        head2.next = new Node(5);
        head2.next.next = new Node(5);

        System.out.println("Linked list after calling pairwiseSwap() ");
        add(head1, head2, 0, null);
    }

    public static void insertAtEnd(Node node, int data) {
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(data);
    }

    public static void add(Node list1, Node list2, int carry, Node res) {
        int sum = 0;
        if (list1 == null && list2 == null) {
            if (carry > 0) {
                insertAtEnd(res, carry);
            }
            printList(res);
            return;
        } else {
            sum = carry + list1.data + list2.data;
            if (sum > 9) {
                carry = sum/10;
                sum = sum%10;
            } else {
                carry = 0;
            }
        }

        if (res == null) {
            res = new Node(sum);
        } else {
            insertAtEnd(res, sum);
        }
        add(list1.next, list2.next, carry, res);
    }


}
