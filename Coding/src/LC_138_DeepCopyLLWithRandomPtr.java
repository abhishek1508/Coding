public class LC_138_DeepCopyLLWithRandomPtr {

    static class RandomListNode {
        int data;
        RandomListNode random, next;
        public RandomListNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        RandomListNode listNode = new RandomListNode(1);
        listNode.next = new RandomListNode(2);
        listNode.next.next = new RandomListNode(3);
        listNode.next.next.next = new RandomListNode(4);
        listNode.next.next.next.next = new RandomListNode(5);

        // 1's random points to 3
        listNode.random = listNode.next.next;

        // 2's random points to 1
        listNode.next.random = listNode;

        // 3's and 4's random points to 5
        listNode.next.next.random = listNode.next.next.next.next;
        listNode.next.next.next.random = listNode.next.next.next.next;

        // 5's random points to 2
        listNode.next.next.next.next.random = listNode.next;

        print(deepCopy(listNode));
    }

    private static void print(RandomListNode start)
    {
        RandomListNode ptr = start;
        while (ptr != null)
        {
            System.out.println("Data = " + ptr.data +
                    ", Random = "+ptr.random.data);
            ptr = ptr.next;
        }
    }

    private static RandomListNode deepCopy(RandomListNode listNode) {
        RandomListNode temp;
        RandomListNode head = listNode;

        while (head != null) {
            temp = head.next;

            head.next = new RandomListNode(head.data);
            head.next.next = temp;
            head = temp;
        }

        head = listNode;
        while(head != null) {
            head.next.random = head.random.next;
            head = head.next.next;
        }

        head = listNode;
        RandomListNode copy = head.next;
        temp = copy;

        while(head != null && copy != null) {
            head.next = (head.next != null)? head.next.next : head.next;
            copy.next = (copy.next != null)? copy.next.next : copy.next;
            head = head.next;
            copy = copy.next;
        }
        return temp;
    }
}
