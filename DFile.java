import java.io.*;
class DFile
{
	public static void main(String args[])
	{
		try
		{
			int i;
			File f= new File("D:\\drivename\\");
			String s[];
			s= f.list();
			for(i=0;i<s.length;i++)
			{
				File ff= new File("D:\\drivename\\"+s[i]);
			}
			if(f.isDirectory())
			{
				System.out.println(s[i]);
			}
		}
		catch(Exception e)
		{
		}
	}
}