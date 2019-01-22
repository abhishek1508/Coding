import java.util.*;

public class LC_15_FindUniqueTripletsAddtoZero {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = findTriplets(nums);
    }

    private static List<List<Integer>> findTriplets(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> uniqueSet = new HashSet<>();
        for (int i = 0; i <nums.length; i++) {
            int start = i+1;
            int end = nums.length-1;
            while (start < end) {
                List<Integer> triplet = new ArrayList<>();
                if (nums[i] + nums[start] + nums[end] == 0) {
                    triplet.add(nums[i]);
                    triplet.add(nums[start]);
                    triplet.add(nums[end]);
                    uniqueSet.add(triplet);
                    start++;
                    end--;
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return new ArrayList<>(uniqueSet);
    }
}
