import java.io.*;
class CallMe
{
	public synchronized void call(String str)
	{
		System.out.println("["+str);
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
		}
		System.out.println("]");
	}
}
class Tcall implements Runnable
{
	String str;
	CallMe cm;
	Thread t;
	public Tcall(String s,CallMe c)
	{
		str=s;
		cm=c;
		t= new Thread(this);
		t.start();
	}
	public void run()
	{
		cm.call(str);
	}
}
class TSyn
{
	public static void main(String args[])
	{
		CallMe c= new CallMe();
		Tcall p,q,r;
		p= new Tcall("Hello",c);
		q= new Tcall("World",c);
		r= new Tcall("Gooday",c);
		try
		{
			p.t.join();
			q.t.join();
			r.t.join();
		}
		catch(InterruptedException e)
		{
		}
	}
}