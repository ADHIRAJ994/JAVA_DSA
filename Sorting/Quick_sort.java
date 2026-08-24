import java.util.*;

public class Quick_sort {
    public static int partition(int arr[],int low,int high){
        int pivot = arr[high];
        int i = low-1;// Starting from -1.

        for(int j = low;j<high;j++){
            if(arr[j]<pivot){
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
    public static void quickSort(int arr[],int low,int high){
        if(low<high){
            int pivot_Index = partition(arr,low,high);

            quickSort(arr, low, pivot_Index-1);
            quickSort(arr, pivot_Index+1, high);
        }
    }

    
    public static void main(String args[]){
        int arr[]  = {6,3,9,5,2,8};
        int n = arr.length;

        quickSort(arr, 0, n-1);
        for(int i =0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}


// Bubble      -> O(n²)
// Selection   -> O(n²)
// Insertion   -> O(n²)
// Merge       -> O(n log n)
// Quick       -> O(n log n), Worst O(n²)
// Heap        -> O(n log n)
// Counting    -> O(n + k)
// Radix       -> O(d(n+k))