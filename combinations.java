import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by donezio on 10/23/18.
 */
public class combinations {
    /*
        leetcode 77 combinations
        Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
                Input: n = 4, k = 2
                Output:
                [
                  [2,4],
                  [3,4],
                  [2,3],
                  [1,2],
                  [1,3],
                  [1,4],
                ]
        base     : current candidate number larger than n or already pick k number
        branches : for 1 to N layer, we either pick this number or dont pick this number
    */
    public static List<List<Integer>> combination(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curList   = new ArrayList<>();
        lc77helper(n,k,1,res,curList);
        return res;
    }

    public static void lc77helper(int n, int k, int cur, List<List<Integer>> res, List<Integer> curList) {
        if (curList.size() >= k || cur > n) {
            if (curList.size() == k) {
                List<Integer> tmpList = new ArrayList<>();
                for (Integer i : curList) {
                    tmpList.add(i);
                }
                res.add(tmpList);
            }
            return;
        }
        // pick this number
        curList.add(cur);
        lc77helper(n,k,cur+1, res,curList);
        // dont pick this number
        curList.remove(curList.size() - 1);
        lc77helper(n,k,cur+1,res,curList);
    }


    /*
        leetcode 39 Combination Sum,

        Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
        find all unique combinations in candidates where the candidate numbers sums to target.

        The same repeated number may be chosen from candidates unlimited number of times.

        Input: candidates = [2,3,6,7], target = 7,
        A solution set is:
        [
          [7],
          [2,2,3]
        ]


        base case : sum of current candidates is target or each the end of the numbers
        branches  : for each number, either pick it or not pick it
                    start from the same index in next layer
                    prunt when curSum > target
    */

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curList   = new ArrayList<>();
        lc39helper(candidates,target,res,curList,0,0);
        return res;
    }

    public static void lc39helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> curList, int index, int curSum) {
        // base
        if (index == candidates.length || curSum == target) {
            if (curSum == target) {
                List<Integer> tmpList = new ArrayList<>();
                for (int i : curList) {
                    tmpList.add(i);
                }
                res.add(tmpList);
            }
            return;
        }
        // branch
        for (int i = index; i < candidates.length; i++) {
            if (curSum + candidates[i] <= target) {
                // pick this number
                curList.add(candidates[i]);
                lc39helper(candidates,target,res, curList,i, curSum + candidates[i]);
                // not pick this number
                curList.remove(curList.size() - 1);
            }
        }
    }

    /*
        leetcode 40. Combination Sum II

        Given a collection of candidate numbers (candidates) with DUPLICATE and a target number (target),
        find all unique combinations in candidates where the candidate numbers sums to target.

        Each number in candidates may only be used ONCE in the combination.

        Input: candidates = [10,1,2,7,6,1,5], target = 8,
        A solution set is:
        [
          [1, 7],
          [1, 2, 5],
          [2, 6],
          [1, 1, 6]
        ]

        same as Combination Sum

        base case : sum of current candidates is target or each the end of the numbers
        branches  : for each number, either pick it or not pick it
                    start from the NEXT index in next layer
                    prunt when curSum > target


    */

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort to dedup
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curList   = new ArrayList<>();
        lc40helper(candidates,target,res,curList,0,0);
        return res;
    }

    public static void lc40helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> curList, int index, int curSum) {
        // base
        if (index == candidates.length || curSum == target) {
            if (curSum == target) {
                List<Integer> tmpList = new ArrayList<>();
                for (int i : curList) {
                    tmpList.add(i);
                }
                res.add(tmpList);
            }
            return;
        }
        // branch
        for (int i = index; i < candidates.length; i++) {
            // skip the same value in the same layer
            if (i != index && candidates[i-1] == candidates[i]) continue;
            if (curSum + candidates[i] <= target) {
                // pick this number
                curList.add(candidates[i]);
                lc40helper(candidates,target,res, curList,i + 1, curSum + candidates[i]);
                // dont pick this number
                curList.remove(curList.size() - 1);
            }
        }
    }



}
