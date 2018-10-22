import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by donezio on 10/21/18.
 *
 *
 *  Iterative inOrder, preOrder and postOrder tree traversal
 *
 *  ALL input are valid tree
 *
 */

public class interative_tree_traversal {

    // print out the node the first time we visit it
    static void perOrder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (stack.size() != 0) {
            TreeNode cur = stack.pollFirst();
            System.out.println(cur.val);
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
        }
    }



    // print out the node the second time we visit it
    static void inOrder(TreeNode root) {
        TreeNode pre = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (pre != null || stack.size() != 0) {
            if (pre != null) {
                stack.offerFirst(pre);
                pre = pre.left;
            }
            else {
                pre = stack.pollFirst();
                System.out.println(pre.val);
                pre = pre.right;
            }
        }
    }

    // print out a node the third time we visit it
    // check prev node to determine if we are visiting curNode node from top or from bot
    static void postOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        stack.offerFirst(root);
        while (stack.size() != 0) {
            TreeNode cur = stack.peekFirst();
            // we are visiting cur node from top, e.g the first time or the second time we visit this node
            if (pre == null || pre.left == cur || pre.right == cur) {
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                }
                else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                }
                else {
                    // this is a leaf node, we can print it out now
                    System.out.println(cur.val);
                    // pop it from stack cause we dont need it anymore
                    stack.pollFirst();
                }
            }
            // we are visiting cur node from bot
            else {
                // return from the left child
                if (pre == cur.left) {
                    // visit right node
                    if (cur.right != null) {
                        stack.offerFirst(cur.right);
                    }
                    else {
                        // no right node, print it out now
                        System.out.println(cur.val);
                        // pop it from stack cause we dont need it anymore
                        stack.pollFirst();
                    }
                }
                // return from right child
                else {
                    System.out.println(cur.val);
                    // pop it from stack cause we dont need it anymore
                    stack.pollFirst();
                }
            }
            pre = cur;
        }
    }
}
