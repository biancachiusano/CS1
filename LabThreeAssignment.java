import java.io.*;
import java.util.*;

public class LabThreeAssignment {
	
	public static void main(String[] args) {

		//Asking and recieving input from the user, which will be stored in the variable: userPlay.
		
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter your play: r (rock), p (paper), s (scissors), l (Lizard), o (Spock)");
		String userPlay = scan1.nextLine();

		/*The user will be able to enter both lowercase and uppercase: r,p,s,l,o.
		The method toLowerCase() will convert all uppercase letters in a string into lowercase letters.*/
		
		userPlay = userPlay.toLowerCase();

		//Checking if the input from the user is one of the correct letters, else an error message is printed.
		
		if(userPlay.equals("r") || userPlay.equals("p") || userPlay.equals("s") || userPlay.equals("l") || userPlay.equals("o")){

			String randomLetter;

			//Generating a random variable with a range from 0 to 4. 
			//Conditional used to convert the randomly generated number into a letter for the game.

			int play = (int)(Math.random() *  5);

			if(play == 0){
				randomLetter = "r";
				computerPlay(randomLetter);
			} else if(play == 1){
				randomLetter = "p";
				computerPlay(randomLetter);
			} else if(play == 2){
				randomLetter = "s";
				computerPlay(randomLetter);
			} else if(play == 3){
				randomLetter = "l";
				computerPlay(randomLetter);
			} else {
				randomLetter = "o";
				computerPlay(randomLetter);
			}

			//Calling the method gameResult() which takes in the user's chosen letter and the computer's play.
			
			System.out.println("You: " + gameResult(userPlay, randomLetter));
		} 
		else {
			System.out.println("The letter/word played does not exist in this game, try again");
		}

	}

	public static void computerPlay(String randomLetter){

		System.out.println("The Computer's play was: " + randomLetter);
			
	}

	public static String gameResult(String u, String c){

		String t = "Tied";
		String w = "Win";
		String l= "Lose";

	/*Using conditionals (if-statements and boolean operators).
	Testing all the possible variations which would result in the user winning.
	If the conditions are false/not met, there is a condition for which the user tied, and one if the user lost.*/

		if(u.equals(c))
			return t;
		else if(u.equals("s") && c.equals("p"))
			return w;
		else if(u.equals("s") && c.equals("l"))
			return w;
		else if(u.equals("r") && c.equals("s"))
			return w;
		else if(u.equals("r") && c.equals("l"))
			return w;
		else if(u.equals("l") && c.equals("o"))
			return w;
		else if(u.equals("l") && c.equals("p"))
			return w;
		else if(u.equals("p") && c.equals("r"))
			return w;
		else if(u.equals("p") && c.equals("o"))
			return w;
		else if(u.equals("o") && c.equals("s"))
			return w;
		else if(u.equals("o") && c.equals("r"))
			return w;
		else 
			return l;

		//Method returns wether the user won, lost or tied.
	}
}