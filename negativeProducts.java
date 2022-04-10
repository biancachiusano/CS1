import java.util.*;
import java.io.*;

public class negativeProducts {

	public static void main(String[] args){

		System.out.println("Please choose a positive number: ");
		Scanner scan1 = new Scanner(System.in);
		int num1 = scan1.nextInt();

		System.out.println("Please choose another positive number: ");
		Scanner scan2 = new Scanner(System.in);
		int num2 = scan2.nextInt();

		//If the user imputs a negative number:
		if(num1<0){
			System.out.println("Error the numbers are not positive");
		}
		else if(num2 < 0){
			System.out.println("Error the numbers are not positive");
		}
		else{

		int negProduct = num1 * num2;

		//Printing the negative number
		System.out.println("The negative product of the two chosen numbers is : " + "-" + negProduct);

		}

		
	}

}