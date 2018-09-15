/**
 * Created by donezio on 9/14/18.
 */

// 1 sumweight of children node
// 2 ???
// 3 sumString

public class sumString {

    // assume string always valid
    public boolean sumString(String str) {
        /*
        *  generate all possible a1 and a2
        *  for every possible combination of a1 + a2 recursively check if the next value if a1 + a2
        * */
        for (int i = 0; i < str.length() - 2; i++) {
            for (int j = i+1; j < str.length() - 1; j++) {
                for (int k = j+ 1; k < str.length(); k++) {
                    int a1 = Integer.valueOf(str.substring(i,j));
                    int a2 = Integer.valueOf(str.substring(j,k));
                    if (checkNext(a1,a2, k, str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkNext(int a, int b, int index, String str) {
        if (index == str.length()) return true;
        String a3 = a + b + ""; //convert to string to get number of digit
        if (index + a3.length() > str.length()) return false;
        String check = str.substring(index, index + a3.length());
        if (a3.equals(check)) {
            return checkNext(b, Integer.valueOf(a3), index + a3.length(), str);
        }
        return false;
    }
}
