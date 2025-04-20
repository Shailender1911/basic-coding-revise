package array.easy;

import java.util.Arrays;

public class LeftRotateArrayByK {
    public    void rotateLeftByK(int a[], int k )
    {
        int n  = a.length;
         k = k%n;

         reverse(a,0,k-1);
         reverse(a,k,n-1);
         reverse(a,0,n-1);

    }

    private void  reverse(int a[] , int start, int end)
    {
        while(start< end)
        {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        LeftRotateArrayByK leftRotateArrayByK = new LeftRotateArrayByK();
        leftRotateArrayByK.rotateLeftByK(arr, k);
        System.out.println(Arrays.toString(arr));  // [3, 4, 5, 6, 7, 1, 2]
    }
}
