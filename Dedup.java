import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by donezio on 10/24/18.
 */
public class Dedup {
    /*
           Given a sorted integer array, remove duplicate elements.
           For each group of elements with the same value keep only one of them.

            {1, 2, 2, 3, 3, 3} ? {1, 2, 3}
     */
    public void depup1(int[] array) {
        int slow = 1;
        int fast = 1;

        while (fast < array.length) {
            if (array[fast] == array[slow -1]) {
                fast++;
            }
            else {
                array[slow] = array[fast];
                slow++;
                fast++;
            }
        }
    }

    // same as dedup1, but only keep the last two
    public void depup2(int[] array) {
        int slow = 1;
        int fast = 1;

        while (fast < array.length) {
            // check the
            if (slow - 2 >= 0 && array[fast] == array[slow -2]) {
                fast++;
            }
            else {
                array[slow] = array[fast];
                slow++;
                fast++;
            }
        }
    }


    // same as dedup1, dont keep any repeat value
    public void depup3(int[] array) {

        int slow = 0;
        int fast = 0;
        int begin = fast;

        while (fast < array.length) {
            begin = fast;
            // check next value's index that is different
            while (fast < array.length && array[fast] == array[begin]) {
                fast++;
            }
            // if the next index is fast + 1
            if (fast - begin == 1) {
                array[slow] = array[begin];
                slow++;
            }
        }
    }

    // remove duplicate number repeatly
    // {1, 2, 3, 3, 3, 2, 2} ? {1, 2, 2, 2} ? {1}, return
    public void depup4(int[] array) {
        Deque<Integer> stack = new LinkedList<>();
        int index = 0;
        while (index < array.length) {
            if (stack.size() == 0 || stack.peekFirst() != array[index]) {
                stack.offerFirst(array[index]);

            }
            else {
                int tmp = stack.pollFirst();
                while (index < array.length &&  array[index] == tmp) {
                    index++;
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pollLast();
        }
    }
}
