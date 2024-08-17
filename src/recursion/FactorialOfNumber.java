package recursion;

public class FactorialOfNumber {

    private static  int factorialOfNumber(int n){
        if(n==0)
            return 1;

        return n*factorialOfNumber(n-1);
    }

    public static void main(String[] args) {
        System.out.println(factorialOfNumber(0));
    }
}
