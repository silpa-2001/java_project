import java.io.*;
import java.util.*;
class Staff
{
	int code;
	String name;
	public Staff()
	{
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the code and name:");
		code=s.nextInt();
		s.nextLine();
		name=s.nextLine();
	}
	public void disp()
	{
		System.out.println("Code: "+code+" Name: "+name);
	}
}
class Faculty extends Staff
{
	String dept;
	String subj; 
	String resar;
	public Faculty()
	{
		super();
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the Dept, subject and research area:");
		dept=s.nextLine();
		subj=s.nextLine();
		resar=s.nextLine();
	}
	public void disp()
	{
		super.disp();
		System.out.println("Department: "+dept+"\nSubject Taken: "+subj+"\nResearch Area: "+resar);
	}
}
class Typist extends Staff
{
	String speed;
	String offi;
	public Typist()
	{
		super();
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the speed and office:");
		speed=s.nextLine();
		offi=s.nextLine();
	}
	public void disp()
	{
		super.disp();
		System.out.println("Speed: "+speed+"\nOffice: "+offi);
	}
}
class Officer extends Staff
{
	String rank; 
	String grade;
	public Officer()
	{
		super();
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the rank and grade:");
		rank=s.nextLine();
		grade=s.nextLine();
	}
	public void disp()
	{
		super.disp();
		System.out.println("Rank: "+rank+"\nGrade: "+grade);
	}
}
class Permanent extends Typist
{
	int sal;
	public Permanent()
	{
		super();
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the salary:");
		sal= s.nextInt();
	}
	public void disp()
	{
		super.disp();
		System.out.println("Salary: "+sal);
	}
}
class Casual extends Typist
{
	int wage;
	public Casual()
	{
		super();
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the daily wage:");
		wage= s.nextInt();
	}
	public void disp()
	{
		super.disp();
		System.out.println("Daily Wage: "+wage);
	}
}
class LevelInher
{
	public static void main(String args[])
	{
		Staff st= new Staff();
		st.disp();
		Faculty f= new Faculty();
		f.disp();
		Typist t= new Typist();
		t.disp();
		Officer o= new Officer();
		o.disp();
		Permanent p= new Permanent();
		p.disp();
		Casual c= new Casual();
		c.disp();
	}
}