/**
 * Created by donezio on 10/25/18.
 */
public class MoveZero {

    // given an array, move 0 to the end, keep relative order
    // {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
    // two pointers, slow and fast
    // all valid to the left of slow
    // all zero between slow and fast - 1
    public static int[] moveZero(int[] array) {

        int slow  = 0;
        int fast  = 0;

        while (fast != array.length) {
            if (fast == 0) {
                fast++;
            }
            else {
                array[slow] = array[fast];
                slow++;
                fast++;
            }
        }
        return array;
    }
}
