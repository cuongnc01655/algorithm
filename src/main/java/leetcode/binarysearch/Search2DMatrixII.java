package leetcode.binarysearch;

public class Search2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix ={
                { 3,  4,  7,  9},
                { 8, 10, 12, 17},
                {15, 17, 18, 20},
                {16, 24, 27, 28}
        };
        System.out.println(searchMatrix(matrix, 18));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            int val = matrix[row][col];
            if (val == target) return true;
            if (val < target) {
                row++;
            } else {
                col --;
            }
        }
        return false;
    }
}
