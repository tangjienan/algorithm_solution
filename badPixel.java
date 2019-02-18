/**
 * Created by donezio on 2/13/19.
 */
public class badPixel {

    static int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};

    public static class Dimension {
        int minX = -1;
        int maxX = -1;
        int minH = -1;
        int maxH = -1;

        @Override
        public String toString() {
            return "minX: " + minX + " maxX: " + maxX + " minH: " + minH + " maxH" + maxH;
        }
    }

    static Dimension dimension;

    public static void main(String[] args) {
        int[][] g = {
                        {0,0,1,1,1,1},
                        {0,1,1,1,1,0},
                        {0,1,1,1,0,0},
                        {0,1,1,1,1,1},
                        {0,1,1,1,0,0}
                    };

        //Method 1, DFS traverse
        int[][] visited = new int[g.length][g[0].length];
        dimension = new Dimension();
        traverseBorder(g, 0,2,visited);
        printGraph(g);
        System.out.println(dimension);
        int result1 = getArea(dimension);
        //Method 2, Binary search

    }

    public static void traverseBorder(int[][] g, int i, int j, int[][] visited) {
        if (isBorder(g, i ,j)) {
            update(dimension, i, j);
            g[i][j] = 2;
        }
        visited[i][j] = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= g.length || y < 0 || y >= g[0].length || visited[x][y] == 1|| g[x][y] == 0 ) continue;
            traverseBorder(g, x, y, visited);
        }
    }

    public static boolean isBorder(int[][] g, int i, int j) {
        if (i - 1 >= 0 && g[i-1][j] == 0) {
            return true;
        }

        if (i + 1 < g.length && g[i+1][j] == 0) {
            return true;
        }

        if (j + 1 < g[0].length && g[i][j+1] == 0) {
            return true;
        }

        if (j - 1 >= 0 && g[i][j-1] == 0) {
            return true;
        }

        return false;
    }

    public static void update(Dimension dimension, int i, int j) {
        if (dimension.minH == -1 || j < dimension.minH) {
            dimension.minH = j;
        }

        if (dimension.maxH == -1 || j > dimension.maxH) {
            dimension.maxH = j;
        }

        if (dimension.minX == -1 || i < dimension.minX) {
            dimension.minX = i;
        }

        if (dimension.maxX == -1 || dimension.maxX < i) {
            dimension.maxX = i;
        }

    }

    public static void printGraph(int[][] g) {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                System.out.print(g[i][j]);
            }
            System.out.println();
        }
    }

    public static int getArea(Dimension dimension) {
        return (dimension.minX - dimension.minX + 1) * (dimension.maxH - dimension.minH + 1);
    }

    public static void binarySearch(int[][] g, int x, int y) {
        for (int i = 0; i < g.length; i++) {

        }
    }

    public static int getFirstOne(int[] arr, int i) {
        return 10;
    }

    // 0001111111110000000
    public static int getLastOne(int[] arr, int i) {
        return 10;
    }
}
