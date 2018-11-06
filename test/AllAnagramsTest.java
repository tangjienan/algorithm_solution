import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by donezio on 11/5/18.
 */
public class AllAnagramsTest {
    @Test
    public void allAnagrams() throws Exception {
        AllAnagrams aa = new AllAnagrams();
        List<Integer> res = aa.allAnagrams("a", "abcda");
        List<Integer> x = Arrays.asList(0, 4);
        assertEquals(res, x);

        res = aa.allAnagrams("ab", "abcda");
        x = Arrays.asList(0);
        assertEquals(res, x);

        res = aa.allAnagrams("abc", "abcdacbac");
        x = Arrays.asList(0,4,5,6);
        assertEquals(res, x);
    }



}