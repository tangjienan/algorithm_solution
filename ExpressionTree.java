import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by donezio on 1/23/19.
 */
public class ExpressionTree {
    public static void main(String[] args) {

    }

    /**
     *   in order expression (3 + 4) * 5 - 6
     *   pre-order expression -*+3456
     *   post-order expression 34+5*6-
     */

    static class Node {
        Node left;
        Node right;

        char c;

        Node(char c) {
            this.c = c;
            left = null;
            right = null;
        }
    }

    /*
                    -
                  /   \
               *        6
              / \
            +    5
          3   4


     */


    public static boolean isOperator(char c) {
        return "-*/+".indexOf(c) != -1;
    }

    // Convert pre-order to inorder
    // Exp: -*+3456
    public static Node preToTree(String str) {
        // algorithm: loop from right to left,
        Deque<Node> stack = new LinkedList<>();
        for (int i = str.length()-1 ; i >= 0; i--) {
            char  c = str.charAt(i);
            if (!isOperator(c)) {
                stack.offerFirst(new Node(c));
            } else {
                Node root = new Node(c);
                root.left = stack.pollFirst();
                root.right = stack.pollFirst();
                stack.offerFirst(root);
            }
        }
        return stack.pollFirst();
    }

    // in order to post order

    /*

        priority

        * - 3
        / - 3
        + - 2
        - - 2
        ( - 1
        ) - 1

        algorithm

        scan from left to right
        1 if operand, append to result
        2 if operator
            1 if ( push to stack
            2 if ) process all the operator in stack until ), at last pop (
            3 remove operator with higher or equal priority to res, push current operator to stack
        3 pop rest operator out and append to result

        Eg: (3 + 4) * 5 - 6

        stack  (   res = ""
        stack  (   res = "3"
        stack  (+  res = "3"
        stack  (+  res = "34"
        stack      res = "34+"
        stack   *  res = "34+"
        stack   *  res = "34+5"
        stack   -  res = "34+5*"
        stack      res = "34+5*6"
     */




}
