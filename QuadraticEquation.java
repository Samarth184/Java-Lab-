import java.util.Scanner;
import java.lang.Math;

class QuadraticEquation{

	public static void main(String [] args){
	int a,b,c;
	int d=0;
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter the coefficients of the quadratic equation in the form a, b,c where ax2 + bx + c=0");
	a = scanner.nextInt();	
	b = scanner.nextInt();
	c = scanner.nextInt();

	d = ((int)Math.pow(b,2)- 4*a*c);
	double result1 = (-b + Math.pow(d,0.5))/(2*a);
	double result2 = (-b - Math.pow(d,0.5))/(2*a);
	
	if(d==0){
		System.out.println("The roots are real and equal");
		System.out.println("The root is:" + " " + result1 );
	}
	else if(d>0){
		System.out.println("The roots are real and distinct");
		System.out.println("The roots are: ");
		System.out.println("root 1 " + result1);
		System.out.println("root 2" + result2);
	}
	else{
		double factor = (Math.sqrt(Math.abs(d))) / (2*a);
		System.out.println("The roots are imaginary");
		System.out.println("The roots are: ");
		System.out.println("root 1 " + -b/(2*a) + "+i " + factor);
		System.out.println("root 2 " + -b/(2*a) + "-i " + factor);
	}

}


}