import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveLLDuplicates {

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int d) {
            val = d;
            next = null;
        }
    }

    public  static void main(String[] args) {

        /* The constructed linked list is:
         1->2->3->4->5->6->7 */
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.println(deleteDuplicates(head));

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode res = null;
        ListNode start = null;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        while (curr != null) {
            if (!map.containsKey(curr.val)) {
                map.put(curr.val, 1);
            } else {
                int value = map.get(curr.val);
                map.put(curr.val, ++value);
            }
            curr = curr.next;
        }
        for (Map.Entry pair : map.entrySet()) {
            int key = (int)pair.getKey();
            if (map.get(key) == 1) {
                if (res == null) {
                    res = new ListNode(key);
                    start = res;
                } else {
                    res.next = new ListNode(key);
                    res = res.next;
                }
            }
        }
        return start;
    }
}
