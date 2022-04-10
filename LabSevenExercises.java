import java.io.*;
import java.util.*;

public class LabSevenExercises {

	//EXERCISE 1 - Reaching Number 1
	/*public static void main(String[] args){

		Scanner scan1 = new Scanner(System.in);
		System.out.println("Please entera natural number: ");
		int num = scan1.nextInt();

		int count = 0; 

		if(num > 0)
			numberOne(num, count);
		else
			System.out.println("Not a natural number, try again");
	}

	public static void numberOne(int n, int c){


		if(n == 1)
			System.out.println("We reached " + n + " after " + c + " steps");
		else if(n%2 == 0){
			System.out.print(n + ", ");
			c = c + 1;
			numberOne(n/2, c);
		}
		else {
			System.out.print(n + " , ");
			n = (n*3) + 1;
			c = c + 1;
			numberOne(n, c);
		}
	}*/

	//EXERCISE 2 - Finding a value and calculating max and min in arrays with recursion
	public static void main(String[] args){

		System.out.println("Please constuct the array");
		System.out.println("Enter the length of the array");
		
		Scanner scan1 = new Scanner(System.in);
		int l = scan1.nextInt();

		//Declaring and initializing the array
		int[] array = new int[l];

		//Filling the array
		for(int i =0; i < array.length; i++){
			System.out.println("Enter value for array [" + i + "]");
			Scanner scan2 = new Scanner(System.in);
			int value = scan2.nextInt();
			array[i] = value;
		}

		

		//Finding a value
		System.out.println("Enter a value that you would like to find in the array");
		Scanner findValue = new Scanner(System.in);
		int v = findValue.nextInt();
		int count = 0;
		findValueRecursion(v, array, count);

		//Finding Max and Min values
		int max = array[0];
		int min = array[0];
		int arrayCount = 1;

		maxAndMinRecursion(array, max, min, arrayCount);

	}

	public static void maxAndMinRecursion(int[] a, int max, int min, int c){

		if(c == a.length){
			System.out.println("The greatest value in the array is: " + max);
			System.out.println("The greatest value in the array is: " + min);
		}else if(a[c] > max){
			max = a[c];
			c++;
			maxAndMinRecursion(a, max, min, c);
		} else if(a[c] < min){
			min = a[c];
			c++;
			maxAndMinRecursion(a, max, min, c);
		} else {
			c++;
			maxAndMinRecursion(a, max, min, c);
		}

	}

	public static void findValueRecursion(int v, int[] a, int c){

		if(a[c] == v){
			System.out.println("Value found at index: " + c);
		}
		else {
			c = c+1;
			findValueRecursion(v, a, c);
		}
	}



}