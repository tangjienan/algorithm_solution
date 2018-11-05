import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by donezio on 11/5/18.
 */
public class AllAnagrams {

    /*
    *   Find all occurance of anagrams of a given string s in a given string l, return the list of starting indices
    *
    *   Algorithm: sliding window, keep a slow pointer and a fast pointer, check number of matches between [slow, fast]
    *
    * */

    // assum all input are valid
    public List<Integer> allAnagrams(String sh, String lo) {
        Map<Character, Integer> map = new HashMap<>();
        buildMap(sh,map);
        List<Integer> res = new ArrayList<>();
        int count = map.keySet().size();
        int slow = 0;
        for (int i = 0; i < lo.length(); i++) {
            // check count
            if (count == 0 && i - slow  == sh.length()) {
                res.add(slow);
            }
            char c = lo.charAt(i);
            Integer curCount = map.get(c);
            // first append end point
            if (curCount != null) {
                map.put(c, curCount - 1);
                if (curCount == 1) {
                    count -= 1;
                }
            }
            // move slow pointer
            if (i >= sh.length()) {
                char c2 = lo.charAt(slow);
                Integer curCount2 = map.get(c2);
                if (curCount2 != null) {
                    map.put(c2, curCount2 + 1);
                    if (curCount2 == 0) {
                        count++;
                    }
                }
                slow++;
            }
        }
        return res;
    }
    private void buildMap(String sh, Map<Character, Integer> map) {
        for (int i = 0; i < sh.length(); i++) {
            char c = sh.charAt(i);
            map.put(c, map.getOrDefault(c,0 ) + 1);
        }
    }
}
