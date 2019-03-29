public class LC88_MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        int m = 0;
        int n = 1;
        merge(nums1, m, nums2, n);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        //1,2,3,0,0,0
        //2,5,6
        int len2 = nums2.length;
        int len1 = nums1.length;
        int pointer = m+n-1;
        int pointer1 = m-1;
        int pointer2 = n-1;

        while (pointer1 >= 0 && pointer2 >= 0) {
            if (nums2[pointer2] > nums1[pointer1]) {
                nums1[pointer] = nums2[pointer2];
                pointer2--;
            } else {
                nums1[pointer] = nums1[pointer1];
                pointer1--;
            }
            pointer--;
        }
        System.arraycopy(nums2, 0, nums1, 0, pointer2+1);
    }
}
