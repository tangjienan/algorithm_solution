import java.util.Arrays;

/**
 * Created by donezio on 10/9/18.
 */
public class myMap <K, V>  {
    /*
    *
    *  A table of buckets (an array of buckets) stroing each <key, value> pair
    *
    *  bucket index is calculated by applying a hash function on the key and the size of the array
    *
    *  e.g : Key -> HashValue -> Index
    *
    *  Collision Control (when two keys is mapped to the same bucket):
    *
    *  Seperate Chaining : store in a LinkedList
    *
    *  Open Addressing : all element are store in the hashtable
    *
    *   1 : Linear Probing : linearly looks for the next slot
    *   2 : Quadratic Probing : look for the i^2 th slot in the ith iteration
    *
    *   Rehashing : too many collision so need to expand the array to move all <key, value> pairs to new index
    *
    *   load factor : to control when rehashing is needed, number of <key, value> / numbers of buckets, default to 0.75
    *
    *   This implementation uses seperate chaining for collision control
    *
    *   Supports these operations :
    *
    *   size()
    *
    *   isEmpty()
    *
    *   clear()
    *
    *   put(K key, V value)
    *
    *   get(K key)
    *
    *   containsKey(K key)
    *
    *   remove(K key)
    *
    * */


    // <Key , Value> pair class
    public static class Node <K, V> {
        private final K key;
        private V value;
        Node<K, V> next = null; // linkedlist point to the next <Key, Value> pair

        public Node (K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V v) {
            value = v;
        }
    }

    private static final int INIT_CAP = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Node<K, V>[] array;
    private int size;

    public myMap() {
        array = new Node[INIT_CAP];
        size  = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear () {
        Arrays.fill(array,null);
        size = 0;
    }

    public  V get(K key) {
        int index = index(key);
        if (array[index] != null) {
            // loop through linkedlist
            Node<K,V> head = array[index];
            while (head != null) {
                if (equalKey(key, head.getKey())) {
                    return head.getValue();
                }
                head = head.next;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = index(key);
        if (array[index] != null) {
            // loop through linkedlist
            Node<K,V> head = array[index];
            while (head != null) {
                if (equalKey(key, head.getKey())) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    // need to rehash when load factor too large
    public void put(K key, V value) {
        int index = index(key);
        Node<K,V> node = array[index];
        while (node != null) {
            // update value if key exsite before
            if (equalKey(node.getKey(), key)) {
                node.setValue(value);
                return;
            }
            node = node.next;
        }
        Node<K, V> newNode = new Node<K, V>(key,value);
        newNode.next = array[index];
        array[index] = newNode;
        size++;
        if (needRehashing()) {
            rehash();
        }
    }

    // return the removed value, null if nothing is removed
    public V remove (K key) {
        int index = index(key);
        Node<K,V> node = array[index];
        Node<K,V> dummyHead  = new Node<K, V>(null, null);
        Node<K,V> prev = dummyHead;
        dummyHead.next = array[index];
        while (node != null) {
            if (equalKey(node.getKey(),key)) {
                V val = node.getValue();
                prev.next = node.next;
                array[index] = dummyHead.next;
                return val;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    private int hash(K key) {
        if (key == null) return 0;
        int code = key.hashCode();
        return code & 0x7fffffff; // 32 bit binary value with all 1 except thw signed bit
    }

    // calculate index of array based on hashcode of the key
    private int index(K key) {
        return  hash(key) % array.length;
    }

    private boolean needRehashing() {
        return size > LOAD_FACTOR * array.length;
    }

    private  boolean equalKey(K a, K b) {
        if (a == b) return true; // same memory address
        if (a != null && a.equals(b)) return true; // same value
        return false;
    }

    private void rehash() {
        Node<K,V>[] old = array;
        array = new Node[array.length * 2];
        for (Node<K,V> node : old) {
            // go through Linkedlist
            while (node != null) {
                Node next = node.next;
                int i = index(node.getKey());
                // move to the head of the bucket
                node.next = array[i];
                array[i] = node;
                node = next;
            }
        }
    }

}
