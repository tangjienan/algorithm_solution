public class YoungMatrix {
    public static void main(String[] args) {

    }

    /*
             3   5   8   12
             8   10  13  17
             9   11  14  18

            from top left -> bottom right, this is a heap

            from top right -> bottom left, this is a binary tree

     */


    // 1 search for target, use the bianry tree view
    // cur > target, go left
    // cur < target, go right;

    public boolean searchTarget(int[][] matrix, int target) {
        int i = 0, j = matrix.length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    // use BST view, for each row, get number of elements that are smaller or equals to target
    public int numberOfElementSmallerThan(int[][] matrix, int target) {
        int i = 0, j = matrix.length - 1;

        int res = 0;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] <= target) {
                res += j + 1;
                i++;
            } else {
                j--;
            }
        }

        return res;
    }

    public int numberOfElementLargerThan(int[][] matrix, int target) {
        int i = 0, j = matrix.length - 1;

        int res = 0;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] <= target) {
                // only line that difference!
                res += matrix[0].length - 1 - j;
                i++;
            } else {
                j--;
            }
        }

        return res;
    }


}
