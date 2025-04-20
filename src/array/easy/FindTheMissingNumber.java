package array.easy;

public class FindTheMissingNumber {
    private  int findMissingNumber(int a[])
    {
        int actualSum = 0;
        int n = a.length+1;
        for(int num : a)
        {
            actualSum +=num;
        }
       int formulaSum = n*(n+1)/2;

        return  formulaSum- actualSum;
    }

    public static void main(String[] args) {
        int a [] = {1,2,3,4,5,6,8};
        FindTheMissingNumber obj = new FindTheMissingNumber();

        System.out.println(obj.findMissingNumber(a));
    }
}
