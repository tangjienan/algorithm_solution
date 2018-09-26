import java.util.Arrays;

/**
 * Created by donezio on 9/14/18.
 */
public class solution {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        myHeap mh = new myHeap(arr);
        mh.offer(-20);
        mh.poll();
        mh.poll();
        mh.offer(-20);
        System.out.println(Arrays.toString(mh.arr));
    }
}