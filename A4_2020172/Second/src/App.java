import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows of the matrix: ");
        int m = Integer.parseInt(in.nextLine());
        System.out.print("Enter the number of columns of the matrix: ");
        int n = Integer.parseInt(in.nextLine());
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();        
            }
        }
        
        in.close();        
    }
}
