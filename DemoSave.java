import java.net.*;
import java.io.*;
import java.util.Date;
class DemoSave
{
	public static void main(String args[])throws Exception
	{
		URL u= new URL("https://mrcet.com/pdf/Lab%20Manuals/WEB%20TECHNOLOGIES%20LAB.pdf");
		URLConnection uc=u.openConnection();
		System.out.println("Date:"+new Date(uc.getDate()));
		System.out.println("Content Type:"+uc.getContentType());
		System.out.println("Expires:"+uc.getExpiration());
		System.out.println("Last Modified:" + new Date(uc.getLastModified()));
		int len=uc.getContentLength();
		System.out.println("Content Length:"+len);
		if(len>0)
		{
			FileOutputStream fout= new FileOutputStream("test.pdf");
			System.out.println("==Content==");
			InputStream in= uc.getInputStream();
			int i=0,c;
			while(((c=in.read())!=-1)&& i<len)
			{
				fout.write(c);
				i++;
			}
			in.close();
			fout.close();
		}
		else
		{
			System.out.println("Content NOT AVAILABLE");
		}
	}
}