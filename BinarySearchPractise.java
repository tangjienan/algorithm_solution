import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by donezio on 1/29/19.
 */
public class BinarySearchPractise {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1,1,1};
        print(getOccurenceInSortedArray(arr,1));
    }

    /**
     *  Search in known search space
     *  find the insertion position for a target number
     *  1 2 3 3 3 6 insert 3 return 2
     *  find the largest smaller number
     */
    static public int insertionIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) { // there always will be 3 elements in the while loop, left mid right
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // when while loop exsite, we need to chekc left right right + 1
        if (arr[left] >= target) return left;
        if (arr[right] >= target) return right;
        return right + 1;
    }


    /*
        search the minimum number in a rotated sorted array with no duplicate
     */
    static public int rotatedMin(int[] arr) {
        int start  = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start  + (end - start) / 2;
            if (arr[mid] < arr[end]) { // right part is sorted
                end = mid;
            } else { // left part sorted and num[mid] is not the minimum
                start = mid + 1;
            }
        }
        return arr[start];
    }

    /*
        search the minimum number in a rotated sorted array with duplicate
     */
    static public int rotatedMinWithDup(int[] arr) {
        int start  = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // mid belongs to right part
            int mid = start  + (end - start) / 2;
            if (arr[mid] < arr[end]) { // right part is sorted
                end = mid;
            } else if (arr[mid] > arr[end]){ // left part sorted and num[mid] is not the minimum
                start = mid + 1;
            } else { // mid == end, reduce search space
                end -= 1;
            }
        }
        return arr[start];
    }

    /**
     *
     * @return -1 if not found, index if found
     */
    static public int rotatFindTarget(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        // mid is part of right part
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < arr[end]) { // right part sorted
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[start] <= target && arr[mid - 1] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return arr[start] == target? start : -1;
    }

    /*
        [1 ,3 , 6, 7, | 4, 2, 0]

        compare to the next number, if larger, then search left
                                    if smaller, then search right
     */
    static public int increasingDecreasingArrayFindMax(int[] arr) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return arr[start];
    }

    /*
        inf 1 3 2 4 5 inf

        compare to the next elemtn, if larger, then go right
                                    if smaller, left and keep mid
     */
    static public int findLocalMin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return arr[start];
    }

    /*
            get peak in a 2d matrix
            Same idea as finding peak in an arry, but in a 2d matrix

            Consider mid column and find maximum element in it.
            Let index of mid column be ?mid?, value of maximum element in mid column be ?max? and maximum element be at ?mat[max_index][mid]?.
            If max >= A[index][mid-1] & max >= A[index][pick+1], max is a peak, return max.
            If max < mat[max_index][mid-1], recur for left half of matrix.
            If max < mat[max_index][mid+1], recur for right half of matrix.
     */



    /*
        a number occurs more than 1/4 in the array

        xAxBxCxD the number can only be in these 4 positions
        // find each one of them, and do a binary search to ind the occurance, check if target
     */
    public static int quarterNumber(int[] arr) {
         /*
            quarter = arr/4
            for int i = quarter, i < arr.length, i += quarter
                use binary search to get left boudary and right boundary, # = right - left + 1, check #

          */

         return -1;
    }

    // use binary search to find number of occurence of a number in a sorted array
    public static int getOccurenceInSortedArray(int[] arr, int target) {
        // find left boundary
        int start = 0;
        int end = arr.length - 1;
        while (start  < end) {
            int mid = start  + (end - start ) / 2;
            if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // start start + 1, target is one of this
        int leftBound = arr[start] == target? start : start + 1;

        // get right bound
        start = 0;
        end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // start -1  , start, target is one of this
        int rightBound = arr[start] == target? start : start - 1;

        return rightBound - leftBound + 1;
    }


    /*
        sorted the array after the element go though ax^2 + bx + c

        find element closest to -b/2, use two pointers

        compare one by one

     */
    public static int sortedNumberAfterFormular(int[] a) {
        return -1;
    }


    // return a sorted number after every element is square
    public void sortedSquare(int[] arr) {
        /*
            -8, - 3, 1 , 3, 9

            seperate it into two list, one for negative number one for postion
            reserve the negative number

            merge two lists

         */

        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negative.add((arr[i]));
            } else {
                positive.add(arr[i]);
            }
        }

        Collections.reverse(negative);

        // do a merge sort for two list
        // return a new array
    }


    // Util methods
    static public void print(String str) {
        System.out.println(str);
    }

    static public void print(int i) {
        System.out.println(i);
    }

    static public void print(List<?> e) {
        for (Object o : e) {
            System.out.println(o);
        }
    }

    static public void print(int[] os) {
        for (int o : os) {
            System.out.println(o);
        }
    }
}
