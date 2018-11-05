import java.util.List;

/**
 * Created by donezio on 11/3/18.
 */

public class RangeTrees {

    /*
    *   Implementation of Segment tree, Interval tree, Range tree and Binary indexed tree
    *
    * */



    public class SegmentTree {
        /*
        * Segment Tree is used in cases where there are multiple range queries on array and modifications of elements of the same array.
        *
        * So Array size is FIXED
        *
        * https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/tutorial/
        *
        * Segment tree stores intervals, and optimized for "which of these intervals contains a given point" queries.
        *
        * Segment Tree is used in cases where there are multiple range queries on array and modifications of elements of the same array.
        * For example, finding the sum of all the elements in an array from indices  to , or finding the minimum (famously known as Range Minumum Query problem) of all the elements in an array from indices to .
        * These problems can be easily solved with one of the most versatile data structures, Segment Tree.
        *
        * Once the Segment Tree is built, its structure cannot be changed.
        * We can update the values of nodes but we cannot change its structure. Segment tree provides two operations:
        *
        * Update: To update the element of the array  and reflect the corresponding change in the Segment tree.
        * Query: In this operation we can query on an interval or segment and return the answer to the problem (say minimum/maximum/summation in the particular segment).
        *
        * */

        // it seems segment tree is best use for input that is an array and search sum, min or max for a range in this array
        // store the required info of the range inside the node
        class SegmentTreeNode {
            int start, end;
            SegmentTreeNode left, right;
            int sum; // the sum of the range, should be modify according to the requirement

            public SegmentTreeNode(int start, int end) {
                this.start = start;
                this.end = end;
                this.left = null;
                this.right = null;
                this.sum = 0;
            }
        }

        SegmentTreeNode root = null;

        // construct a segment tree base on input array
        public SegmentTreeNode buildTree(int[] arr) {
            root = buildTree(arr,0,arr.length - 1);
            return root;
        }

        public SegmentTreeNode buildTree(int[] arr, int start, int end) {
            if (start > end) return null;

            SegmentTreeNode root = new SegmentTreeNode(start, end);
            if (start == end) {
                root.sum = arr[start];
                return root;
            }

            int mid = start + (end - start)/2;

            root.left  = buildTree(arr, start, mid);
            root.right = buildTree(arr, mid+1, end);
            root.sum = root.left.sum + root.right.sum;
            return root;
        }

        public void update(int i, int val) {
            update(root, i , val);
        }

        public void update(SegmentTreeNode root, int index, int val) {
            if (root.start == root.end) {
                root.sum = val;
                return;
            }

            int mid = root.start + (root.end - root.start) /2;
            if (index <= mid) {
                update(root.left, index, val);
            }
            else {
                update(root.right, index, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }

        public int sumRange(int i, int j) {
            return sumRange(root,i,j);
        }

        public int sumRange(SegmentTreeNode root, int i, int j) {
            if (root.start == i && root.end == j) {
                return root.sum;
            }
            int mid = root.start + (root.end - root.start)/2;
            if (j <= mid) {
                // range within left side
                return sumRange(root.left, i , j);
            }
            else if (i >= mid + 1){
                // range within right side
                return sumRange(root.right, i , j);
            }
            else {
                return sumRange(root.left, i , mid) + sumRange(root.right, mid+1 , j);
            }

        }

    }

    public class Interval {
        int low;
        int high;
        String id;

        public Interval(int low, int high, String id) {
            this.low = low;
            this.high = high;
            this.id = id;
        }
    }


    public class IntervalTreeNode {
        IntervalTreeNode left;
        IntervalTreeNode right;
        String id; // information stores in this interval
        Interval interval;
        int max;

        public IntervalTreeNode(Interval i) {
            this.max = i.high;
            this.left = null;
            this.right = null;
            this.id = i.id;
            this.interval = new Interval(i.low,i.high,i.id);
        }
    }

    /*
    *   https://www.geeksforgeeks.org/interval-tree/
    *   stores intervals as well, but optimized for "which of these intervals overlap with a given interval" queries.
    *   It can also be used for point queries - similar to segment tree.
    *   1) Add an interval
    *   2) Remove an interval
    *   3) Given an interval x, find if x overlaps with any of the existing intervals.
    *
    *   Every node of Interval Tree stores following information.
    *   a) i: An interval which is represented as a pair [low, high]
    *   b) max: Maximum high value in subtree rooted with this node.
    *
    *   The low value of an interval is used as key to maintain order in BST.
    *   The insert and delete operations are same as insert and delete in self-balancing BST used.
    *
    *   Interval overlappingIntervalSearch(root, x)
        1) If x overlaps with root's interval, return the root's interval.

        2) If left child of root is not empty and the max  in left child
        is greater than x's low value, recur for left child

        3) Else recur for right child.
    */
    public class IntervalTree {
        IntervalTreeNode root;

        public IntervalTree() {
            root = null;
        }

        public IntervalTreeNode insert(Interval i) {
            IntervalTreeNode root = insertHelper(this.root,i);
            if (this.root == null) {
                this.root = root;
            }
            return root;
        }

        public IntervalTreeNode insertHelper(IntervalTreeNode root, Interval i) {

            if (root == null) {
                return new IntervalTreeNode(i);
            }

            // using root low value as key to maintain order
            int rootLow = root.interval.low;

            if (i.low < rootLow) {
                root.left = insertHelper(root.left, i);
            }
            else if (i.low > rootLow){
                root.right = insertHelper(root.right, i);
            }
            else {
                // same low value, sort by high value,
                if (i.high < root.interval.high) {
                    root.left = insertHelper(root.left, i);
                }
                else if (i.high > root.interval.high) {
                    root.right = insertHelper(root.right,i);
                }
                else {
                    // same interval, append to right child
                    root.right = insertHelper(root.right,i);
                }
            }

            // update max value
            if (root.max < i.high) {
                root.max = i.high;
            }

            return root;
        }

        public boolean overLap(Interval i1, Interval i2) {
            if (i1.low <= i2.low && i1.high >= i2.low) return true;
            return false;
        }

        public void search(IntervalTreeNode root, Interval i1, List<String> cur) {
            if (root == null) {
                return;
            }
            if (overLap(root.interval, i1)) {
                cur.add(root.id);
            }

            // can it go left ?
            if (root.left != null && root.left.max >= i1.low) {
                search(root.left, i1,cur);
            }

            // can it go right?
            if (root.right != null && root.right.max >= i1.low) {
                search(root.right, i1,cur);
            }
        }

        // 10 12
        // 10 14
        // 10 11
        // 10 20


    }
}


/*

        RangeTrees rt = new RangeTrees();

        RangeTrees.Interval i1 = rt. new Interval(1,3,"a");
        RangeTrees.Interval i2 = rt. new Interval(1,10,"b");
        RangeTrees.Interval i3 = rt. new Interval(2,8,"c");

        RangeTrees.Interval i4 = rt. new Interval(10,10,"c");

        RangeTrees.IntervalTree it = rt. new IntervalTree();

        it.insert(i1);
        it.insert(i2);
        it.insert(i3);

        List<String> res = new ArrayList<>();

        it.search(it.root,i4,res);

        for (String str : res) {
            System.out.println(str);
        }


 */