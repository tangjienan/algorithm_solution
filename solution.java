/**
 * Created by donezio on 9/14/18.
 *
 */
public class solution {


    static class Node<K, V> {
        Node next;
        K key;
        V val;

        Node(K k, V v) {
            this.key = k;
            this.val = v;
            this.next = null;
        }
    }


    static class simpleMap <K, V> {

        Node<K,V>[] nodes;
        int capaticy;
        int currentCapacity = 0;

        simpleMap(int capaticy) {
            nodes = new Node[capaticy];
            this.capaticy = capaticy;
        }

        V get(K k) {
            int index = k.hashCode() % capaticy;
            if (nodes[index] == null) {
                return null;
            } else {
                Node<K,V> head = nodes[index];
                while (head != null) {
                    if (head.key == k) {
                        return head.val;
                    }
                    head = head.next;
                }
            }
            return null;
        }

        void put(K k, V v) {
            if (currentCapacity == capaticy) return;
            int index = k.hashCode() % capaticy;
            Node<K,V> nodeToPut = new Node<K,V>(k,v);
            if (nodes[index] != null) {
                Node head = nodes[index];
                while (head.next != null) {
                    head = head.next;
                }
                head.next = nodeToPut;
            } else {
                nodes[index] = nodeToPut;
            }
        }
    }




    public static void main(String[] args) {
        //int res = addToFormPalidrone.addToFormPalidrone("abcd");
        //System.out.println(res);

        simpleMap<String, String> map = new simpleMap<>(10);
        map.put("hey","hey");
        map.put("hu", "sdasda");
        System.out.println(map.get("hey"));

    }
}