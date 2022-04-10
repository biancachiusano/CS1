import java.io.*;
import java.util.*;

public class TestingExamQuestions{

	//QUESTION 7 - repeatArray
	/*public static void main(String[] args){

		int[] A = {1, 2};
		int[] B = {4, 2, -3, 2, 1};

		System.out.println(Arrays.toString(repeatArray(A)));
		System.out.println(Arrays.toString(repeatArray(B)));
	}


	public static int[] repeatArray(int[] arr){

		//Check is element is positive and greater than 0
		//Calculate length of new Array

		int length = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > 0){
				length = length + arr[i];
			}
		}

		//Declare and initialize the new array

		int[] newArray = new int[length];

		//Fill in the new array
		int index= 0; 
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > 0){
				for(int j = 0; j< arr[i]; j++){
					newArray[index] = arr[i];
					index ++;
				}
			}
		}

		return newArray;
	}*/


	/*public static void main(String[] args){

		int[][] A = 
		{ 	{10, 4, 6, 12},
			{5, 7, 8, 4},
			{8, 11, 20, 2},
			{1, 3, 12, 9} };


		System.out.println("K = " + evenRowColIndex(A));
	}

	public static int evenRowColIndex(int[][] A){

		//Check the length of the row and the column of the 2-dimensional array. Select the smallest one.
		int length = A[0].length;
		if(A.length < A[0].length)
			length = A.length;
		
		int index = -1;
		boolean rowFound;
		boolean colFound;

		//Loop through the possible indices K
		for(int i = 0; i < length; i++){
			rowFound = true;
			colFound = true;
			
			for(int j = 0; j < length; j++){
				//First looping through the columns for K row
				if(A[i][j]%2 != 0){
					rowFound = false;
					break;
				}
				//Now loop through the rows for K column
				if(A[j][i]%2 != 0){
					colFound = false;
					break;
				}
			}

			if(rowFound == true && colFound == true){
				index = i;
				break;
			}

		}
			return index;
	}*/

	//Mock Exam 2 - Question 7 - The identity Matrix
	/*public static void main(String[] args){

		int[][] A = 
		{ 	{1, 0, 0, 0, 2},
			{0, 1, 0, 0, 3},
			{0, 0, 1, 5, 4},
			{0, 0, 0, 1, 5},
			{0, 0, 0, 0, 1} };

		System.out.println(biggestim(A));

	}

	public static int biggestim(int[][] arr){
		
		int n = 0;
		//Check is the whole 2-dimensional array is an identity matrix
		if(checkim(arr) == true){
			n = arr.length;
		}
		else {
			//Declare new two dimensional array
			int[][] tempMatrix; 
			for(int i = 2; i < arr.length; i++){
				tempMatrix = new int[i][i];
				for(int row = 0; row < i; row++){
					for(int col = 0; col < i; col++){
						tempMatrix[row][col] = arr[row][col];
					}
				}

				if(checkim(tempMatrix) == true){
					n = i;
				}
			}
		}

		return n;
	}

	public static boolean checkim(int[][] arr){
		boolean flag = true;
		int count = 0;

		//loop through the 2 dimensional array
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				//Check for 1
				if(i == j && arr[i][j] != 1){
					count++;
				}
				//Check for 0
				else if(i !=j && arr[i][j] != 0){
					count++;
				}
			}
		}
		//Check counter
		if(count > 0){
			flag = false;
		}
		return flag;
	}*/

	//Mock exam 2 - Question 8 - Duplicate values on the fly

	/*public static void main(String[] args){
		//Create an array which stores the elements inputted from the user 
		//Also create an array for duplicates 
		int[] arr = new arr[]


	}*/

	//Mock Exam 2018 2 - Question 8 - Common Friends

	/*public static void main(String[] args){

		boolean[][] A = {{false, true, false, true, true},
						 {true, false, true, false, true},
						 {false, true, false, false, false},
						 {true, false, false, false, true},
						 {true, true, false, true, false}};
		System.out.println(findCommon(A, 2, 1));
	}

	public static boolean findCommon(boolean[][] A, int i, int j){

		boolean found = false;
		int col = 0;

		while(col < A[0].length && found != true){
			if(A[i][col] == true && A[j][col] == true){
				found = true;
			}
			col++;
		}
		return found;
	}*/

	//Mock Exam 2018 2 - Question 9 - digitTransformer

