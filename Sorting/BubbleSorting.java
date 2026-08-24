import java.util.*;

public class BubbleSorting {

    void printArray(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
    }

   void BubbleSort(int arr[],int n){
        if(n==1){
            return;
        }

        for(int i = 0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        BubbleSort(arr, n-1);
    }

    public static void main(String[] args) {
        BubbleSorting obj = new BubbleSorting();
        int arr[] = {2, 5, 3, 1, 6, 7};
        int size = arr.length;
        
        System.out.println("Before sorting:");
        obj.printArray(arr, size);
        
        obj.BubbleSort(arr, size);
        
        System.out.println("\nAfter sorting:");
        obj.printArray(arr, size);
    }
}
