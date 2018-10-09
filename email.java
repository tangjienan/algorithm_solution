import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by donezio on 10/3/18.
 */
public class email {
    // modify email input
    public String email(String input) {
        // do nothing
        Set<String> s = new HashSet<String>();
        //Map<String, String> map = new HashMap<>():
        if (input.indexOf(".") == -1 && input.indexOf("+") == -1) return input;
        String[] tmp = input.split("@");
        input = tmp[0];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            if (input.charAt(i) != '.' && input.charAt(i) != '+') {
                sb.append(input.charAt(i));
                i++;
            }
            else {
                if (input.charAt(i) == '+') break;
                else {
                    while (i < input.length() && input.charAt(i) == '.') {
                        i++;
                    }
                }
            }
        }
        return sb.append("@").append(tmp[1]).toString();
    }
}
