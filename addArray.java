/**
 * Created by donezio on 9/19/18.
 */
public class addArray {
    // adding two array represented in reverse order
    // solve in recursive way
    /*
    * 2 -> 3 - > 4   is 432
    * 1 -> 4 - > 7   is 741
    * 3711
    * */

    public ListNode addArray(ListNode l1, ListNode l2) {
        return helper(l1,l2,0);
    }

    public ListNode helper(ListNode l1, ListNode l2, int adder) {
        // base case, when two ListNode are all NULL
        if (l1 == null && l2 == null ) {
            if  (adder == 1) {
                return new ListNode(1);
            }
            else {
                return null;
            }
        }
        // handle null
        int tmp1 = (l1 == null)? 0 : l1.value;
        int tmp2 = (l2 == null)? 0 : l2.value;
        ListNode tmpN1 = (l1 == null)? l1 : l1.next;
        ListNode tmpN2 = (l2 == null)? l2 : l2.next;
        // calculate value
        int add = (tmp1 + tmp2 + adder)/10;
        ListNode root = new ListNode((tmp1 + tmp2 + adder)%10);
        // recursive call
        ListNode next = helper( tmpN1, tmpN2, add);
        root.next = next;
        return root;

    }
}
