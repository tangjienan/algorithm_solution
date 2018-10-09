import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;

/**
 * Created by donezio on 9/14/18.
 */
public class solution {
    public static void main(String[] args) {
        myMap map = new myMap();
        System.out.println("DSADASd");
        map.put("test", "test");
        System.out.println(map.get("test"));
        map.remove("test");
        System.out.println(map.get("test"));
    }
}