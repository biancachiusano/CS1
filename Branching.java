/**
 * Implementation of the 3-SATISFIABILITY algorithm presented by Steven Kelk in Discrete Mathematics course.
 * 		The problem can be described as a "logical-AND of lots of clauses, where a clause is the logical-OR of three (possibly negated) primitive propositions."
 * 		For example: (x OR y OR not z) AND (not x OR w OR z) AND (…) AND ….
 * 		This piece of code will be useful when developing your solution for Project 1.1
 *
 *	INSTRUCTIONS: 
 *		- To properly compile and run this code you may need to copy these files into the Java folder (for example, C:\Program Files\Java\jdk1.8.0_60) or include your working folder into the path (see Practical session 1 f you need a refresher on how to do it)
 *		- You do NOT need to compile ReturnObject.java. As this class is used inside Branching.java, it will be automatically compiled when executing "javac Branching.java"
 *		- At the beginning of the main method you will find several examples to test your implementation. Please comment and uncomment the parts accordingly
 *			- SHORT TRUE EXAMPLE: This example contains just a few statements and it must return "true"
 *			- TRUE EXAMPLE: This is a more complex example, also returning "true" if the implementation is correct
 *			- FALSE EXAMPLE Similarly, this (complex) example must lead to "false" if properly implemented
 *
 * @author Enrique Hortal
 * @version 1.0
 */

import java.util.*;

