package main.java.leetcode.bitmanipulation;

import java.util.Arrays;

public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        String xBin = Integer.toBinaryString(x);
        String yBin = Integer.toBinaryString(y);
        int maxLen = Math.max(xBin.length(), yBin.length());
        xBin = padMissingZero(xBin, maxLen);
        yBin = padMissingZero(yBin, maxLen);
        int count = 0;
        for (int i = 0; i < maxLen; i++) {
            if (xBin.charAt(i) != yBin.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private static String padMissingZero(String x, int len) {
        int lenNeedPad = len - x.length();
        if (lenNeedPad <= 0) return x;
        String[] pad = new String[lenNeedPad];
        Arrays.fill(pad, "0");
        return String.join("", pad) + x;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(padMissingZero("100", 4));
        System.out.println(padMissingZero("100", 3));
    }
}
