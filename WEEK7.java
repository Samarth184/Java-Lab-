import java.util.Scanner;

class WrongAgeException extends IllegalArgumentException{
	WrongAgeException(){};
	WrongAgeException(String some){
		super(some);
	}
}

class Father{
	int ageFather;
	Father(){}
	Father(int ageFather) throws WrongAgeException{
		if(ageFather<=0){
			throw new WrongAgeException("Age should be greater than zero!");
		}
		this.ageFather = ageFather;
	}
}

class Son extends Father{
	int ageSon;
	Son(){}
	Son(int ageFather, int ageSon) throws WrongAgeException{
		super(ageFather);
		if(ageFather <= ageSon){
			throw new WrongAgeException("Age of son can't be greater than Father's age!!!");
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
		catch(WrongAgeException wae){
			System.out.println(wae);
			System.out.println("Exception caught in main!#!");
		}
		
	}
	
}
