/**
 * Created by donezio on 12/26/18.
 */
public class GenericTest {

    //Generic class
    public static class Node<T> {
        private  T value;

        public Node<T> next;

        public Node(T val) {
            this.value = val;
        }

        public T getValue() {
            return value;
        }

        public String toString() {
           return "non onoo ";
        }
    }


    public static void main(String[] args) {
       Node<String> node1 = new Node<>("node1");
       Node<String> node2 = new Node<>("node2");

       System.out.println((String)node1.getValue());
        System.out.println((String)node2.getValue());
    }
}
