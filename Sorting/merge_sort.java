public class merge_sort {
   public static void Conquer(int arr[], int st, int end, int mid) {
    int merged[] = new int[end - st + 1];
    int idx1 = st;
    int idx2 = mid + 1;
    int x = 0;

    while (idx1 <= mid && idx2 <= end) {
        if (arr[idx1] <= arr[idx2]) {
            merged[x++] = arr[idx1++];
        } else {
            merged[x++] = arr[idx2++];
        }
    }

    while (idx1 <= mid) {
        merged[x++] = arr[idx1++];// print the rest of the array if left.
    }

    while (idx2 <= end) {
        merged[x++] = arr[idx2++];// print the rest of the array if left.
    }

    for (int i = 0, j = st; i < merged.length; i++, j++) {
        arr[j] = merged[i];// Coping array.
    }
}

    public static void Divide(int arr[],int st,int end){
        if(st>=end){
            return;
        }
        int mid = st+(end-st)/2;
        Divide(arr, st, mid); // Starting to divide the array in two.
        Divide(arr, mid+1, end);// Starting to divide the array in two.
        Conquer(arr, st, end, mid);// Makes the Array Sorted.
    }
    public static void main(String args[]){
        int arr[] = {6,4,2,7,8,9};
        int n = arr.length;

        Divide(arr, 0, n-1);

        for(int i =0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        
    }
}
