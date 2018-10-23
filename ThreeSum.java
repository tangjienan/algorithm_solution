import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by donezio on 10/22/18.
 */
public class ThreeSum {
    // determin if there is 3 values inside the array sum up to target

    // fix a number, perform two sum to the rest, look for sum = target - number
    // O(n^2)
    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here
        Arrays.sort(array);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < array.length -2; i++) {
            int find = target - array[i];
            int j = i + 1;
            int k = array.length - 1;
            while ( j < k) {
                int tmp = array[j] + array[k];
                if (tmp == find) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(i);
                    tmpList.add(j);
                    tmpList.add(k);
                    res.add(tmpList);
                }
                if (tmp < find) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return res;
    }

}
