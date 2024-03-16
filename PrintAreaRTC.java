import java.io.*;
import java.util.*;
abstract class Shape
{
	int a,b;
	abstract public double printArea();
} 
class Rectangle extends Shape
{
	int a,b;
	public Rectangle()
	{
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the values for l and b:");
		a=s.nextInt();
		b=s.nextInt();
	}
	public double printArea()
	{
		return a*b;
	}
}
class Triangle extends Shape
{
	int a,b;
	public Triangle()
	{
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the values for h and b:");
		a=s.nextInt();
		b=s.nextInt();
	}
	public double printArea()
	{
		return 0.5*a*b;
	}
}
class Circle extends Shape
{
	int a;
	public Circle()
	{
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the value for r:");
		a=s.nextInt();
	}
	public double printArea()
	{
		return 22/7*a*a;
	}
}
class PrintAreaRTC
{
	public static void main(String args[])
	{
		int ch;
		double n;
		Shape obj;
		Scanner s= new Scanner(System.in);
		System.out.println("1.Rectangle\n2.Triangle\n3.Circle\nYour Choice:");
		ch=s.nextInt();
		if(ch==1)
		{
			obj= new Rectangle();
			n=obj.printArea();
			System.out.println("Area of Rectangle = "+n);
		}
		else if(ch==2)
		{
			obj= new Triangle();
			n=obj.printArea();
			System.out.println("Area of Triangle = "+n);
		}
		else if(ch==3)
		{
			obj= new Circle();
			n=obj.printArea();
			System.out.println("Area of Circle= "+n);
		}
		else
		{
			System.out.println("Invaild Choice...You have EXITED form the program.");
		}
	}
}