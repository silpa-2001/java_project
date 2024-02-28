import java.io.*;
import java.util.*;
class FileW
{
	public static void main(String args[])
	{
		FileOutputStream fout;
		Scanner s= new Scanner(System.in);
		String fname;
		String data;
		try
		{
			System.out.println("Enter the File Name:");
			fname= s.nextLine();
			fout= new FileOutputStream(fname);
			data=s.nextLine();
			while(!data.equals("quit"))
			{
				fout.write(data.getBytes());
				fout.write("\n".getBytes());
				data=s.nextLine();
			}
			fout.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	} 
}