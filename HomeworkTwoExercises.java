import java.util.*;
import java.io.*;

public class HomeworkTwoExercises{

	//EXERCISE 3 - exam pass or fail

	/*public static void main(String[] args){

		System.out.println("Introduction to CS1 Pass or Fail Decision");
		System.out.println("What is your practical grade?");
		Scanner scan1 = new Scanner(System.in);
		double practical = scan1.nextDouble();
		System.out.println("What is your exam grade?");
		double exam = scan1.nextDouble();

		if((practical + exam) >= 6.0)
			System.out.println("You Pass");
		else
			System.out.println("You Fail");
	}*/


	//EXERCISE 5 - pay

	/*public static void main(String[] args){

		System.out.println("How many hours did the TA work this week?: ");
		Scanner scan1 = new Scanner(System.in);
		int h = scan1.nextInt();

		System.out.println("The TA should be payed: " + computeSalary(4.0,h));
	}

	public static double computeSalary(double s, int h){
		//THE INT HOURS CAN BE CONVERTED INTO DOUBLE

		if(h > 8)
			return (s*h)+((s/2) * (h-8));
		else
			return (s*h);
	}*/


	//EXERCISE 8 - Unique integers

	/*public static void main(String[] args){

		System.out.println("Please enter three integers: ");
		
		Scanner scan1 = new Scanner(System.in);
		int n1 = scan1.nextInt();
		int n2 = scan1.nextInt();
		int n3 = scan1.nextInt();

		System.out.println("In the set: (" + n1 + "," + n2 + "," + n3 + ") There are: " + uniqueNumbers(n1,n2,n3) + " unique numbers");
	}

	public static int uniqueNumbers(int a, int b, int c){

		if((a==b && a!=c) || (b==c && b!=a))
			return 2;
		else if(b==c && b==a)
			return 1;
		else 
			return 3;
	}*/


	//EXERCISE 11 - Switch Case

	/*public static void main(String[] args){

		System.out.println("Enter a Number from 10 to 40: ");
		Scanner scan1 = new Scanner(System.in);
		int choice = scan1.nextInt();
		String choiceName;

		switch(choice) {

			case 10: choiceName = "Ten"; break;
			case 20: choiceName = "Twenty"; break;
			case 30: choiceName = "Thirty"; break;
			case 40: choiceName = "Forty"; break;
			default: choiceName = "Don't Care"; break;
		}

		System.out.println(choiceName);
	}*/

	//EXERCISE 12 - String length - THIS IS ALL INCORRECT (for the exercise)

	/*public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		System.out.print("Type your name: ");
		String name = console.nextLine();

		if(name.equals("Jerry")){
			System.out.println("You must be really awsome");
		}
		replace("a","e");
		toUpperCase(name);
		name.substring(0,3);
		System.out.println(name + "has " + name.length() + " letters");
	}*/

}