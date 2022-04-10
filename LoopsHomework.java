import java.util.*;
import java.io.*;

public class LoopsHomework{

	//EXERCISE 5
	/*public static void main(String[] args){

		for(int i = 1; i <= 1000; i++){
			System.out.print(i + " , ");
		}

		System.out.println();

		for(int i = 2; i <= 100; i+=2){
			System.out.print(i + " , ");
		}

		System.out.println();

		for(int i = 50; i >= -5; i-=5){
			System.out.print(i + " , ");
		}
	}*/

	//EXERCISE 6 - Bottles of Beer on the wall song

	/*public static void main(String[] args){

		for(int numBeer = 10; numBeer >= 0; numBeer--){
			System.out.println(numBeer + " bottles of beer on the wall, " + numBeer + " bottles of beer");
			int newNumBeer = numBeer - 1;
			System.out.println("Take one down, pass it around, " + newNumBeer  + " bottles of beer on the wall");
		}
	}*/

	//EXERCISE 8 - Single Digit

	/*public static void main(String[] args){

		System.out.println("Enter a number: ");
		Scanner scan1 = new Scanner(System.in);
		int num = scan1.nextInt();

		System.out.println("Your number has one digit: " + isSingleDigit(num));
	}

	public static boolean isSingleDigit(int n){

		//You can check if your number has only one digit with an If-Statement:
		//if(n%10 == n)
		//	return true;
		//else 
		//	return false;

		//Or with a while loop
		int count = 0;

		while(n != 0){
			n /= 10;
			count ++;
		}

		if(count > 1)
			return false;
		else 
			return true;
	}*/


	//EXERCISE 9 - Print Letters
	/*public static void main(String[] args){
	
		printLetters();
	}

	public static void printLetters() {

		System.out.println("Enter a word: ");
		Scanner scan1 = new Scanner(System.in);
		String w = scan1.nextLine();

		String letters = "";
		for(int i = 0; i < w.length(); i++){
			char c = w.charAt(i);
			letters = letters + c + "-";
		}

		System.out.println(letters);
		
	}*/

	//EXERCISE 10 - Pattern of nested loops
	/*public static void main(String[] args){

		for(int i = 7; i >= 1; i-=2){

			for(int j = 1; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}

	}*/

	//COMPILING EXERCISE 11

	/*public static void main(String[] args){
		for(int i = 1; i<= 10; i++){
			for(int j = 1; j <= i; j++){
				System.out.print("*");
			}
			for(int j = 1; j <= 20 - 2*i; j++){
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}*/
	

}