import java.util.Scanner;

class Functions <T>{
    Scanner in = new Scanner(System.in);
}



class ColorfulPixel {
    int[] RGB = new int[3];;
    ColorfulPixel(int redColor, int greenColor, int blueColor) {
        RGB[0] = redColor;
        RGB[1] = greenColor;
        RGB[2] = blueColor;

    }
}

class GreyscalePixel {
    int greycolor;
    GreyscalePixel(int greycolor) {
        this.greycolor = greycolor;
    }
} 


public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows of the matrix: ");
        int m = Integer.parseInt(in.nextLine());
        System.out.print("Enter the number of columns of the matrix: ");
        int n = Integer.parseInt(in.nextLine());
        System.out.println("Enter the type of image: ");
        System.out.println("1. Colorful");
        System.out.println("2. Greyscale");
        int type = Integer.parseInt(in.nextLine());
        if (type == 1) {

        } else if (type == 2) {

        } else {
            System.out.println("Wrong input!");
        }
        
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();        
            }
        }
        
        in.close();        
    }
}
