/**
 * Created by donezio on 10/3/18.
 */
public class Maximum_Average_Subarray {
    public double findMAx(int[] nums, int k ) {
        double curMax = 0;
        double cur = 0;
        double[] preSum = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            double last = (i == 0)? 0 : preSum[i - 1];
            preSum[i] = last + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + k - 1; j < nums.length; j++) {
                cur = (double)preSum[j] - preSum[i] + nums[i];
                cur = cur/(double)(j - i + 1);
                if (cur > curMax) {
                    curMax = cur;
                }
            }
        }
        return curMax;
    }
}

