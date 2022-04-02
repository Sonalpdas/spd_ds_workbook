package cracking_the_coding_interview.one;

/*
Rotate Matrix:
------------------
Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
write a method to rotate the image by 90 degrees. Can you do this in place?
*/

/*
Notes:
--------------

Practice example: 5x5 matrix
1 2 3 4 5
6 7 8 9 1
4 8 9 2 1  => Loop for each item in 1st row except last item:(0,0)-> (0,4); (0,4)->(4,5); (4,4)->(0,4); (0,4)->(0,0);
3 5 6 7 3  => Go to next row, start and end index will both reduce by 1, this iteration terminates when start < end idx
7 8 9 2 3

 */

public class PracticeProblem7 {

    public static int[][] rotateMatrix(int[][] matrix) {

        // Outer loop: to go over half the rows i.e until left index < right index
        int matrix_size = matrix.length;

        for(int row = 0; row < matrix_size; row++) {

            for(int col = row; col < matrix_size ; col ++){

                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;

            }

        }

        return matrix;

    }

    public static int[][] rotateMatrixPointers(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n ; i++){
            for(int j=0; j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }


        return matrix;

    }

    public static void printMatrix(int[][] sampleMatrix) {
        for(int i=0; i < sampleMatrix.length; i++) {
            System.out.println("");
            for(int j=0; j< sampleMatrix.length; j++){
                System.out.print(" "+sampleMatrix[i][j]);
            }

        }
    }

    // print original and rotated matrix
    public static void main(String[] args) {
        int[][] sample1 = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(sample1);

        System.out.println("--------------");
        System.out.println("Rotated Matrix:");
        printMatrix(rotateMatrix(sample1));

        System.out.println("--------------");
        System.out.println("Rotated Matrix pointers:");
        printMatrix(rotateMatrixPointers(sample1));

    }

}
