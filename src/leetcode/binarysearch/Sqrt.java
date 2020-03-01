package leetcode.binarysearch;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(Integer.MAX_VALUE));
//        System.out.println(sqrt(17));
//        System.out.println(sqrt(225));
//        System.out.println(sqrt(10));
    }

    static int sqrt(int num) {
        if (num == 0 || num == 1) return num;
        int left = 0, right = num;

        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid * mid == num) return mid;
            if (mid * mid > num) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }
}
