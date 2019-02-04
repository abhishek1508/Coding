import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_215_KthLargestElement {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 4));
    }

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n1 - n2;
            }
        });

        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
