/**
 * Created by donezio on 10/22/18.
 *
 * implementaion of different soring algorithms
 *
 */
public class mySorting {


    public static  void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }

    }


    //
    public static void mergeSort(int[] arr, int i , int j) {
        if ( i >= j) return;
        int mid = i + (j - i)/2;
        mergeSort(arr, i , mid);
        mergeSort(arr,mid+1,j);

        mergeHelper(i, mid + 1, j , arr);
        if (i == 0 && j == arr.length - 1) {
            printArray(arr);
        }
    }

    public static  void mergeHelper(int left, int right, int end, int[] arr) {
        int[] aux = new int[arr.length];
        for (int i = left; i <= end; i++) {
            aux[i] = arr[i];
        }
        int index1 = left;
        int index2 = right;
        int auxIndex = left;
        while (index1 < right || index2 <= end) {
            if (index1 >= right) {
                arr[auxIndex] = aux[index2];
                index2++;
                auxIndex++;
                continue;
            }
            if (index2 > end) {
                arr[auxIndex] = aux[index1];
                auxIndex++;
                index1++;
                continue;
            }
            if (aux[index1] > aux[index2]) {
                arr[auxIndex] = aux[index2];
                auxIndex++;
                index2++;
            }
            else {
                arr[auxIndex] = aux[index1];
                auxIndex++;
                index1++;
            }

        }
    }

    public static void quickSort(int[] arr, int i, int j) {
        if ( i >= j) return;
        int pivot  = arr[j];
        int index1 = 0;
        int index2 = j - 1;
        while (index1 <= index2) {
            if (arr[index1] < pivot) {
                index1++;
            }
            else {
                swap(arr, index1, index2);
                index2--;
            }
        }
        swap(arr,index1,j);
        quickSort(arr,i, index1 - 1);
        quickSort(arr,index1 + 1, j);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println("");
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j]  = tmp;
    }
}
