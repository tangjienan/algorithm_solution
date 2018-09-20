/**
 * Created by donezio on 9/15/18.
 */
public class RangeSum {
    /*claculate sum of range in an array using segment tree
    * support update function
    * */
    class TreeNode {
        int start;
        int end;
        int sum;
        TreeNode left;
        TreeNode right;
        TreeNode (int s, int e, int v) {
            this.start = s;
            this.end = e;
            this.sum = v;
            this.left = null;
            this.right = null;
        }
    }

    TreeNode root;

    public int countRangeSum(int[] nums, int lower, int upper) {
        root = buildTree(nums, 0, nums.length - 1);
        return helper(root, lower, upper);
    }

    public int helper(TreeNode root, int lower, int upper) {
        if (root.start >= lower && root.end <= upper) {
            return root.sum;
        }
        else if (root.start > upper || root.end < lower){
            return 0;
        }
        else {
            return helper(root.left, lower, upper) + helper(root.right, lower, upper);
        }
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) {
            return new TreeNode(start,end,nums[start]);
        }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(start, end, nums[mid]);
        root.left = buildTree(nums, start, mid);
        root.right = buildTree(nums, mid+1, end);
        return root;
    }
    
}


