/**
 * Created by donezio on 10/24/18.
 */
public class Knapsack {

    /*
        leetcode 416 Partition Equal Subset Sum

        Given a non-empty array containing only positive integers,
        find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

        Input: [1, 5, 11, 5]

        Output: true

        idea : either pick or not pick a number to reach target(sum / 2)

        dp[i][j] means whether the specific sum j can be gotten from the first i numbers.

        base case: dp[0][0] is true
        induction rule:  dp[i][j] = dp[i-1][j] || dp[i-1][j - num[i - 1]

        left to right
        top to bottom

        return dp[nums.length][target]
     */

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        // can be optimized to 1D array
        boolean[][] dp = new boolean[nums.length + 1][sum/2 + 1];
        // base case
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                boolean checkLeft = (j - nums[i-1] >= 0)? dp[i-1][j- nums[i-1]] : false;
                dp[i][j] = dp[i-1][j] || checkLeft;
            }
        }
        return dp[nums.length][sum/2];
    }
}
