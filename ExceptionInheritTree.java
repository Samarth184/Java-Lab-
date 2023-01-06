import java.lang.*;
import java.util.Scanner;

class Father{
	int ageFather;
	Father(){}
	Father(int ageFather) throws IllegalArgumentException{
		if(ageFather<=0){
			throw new IllegalArgumentException("Age should be greater than zero!");
		}
		this.ageFather = ageFather;
	}
}

class Son extends Father{
	int ageSon;
	Son(){}
	Son(int ageFather, int ageSon) throws IllegalArgumentException{
		super(ageFather);
		if(ageFather <= ageSon){
			throw new IllegalArgumentException("Age of son can't be greater than Father's age!!!");
		}
		this.ageSon = ageSon;
	}
	
}

class ExceptionInheritTree{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int ageFather, ageSon;
		System.out.println("enter age of father and son");
		ageFather = sc.nextInt();
		ageSon = sc.nextInt();
		try{
			Son son = new Son(ageFather, ageSon);
			System.out.println("Father's age: " + son.ageFather + "\n" + "Sons's age: " + son.ageSon);
		}
		catch(IllegalArgumentException iae){
			System.out.println(iae);
			System.out.println("Exception caught in main!#!");
		}
		
	}
	
}