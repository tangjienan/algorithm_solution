import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;

/**
 * Created by donezio on 9/14/18.
 *
 *
 *
 *
 */
public class solution {
    public static void main(String[] args) {

        /*
                        3
                     2     5
                  0      4
                    1
         */

        TreeNode root = TreeNode.exampleTree();
        interative_tree_traversal.postOrder(root);


    }
}