import java.lang.Math;
import java.util.Scanner;

class Bank {
	public static void main(String args []){
		Scanner scanner = new Scanner(System.in);
		String name, accNo;
        	CurrentAccount cacc;
        	SavingsAccount sacc;
		int choice;
		
		System.out.println("Enter an option");
		System.out.println("1 : Open a Savings Account");
		System.out.println("2 : Open a Current Account");
		choice = scanner.nextInt();

		System.out.println("Enter your Name and Account NO");
		name = scanner.next();
		accNo = scanner.next();

		switch(choice){

			case 1:	sacc = new SavingsAccount(name, accNo);
				System.out.println("Enter your starting balance");
				sacc.balance = scanner.nextDouble();

				int opt = 0;
		
				System.out.println("1 :  Deposit");
				System.out.println("2 :  Withdraw");
				System.out.println("3 : Display Balance");		
				System.out.println("4: Quit");
				while(opt != 4){
						System.out.println("Select an option");
						opt = scanner.nextInt();
						switch(opt){
							case 1: System.out.println("Enter the amount you want to deposit");
								double damount = scanner.nextDouble();
									sacc.deposit(damount);
									break;
							case 2:	System.out.println("Enter the amount you want to withdraw");
									double wamount = scanner.nextDouble();
									sacc.withdraw(wamount);
									break;
							case 3:	
									sacc.display();
									sacc.interestCalculator(1);	
									break;
							case 4:	break;
                    	}
                	}
            		break;
        
            	case 2:	cacc= new CurrentAccount(name, accNo);
                	System.out.println("Enter your starting balance");
                	cacc.balance = scanner.nextDouble();
                	opt = 0;
            
                	System.out.println("1 :  Deposit");
                	System.out.println("2 :  Withdraw");
                	System.out.println("3 : Display Balance");		
                	System.out.println("4: Quit");
                	while(opt != 4){
                    		System.out.println("Select an option");
                    		opt = scanner.nextInt();
                    		switch(opt){
								case 1: System.out.println("Enter the amount you want to deposit");
									double damount = scanner.nextDouble();
									cacc.deposit(damount);
									break;
								case 2:	System.out.println("Enter the amount you want to withdraw");
									double wamount = scanner.nextDouble();
									cacc.withdraw(wamount);
									break;
								case 3:	
									cacc.display();
									break;
								case 4:	break;
                    		}
                		}
            		break;
        	
		}
	}
}

 abstract class Account {
	String customerName;
	String accountNumber;
        int accountType;
        double balance = 0;

        Account(String customerName, String accountNumber, int accountType) {
            	this.customerName = customerName;
            	this.accountNumber = accountNumber;
            	this.accountType = accountType;
        }

        abstract public void withdraw(double amount);

        public void deposit(double amount) {
            	balance += amount;
            	System.out.println("Your Balance is : " + balance);
        }

        public void display() {
       	     System.out.println("Balance is:" + balance);
	}
}

class SavingsAccount extends Account {

        	final double rateOfInterest = 0.06;
        	final int term = 4;

        	SavingsAccount(String customerName, String accountNumber) {
            		super(customerName, accountNumber, 1);
        	}

        	public void withdraw(double amount) {
            		if ((balance - amount) > 0.00)
                	balance -= amount;
            		else
                	System.out.println("Insufficient Balance");
            		this.display();
       	 }

        	public void interestCalculator(int period) {
            		double principal = this.balance, interestEarned;

              		double quarterlyInterest = rateOfInterest / term;
              		double quarterlyPeriod = period * term;

              		interestEarned = principal * Math.pow((1 + quarterlyInterest), quarterlyPeriod) - principal;

           	 	System.out.println("Interest earned for this balance (compounded quarterly) for one year is :" + interestEarned);
        }

 }


 class CurrentAccount extends Account {

    	final double penaltyPercent = 0.10;
    	final double minimumBalance = 5000.00;
	
	
    	CurrentAccount(String customerName, String accountNumber) {
        		super(customerName, accountNumber, 2);
			System.out.println("Cheque book has been issued");
    	}

    	public void withdraw(double amount) {
        		if ((balance - amount) > 0.00)
            		balance -= amount;
        		else
            		System.out.println("Insufficient Balance");
        		this.display();
        		if (balance < minimumBalance){
			System.out.println("A penalty of " + balance*penaltyPercent + "has been imposed");
            		balance -= balance * penaltyPercent;
        		}
    	}	
}
