public class Matrix {
    int m;
    int n;
    String matrixUniqueID;
    int[][] entries = new int[m][n];
    int determinant;
    
    Matrix(int noOfRows, int noOfColumns, String matrixUniqueID){
        this.m = noOfRows;
        this.n = noOfColumns;
        this.matrixUniqueID = matrixUniqueID;
    }
}

class OnesMatrix extends Matrix{

    OnesMatrix(int noOfRows, int noOfColumns, String matrixUniqueID) {
        super(noOfRows, noOfColumns, matrixUniqueID);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                entries[m][n] = 1;
            }
        }
    }



}

class NullMatrix extends Matrix{
    NullMatrix(int noOfRows, int noOfColumns, String matrixUniqueID) {
        super(noOfRows, noOfColumns, matrixUniqueID);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                entries[m][n] = 0;
            }
        }
    }


}

class SquareMatrix extends Matrix {
    SquareMatrix(int noOfRows, int noOfColumns, String matrixUniqueID) {
        super(noOfRows, noOfColumns, matrixUniqueID);
        
    }


}

class RectangleMatrix extends Matrix {



}

class RowMatrix extends RectangleMatrix {

}

class ColumnMatrix extends RectangleMatrix {

}

class SymmetricMatrix extends SquareMatrix {

}

class Skew_SymmetricMatrix extends SquareMatrix {
    
}

class Upper_TriangularMatrix extends SquareMatrix {

}

class Lower_TriangularMatrix extends SquareMatrix {
    
}

class SingularMatrix extends SquareMatrix {

}

class DiagonalMatrix extends SymmetricMatrix {
    
}

class ScalarMatrix extends DiagonalMatrix {

}

class IdentityMatrix extends ScalarMatrix {

}

class SingletonMatrix extends SquareMatrix {

}