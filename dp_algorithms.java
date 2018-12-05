/**
 * Created by donezio on 11/7/18.
 */
public class dp_algorithms {

    // Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1],
    // to get the maximal product of p[0]p[1] ... p[m-1]?
    // ?????????????
    static int cutRopr(int n) {
        int[] max = new int[n + 1];
        max[0] = 0;
        max[1] = 1;

        int curMax = 0;
        for (int len = 2; len <= n; len++) {
            for (int j = 1; j < len; j++) {
                curMax = Math.max(curMax, Math.max(max[j], j) * (len - j));
            }
            max[len] = curMax;
            curMax = 0;
        }

        return max[n];
    }
}
