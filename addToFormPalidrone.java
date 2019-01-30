/**
 * Created by donezio on 1/22/19.
 */
public class addToFormPalidrone {

    /**
     *
     *
     * @param s string
     * @return minimum chars to add to the string to form a palindrone
     */

    public static int addToFormPalidrone(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i > 1) {
                            dp[i][j] = dp[i+1][j-1];
                        } else {
                            dp[i][j] = 0;
                        }
                    } else {
                        dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j]) +1;
                    }
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
