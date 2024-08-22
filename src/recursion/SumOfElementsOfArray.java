package recursion;

public class SumOfElementsOfArray {

    private  static  int sumOfElementsOfArray(int [] a ,int n)
    {
        if(n==0)
            return 0;

        return a[n-1]+sumOfElementsOfArray(a,n-1);
    }

    public static void main(String[] args) {
        int [] a= {10,15,20};
        System.out.printf("Sum of all the elements of array is : %d",sumOfElementsOfArray(a,a.length));
    }
}
