package dpPractise;

import java.util.Arrays;

/**
 * Created by donezio on 1/22/19.
 */
public class dpPractise {


    public static void main(String[] args) {
        mergeSort();
    }



    /**
     *
     *
     * @param s string
     * @return minimum chars to add to the string to form a palindrone
     */

    public int addToFormPalidrone(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i > 1) {
                            dp[i][j] = dp[i+1][j-1];
                        } else {
                            dp[i][j] = 0;
                        }
                    } else {
                        dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j]) +1;
                    }
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    /*
     * Q: ???array????1,0 ????????????????index????????
     ???1 -->0  0 -- >1
     ???????????????array???1 ?????? ??????array??1
     ????????
     ???????????????subarray??????0/1????0??>1???
     ??0????????????????? 1 ? -1, 0 ? 1
     */

    public int swapZeroOne(int[] arr) {

        // 0  1  1   1   0   1   0   1   0   1   1
        // 1 -1 -1  -1   1

        return 0;
    }


    /**
     * sorting algorithms !!!
     */

    public static void quickSort() {

        int[] nums = {9,8,7,6,5,4,3,2,1};
        quickSortH(nums, 0 , nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSortH(int[] arr, int i, int j) {
        if (i >= j) return;

        int pivot = arr[j];
        int start = i;
        j = j - 1;
        int end = j + 1;
        while (i <= j) {
            if (arr[i] >= pivot) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j--;
            } else {
                i++;
            }
        }

        //1543
        int tmp = arr[i];
        arr[i] = pivot;
        arr[end] = tmp;

        quickSortH(arr,start, i -1);
        quickSortH(arr,i + 1, end);

    }

    public static void mergeSort() {
        int[] nums = {9,8,7,6,5,4,3,2,1};
        mergeHelper(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeHelper(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeHelper(arr, left, mid);
        mergeHelper(arr,mid + 1, right);

        sortHelper(arr, left, right, mid);

    }

    public static void sortHelper(int[] arr, int left, int right, int mid) {
        int[] helperArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            helperArray[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;

        int index = left;

        while (i <= mid && j <= right) {
            if (helperArray[i] > helperArray[j]) {
                arr[index] = helperArray[j];
                j++;
            } else {
                arr[index] = helperArray[i];
                i++;
            }
            index++;
        }

        while (i <= mid) {
            arr[index++] = helperArray[i++];
        }

        while (j <= right) {
            arr[index++] = helperArray[j++];
        }

    }

}
