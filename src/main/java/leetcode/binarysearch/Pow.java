package leetcode.binarysearch;

public class Pow {
    public static void main(String[] args) {
        System.out.println(pow(2.0, 10));
        System.out.println(pow(2.0, Integer.MIN_VALUE));
    }

    private static double pow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        return n % 2 == 0 ? pow(x * x, n/2) : x * pow(x*x, n/2);
    }
}
