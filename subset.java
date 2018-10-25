import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by donezio on 10/24/18.
 */
public class subset {
    /*
        leetcode 78 Subsets

        Given a set of distinct integers, nums, return all possible subsets (the power set).

        Note: The solution set must not contain duplicate subsets.

        Input: nums = [1,2,3]
        Output:
        [
          [3],
          [1],
          [2],
          [1,2,3],
          [1,3],
          [2,3],
          [1,2],
          []
        ]

        base,    index readch the end of array
        layer,   either pick this number or not pick this number

     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        lc78Helper(nums,0,cur,res);
        return res;
    }

    public static void lc78Helper(int[] nums, int index, List<Integer> cur, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> tmpList = new ArrayList<>();
            for (int i : cur) {
                tmpList.add(i);
            }
            res.add(tmpList);
            return;
        }

        // pick this value
        cur.add(nums[index]);
        lc78Helper(nums, index + 1, cur, res);

        // dont pick value
        cur.remove(cur.size() - 1);
        lc78Helper(nums,index + 1, cur,res);

    }


    /*
        leetcode 90 Subset II
        Given a collection of integers that might contain duplicates, nums,
        return all possible subsets (the power set).

        Input: [1,2,2]
        Output:
        [
          [2],
          [1],
          [1,2,2],
          [2,2],
          [1,2],
          []
        ]

        idea :  only pick the first occurence of duplicate numbers

        base : index reach end of array,
        layer : either pick or not pick this number,
                for DEDUP, when not pick this numebr, move index to the next distinct number

    */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        lc90Helper(nums,0,cur,res);
        return res;
    }

    public static void lc90Helper(int[] nums, int index, List<Integer> cur, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> tmpList = new ArrayList<>();
            for (int i : cur) {
                tmpList.add(i);
            }
            res.add(tmpList);
            return;
        }

        // pick this value
        cur.add(nums[index]);
        lc90Helper(nums, index + 1, cur, res);

        // dont pick value

        // move to the next distinct number
        while (index < nums.length -1 && nums[index] == nums[index + 1]) {
            index++;
        }
        cur.remove(cur.size() - 1);
        lc90Helper(nums,index + 1, cur,res);

    }

    /*
        leetcode 416 Partition Equal Subset Sum

        Given a non-empty array containing only positive integers,
        find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

        Input: [1, 5, 11, 5]

        Output: true

        Explanation: The array can be partitioned as [1, 5, 5] and [11].

        target == sum / 2

        base case : curSum == target, index reach end , curSum > target

        layer : either pick this number or not

     */

    // LTE, 0/1 knapsack problem
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return lc416Helper(nums,0,sum/2, 0);
    }

    public static boolean lc416Helper(int[] nums, int index, int target, int curSum) {
        if (index >= nums.length) return false;
        if (curSum > target) return false;
        if (curSum == target) return true;

        // pick this number
        curSum += nums[index];
        boolean checkPick = lc416Helper(nums, index + 1, target, curSum);
        if (checkPick == true) return checkPick;
        // dont pick this number
        curSum -= nums[index];
        boolean checkNotPick = lc416Helper(nums, index + 1, target, curSum);
        if (checkNotPick == true) return checkNotPick;
        return false;
    }

}
