package patterns;

public class Patterns {

    public static void main(String[] args) {
        // print4Star();
        //incrementStarInEveryLine();
      //  trianglePrint(5);
        reverserTrianglePrint(5);
        incrementNumberPrintinInEachLine(4);
    }

    private static void incrementNumberPrintinInEachLine(int n) {

       int num =1;
        for(int i =0;i<n;i++)
        {
            for(int j =i;j<i+1;j++)
            {
                System.out.print(num);
                num = num+1;

            }
            System.out.println("");
        }
    }

    private static void trianglePrint(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
//            System.out.println("");
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void reverserTrianglePrint(int n) {
        for (int i = 0; i < n; i++) {
            for (int j=0;j<i-1;j++) {
                System.out.print(" ");
            }
            for (int k = 2*n-i-1; k <0; k--) {
                System.out.print("*");
            }
//            System.out.println("");
            for (int j = 0; j < i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void incrementStarInEveryLine() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("\n");
        }
    }

    private static void print4Star() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(" * ");
            }
            System.out.println("\n");
        }
    }
}
