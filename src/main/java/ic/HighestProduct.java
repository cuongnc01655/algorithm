package ic;



import java.util.Arrays;

/**
 * Given an array of integers, find the highest product you can get from three of the integers.
 * The input arrayOfInts will always have at least three integers.
 */
public class HighestProduct {
    public int highestProductOf3(int[] arr) {
        int len = arr.length;
        if (len < 3) throw new RuntimeException("length should be at least 3");
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i: arr) {
            if (i >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i >= max2) {
                max3 = max2;
                max2 = i;
            } else if(i > max3) {
                max3 = i;
            }
            if ( i < 0 && i <= min1) {
                min2 = min1;
                min1 = i;
            } else if (i < 0 && i < min2) {
                min2 = i;
            }
        }
        if (min1 < 0 && min2 < 0) {
            return Math.max(min1 * min2 * max1, max1 * max2 * max3);
        } else {
            return max1 * max2 * max3;
        }
    }
}

