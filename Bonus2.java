import java.util.*;
import java.io.*;
import java.lang.Math;

public class Bonus2 {

	public static void main(String[] args){

		Scanner scan1 = new Scanner(System.in);
		System.out.println("Please enter two numbers in type double: ");
		double n1 = scan1.nextDouble();
		double n2 = scan1.nextDouble();

		System.out.println("The division of the double, which returns an int type value: " + doubleDivision(n1, n2));
		System.out.println("The division of the double, which returns the closest integer: " + (int) roundingDoubles(n1, n2));
	
	}

	public static int doubleDivision(double a, double b){

		double division = a/b;
		int converter = (int) division;
		return converter;

	}

	public static double roundingDoubles(double a, double b){
		double division = a/b;
		double round = Math.floor(Math.round(division)); 
		return round;

	}


}