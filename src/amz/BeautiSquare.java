package amz;

public class BeautiSquare {
    public static void main(String[] args) {
        int n = 11;
        int size = 2*n - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int x = i < n ? i : size - i - 1;
                int y = j < n ? j : size - j - 1;
                int value = n - Math.min(x, y);
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
