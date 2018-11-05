import java.util.*;

/**
 * Created by donezio on 10/25/18.
 */
public class Login_Numbers_Per_Interval {

    /*
        Given a list of login sessions with start and end timestamps.

        Get the list of intervals with number of users logged in.

        Examples:

        login sessions: [[1, 2], [0, 4], [5, 6]]

        return [[0, 1, 1], [1, 2, 2], [2, 4, 1], [5, 6, 1]]

        at (0, 1) there is 1 user logged in.

        at (1, 2) there is 2 user logged in.

        at (2, 4) there is 1 user logged in (one user logged out at 2).

        at (5, 6) there is 1 user logged in.
    */


    public int[][] sessionNum(int[][] logins) {
        // <time, login Count>
        Map<Integer, Integer> map = new HashMap<>();
        // start or end point for time, treeSet for sorting
        Set<Integer> endPoints = new TreeSet<>();
        for (int[] login : logins) {
            int start = login[0];
            int end   = login[1];
            endPoints.add(start);
            endPoints.add(end);
            for (int i = start + 1; i <= end; i++) {
                map.put(i, map.getOrDefault(start, 0) + 1);
            }
        }
        List<int[]> res = new ArrayList<>();

        Integer start = null;
        for (Integer endPoint : endPoints) {
            if (start != null) {
                int[] interval = new int[3];
                interval[0] = start;
                interval[1] = endPoint;
                //int count = 0;
                int count = 0;
                for (int i = start + 1; i <= endPoint; i++) {
                    count = Math.max(count, map.getOrDefault(i,0));

                }
                interval[2] += count;
                res.add(interval);
            }
            start = endPoint;
        }
        int[][] resArray = new int[res.size()][3];
        for (int i = 0; i < res.size(); i++) {
            resArray[i][0] = res.get(i)[0];
            resArray[i][1] = res.get(i)[1];
            resArray[i][2] = res.get(i)[2];
        }
        return resArray;
     }


}
