import java.util.Scanner;

class ColorfulPixelSet {
    int[][][] colorMatrix;

    public void setColorMatrix(int[][][] colorMatrix) {
        this.colorMatrix = colorMatrix;
    }
    
    public int[][][] getColorMatrix() {
        return colorMatrix;
    }

    public int getRows() {
        return colorMatrix.length;
    }

    public int getColumns() {
        return colorMatrix[0].length;
    }
}

class GreyscalePixelSet {

    int[][] greyMatrix;

    public void setGreyMatrix(int[][] greyMatrix) {
        this.greyMatrix = greyMatrix;
    }
    
    public int[][] getGreyMatrix() {
        return greyMatrix;
    }

    public int getRows() {
        return greyMatrix.length;
    }

    public int getColumns() {
        return greyMatrix[0].length;
    }
} 

class Functions <T> {

    public T createMatrix(T newPixelSet, Scanner in) {
        if (newPixelSet instanceof ColorfulPixelSet) {
            System.out.print("Enter the number of rows of the matrix: ");
            int m = Integer.parseInt(in.nextLine());
            System.out.print("Enter the number of columns of the matrix: ");
            int n = Integer.parseInt(in.nextLine());
            int [][][] matrix = new int[m][n][3];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int[] colorset = {1, 1, 1};
                    matrix[i][j] = colorset;
                }
            }
            ((ColorfulPixelSet) newPixelSet).setColorMatrix(matrix);
        } else {
            System.out.print("Enter the number of rows of the matrix: ");
            int m = Integer.parseInt(in.nextLine());
            System.out.print("Enter the number of columns of the matrix: ");
            int n = Integer.parseInt(in.nextLine());
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 1;        
                }
            }
            ((GreyscalePixelSet) newPixelSet).setGreyMatrix(matrix);
        }
        return newPixelSet;
    }

    public T inputMatrix (T newPixelSet, Scanner in) {
        if (newPixelSet instanceof ColorfulPixelSet) {
            System.out.print("Enter the number of rows of the matrix: ");
            int m = Integer.parseInt(in.nextLine());
            System.out.print("Enter the number of columns of the matrix: ");
            int n = Integer.parseInt(in.nextLine());
            int [][][] matrix = new int[m][n][3];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int[] colorset = new int[3];
                    for (int k = 0; k < 3; k++) {
                        colorset[k] = in.nextInt();
                    }
                    matrix[i][j] = colorset;
                }
            }
            ((ColorfulPixelSet) newPixelSet).setColorMatrix(matrix);
        } else {
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
            ((GreyscalePixelSet) newPixelSet).setGreyMatrix(matrix);
        }
        return newPixelSet;
    }

    public void update(T newPixelSet, Scanner in) {
        if (newPixelSet instanceof ColorfulPixelSet) {
            int [][][] matrix = ((ColorfulPixelSet) newPixelSet).getColorMatrix();
            System.out.print("Enter the number of row with number to be updated: ");
            int rowNo = (Integer.parseInt(in.nextLine()) - 1);
            System.out.print("Enter the number of column with number to be updated: ");
            int columnNo = (Integer.parseInt(in.nextLine()) - 1);
            System.out.print("Updating Red, Green or Blue ? (1-red, 2-green, 3-blue): ");
            int rgb = Integer.parseInt(in.nextLine());
            System.out.print("Enter the new value: ");
            int value = Integer.parseInt(in.nextLine());
            matrix[rowNo][columnNo][rgb] = value;
            ((ColorfulPixelSet) newPixelSet).setColorMatrix(matrix);
        } else {
            int [][] matrix = ((GreyscalePixelSet) newPixelSet).getGreyMatrix();
            System.out.print("Enter the number of row with number to be updated: ");
            int rowNo = (Integer.parseInt(in.nextLine()) - 1);
            System.out.print("Enter the number of column with number to be updated: ");
            int columnNo = (Integer.parseInt(in.nextLine()) - 1);
            System.out.print("Enter the new value: ");
            int value = Integer.parseInt(in.nextLine());
            matrix[rowNo][columnNo] = value;
            ((GreyscalePixelSet) newPixelSet).setGreyMatrix(matrix);
        }
    }
    
    public void printer(T newPixelSet) {
        if (newPixelSet instanceof ColorfulPixelSet) {
            int m = ((ColorfulPixelSet) newPixelSet).getRows();
            int n = ((ColorfulPixelSet) newPixelSet).getColumns();
            int [][][] matrix = ((ColorfulPixelSet) newPixelSet).getColorMatrix();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(
                        "[R: "+matrix[i][j][0]+
                        ", G: "+matrix[i][j][1]+
                        ", B: "+matrix[i][j][2]+"] "
                    );                    
                }
                System.out.println();
            }
        } else {
            int m = ((GreyscalePixelSet) newPixelSet).getRows();
            int n = ((GreyscalePixelSet) newPixelSet).getColumns();
            int [][] matrix = ((GreyscalePixelSet) newPixelSet).getGreyMatrix();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
        }  
    }

    public void printNegative(T newPixelSet) {
        if (newPixelSet instanceof ColorfulPixelSet) {
            int m = ((ColorfulPixelSet) newPixelSet).getRows();
            int n = ((ColorfulPixelSet) newPixelSet).getColumns();
            int [][][] matrix = ((ColorfulPixelSet) newPixelSet).getColorMatrix();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(
                        "[R: "+(255-matrix[i][j][0])+
                        ", G: "+(255-matrix[i][j][1])+
                        ", B: "+(255-matrix[i][j][2])+"] "
                    );                    
                }
                System.out.println();
            }
        } else {
            int m = ((GreyscalePixelSet) newPixelSet).getRows();
            int n = ((GreyscalePixelSet) newPixelSet).getColumns();
            int [][] matrix = ((GreyscalePixelSet) newPixelSet).getGreyMatrix();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print((255-matrix[i][j])+" ");
                }
                System.out.println();
            }
        }
    }
}

