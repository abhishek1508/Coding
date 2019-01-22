import java.util.Stack;

public class NextGreatestElementOnRight {

    private static void nextGreatest(int arr[])
    {
        Stack<Integer> s = new Stack<>();
        s.push(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = -1;
            while (!s.isEmpty() && arr[i] < s.peek()) {
                temp = s.pop();
            }
            if (s.isEmpty()) {
                arr[i] = temp;
            }
            s.push(arr[i]);
        }
    }

    private static void printArray(int arr[])
    {
        for (int anArr : arr) System.out.print(anArr + " ");
    }

    public static void main (String[] args)
    {
        int arr[] = {7,5,8,3,4,1,2,9,11};
        nextGreatest (arr);
        System.out.println("The modified array:");
        printArray (arr);
    }
}
