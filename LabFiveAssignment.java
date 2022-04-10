import java.io.*;
import java.util.*;

public class LabFiveAssignment{

	public static void main(String[] args){

		//User input used to create, declare and initialize the first matrix
		//Number of rows for the first matrix
		System.out.println("Choose the number of rows for the first Matrix: ");
		Scanner scan1 = new Scanner(System.in);
		int r1 = scan1.nextInt();

		//Number of columns for the first matrix
		System.out.println("Choose the number of columns for the first Matrix: ");
		int c1 = scan1.nextInt();


		//Repeating the same process, but for the second matrix
		System.out.println("Choose the number of rows for the second Matrix: ");
		int r2 = scan1.nextInt();

		System.out.println("Choose the number of columns for the second Matrix: ");
		int c2 = scan1.nextInt();

		//Checking if the hight of the first matrix is equal to the width of the second matrix
		if(c1 == r2 || c2 == r1) {

			//Declaring the first matrix, "matrixOne"
			int[][] matrixOne = new int[r1][c1];

			System.out.println();
			System.out.println("Filling in the first Matrix!");
			//Filling matrixOne with user input, using a for loop
			Scanner mat1Scan = new Scanner(System.in);
			for(int i = 0; i < r1; i++){

				for(int j = 0; j < c1; j++){
					System.out.println("Enter a number for index: [" + i + "][" + j + "]");
					matrixOne[i][j] = mat1Scan.nextInt();
				}
			}

			System.out.println();
			System.out.println("Filling in the second Matrix!");
			
			//Declaring the second matrix
			int[][] matrixTwo = new int[r2][c2];

			//Filling matrixTwo with using input 
			Scanner mat2Scan = new Scanner(System.in);
			for(int i = 0; i < r2; i++){

				for(int j = 0; j < c2; j++){
					System.out.println("Enter a number for index: [" + i + "][" + j + "]");
					matrixTwo[i][j] = mat2Scan.nextInt();
				}
			}

			//For visualisation purposes: printing matrixOne
			System.out.println("First Matrix:");
			for(int i = 0; i < r1; i++){
				for(int j = 0; j < c1; j++){
					System.out.printf("%8d",matrixOne[i][j]);
				}
				System.out.println();
			}
			System.out.println();

			//For visualisation purposes: printing matrixTwo
			System.out.println("Second Matrix:");
			for(int i = 0; i < r2; i++){
				for(int j = 0; j < c2; j++){
					System.out.printf("%8d",matrixTwo[i][j]);
				}
				System.out.println();
			}

			//Printing the product between the two matrices, stored in another two-dimensional array
			System.out.println();
			System.out.println("The product of the two matrices is:");

			//Calling the method that will multiply the two matrices passed as parameters
			multiplyMatrices(matrixOne, matrixTwo);
		}
		else
			System.out.println("This matrix multiplication is illegal, retry");

	}

	public static void multiplyMatrices(int[][] mat1, int[][] mat2){

		//Creating the matrix that will store the product
		//The new matrix will have as many rows as in mat1 and as many columns as in mat2
		int[][] product = new int[mat1.length][mat2[0].length];

		//Three nested loops
		//First loop, loops through the rows of mat1
		for(int k = 0; k < mat1.length; k++){
			//Second loop, loops through the columns of mat2
			for(int i = 0; i < mat2[0].length; i++){
				//Variable "calc" stores the singular products
				//Variable "sum" that store the sum of the products
				int calc = 0;
				int sum = 0;
				//Third loop, loops through every column of mat1
				for(int j = 0; j < mat1[0].length; j++){
					
					calc = mat1[k][j] * mat2[j][i];
					sum = sum + calc;
				}
				product[k][i] = sum;
			}

		}
		
		//Filling the matrix, which will be the product of the multiplicaiton between mat1 and mat2
		for(int i = 0; i < mat1.length; i++){
			for(int j = 0; j < mat2[0].length; j++){
				System.out.printf("%8d", product[i][j]);
			}
			System.out.println();
		}
	}
}