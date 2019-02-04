public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4,10,3,5,1};
        sort(arr);
        printArray(arr);
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n-1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i-1, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int parent = i;
        int left = (2*i) + 1;
        int right = (2*i) + 2;
        if (left < n && arr[left] > arr[parent]) {
            parent = left;
        }

        if (left < n && arr[right] > arr[parent]) {
            parent = right;
        }
        if (parent != i) {
            int temp = arr[i];
            arr[i] = arr[parent];
            arr[parent] = temp;
            heapify(arr, n, parent);
        }
    }
}
