import java.util.List;

/**
 * Created by donezio on 9/14/18.
 *
 */
public class solution {
    public static void main(String[] args) {


//        RangeTrees rt = new RangeTrees();
//        RangeTrees.SegmentTree st =  rt. new SegmentTree();
//        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
//
//        st.buildTree(arr);
//
//        System.out.println(st.sumRange(1,2));


        AllAnagrams aa = new AllAnagrams();
        List<Integer> res = aa.allAnagrams("ab", "abcbac");
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}