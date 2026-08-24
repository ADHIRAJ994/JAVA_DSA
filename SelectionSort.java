public class SelectionSort {
    void printArray(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    void SelectSort(int arr[], int size) {
        int temp;
        for (int i = 0; i < size - 1; i++) {
            int smallest = i;
            for (int j = i+1; j < size; j++) {
                if(arr[smallest]>arr[j]){
                    smallest = j;
                }
        }
        temp = arr[smallest];
        arr[smallest] = arr[i];
        arr[i] = temp;
    }
}
    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort();
        int arr[] = {2, 5, 3, 1, 6, 7};
        int size = arr.length;
        
        System.out.println("Before sorting:");
        obj.printArray(arr, size);
        
        obj.SelectSort(arr, size);
        
        System.out.println("\nAfter sorting:");
        obj.printArray(arr, size);
    }
}
