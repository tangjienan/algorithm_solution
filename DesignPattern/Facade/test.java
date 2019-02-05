package DesignPattern.Facade;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by donezio on 2/1/19.
 */
public class test {
    public static void main(String[] args) {
        System.out.println(helper("aabbbccdee"));
    }

    public static String helper(String str) {
        if (str == null || str.length() == 0) return str;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            sb.append(e.getKey()).append(e.getValue());
        }

        return sb.toString();
    }

    public static int helper2(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int curSum = arr[0];
        int res = curSum;


        for (int i = 1; i < arr.length; i++) {
           if (arr[i] > arr[i - 1]) {
               curSum += arr[i];
           }
           else {
               curSum = arr[i];
           }
            res = Math.max(curSum, res);
        }

        return res;
    }
}
