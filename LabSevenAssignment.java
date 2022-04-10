import java.util.*;
import java.io.*;

public class LabSevenAssignment{

	public static void main(String[] args){

		//User input to declare the variable height. This variable represents the number of disks in the tower
		System.out.println("Please enter the tower hight: ");
		Scanner scan1 = new Scanner(System.in);
		int height = scan1.nextInt();

		//Declaring the three rods 
		String A = "rod1";
		String B = "rod2";
		String C = "rod3";

		//Calling the method: towersOfHanoi
		towersOfHanoi(height, A, B, C);
	}

	public static void towersOfHanoi(int h, String from, String temp, String dest){
		
		//Method takes the number of disks and the three rods
		//A, B and C are not the same as from, temp and dest, they just start in this order

		//"Base Case" where to move disk 1
		if(h == 1){
			System.out.println("Move disk 1 from " + from + " to " + dest);
		}	
		else {
			//Function Call
			towersOfHanoi(h-1, from, dest, temp); 
			
			System.out.println("Move disk " + h + " from " + from + " to " + dest); 
			
			//Function Call
			//Move whatever is on temp, from temp to dest, thus temp becomes the new start and start is the new temp
			towersOfHanoi(h-1, temp, from, dest); 

		}

	}
}