public class Branching {
	final static boolean DEBUG = true;
	/** Method to check the index of a targeted value in a one-dimensional array (-1 if it is not found)
	 * @param array Array of elements where a concrete value will be checked 
	 * @param value Value to be found (or not) in the provided array
	 * @return The method returns the index in <i>array</i> where <i>value</i> was found, -1 otherwise (or if array is null)
	 */
	public static int findIndex(String array[], String value) { 	  
		int index = -1;
		for(int i = 0; i < array.length; i++) {
			if(array[i].equals(value)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * Method to fill in all the instances of <i>primitive</i> in the array <i>L</i> with <i>value</i>
	 * @param L List of logical AND clauses
	 * @param L_values Known values of the logical AND clauses
	 * @param primitive Primitive to be updated
	 * @param value Value to be updated in the given <i>primitive</i>
	 * @return New version of <i>L_values</i>
	 */
	public static Boolean[][] fillIn(String[][] L, Boolean[][] L_values, String primitive, Boolean value) {
		//PDF DM: Step1) Fill in truth values for all of the primitives that already have been given true or false status
		//Loop through L: logical AND clauses
		//get all primitives and give a value to it. 
		//put the value for all primitives in the boolean L values array

		for(int lRow = 0; lRow < L.length; lRow++){
			for(int lCol = 0; lCol < L[0].length; lCol++){
				if((L[lRow][lCol]).equals(primitive)){
					//Once found give that primitive's index the value
					L_values[lRow][lCol] = value;
				}
			}
		}
		return L_values;
	}

	// Method to check if an array contains a given value
	public static boolean contains (int[] array, int value) {
		Boolean found = false;
		for(int i = 0; i < array.length; i++){
			if(array[i] == value)
				found = true;
		}

		return found;
	}

	
	/** 
	 * This method is the core of the branching algorithm. It goes through all the possible combinations of the input to look for 
	 * a solution to the 3-SAT problem.
	 * @param L List of logical AND clauses
	 * @param L_values Known values of the logical AND clauses
	 * @param A Array storing the unique values of the primitives to be evaluated
	 * @param A_values Current values for each of the unique primitives being evaluated
	 * @param next_p Primitive to be analysed
	 * @return The method returns a boolean value (whether the logical expression is satisfiable or not), and the current values of each primitive
	 */
	public static ReturnObject isSatisfiable(String[][] L, Boolean[][] L_values, String[] A, Boolean[] A_values, String next_p) {		
		// 3. If there are no clauses left (i.e. they have all been satisfied and thus discarded), then return TRUE.
		if (L.length == 0) {
			  if(DEBUG) System.out.println("return: empty L");
			  return new ReturnObject(true, A_values);
		}

		// 1. Fill in truth values for all the primitives that already have been given True or False status.
		if (next_p != null) {
			int next = findIndex(A, next_p); 
			L_values = fillIn(L, L_values, next_p, A_values[next]);
			// Also the negative ones
			L_values = fillIn(L, L_values, next_p+'n', !(A_values[next]));
		    
			// Delete values from previous branches
			for (int a=0; a<A.length; a++) {
				if (A_values[a] == null) {
					L_values = fillIn(L, L_values, A[a], null);
					L_values = fillIn(L, L_values, A[a]+'n', null);
				}
			}
			
			if(DEBUG) System.out.println("A: " + Arrays.toString(A) + " = " + Arrays.toString(A_values));
			if(DEBUG) System.out.println("L: " + Arrays.deepToString(L));
			if(DEBUG) System.out.println("L_values: " + Arrays.deepToString(L_values));
		}	     

	    // 2. For each clause in L,
		// NOTE: This code considers a maximum 10 clauses but it could be modified to be defined dynamically
	    int[] toRemove = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	    int numIndicesToRemove = 0;
	    
	    for (int i=0; i<L.length; i++) {
	    	// a. If the clause has had all its primitives filled in, and the clause is false, then return FALSE
	    	//Check that neither of the three primitives is going to be null or true 6 statements connected with and operator
	    	if(L_values[i][0] != null && L_values[i][0] == false && L_values[i][1] != null && L_values[i][1] == false && L_values[i][2] != null && L_values[i][2] == false) 
	    	{	//If true than print this
	    		if(DEBUG) System.out.println("return: L_values[" + i + "] all False");
	    		return new ReturnObject(false, A_values);	
	    	}
	        
	    	/* b. If the clause has had all its primitives filled in, and the clause is true, 
	    	 * (or there are still primitives in the clause that have not yet been filled in, but we can see that it is definitely true),
	    	 * throw the clause away from L
	    	 */
	    	//Check that the clause is true and make sure that it is not empty. If it is not empty AND it is true OR the second one Or the tird one (variables)
	    	if((L_values[i][0] != null && L_values[i][0] == true) || (L_values[i][1] != null && L_values[i][1] == true) || (L_values[i][2] != null && L_values[i][2] == true)) 
	    	{
	    		toRemove[numIndicesToRemove++] = i;
	    		if(DEBUG) System.out.println("Index " + i + " to be removed");
	    	}
	    }
	    
	    // NOTE: We just consider 3 variables per clause but a different number of variables (or even varying number of variables per clause) could be considered
	    String[][] L_new = new String[L.length-numIndicesToRemove][3];
	    Boolean[][] L_values_new = new Boolean[L.length-numIndicesToRemove][3];
	    int pos = 0;
	    for (int i=0; i<L.length; i++) {
	    	if (!contains(toRemove, i)) {
	    		L_new[pos] = L[i];
	    		L_values_new[pos] = L_values[i];
	    		pos++;
	    		if(DEBUG) System.out.println("Index " + i + " is kept");
	    	} else if(DEBUG) System.out.println(next_p + ": removing..." + Arrays.toString(L[i]) + " = " + Arrays.toString(L_values[i]));
	    	
	    }
	    if(DEBUG) System.out.println(Arrays.deepToString(L_new));
	    
	    // 3. If there are no clauses left (i.e. they have all been satisfied and thus discarded), then return TRUE.
	    if(L_new.length == 0)
	    {
	    	if(DEBUG) System.out.println("return: empty L after removal");
	    	return new ReturnObject(true, A_values);
	    }
	    
	    // 4. Select a proposition p that still has 'don't know' status.
	    // NOTE: This part could be improved. For example, it could start looking for the variable which appears more often. 
	    int a = -1;
	    for (int i=0; i<A_values.length; i++) {
	    	if (A_values[i] == null) {
	    		a = i;
	    	}
	    }
	    if (a!=-1) {
		    A_values[a] = true;
		    // 5. Boolean branch1 = isSatisfiable( L, A augmented with 'p is true' ); 
		    		    
		    // Before executing the recursive call, you need to evaluate if the (potential) side effect produced when passing an array as parameter to a method (see Lecture 5) must be avoided
		    
		    
		    // RECURSIVE CALL!!!!! 
		    ReturnObject output = isSatisfiable(L_new, L_values_new, A, A_values, A[a]); 
		    

		    // 6. If branch1 == TRUE, return TRUE
		    if (output.out) {
		    	if(DEBUG) System.out.println("return: positive branch " + A[a]);
			    return new ReturnObject(true, output.A_values);
		    }
			
		    // 7. Boolean branch2 = Solve isSatisfiable( L, A augmented with 'p is false');
		    A_values[a] = false;
		    
			// Before executing the recursive call, you need to evaluate if the (potential) side effect produced when passing an array as parameter to a method (see Lecture 5) must be avoided
		    
		    
		    // RECURSIVE CALL!!!!! 
		    ReturnObject output2 = isSatisfiable(L, L_values, A, A_values, A[a]); 
		    
		    // 8. If branch2 == TRUE, return TRUE;
		    if (output2.out) {
		    	if(DEBUG) System.out.println("return: negative branch " + A[a]);
		    	return new ReturnObject(true, output2.A_values);
		    }
	    }
	  
	    // 9. Return FALSE (i.e. both branches failed!)
	    return new ReturnObject(false, A_values);
	}
	
	
	public static void main(String[] args) {
		// SHORT TRUE EXAMPLE
		/*String[][] L = {{"x", "y", "z"}, {"xn", "yn", "z"},{"xn", "yn", "zn"}};
		Boolean[][] L_values = {{null, null, null}, {null, null, null}, {null, null, null}};
		String[] A = {"x", "y", "z"};
		Boolean[] A_values = {null, null, null};*/
		
		
		// FALSE EXAMPLE
		/*String[][] L = {{"xn", "yn", "zn"}, {"x", "yn", "zn"}, {"xn", "yn", "p"}, {"x", "z", "p"}, {"yn", "z", "pn"}, 
						{"y", "zn", "p"}, {"y", "zn", "tn"}, {"y", "z", "tn"}, {"y", "pn", "t"}, {"z", "p", "t"}}; // false
		Boolean[][] L_values = {{null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null},
				{null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}};
		String[] A = {"x", "y", "z", "p", "t"};
		Boolean[] A_values = {null, null, null, null, null};*/
		
		// TRUE EXAMPLE
		String[][] L = {{"xn", "yn", "zn"}, {"x", "yn", "zn"}, {"xn", "yn", "p"}, {"x", "z", "p"}, {"yn", "z", "pn"}, 
						{"y", "zn", "p"}, {"y", "zn", "tn"}, {"y", "z", "tn"}, {"y", "pn", "t"}};	// true
		Boolean[][] L_values = {{null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null},
								{null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}};
		String[] A = {"x", "y", "z", "p", "t"};
		Boolean[] A_values = {null, null, null, null, null};
		
		ReturnObject output = new ReturnObject(true, A_values);
		// We will also measure the time needed to find the solution
		long start = System.nanoTime();
		
		output = isSatisfiable(L, L_values, A, A_values, null);

		System.out.print("isSatisfiable returns \"" + output.out + "\"");
		if (output.out)
			System.out.print(" with values: " + Arrays.toString(A) + " = " + Arrays.toString(output.A_values));
					
		System.out.println("\nThe time needed to perform this analysis was: " + (System.nanoTime()-start)/1000000.0 + " ms.");
	}

}
