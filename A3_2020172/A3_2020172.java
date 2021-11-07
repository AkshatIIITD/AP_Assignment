import java.util.ArrayList;
import java.util.Scanner;

public class A3_2020172 {
    public static void opMenu() {
            System.out.println("1. Addition");
            System.out.println("2. Substraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
    }

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
        ArrayList<Matrix> listOfMatrices = new ArrayList<>();
        
            
        menu();
        int optionNo = Integer.parseInt(in.nextLine());
        while (optionNo != 16) {
            
            if (optionNo == 1) {
                System.out.print("Enter uniqueID for the matrix: ");
                String uniqueID = in.nextLine();
                System.out.println("Enter Dimensions");
                System.out.print("Enter no of rows for the matrix: ");
                int noOfRows = Integer.parseInt(in.nextLine());
                System.out.print("Enter no of columns for the matrix: ");
                int noOfColumns = Integer.parseInt(in.nextLine());
                
                for (int i = 0; i < noOfRows; i++) {
                    for (int j = 0; j < noOfColumns; j++) {
                        
                    }
                }
                //listOfMatrices.add(e);

            } else if (optionNo == 2) {
                System.out.println("1. Rectangular Matrix");
                System.out.println("2. Square Matrix");
                System.out.println("3. Row Matrix");
                System.out.println("4. Column Matrix");
                System.out.println("5. Symmetric Matrix");
                System.out.println("6. Skew-symmetric Matrix");
                System.out.println("7. Upper-triangular Matrix");
                System.out.println("8. Lower-triangular Matrix");
                System.out.println("9. Singular Matrix");
                System.out.println("10. Diagonal Matrix");
                System.out.println("11. Scalar Matrix");
                System.out.println("12. Identity Matrix");
                System.out.println("13. Singleton Matrix");
                System.out.println("14. Ones Matrix");
                System.out.println("15. Null Matrix ");
                System.out.print("Enter the index of the type of matrix required from the options above: ");
                int martrixOption = Integer.parseInt(in.nextLine());
                if(martrixOption == 1) {


                } else if (martrixOption == 2) {



                } else if (martrixOption == 3) {



                } else if (martrixOption == 4) {



                } else if (martrixOption == 5) {



                } else if (martrixOption == 6) {



                } else if (martrixOption == 7) {



                } else if (martrixOption == 8) {



                } else if (martrixOption == 9) {



                } else if (martrixOption == 10) {



                } else if (martrixOption == 11) {



                } else if (martrixOption == 12) {



                } else if (martrixOption == 13) {



                } else if (martrixOption == 14) {



                } else if (martrixOption == 15) {



                } else {
                    System.out.println("invalid index number");
                }


            } else if (optionNo == 3) {
                System.out.print("Enter the unique ID of the matrix to be edited: ");
                String inputUniqueID = in.nextLine();



            } else if (optionNo == 4) {
                System.out.print("Enter the unique ID of the matrix to get labels: ");
                String inputUniqueID = in.nextLine();


            } else if (optionNo == 5) {
                opMenu();
                System.out.print("Enter the index of operation type: ");
                int martrixOption = Integer.parseInt(in.nextLine());
                System.out.print("Enter the unique ID of the first matrix: ");
                String matrixID1 = in.nextLine();
                System.out.print("Enter the unique ID of the second matrix: ");
                String matrixID2 = in.nextLine();
                if(martrixOption == 1) {


                } else if (martrixOption == 2) {



                } else if (martrixOption == 3) {



                } else if (martrixOption == 4) {



                } else {
                    System.out.println("invalid index number");
                }


            } else if (optionNo == 6) {
                opMenu();
                System.out.print("Enter the index of operation type: ");
                int martrixOption = Integer.parseInt(in.nextLine());
                System.out.print("Enter the unique ID of the first matrix: ");
                String matrixID1 = in.nextLine();
                System.out.print("Enter the unique ID of the second matrix: ");
                String matrixID2 = in.nextLine();
                if(martrixOption == 1) {


                } else if (martrixOption == 2) {



                } else if (martrixOption == 3) {



                } else if (martrixOption == 4) {



                } else {
                    System.out.println("invalid index number");
                }


            } else if (optionNo == 7) {
                System.out.print("Enter the unique ID of the matrix: ");
                String inputUniqueID = in.nextLine();


            } else if (optionNo == 8) {
                System.out.print("Enter the unique ID of the matrix: ");
                String inputUniqueID = in.nextLine();


            } else if (optionNo == 9) {
                System.out.println("1. Row-Wise mean");
                System.out.println("2. Column-Wise mean");
                System.out.println("3. Mean of all entries");
                System.out.print("Enter the index of the type of mean required");
                int martrixMeanOption = Integer.parseInt(in.nextLine());
                System.out.print("Enter the unique ID of the matrix: ");
                String inputUniqueID = in.nextLine();
                if (martrixMeanOption == 1) {

                } else if (martrixMeanOption == 2) {

                } else if (martrixMeanOption == 3) {

                } else {
                    System.out.println("invalid index number");
                }


            } else if (optionNo == 10) {
                System.out.print("Enter the unique ID of the square matrix: ");
                String inputUniqueID = in.nextLine();


            } else if (optionNo == 11) {
                



            } else if (optionNo == 12) {
                System.out.print("Enter the unique ID of the matrix: ");
                String inputUniqueID = in.nextLine();



            } else if (optionNo == 13) {




            } else if (optionNo == 14) {




            } else if (optionNo == 15) {
                System.out.print("Enter the label to receive matrices: ");
                String label = in.nextLine();


            } else {
                System.out.println("invalid option number");
            }
            menu();
            optionNo = Integer.parseInt(in.nextLine());
        }
        in.close();
    }
}