import java.util.*;

public class trial{
    void printArray(int arr[]){
        for(int i = 0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
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
    // Quick Sort
    int partition(int arr[],int low,int high){
        int pivot = arr[high];
        int i = low-1;

        for(int j = low;j<high;j++){
            if(pivot>arr[j]){
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
    void quickSort(int arr[],int low,int high){
        if(low<high){
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
            
        }
    }
    // Merge Sort 

    void conquer(int arr[],int st,int end ,int mid){
        int merged[] = new int[end-st+1];
        int idx1 = st;
        int idx2 = mid+1;
        int x = 0;

        while(idx1<=mid&&idx2<=end){
            if(arr[idx1]<=arr[idx2]){
                merged[x++] = arr[idx1++];
            }else{
                merged[x++] = arr[idx2++];
            }
        }
        while(idx1<=mid){
            merged[x++] = arr[idx1++];
        }
        while(idx2<=end){
            merged[x++] = arr[idx2++];
        }
        for(int i = 0,j = st;i<merged.length;i++,j++){
            arr[j] = merged[i]; // Coping The array
        }
    }

    void divide(int arr[],int st,int end){
        if(st>=end){
            return;
        }
        int mid = st+(end-st)/2;
        divide(arr, st, mid);
        divide(arr, mid+1, end);
        conquer(arr, st, end, mid);
    }
    // Selection Sort
    void selectionSort(int arr[]){
        int n = arr.length;

        for(int i = 0;i<n-1;i++){
            int minIndex = i;

            for(int j = i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // insertion Sort

    void insertionSort(int arr[]){
        for(int i = 1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;

            while(j>=0&&arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    
    // Heap Sort
    void heapSort(int arr[]){
        int n = arr.length;

        for(int i = n/2-1;i>=0;i--){
            heapify(arr, n, i);
        }

        for(int i = n-1;i>0;i--){

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);

        }
    }

    void heapify(int arr[],int n,int i){
        int largest = i;

        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n&&arr[left]>arr[largest]){
            largest = left;
        }
        if(right<n&&arr[right]>arr[largest]){
            largest = right;
        }

        if(largest!=i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
    public static void main(String args[]){
      int arr[] = {1,3,2,6,5,4};
      trial obj = new trial();
      
      obj.printArray(arr);
      System.out.println();

      obj.heapSort(arr);
      obj.printArray(arr);
      
      
       
    }

}