public class App <T>{

    public static void menu() {
        System.out.println("------------------------------");
        System.out.println("-------------MENU-------------");
        System.out.println("1. Print pixel matrix");
        System.out.println("2. Print negative pixel matrix");
        System.out.println("3. Update the matrix");
        System.out.println("4. Exit");
        System.out.println("-------------------------------");
    }
    public static <T> void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the type of image: ");
        System.out.println("1. Colorful");
        System.out.println("2. Greyscale");
        int type = Integer.parseInt(in.nextLine());
        System.out.println("Enter the type of matrix: ");
        System.out.println("1. Default (all values 1) type 1");
        System.out.println("2. Custom (all values are supposed to be input) (type any number other than 1)");
        int matType = Integer.parseInt(in.nextLine());
        T newPixelSet = (T) new ColorfulPixelSet();
        Functions<T> func = new Functions<>();
        if (type == 1) {
            if (matType == 1) {
                newPixelSet = func.createMatrix((T) new ColorfulPixelSet(), in);
            } else if (matType == 2) {
                newPixelSet = func.inputMatrix((T) new ColorfulPixelSet(), in);
            } else {
                System.out.println("Wrong input!");
            }
        } else {
            if (matType == 1) {
                newPixelSet = func.createMatrix((T) new GreyscalePixelSet(), in);
            } else if (matType == 2) {
                newPixelSet = func.inputMatrix((T) new GreyscalePixelSet(), in);
            } else {
                System.out.println("Wrong input!");
            }
        }
        menu();
        int option = Integer.parseInt(in.nextLine());
        while (option != 4) {
            if (option == 1) {
                func.printer(newPixelSet);              
            } else if (option == 2) {
                func.printNegative(newPixelSet);
            } else if (option == 3) {
                func.update(newPixelSet, in);
            } else {
                System.out.println("Wrong input!");
            }
            menu();
            option = Integer.parseInt(in.nextLine());
        }   
        in.close();        
    }
}