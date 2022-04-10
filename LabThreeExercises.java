import java.util.*;
import java.io.*;

public class LabThreeExercises {

	/*
	//EXERCISE 1
	public static void main(String[] args){

		Scanner scan1 = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int num = scan1.nextInt();

		System.out.println(" Your number is: " + oddOrEven(num));

	}

	public static String oddOrEven(int n){

		String even = "Even";
		String odd = "Odd";

		if(n%2 == 0)
			return even;
		else 
			return odd;
	}

	//This Works!
	*/

	
	//EXERCISE 2
	/*public static void main(String[] args){

		Scanner scan1 = new Scanner(System.in);
		System.out.println("Please enter a positive number below 20: ");
		int num = scan1.nextInt();

		if(num < 0 || num > 20)
			System.out.println("The number you entered was either negative or greater than 20");
		
		else 
			System.out.println("The number you entered is : " + isPrime(num));
		
	}

	public static String isPrime(int n){
		
		int lowerBound = 2;
		String prime = "Prime";
		String notPrime = "Not a Prime number";
		boolean flag = false;

		for(int i = lowerBound; i < n; i++){
			if(n%i == 0) {
				flag = true;
				break;
			}
		}

		if(flag == false)
			return prime;
		else
			return notPrime; 		

	}*/

	//EXERCISE 3
	public static void main(String[] args){

		Scanner scan1 = new Scanner(System.in);
		System.out.println("How many sides does your dice have?");
		int side = scan1.nextInt();

		if(side < 4)
			System.out.println("A die doesn't have less then 4 sides, enter again");
		else
			System.out.println("Random Roll. The number generated from that roll is: " + randomRoll(side));
	}


	public static int randomRoll(int s){

		double random = Math.random();
		System.out.println(random);
		double ans = (double) s * random;
		double round = Math.floor(Math.round(ans));
		int convert = (int) round;
		
		return convert;
	}









}