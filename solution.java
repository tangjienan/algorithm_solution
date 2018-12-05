import java.util.List;

/**
 * Created by donezio on 9/14/18.
 *
 */
public class solution {
    public static void main(String[] args) {
        NS_Sum sb = new NS_Sum();
        List<List<Integer>> res = sb.NS_SUM(2,5);
        for (List<Integer> list: res) {
            System.out.println("!!!!!!!!!!!!!!!!");
            for (Integer i : list) {
                System.out.print(i + ",");
            }
            System.out.println("!!!!!!!!!!!!!!!!");
        }
    }
}