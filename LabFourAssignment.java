import java.io.*;
import java.util.*;

public class LabFourAssignment{

	public static void main(String[] args){

		//Asking the user to choose a whole number greater then 0 as an input.
		//Scanner is used to read the number inputted by the user.

		Scanner scan1 = new Scanner(System.in);
		System.out.println("Please enter a positive whole number: ");
		int num = scan1.nextInt();

		//Checking if the number chosen by the user is positive.
		if(num < 0)
			System.out.println("Not a positive whole number, retry");
		//Method countPrimes() is called. This method uses the number chosen by the user as a parameter.
		else
			System.out.println("There are: " + countPrimes(num) + " prime numbers (between 0 and " + num + ")");
	}

	public static Boolean isPrime(int n){

		//Number two is chosen as the lowerbound, as 1 in not a prime number.
		int lowerBound = 2;

		//This variable is initialized to be true because 2 is prime, and 2 won't be considered in the for-loop.
		boolean primeNum = true;

		/*In this case n is the upperBound, thus we are checking 
		to see if any number from 2 to n-1 can divide n (making it not prime)*/

		for(int i = lowerBound; i < n; i++){

		//If "n mod i" doesn't give a remainder, the number is not prime.
			if(n%i == 0) {
				primeNum = false;
				break;
			}
		}
		return primeNum;
	}

	public static int countPrimes(int N){

		//The variable count will keep track of the amount of prime numbers between 0 and the chosen number.
		int count = 0;

		//Looping through all of the numbers between 2 and the chosen number (1 is not prime).
		for(int i = 2; i <= N; i++){
		
		//Calling method isPrime(), checking if the number(i) in question is prime or not. 
		//If it is prime, the variable count will increase by one.
			
			if(isPrime(i) == true)
				count = count + 1;
		}

		return count; 
	}
}