import java.util.Scanner;

class Functions <T> {

    public T createMatrix (T newPixelSet) {
        Scanner in = new Scanner(System.in);
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
        in.close();
        return newPixelSet;
    }

    public void printer(T newPixelSet) {
        if (newPixelSet instanceof ColorfulPixelSet) {
            int m = ((ColorfulPixelSet) newPixelSet).getRows();
            int n = ((ColorfulPixelSet) newPixelSet).getColumns();
            int [][][] matrix = ((ColorfulPixelSet) newPixelSet).getColorMatrix();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.println(
                        "[R: "+matrix[i][j][0]+
                        ", G: "+matrix[i][j][1]+
                        ", B: "+matrix[i][j][2]+"]"
                    );                    
                }
            }
        } else {
            int m = ((GreyscalePixelSet) newPixelSet).getRows();
            int n = ((GreyscalePixelSet) newPixelSet).getColumns();
            int [][] matrix = ((GreyscalePixelSet) newPixelSet).getGreyMatrix();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.println(matrix[i][j]);
                }
            }
        }  
    }
}

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


public class App <T>{
    public static <T> void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the type of image: ");
        System.out.println("1. Colorful");
        System.out.println("2. Greyscale");
        int type = Integer.parseInt(in.nextLine());
        T newPixelSet;
        
        if (type == 1) {
            newPixelSet = (T) new ColorfulPixelSet();
            Functions<ColorfulPixelSet> func = new Functions<>();
            newPixelSet = (T) func.createMatrix((ColorfulPixelSet) newPixelSet);
            func.printer((ColorfulPixelSet) newPixelSet);            
        
        } else if (type == 2) {
            newPixelSet = (T) new GreyscalePixelSet();
            Functions<GreyscalePixelSet> func = new Functions<>();
            newPixelSet = (T) func.createMatrix((GreyscalePixelSet) newPixelSet);
            func.printer((GreyscalePixelSet) newPixelSet);

        } else {
            System.out.println("Wrong input!");
        }       
        in.close();        
    }
}