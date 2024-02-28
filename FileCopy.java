import java.io.*;
import java.util.*;
class FileCopy
{
	public static void main(String args[])
	{
		FileInputStream fin1,fin2;
		FileOutputStream fout;
		Scanner s=new Scanner(System.in);
		String f1,f2,f3;
		try
		{
			System.out.println("Enter the File names:");
			f1= s.nextLine();
			f2= s.nextLine();
			f3= s.nextLine();
			fin1= new FileInputStream(f1);
			fin2= new FileInputStream(f2);
			fout= new FileOutputStream(f3);
			byte b[];
			b= new byte[5];
			int n= fin1.read(b,0,5);
			while(n!=-1)
			{
				fout.write(b,0,n);
				n= fin1.read(b,0,5);
			}
			n= fin2.read(b,0,5);
			while(n!=-1)
			{
				fout.write(b,0,n);
				n= fin2.read(b,0,5);
			}
			fout.close();
			fin2.close();
			fin1.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}