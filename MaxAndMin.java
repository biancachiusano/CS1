import java.util.*;
import java.io.*;
import java.lang.Math;

public class MaxAndMin {

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
    	System.out.println("Please enter five numbers:");
    	int n1 = in.nextInt();
    	int n2 = in.nextInt();
    	int n3 = in.nextInt();
        int n4 = in.nextInt();
        int n5 = in.nextInt();

        //Calling the method to identify the max number of the first three number
    	int max = maxOf3(n1,n2,n3);

        //Understanding if n4 or n5 is greater than "max" using Math.max
        max = Math.max(max, Math.max(n4, n5));
    
    	System.out.println("Maximum: " + max);


        //Calling the method to identify the min number of the first three number
        int min = minOf3(n1,n2,n3);

    	//Understanding if n4 or n5 is smaller than min using Math.min
        min = Math.min(min, Math.min(n4, n5));

    	System.out.println("Minimum: " + min);

    }

    public static int maxOf3(int r, int s, int t) {
        
        //Trying to use Arrays
        int[] maxArray = new int[]{r, s, t};

        int maxValue = maxArray[0];

        for(int i = 1; i < maxArray.length; i++){
            if(maxArray[i] > maxValue)
                maxValue = maxArray[i];
        }

        return maxValue;
    }
    
    public static int minOf3(int r, int s, int t) {

        int minValue = r;

        minValue = Math.min(minValue, Math.min(s, t));
        
        return minValue;
    }
    
}