import java.util.NoSuchElementException;

/**
 * Created by donezio on 9/26/18.
 */
public class myHeap  {
    /*
    * implementation of min-heap based on array, starting at index 0, all elements are unique
    * */

    int[] arr;
    int capacity;
    int index;
    int initialCapacity;
    int size;

    // initialization of min - heap with an array
    public myHeap(int[] array)  {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array can not be null or empty");
        }
        this.arr = array;
        this.size = array.length;
        heapify();
    }

    // initialization of min - heap with size
    public myHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity should be larger than 0");
        }
        this.arr = new int[cap];
        this.size = 0;
    }
    // return the top of heap
    public int peek() {
        if (size <= 0) {
            throw new IllegalArgumentException("heap is null or empty");
        }
        return arr[0];
    }

    // remove the top of heap
    // 1 : remove value at index 0
    // 2 : put last value on top
    // 3 : percolate down
    public int poll() {
        if (size <= 0) {
            throw new NoSuchElementException("heap is null or empty");
        }
        int result = arr[0];
        arr[0] = arr[size - 1];
        size = size - 1;
        percolateDown(0);
        return result;
    }

    // insert value into min heap
    // 1 : expand array if full
    // 2 : append in the end
    // 3 : percolateUp
    public void offer(int ele) {
        // expand
        if (size == arr.length) {
            int[] newArray = new int[(int)(arr.length * 1.5)];
            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
        // insert
        arr[size] = ele;

        percolateUp(size);
        size  = size + 1;
    }

    // convert an array into a heap
    // perform percolateDown for each node with a children, from deepest level to top
    // O(n)
    public void heapify() {
        int lastParentIndex = (this.size - 2)/2;
        for (int i = lastParentIndex; i >= 0; i-- ) {
            System.out.println(i);
            percolateDown(i);
            //System.out.println("heapify");
        }
    }

    // O(n) finding the position
    // percolateDown or Up O(logN)
    // return original value or current value if ele not found
    public int update(int ele) {
        // find ele index in heap
        int updateIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                updateIndex = i;
                break;
            }
        }
        // ele not in heap, just offer it to heap
        if (updateIndex == - 1) {
            offer(ele);
            return ele;
        }
        //
        int result = arr[updateIndex];
        if (result < ele) {
            percolateUp(updateIndex);
        }
        else {
            percolateDown(updateIndex);
        }
        return result;
    }

    // current size of the heap
    public int size() {
        return size;
    }

    // current size if empty
    public boolean isEmpty() {
        return arr.length == 0;
    }

    // current heap is full
    public boolean isFull() {
        return size == arr.length;
    }

    // move value up of the heap
    // 1 : compare current vlaue with parent value
    // 2 : swap with parent if smaller, break if larger
    // O(logN)
    private void percolateUp(int idx) {
        while (idx > 0) {
            int parentIndex = (idx - 1) / 2;
            if (arr[parentIndex] > arr[idx]) {
                int tmp = arr[parentIndex];
                arr[parentIndex] = arr[idx];
                arr[idx] = tmp;
            }
            else {
                break;
            }
            idx = parentIndex;
        }
    }

    // move value down of the heap
    // 1 : get child indexes
    // 2 : move down if larger than child value
    // O(logN)
    private void percolateDown(int idx) {

        // idx needs to have children
        while (idx <= ((size - 2)/2)) {
            int leftIndex = idx * 2 + 1;
            int rightIndex = idx * 2 + 2;
            int swapIndex = leftIndex;
            // swap with right child if right child exist and right child is smller than left child
            if (rightIndex < size && arr[rightIndex] < arr[leftIndex]) {
                swapIndex = rightIndex;
            }
            //System.out.println(arr[idx] + "  " + arr[swapIndex]);
            if (arr[idx] < arr[swapIndex]) {
                break;
            }
            else {

                int tmp = arr[idx];
                arr[idx] = arr[swapIndex];
                arr[swapIndex] = tmp;

            }
            idx = swapIndex;
        }
    }

}
