/**
 * Created by donezio on 9/21/18.
 */
public class Max_SubArr_Divide_Conqure {
    /*
    * Using divide and conqure to solve maximum subarray problem
    * 1 : divide into two part , get max subarray start and end in both part
    * 2 : get max subarray start in first part and end in second part
    *
    * */
    public int divideAndConqure(int[] arr) {
        return helper(0 , arr.length - 1, arr);
    }

    public int helper(int start, int end,int[] arr) {
        if (start > end) return 0;
        if (start == end) return arr[start];

        int mid   = start + (end - start)/2;
        // maximum subarry start and end in left part
        int left  = helper(start, mid, arr);
        // maximum subarray start and end in right part
        int right = helper(mid + 1, end, arr);
        int leftSum = 0;
        int rightSum = 0;
        int tmp = 0;

        // get subarray start in left part
        for (int i = mid; i >= start; i--) {
            tmp += arr[i];
            leftSum = Math.max(tmp, leftSum);
        }
        tmp = 0;
        // get subarray start in right part
        for (int i = mid + 1; i <= end; i++) {
            tmp += arr[i];
            rightSum = Math.max(tmp,rightSum);
        }
        return Math.max(leftSum + rightSum, Math.max(left, right));
    }
}
