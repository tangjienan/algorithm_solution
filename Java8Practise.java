import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by donezio on 1/30/19.
 */
public class Java8Practise {



    /*
        interface can have default implementation, class implement interface can override this method
        all method in interface are public
     */
    interface myInterface {
        default void hello() {
            System.out.println("hey");
        }

        static void helloStatic() {
            System.out.println("static hello");
        }
        int i = 20;
    }

    static class Foo implements myInterface {

        int i = 30;

        @Override
        public void hello() {
            //myInterface.super.hello();
            System.out.println("no hey" + myInterface.i + " " + i);
        }

        public void helloStatic() {

        }
    }


    static class mapFilterReduce {
        // creating a stream
        public void createStream() {
            // Create an ArrayList
            List<Integer> myList = new ArrayList<Integer>();
            myList.add(1);
            myList.add(5);
            myList.add(8);
            // Convert it into a Stream
            Stream<Integer> myStream = myList.stream();

            // Create an array
            Integer[] myArray = {1, 5, 8};
            // Convert it into a Stream
            Stream<Integer> myArrayStream = Arrays.stream(myArray);

        }

        public static void mapExample() {
            String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};
            Stream<String> myStream = Arrays.stream(myArray);
            Stream<String> newStraam = myStream.map(s -> s.toUpperCase());
            String[] newArray = newStraam.toArray(String[] :: new);
        }

        public static void streamExample() {
            String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};
            Arrays.stream(myArray)
                    .filter(s -> s.length() > 4)
                    .toArray(String[]::new);
        }

        public static void reduce() {
            int myArray[] = { 1, 5, 8 };
            int sum = Arrays.stream(myArray).sum();

            String[] myArray1 = { "this", "is", "a", "sentence" };
            String result = Arrays.stream(myArray1)
                    .reduce("", (a,b) -> a + b);
        }
    }

    public static void main(String[] args) {
        Integer[] array = {2,1,3,4,5,6,7,5,4,3};
        Arrays.sort(array, (a,b) -> (b - a));
        Arrays.stream(array).forEach(e -> System.out.print(e));
        System.out.println("");
        Integer[] newArray = Arrays.stream(array).filter(a -> a < 5).toArray(Integer[] :: new);
        Arrays.stream(newArray).forEach(e -> System.out.print(e));
        System.out.println("");
        int max = Arrays.stream(newArray).reduce(Integer.MIN_VALUE, (a,b) -> {
            return a.compareTo(b) < 0? b : a;
        });
        System.out.println(max);
    }

}
