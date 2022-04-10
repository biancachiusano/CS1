import java.io.*;
import java.util.*;

public class LabSixAssignment {

	public static void main(String[] args){

		//Assignment 6.1
		System.out.println("This is 6.1 : ");
		//Creating the two-dimensional array "matrix" through user input
		System.out.println("Input number of rows for the matrix: ");
		Scanner scan1 = new Scanner(System.in);
		int rows = scan1.nextInt();

		System.out.println("Input number of colums for the matrix: ");
		int columns = scan1.nextInt();

		int[][] matrix = new int[rows][columns];

		System.out.println();
		System.out.println("Please enter the values for the matrix");
		
		Scanner matrixScan = new Scanner(System.in);
		
		//Filling the matrix
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				System.out.println("Enter a number for index: [" + i + "][" + j + "]");
				matrix[i][j] = matrixScan.nextInt();
			}
		}
		System.out.println();
		System.out.println("The matrix: ");
		//Printing the matrix for visualisation purposes
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.printf("%8d", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("The values of the matrix (printed diagonally) are: ");
		//Calling the method "diagonalPrint" which passes the matrix created as a parameter
		diagonalPrint(matrix);
		System.out.println();


		System.out.println();
		System.out.println("This is 6.2 : ");
		//This Assignment 6.2 in the main method
		//Declaring and initializing the array that is going to be passed to the method: allNumsWithin()
		System.out.println("Enter the length of new array: ");
		Scanner l = new Scanner(System.in);
		int arrayLength = l.nextInt();

		int[] array = new int[arrayLength];

		//Filling in the array with user input
		System.out.println();
		System.out.println("Filling the Array: ");

		for(int i = 0; i < array.length; i++){
			System.out.println("Enter the value for [" + i + "]");
			Scanner values = new Scanner(System.in); 
			array[i] = values.nextInt();
		}

		//The user will choose the value of "K"
		System.out.println("..Finding values between 0 and k, please specify k (1 <= k <= array length) : ");
		Scanner kValue = new Scanner(System.in);
		int k = kValue.nextInt();
		System.out.println();

		if(k > arrayLength || k < 1){
			System.out.println("The value of k doesn't fit in the specified limits, try again");
		}
		else {
			//If k satisfies its conditions, call the method allNumsWithin, which takes the array and k as its parameters
			allNumsWithin(array, k);
		}
	}

	public static void diagonalPrint(int[][] M){

		//This method will to print all elements, of the matrix that was passed as parameter, diagonally
		//This will be done by looping through the matrix twice in two different ways
		//First loop through all the rows, not including the last row
		for(int i = 0; i < M.length-1; i++){
			int w = i;
			int k = 0;
		//The pattern: The elements that has to be printed after indexes [w][k] is [w-1][k+1] until w < 0
		//Print a dash after printing the element
			while(w >= 0){
				System.out.print(M[w][k] + " - ");
				w = w-1;
				k = k+1;
			}
		}
		//The last row is not included in the "row loop" because it would overlap with the "Column loop" that will follow
		//Now loop through all the columns, from right to left
		for(int j = 0; j < M[0].length - 1 ; j++){
			int w = M.length-1;
			int k = j;
		//The same logic as previoulsly is used
			while(k <= M[0].length - 1){
				System.out.print(M[w][k] + " - ");
				w = w-1;
				k = k+1;
			}
		}
		//The last element is printed seperately because it does not contain the dash
		System.out.print(M[M.length-1][M[0].length-1]);
	}


	public static void allNumsWithin(int[] A, int k){
		
		/*
		This method computes the minimum length of a section of the array passed as parameter.
		This section has to contain all elements from 0 to k-1
		*/

		//Create an array list (arrayToArrayList) which will contain all elements of the array created by the user
		//I found it easier to handle the elements using arrayLists rather than arrays
		ArrayList<Integer> arrayToArrayList = new ArrayList<Integer>();

		//Loop through the array
		for(int i = 0; i < A.length; i++){
			arrayToArrayList.add(A[i]);
		}

		//For visualisation purposes, print the initial arrayList
		System.out.println("The array: " + arrayToArrayList);

		boolean possible = true;
		//Check if the array list contains all elements between 0 and k 
		for(int w = 0; w < k; w++){
			if(arrayToArrayList.contains(w) == false){
				possible = false;
			}
		}

		//Declare two arrayLists, these are used to filter the bigger arraylist containing the initial elements
		ArrayList<Integer> smallerArray = new ArrayList<Integer>();
		ArrayList<Integer> inverseSmallerArray = new ArrayList<Integer>();

		//If the array passed contains all elements between 0 and k-1 (inclusive), we can proceed
		if(possible == true){
			
			boolean limits = false;
			int j = 0;

			/*This while loop will add elements of arrayToArrayList (from left to right) into smallerArray,
			until this arraylist will contain all elements between 0 and k-1 (inclusive).  
			*/
			while(limits == false && j < arrayToArrayList.size()) {
				smallerArray.add(arrayToArrayList.get(j));
				limits = true;
				for(int i= 0; i < k ;i++){
					if(!smallerArray.contains(i))
						limits = false;
				}
				j++;
			}

			/*This second while loop, instead, will add elements of arrayToArrayList (from right to left) into inverseSmallerArray,
			until this arraylist will contain all elements between 0 and k-1 (inclusive). Thus these two while loops act similarly 
			but are looping from different sides. Hopefully these two new arraylists will be smaller than the initial arraylist.
			*/
			limits = false;
			j = arrayToArrayList.size()-1;
	
			while(limits == false && j >= 0){
				inverseSmallerArray.add(arrayToArrayList.get(j));
				limits = true;
				for(int y= 0; y < k ;y++){
					if(!inverseSmallerArray.contains(y))
						limits = false;
				}
				j--;
			}

			/*Compare the sizes of two arrayLists created. Both of them should contain all elements between 0 and k-1. 
			We want the smallest array, as it is more filtered.
			*/

			//Create one last arrayList which will further filter one of smaller arraylist between the two.
			ArrayList<Integer> finalArray = new ArrayList<Integer>();

			//The loop will be from right to left
			if(inverseSmallerArray.size() < smallerArray.size()){
				
				boolean lastCheck = false;
				int a = inverseSmallerArray.size()-1;
				while(lastCheck == false && a >= 0) {
					finalArray.add(inverseSmallerArray.get(a));
					lastCheck = true;
					for(int b = 0; b < k ;b++){
							if(!finalArray.contains(b))
								lastCheck = false;
						}
					a--;
				}
			}
			else {

				boolean lastCheck = false;
				int a = smallerArray.size()-1;
				while(lastCheck == false && a >= 0) {
					finalArray.add(smallerArray.get(a));
					lastCheck = true;
					for(int b = 0; b < k ;b++){
							if(!finalArray.contains(b))
								lastCheck = false;
						}
					a--;
				}
			}

			/*Now finalArray should contain the smallest possible section of the initial array passed, 
			including all elements between 0 and k-1*/

			System.out.println("The smallest section (with elements from 0 to k-1) contains these elements: " + finalArray);

			//Printing the size of the finalArray, which represents the length of the section
			System.out.println("The section's size is: " + finalArray.size());
		}
		else 
			//if the arrayToArrayList does not contain all elements between 0 and k-1
			System.out.println(0);
	}

}