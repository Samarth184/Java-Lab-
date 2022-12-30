import java.util.Scanner;

public class InterfacedScoreCalc {
   	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
        Student student;
	int opt = 0;
	System.out.println("Choose an option\n1.UnderGraduate\n2.Graduate");
	opt = scanner.nextInt();
	switch(opt){
		case 1: System.out.println("Enter your name");
			student = new UndergraduateStudent(scanner.next());
			System.out.println("Enter your marks");
			for(int i = 0; i<4; i++){
				student.setTestScore(i, scanner.nextInt());
			}
			System.out.println("Student Name: " + student.getStudentName());
        		System.out.println("Result: " + student.getTestResult());
			break;
		case 2: System.out.println("Enter your name");
			student = new GraduateStudent(scanner.next());
			System.out.println("Enter your marks");
			for(int i = 0; i<4; i++){
				student.setTestScore(i, scanner.nextInt());
			}
			System.out.println("Student Name: " + student.getStudentName());
        		System.out.println("Result: " + student.getTestResult());
			break;
	}
      
    }

}

interface StudentFunctions{
	void generateResult();
	void setTestScore();
	String getStudentName();
	void setStudentName(String studentName);
	String getTestResult();
	int[] getTestScores();
	void setTestResult();
}

abstract class Student implements StudentFunctions{
	String studentName;
	int[] testScores = new int[4];
	String testResult;
	Student(String studentName) {	
		this.studentName = studentName;
        	testResult = "Default";
   	 }

    	abstract public void generateResult();

    	public void setTestScore(int testNumber, int testScore) {
        	testScores[testNumber] = testScore;
   	 }

    	public String getStudentName() {
        	return this.studentName;
    	}

    	public void setStudentName(String studentName) {
        	this.studentName = studentName;
   	 }

    	public int[] getTestScores() {
        	return this.testScores;
    	}

    	public String getTestResult() {
        	this.generateResult();
        	return testResult;
    	}

    	public void setTestResult(String testResult) {
        	this.testResult = testResult;
    	}
}

class UndergraduateStudent extends Student {
    UndergraduateStudent(String studentName) {
        super(studentName);
    }

    @Override
    public void generateResult() {
        int a[] = this.getTestScores();
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += a[i];
        }
        int avg = sum / 4;
        if (avg >= 60)
            this.setTestResult("Pass");
        else
            this.setTestResult("Fail");
    }
}

class GraduateStudent extends Student {
    GraduateStudent(String studentName) {
        super(studentName);
    }

    @Override
    public void generateResult() {
        int a[] = this.getTestScores();
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += a[i];
        }
        int avg = sum / 4;
        if (avg >= 70)
            this.setTestResult("Pass");
        else
            this.setTestResult("Fail");
    }
}
