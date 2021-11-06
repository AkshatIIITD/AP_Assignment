import java.util.Scanner;

public class A3_2020172 {
    public static void menu() {
        System.out.println("Hello, Welcome to the matrix calculator");
        System.out.println("1. Add matrix in list");
        System.out.println("2. Create matrix according to matrix-type");
        System.out.println("3. Change the elements (type should be constant)");
        System.out.println("4. List types of specific matrix");
        System.out.println("5. Operations between matrices");
        System.out.println("6. Operations between matrices (element-wise)");
        System.out.println("7. Compute the transpose of a matrix");
        System.out.println("8. Compute the insverse of a matrix");
        System.out.println("9. Compute Mean");
        System.out.println("10. Compute the determinant of a matrix");
        System.out.println("11. Using singleton matrix as scalar");
        System.out.println("12. Compute the sum of a matrix and its transpose");
        System.out.println("13. Compute the eigen vectors and values of a matrix (2x2 only)");
        System.out.println("14. Solve linear equations");
        System.out.println("15. Receive list of ");
        System.out.println("16. Exit");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);    
        menu();
        int optionNo = Integer.parseInt(in.nextLine());
        while (optionNo != 16) {
            if (optionNo == 1) {

            } else if (optionNo == 2) {

            } else if (optionNo == 3) {

            } else if (optionNo == 4) {

            } else if (optionNo == 5) {

            } else if (optionNo == 6) {

            } else if (optionNo == 7) {

            } else if (optionNo == 8) {

            } else if (optionNo == 9) {

            } else if (optionNo == 10) {

            } else if (optionNo == 11) {

            } else if (optionNo == 12) {

            } else if (optionNo == 13) {

            } else if (optionNo == 14) {

            } else if (optionNo == 15) {

            } else {
                System.out.println("invalid option number");
            }
            menu();
            optionNo = Integer.parseInt(in.nextLine());
        }

        in.close();
    }
}