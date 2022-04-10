import java.util.*;
import java.io.*;

public class RecursionTrial{

	public static void main(String[] args){

		System.out.println(fibRecusion(4));

	}

	public static int fibRecusion(int index){

		if(index == 0)
			return 0;
		else if(index == 1)
			return 1;
		else
			return fibRecusion(index-1) + fibRecusion(index-2);
	}
}