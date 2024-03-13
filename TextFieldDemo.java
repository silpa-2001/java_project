import java.io.*;
import java.awt.*;
import java.awt.event.*;
class CTF extends Frame implements ActionListener
{
	Button b1,b2;
	Textfield t1,t2;
	public CTF()
	{
		super("Textfield Demo...");
		t1=new Textfield(10);
		t2=new Textfield(10);
		b1= new Button("Move");
		b2= new Button("Exit");
		setLayout(new FlowLayout());
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(600,600);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String s=t1.getText();
			t1.setText("");
			t2.setText(s);
		}
		else
		{
			System.exit(0);
		}
	}
}
class TextFieldDemo
{
	public static void main(String args[])
	{
		CTF obj= new CTF();
	}
}