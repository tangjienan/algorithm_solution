/**
 * Created by donezio on 9/22/18.
 */
public class LPS_DP {
    /*
    * dp solution for longest palindromic substring
    * */
    public String LPS_DP(String str) {
        boolean[][] dp = new boolean[str.length()][str.length()];
        int n = str.length();
        String res = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = str.charAt(i) == str.charAt(j) && ( i - j < 3 || dp[i+1][j-1]);
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = str.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
