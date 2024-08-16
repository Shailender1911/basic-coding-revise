package recursion;

public class BasicRecursion {

    private static void printName5Times(int count, String name) {
        if (count == 5) {
            return;
        }
        System.out.println(name);
        printName5Times(count+1, name);

    }
    public static void main(String[] args) {
        int count = 0;

        printName5Times(count, "Shailender");

    }
}
