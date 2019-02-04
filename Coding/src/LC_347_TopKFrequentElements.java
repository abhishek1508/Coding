import java.util.*;

public class LC_347_TopKFrequentElements {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3};
        List<Integer> list = topKFrequent(arr, 2);
        for (int n : list) {
            System.out.print(n +" ");
        }
    }

    private static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return map.get(n1) - map.get(n2);
            }
        });
        for (int n: map.keySet()) {
            q.add(n);
            if (q.size() > k)
                q.poll();
        }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll());
        }
        return result;
    }
}
