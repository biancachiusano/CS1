import java.util.*;
import java.io.*;

public class LabFiveExercises {

	//EXERCISE 1 
	/*public static void main(String[] args){

		System.out.println("Please enter a number for the length of the array");
		Scanner scan1 = new Scanner(System.in);
		int LENGTH = scan1.nextInt();

		int[] values = new int[LENGTH];

		int even = 0; 
		int odd = 0;

		for(int i = 0; i < LENGTH; i++){

			System.out.println("Enter the value for index: " + i);
			Scanner element = new Scanner(System.in);
			values[i] = element.nextInt();

			if(i%2 == 0){
				even = even + values[i];
			}
			else{
				odd = odd + values[i];
			}	
		}

		System.out.println("The sum of all elements with even index is: " + even);
		System.out.println("The sum of all elements with odd index is: " + odd);
	}*/


	//EXERCISE 2

	public static void main(String[] args){

		//Declaring
		final int COUNTRIES = 4;
		final int MEDALS = 4;
		int[][] counts = new int[COUNTRIES][MEDALS];

		//Initializing 
		counts[3][2] = 50;
		
		//Accessing and printing all elements
			for(int i = 0; i < COUNTRIES; i++){

				for(int j = 0; j < MEDALS; j++){
					System.out.printf("%8d", counts[i][j]);
				}

				System.out.println();
			}
	}


}