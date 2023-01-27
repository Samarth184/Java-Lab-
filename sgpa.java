import java.util.Scanner;
class Studentx{
    Scanner s=new Scanner(System.in);
    private int usn;
    private String name;
    int n;
    int[] marks=new int[10];
    int[] credits=new int[10];
    void getMarks(){
        System.out.println("Enter no of subjects:");
        this.n=s.nextInt();
        System.out.println("Enter marks of subjects and credits consecutively:");
        for(int i=0;i<n;i++){
            this.marks[i]=s.nextInt();
            this.credits[i]=s.nextInt();
        }
    }
    int[] getGrade(){
        int[] grade=new int[10];
        for(int i=0;i<n;i++){
            if(marks[i]>=90){
                grade[i]=10;
            }else if(marks[i]>=80){
                grade[i]=9;
            }else if(marks[i]>=70){
                grade[i]=8;
            }else if(marks[i]>=60){
                grade[i]=7;
            }else if(marks[i]>=50){
                grade[i]=6;
            }else if(marks[i]>=40){
                grade[i]=5;
            }else if(marks[i]>=30){
                grade[i]=4;
            }else{
                grade[i]=0;
            }
        }
        return grade;
    }
    double calc(){
        int sum1=0,sum2=0;
        for(int i=0;i<n;i++){
            int[] grade;
            grade=getGrade();
            sum1+=grade[i]*this.credits[i];
            sum2+=this.credits[i];
        }
        return (double)sum1/sum2;
    }
    void display(){
        System.out.println("Marks\tCredits\n");
        for(int i=0;i<n;i++){
            System.out.println(this.marks[i]+"\t\t"+this.credits[i]+"\n");
        }
        System.out.println("SGPA="+calc());
    }
}
class mainx{
    public static void main(String args[]){
        Studentx s=new Studentx();
        s.getMarks();
        s.calc();
        s.display();
    }
}