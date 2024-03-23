import java.io.*;
class CThread implements Runnable
{
	int n,m;
	public CThread(int a, int b)
	{
		m=a;
		n=b;
	}
	public void run()
	{
		while(m!=n)
		{
			System.out.println(m+"\t");
			if(m<n)
			{
				m++;
			}
			else
			{
				m--;
			}
		}
		System.out.println(m+"\t");
	}
}
class MThread
{
	public static void main(String args[])
	{
		CThread t,s;
		Thread p,q;
		t= new CThread(1,21);
		s= new CThread(21,1);
		p= new Thread(t);
		q= new Thread(s);
		p.start();
		q.start();
	}
}