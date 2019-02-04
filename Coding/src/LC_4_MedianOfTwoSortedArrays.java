public class LC_4_MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3};
        int[] arr2 = new int[]{2};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int length1 = nums1.length;
        int length2 = nums2.length;

        int start = 0;
        int end = length1;

        if (length1 == 0) {
            return findMedian(nums2);
        } else if (length2 == 0) {
            return findMedian(nums1);
        }

        while (start < end) {
            int partitionX = start + end;
            int partitionY = (length1 + length2 + 1)/2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == length1 ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == length2 ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((length1 + length2) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                end = partitionX - 1;
            } else {
                start = partitionX + 1;
            }
        }
        return -1;
    }

    private static double findMedian(int[] arr) {
        int length = arr.length;
        if (length % 2 == 0) {
            int high = length/2;
            int low = high - 1;
            return (double)(arr[low] + arr[high]) / 2;
        } else {
            return (double)arr[length/2];
        }
    }
}
