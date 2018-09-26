import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by donezio on 9/24/18.
 */
public class Unique_B_Tree_II {
    /* unique binary tree II implementation with memo
    * */

    public List<TreeNode> UBT2 (int n ) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        return helper(1, n, map);
    }

    public List<TreeNode> helper(int start, int end, Map<String, List<TreeNode>> map) {
        if (start > end)  {
            List<TreeNode> tmp = new ArrayList<TreeNode>();
            tmp.add(null);
            return tmp;
        }
        String tmpName = start + "#" + end;
        if (map.containsKey(tmpName)) {
            //System.out.println("prune");
            return map.get(tmpName);
        }
        if (start == end) {
            List<TreeNode> tmp = new ArrayList<TreeNode>();
            tmp.add(new TreeNode(start));
            return tmp;
        }
        List<TreeNode> res = new ArrayList<TreeNode>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left  = helper(start, i - 1, map);
            List<TreeNode> right = helper( i+ 1, end, map);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        map.put(tmpName, res);
        return res;
    }
}
