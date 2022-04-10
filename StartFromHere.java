import java.util.*;
import java.io.*;

public class StartFromHere {
	
	/*
	//EXERCISE 1
	public static void main(String[] args) {
		
		// Initialise a Scanner to read from the command line
		Scanner in = new Scanner(System.in);
		System.out.println("Please type in a number as a radius");
		double radius = in.nextDouble();

		
		// Give some output;
		System.out.println("This is the area of the circle with radius, " + radius + " is:" + circleArea(radius));
		
	}

	public static double circleArea(double r){
		
		//PI as a constan
		final double pi = Math.PI;

		//Area
		double area = pi * r * r;
		return area;
	}
	*/


	/*
	//EXERSICE 2
	public static void main(String[] args){

		//Ask the user for the clock speed and store the clock speed in double variable
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Please insert the clock speed of your computer in Ghz");
		double clockSpeed = scan1.nextDouble();

		System.out.println("Light travels " + Calculator(clockSpeed) + " km after 1 clock cycle of your computer");


	}

	//Method to calculate how far light travels during one clock speed of their computer
	public static double Calculator(double cs) {

		//Light speed in km/s
		double lightSpeed = 299792.458;

		cs = cs * Math.pow(10,9);

		double clockCycleCalculation = lightSpeed/cs;
		return clockCycleCalculation;
	}
	*/

	//EXERCISE 3

	public static void main(String[] args){

		Scanner scan1 = new Scanner(System.in);
		System.out.println("Please enter a value for x: ");
		int x = scan1.nextInt();

		Scanner scan2 = new Scanner(System.in);
		System.out.println("Please enter a value for y: ");
		int y = scan2.nextInt();

		System.out.println("Your value x is: " + x);
		System.out.println("Your value y is: " + y);

		//switchInts(x, y);

		int newX = y;
		int newY = x;

		System.out.println("Your new value for x is: " + newX);
		System.out.println("Your new value for y is: " + newY);


	}
}