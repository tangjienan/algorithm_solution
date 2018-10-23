import java.util.HashSet;
import java.util.Set;

/**
 * Created by donezio on 10/22/18.
 *
 *
 */
public class SwapSwap {
    /*
    *  shuffle input array so that for each i there is i number between them, input range from 1 to N
    *
    *    3 1 2 1 3 2
    *    0 1 2 3 4 5
    * */

    // get all permutation and check each one
    public static void SwapSwapSol1 (int[] arr) {
        helper1(arr,0);
        mySorting.printArray(arr);
    }

    // put each valid number inside array in each slot
    public static  void SwapSwapSol2 (int[] arr) {
        int[] valid = new int[arr.length];
        helper2(1,arr,valid);
    }

    public static void  helper2(int layer,int[] arr,int[] valid) {
        if (layer > arr.length / 2) {
            mySorting.printArray(valid);
            return;
        }
        for (int index = 0; index  < arr.length; index++) {
            if (valid[index] == 0 ) {
                int next = index + layer + 1;
                if (next < arr.length && valid[next] == 0) {
                    valid[index] = layer;
                    valid[next]  = layer;
                    helper2(layer + 1, arr, valid);
                    valid[index] = 0;
                    valid[next]  = 0;
                }
            }
        }
    }



    public static boolean helper1(int[] arr, int index) {
        if (index == arr.length) {
            mySorting.printArray(arr);
            return check(arr);
        }

        // for each layer, swap
        Set<Integer> s = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (s.add(arr[i])) {
                mySorting.swap(arr,index,i);
                if (helper1(arr,i + 1)) return true;
                mySorting.swap(arr,index,i);
            }
        }
        return false;
    }

    public static boolean check(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!s.add(arr[i])) {
                int index = i - (arr[i] + 1);
                if ( index < 0 || arr[index] != arr[i]) return false;
            }
        }
        System.out.println("Yes");
        return true;
    }



}
