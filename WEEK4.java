class AbstractRunner{
	public static void main(String args []){
		Rectangle r = new Rectangle(5, 10);
		Triangle t = new Triangle(5,10);
		Circle c = new Circle(5);
		
		r.printArea();
		t.printArea();
		c.printArea();
	}
}

abstract class Shape{
	int a;
	int b;
	Shape(int a, int b){
		this.a = a;
		this.b = b;
	}
	public abstract void printArea();
}

class Rectangle extends Shape{
	Rectangle(int a, int b){
		super(a, b);
	}
	public void printArea(){
		System.out.println(a * b);
	}
}

class Triangle extends Shape{
	Triangle(int a, int b){
		super(a, b);
	}
	public void printArea(){
		System.out.println(0.5 * a * b);
	}
}

class Circle extends Shape{
	Circle(int a){
		super(a, a);
	}
	public void printArea(){
		System.out.println(3.14 * a * b);
	}
}