	/*public static void main(String[] args){

		long[][] A = {{3, -101, 94, 12, 3},
					  {777, 72, 54, 33040, 4},
					  {-444, 8898, 32, 9948, 233230021}};

		digitTransformer(A);
	}

	public static void digitTransformer(long[][] A){

		int[][] newArr = new int[A.length][A[0].length];

		for(int row = 0; row < A.length; row++){
			for(int col = 0; col < A[0].length; col++){
				boolean satisified = false;
				//reset variables
				int multiplesOfTen = 10;
				int count = 1;
				int digit = 0;

				while(satisified != true){
					//check if element is positive or negative
					if(A[row][col] < 0){
						if(A[row][col]% (-multiplesOfTen) == A[row][col]){
							satisified = true;
						}
					}
					else{
						if(A[row][col]% multiplesOfTen == A[row][col]){
							satisified = true;
						}
					}
					digit = count;
					multiplesOfTen = multiplesOfTen * 10;
					count++;
				}
				
				newArr[row][col] = digit;
			}
		}

		System.out.println(Arrays.deepToString(newArr));
	}*/

	//Can a method be called from an if statement (yes if it returns a boolean value)
	/*public static void main(String[] args){

		int x = -1;
		int y  = 1;

		if(methodBool(x, y)){
			System.out.println("Yes");
		}
		else 
			System.out.println("No");
	}

	public static boolean methodBool(int x, int y){

		if(x < 0 && y > 0)
			return true;
		else
			return false;
	}*/

	//MOCK exam 2018 2 - Question 10

	//MOCK exam 2019 2 - Question 7 - flattening 

	/*public static void main(String[] args){

		int[][] A = 
		{ 	{0, -1, -2},
			{3, 4, 5},
			{6, -7, 8},
			{9, 10, 11} };

		System.out.println(Arrays.toString(flatten(A)));
	}

	public static int[] flatten(int[][] arr){

		int count = 0;

		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[0].length; col++){
				if(arr[row][col] > -1){
					count++;
				}
			}
		}

		int[] newArr = new int[count];
		int index = 0;
		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[0].length; col++){
				if(arr[row][col] > -1){
					newArr[index] = arr[row][col];
					index++;
				}
			}
		}

		return newArr;
	}*/
	
	//MOCK exam 2019 2 - Question 8 - Multiply

	/*public static void main(String[] args){

		int[] A = {3, 9, 17, 50};
		int[] B = {0, 1, 2, 3, 21, 42, 45};
		int p = 42;

		System.out.println(check(A, B, p));

	}

	public static boolean check(int[] A, int[] B, int p){

		//boolean found = false;
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < B.length; j++){
				if((A[i]*B[j]) == p){
					return true;
				}
			}
		}

		return false; 
	}*/

	//MOCK exam 2019 2 - Question 9 - Are you 
	/*public static void main(String[] args){

		int n = 199;
		System.out.println(is_emirp(n));
	}

	public static int is_emirp(int N){

		if(N%10 == N){
			return N;
		}

		int n = 0; 
		int count = 1;
		while(N%(10 * count) != N){
			count++;
		} 

		for(int i = 0; i < count; i++){

			int number = 0;
			int temp = 0; 
			count = 1;
			temp = N%(10 * count);

			while(N%(10 * count) != N){
				count++;
			}

			number = temp * (10* (count -1));
			n = n + number; 
		}

		return n; 

	}

	public static boolean isPrime(int n){


	}*/



	//MOCK exam 2019 2 - Question 10

	/*public static void main(String[] args){
		int N = 5;
		//int[] cargo = {1000, 400, 700, 500, 600, 1700, 800};
		int[] cargo = {1100, 1200, 1600, 500, 1200, 1700, 1800, 1900};
		loader(N, cargo);
	}

	public static void loader(int N, int[] cargo){

		int n = 0; 
		int c = 0; 
		int vol = 2000;

		while(n < N-1 && c < cargo.length){
			
			if((vol - cargo[c]) >= 0){
				vol = vol-cargo[c];
				c++;
			}
			else{
				n++;
				vol = 2000;
			}
		}

		int tot = 0;
			for(int i = 0; i < cargo.length; i++){
				tot = tot + cargo[i];
			}

		if( c == cargo.length){
			n++;
			System.out.println("Number of wagons used: " + n);
			System.out.println("Number of boxes used: " + c);
			System.out.println("Loads of wagon used: " + tot);
		}
		else{
			n++;
			c++;
			System.out.println("Number of wagons used: " + n);
			System.out.println("Number of boxes used: " + c);
			System.out.println("Num of boxes stored " + (cargo.length - c));
			//System.out.println("Volum not used used: " + ((N*2000) - (n*2000)));
			int temp = cargo.length - c;
			int notVol = 0;
			for(int i = cargo.length-1; i >= (cargo.length - temp); i--){
				notVol = notVol + cargo[i];
				System.out.println(notVol);
			}
			System.out.println("Volum not used used: " + notVol);
		}
	}*/

	


}