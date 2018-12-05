import java.util.*;

/**
 * Created by donezio on 11/10/18.
 */
public class NS_Sum {
    /*
    *   given N ans S, find all the combination of N numbers that can sum to  S
    *
    * */

    public List<List<Integer>> NS_SUM(int N, int S) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        helper(res,N,0,S,0,cur, visited);
        return res;
    }

    public void helper(List<List<Integer>> res, int N, int curSum, int target, int index, List<Integer> curList, Set<Integer> s) {
        if (curSum > target || curList.size() > N) {
            return;
        }
        if (curSum == target && curList.size() == N) {
            List<Integer> tmp = new LinkedList<>();
            //List<Integer> newList = new ArrayList<>(oldList);
            for (Integer i: curList) {
                tmp.add(i);
            }
            res.add(tmp);
            return;
        }
        for (int i = 0; i <= target; i++) {
            if (s.add(i)) {
                curList.add(i);
                helper(res, N, curSum + i, target, i + 1, curList, s);
                curList.remove(curList.size() - 1);
            }
            s.remove(i);
        }
    }
}
