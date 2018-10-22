/**
 * Created by donezio on 9/24/18.
 */
public class TreeNode {
    // TreeNode
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode exampleTree() {

        /*

                        3
                     2     5
                  0      4
                    1
         */

        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node0.right = node1;
        node2.left  = node0;
        node5.left  = node4;
        node3.left  = node2;
        node3.right = node5;
        return node3;
    }
}
