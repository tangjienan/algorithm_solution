import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by donezio on 10/22/18.
 *
 *
 * Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.
 */
public class AllValidParentheses {

    String[] parentheses = {"(", ")", "{", "}", "<", ">"};
    int totalLen = 0;
    public List<String> validParentheses(int l, int m, int n) {
        // Write your solution here
        int[] currentNum = new int[]{l,l,m,m,n,n};
        this.totalLen = 2 * l + 2 * m + 2 * n;
        List<String> res = new ArrayList<>();
        helper(currentNum, new StringBuilder(), new LinkedList<>(), res);
        return res;
    }

    public void helper(int[] currentNum, StringBuilder sb, Deque<String> stack, List<String> res) {
        // end of dfs : when res size equal to target size
        if (sb.length() == totalLen) {
            res.add(sb.toString());
            return;
        }
        // in each layer, for each parentheses, add it or not add it
        for (int i = 0; i < currentNum.length; i++) {
            // a left parentheses
            if ( i % 2 == 0) {
                if (currentNum[i] > 0) {
                    // in
                    currentNum[i] -= 1;
                    sb.append(parentheses[i]);
                    stack.offerFirst(parentheses[i]);
                    helper(currentNum, sb, stack,res);
                    // out
                    currentNum[i] += 1;
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                }
            }
            // a right parentheses
            else {
                if (currentNum[i] > 0 && stack.size() != 0 && stack.peekFirst().equals(parentheses[i - 1])) {
                    // in
                    currentNum[i] -= 1;
                    stack.pollFirst();
                    sb.append(parentheses[i]);
                    helper(currentNum,sb,stack,res);
                    stack.offerFirst(parentheses[i-1]);
                    currentNum[i] +=1;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}



