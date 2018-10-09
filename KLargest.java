/**
 * Created by donezio on 9/26/18.
 */
public class KLargest {
    /*
    *  the Kth largest element in an unsorted array
    *  solved using quick select algorithm
    *
    *  */

    public int Klargest(int[] arr, int K) {
        int p = helper( 0, arr.length - 1, arr, K);
        return arr[p];
    }

    public int helper(int start, int end, int[] arr, int target) {
        int idx = getIndex(start,end, arr, target);
        if (arr.length - idx == target) return idx;
        else if (arr.length - idx < target) {
            return helper(start, idx - 1, arr ,target);
        }
        else {
            return helper(idx + 1, end, arr, target);
        }
    }

    public int getIndex(int start, int end, int[] arr, int target) {
        int left = 0;
        int right = end - 1;
        int pivot = arr[end];
        while (left <= right) {
            if (arr[left] < pivot) {
                left++;
            }
            else {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                right--;
            }
        }
        return start;
    }
}
