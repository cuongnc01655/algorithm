package main.java.leetcode.binarysearch;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix ={
            {3, 4, 5},
            {8,9, 10},
            {15, 17, 20},
            { 24, 27, 28}
        };
        int[][] matrix2 = {{1}};
        System.out.println(searchMatrix(matrix, 21));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int height = matrix.length;
        int width = matrix[0].length;
        int l = 0, r = height*width - 1;
        while (l != r) {
            int mid = (l + r - 1) / 2;
            int value = matrix[mid / width][mid % width];
            if (value == target) return true;
            if (value < target) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return matrix[r / width][r % width] == target;
    }
}
