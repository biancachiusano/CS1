
public class MethodsLecture2 {
	
	public static void main(String[] args){
	
			int a = 2;
			int b = 3; 
			int c = 4;

			System.out.println(nameOfTheMethod(a, b, c));

			//The following will not print anything:
			//nameOfTheMethod(16,15,20); because it is just an integer 
			//I could, however, assign it to another variable and print that variable

			int sum = nameOfTheMethod(16,15,20);
			System.out.println(sum);
	}

	//Here I can write the method, takes an input of parameters, in this case 3
	public static int nameOfTheMethod(int x, int y, int z){
		
		int sum = x + y + z;
		return sum;
		//The output is what it returns
	}

	//What is going to be printed is just an integer value
}
