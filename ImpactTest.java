import java.util.*;

/**
 * Created by donezio on 10/30/18.
 */
public class ImpactTest {


    /*
   * Turn a array into a comma delimited list
   *
   * Algorithm:  Loop through array, keep start index and end index of the sequential numbers, append into string
   *
   * Space Complexity:  O(n)  created a new string
   * Time  Complexity:  O(n)  loop through the while array
   *
   * @param  nums  input array
   * @return       comma delimited list represented in string
   * */


    public static String commaDelimitedNumber(int[] nums) {

        if (nums == null || nums.length == 0) return "";

        StringBuilder sb = new StringBuilder();

        int end   = 0; // current index we are checking
        int start = 0; // starting index for sequential numbers, equal to end if not sequential

        while (end < nums.length) {
            int pre = nums[start]; // previous number for checking sequential
            // end will point to the last number if there are sequential numbers
            while (end + 1< nums.length && nums[end + 1] == pre + 1) {
                pre = nums[end + 1];
                end++;
            }
            // no sequential
            if (start == end) {
                sb.append(nums[start]).append(",");
            }
            else {
                sb.append(nums[start]).append("-").append(nums[end]).append(",");
            }
            start = end + 1;
            end   = end + 1;
        }
        // remove last comma
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }



    /*
   * Turn a bad String into a good String, a good sting is a string without consecutive same letter
   *
   * Algorithm:  Loop through the String once. If encounter consecutive same letters, add the first occurrence to the resolution and skip the rest.
   *
   * Space Complexity:  O(n)  worst case is that no consecutive same letter, so it add every character into input again.
   * Time  Complexity:  O(n)  Loop through the input String once
   *
   * @param  str  input string, can be null
   * @return      a good string form from the input
   * */
    public static String convertToGoodString(String str) {

        if (str == null || str.length() == 0) return str;

        StringBuilder sb = new StringBuilder();
        int end = 0; // current index we are checking

        while (end < str.length()) {
            int  begin = end;
            char c = str.charAt(begin);
            while (end < str.length() && c == str.charAt(end)) {
                end++;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /*
    * Return all the distinct duplicate number given an array of number with duplicate number
    *
    * Algorithm:  Sort the input array, loop through the array once to get duplicate
    *
    * Space Complexity:  O(1)  if ignore the O(log(n))  space from sorting
    * Time  Complexity:  O(nlog(n)) + O(n) = O(nlog(n))  from sorting the array and loop through the array
    *
    * @param  nums  input array with positive integer,can be null
    * @return       an array of distinct duplicate numbers or empty array if no duplicate
    * */
    public static int[] distinctDupElem(int[] nums) {

        if (nums == null || nums.length == 0) return new int[0];

        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        int end = 0; // current index we are checking

        while (end < nums.length) {
            int begin = end;
            while (end < nums.length && nums[end] == nums[begin]) {
                end++;
            }
            if (end - begin != 1) {
                list.add(nums[begin]);
            }
        }

        int[] res = new int[list.size()];
        for (int index = 0; index < list.size(); index++) {
            res[index] = list.get(index);
        }
        return res;
    }

    /*
    * Check if a String contains all characters between a to z
    *
    * Algorithm:  Check each character one by one, if it is between a and z, add it to a set.
    *             After going throught the String, check the size of set, return true if length is 26
    *
    * Space Complexity:  O(n), size of the hashset, at most 26
    * Time  Complexity:  O(len(str), length of the string
    *
    * @param  str  input string, can be null
    * @return      a boolean value
    * */
    public static boolean isComplete(String str) {
        // impossible to contain all the characters
        if (str == null || str.length() < 26) return false;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ( 'a' <= c && c <= 'z') {
                set.add(c);
            }
        }
        return set.size() == 26;
    }
}
