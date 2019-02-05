public class quickSelect {
    /*
        Quickselect is a selection algorithm to find the k-th smallest element in an unordered list.
        It is related to the quick sort sorting algorithm.

        he algorithm is similar to QuickSort. The difference is, instead of recurring for both sides (after finding pivot), it recurs only for the part that contains the k-th smallest element.
        The logic is simple, if index of partitioned element is more than k, then we recur for left part. If index is same as k, we have found the k-th smallest element and we return.
        If index is less than k, then we recur for right part. This reduces the expected complexity from O(n log n) to O(n), with a worst case of O(n^2).
     */
    public static void main(String[] args) {
        int[] nums = {1,0,5,3,4,2};
        int num = kthSmallest(nums, 2);
        System.out.println(num);
    }

    // worst case n^2.
    public static int kthSmallest(int[] arr, int k) {
        return kth(arr, k , 0 , arr.length - 1);
    }

    // always use k
    public static int kth(int[] arr, int k, int left, int right) {
        int pivot = partition(arr, left, right);
        if (pivot == k - 1) return arr[pivot];
        // use k here since the numbers in [0, pivot] are all smaller
        if (pivot < k - 1) return kth(arr, k, pivot + 1, right);
        else return kth(arr, k, left, pivot - 1);
    }

    // all the numbers samller than pivot will be on the left, all the number larger than pivot will be on the right
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int start = left;
        int end = right - 1;

        while (start <= end ) {
            if (arr[start] < pivot) {
                start ++;
            } else {
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                end --;
            }
        }
        int tmp = arr[start];
        arr[start] = pivot;
        arr[right] = tmp;
        return start;
    }

    // find the largest number x in the array such that there are at least x number >= x in the array
    // a brute, for every number, find how many numbers larger than this value
    // quickSelct,
    public static int Hindex(int[] arr, int k) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int pivot = partition(arr,left,right);
            if (arr[pivot] <= arr.length - pivot + 1) {
                result = pivot;
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return result;
    }

    // n sized array containing numbers from [0, n], find the missing number
    /*
        1 : brute, for [0 , n] search if it is in the array
        2 : use a hashset, or an auxilary arry to record seen numbers
        3 : calculate sum between [0 - n], get current sum, result is the difference
        4 : binary search, from [0, n[, # of element < x in the original element
        5 : quickSelect if arr[pivot] == pivot, go right, else go left
     */

}
