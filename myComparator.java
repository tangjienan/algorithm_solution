import java.util.*;

/**
 * Created by donezio on 9/23/18.
 */
public class myComparator {
    /*code example for creating comparartor and store them inside an array */
    class MyClass {
        int    i1;
        String name;
        MyClass(int i1, String name) {
            this.i1 = i1;
            this.name = name;
        }
    }

    PriorityQueue<MyClass> qp = new PriorityQueue<>((a,b)-> a.i1 - b.i1);

    public void solution() {
        Comparator<MyClass> compare1 = new Comparator<MyClass>() {
            @Override
            public int compare(MyClass o1, MyClass o2) {
                if (o1.i1 < o2.i1) return -1;
                else if (o1.i1 > o2.i1) return 1;
                return 0;
            }
        };
        Comparator<MyClass> compare2 = new Comparator<MyClass>() {
            @Override
            public int compare(MyClass o1, MyClass o2) {
                return o1.name.compareTo(o2.name);
            }
        };
        Comparator<MyClass> compare3 = new Comparator<MyClass>() {
            @Override
            public int compare(MyClass o1, MyClass o2) {
                return - o1.name.compareTo(o2.name);
            }
        };


        Comparator<MyClass>[] arr = new Comparator[3];
        arr[0] = compare1;
        arr[1] = compare2;
        arr[2] = compare3;
        MyClass c2 = new MyClass(11,"ebdfd");
        MyClass c3 = new MyClass(12,"zbdfd");
        MyClass c1 = new MyClass(10,"abcd");


        List<MyClass> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        Collections.sort(list, arr[2]);

        for (MyClass c : list) {
            System.out.println(c.i1 + "  "+ c.name);
        }
    }
}
