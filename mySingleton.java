/**
 * Created by donezio on 11/2/18.
 *
 *  singleton implementaion
 */
public class mySingleton {

    private static  mySingleton instance; // lazy evaluation

    private mySingleton() {}

    public static mySingleton getInstance() {
        if (instance == null) {
            instance = new mySingleton();
        }
        return instance;
    }
}
