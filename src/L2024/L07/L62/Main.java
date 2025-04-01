package L2024.L07.L62;

/**
 * @author 王强
 * @since 2024/7/12
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
    public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == 0) {
                    matrix[row][col] = 1;
                    continue;
                }
                if (col == 0) {
                    matrix[row][col] = 1;
                    continue;
                }
                matrix[row][col] = matrix[row][col - 1] + matrix[row - 1][col];
            }
        }
        return matrix[m - 1][n - 1];
    }
}
