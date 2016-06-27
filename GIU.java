package Encrypt;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GIU
{
	static int a;
	static int b;
	static int m;
	static JTextArea Enc;
	static JTextArea Mess;
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("EnCrypt Message ");
		JPanel main = new JPanel(new GridLayout(3, 1));
		JPanel top = new JPanel(new GridLayout(2, 2));
		JPanel first = new JPanel(new GridLayout(1, 2));
		JPanel leftTop = new JPanel();
		JLabel Alabel = new JLabel("Set A KEY");
		JLabel errorM = new JLabel("Plese Use coprime number to encrypt message !");
		JTextField A = new JTextField();//field for A key
		A.setColumns(20);
		JPanel rigthTop = new JPanel();
		JLabel Mlabel = new JLabel("Multiplicative Number");
		JTextField M = new JTextField();//field for Multiplicative number
		M.setColumns(20);
		JPanel second = new JPanel(new GridLayout(1, 2));
		JPanel leftBottom = new JPanel();
		JLabel Blabel = new JLabel("Set B KEY");
		JTextField B = new JTextField();//field for B key
		B.setColumns(20);
		JPanel rigthBottom = new JPanel();
		JButton AD = new JButton("Set KEY");
		AD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean checkA= false;
							String anum=A.getText();
							a = Integer.parseInt(anum);
							String bnum=B.getText();
							b = Integer.parseInt(bnum);
							checkA = isPrime(a);
							if(checkA==false)
							{
								errorM.setText(a + " Please use coprime number with 26!");
							}else{
								errorM.setText(a + " Type in message !");
								m = multiplicativeNumber(a);
							}
							
							
							String mul = m + " ";
							M.setText(mul);
							
			}
		});
		JPanel third = new JPanel();			//panel
		JButton encr = new JButton("Encrypt");
		encr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = Mess.getText().toLowerCase();
				char[] ch = str.toCharArray();
				char[] chE = new char[ch.length];
				//for(char c:ch)
					//System.out.print(c);
				int[]num = new int[str.length()];
				//System.out.println("ch length is  " +ch.length);
				for(int i=0;i<ch.length;i++)
				{
				char chTemp = ch[i];
				num[i] = getPosition(chTemp);
				//System.out.println(chTemp);
				}
				
				
				//position for original letters
				//System.out.println("Positions for original letters are : ");
				//for(int t:num)
				//	System.out.print(t + " ");
				
				//System.out.println("\n\nENCODING\n\n");
				String messageStr = "";
				for(int i=0;i<num.length;i++)
				{
					int L = num[i];
					chE[i] = encodeLetter(L);
					//System.out.print("p");
					messageStr = messageStr + chE[i];
					
				}
				Enc.setText(messageStr);
				
			}
		});
		Mess = new JTextArea();
		Mess.setEditable(true);
		Mess.setColumns(50);
		Mess.setRows(30);
		JPanel fourth = new JPanel();			//panel
		Enc = new JTextArea();
		Enc.setColumns(50);
		Enc.setRows(30);
		
		frame.add(main);
		main.add(top);
		top.add(first);
		first.add(leftTop);
		leftTop.add(Alabel);
		leftTop.add(A);
		leftTop.add(errorM);
		first.add(rigthTop);
		rigthTop.add(Mlabel);
		rigthTop.add(M);
		
		
		top.add(second);
		second.add(leftBottom);
		leftBottom.add(Blabel);
		leftBottom.add(B);
		second.add(rigthBottom);
		rigthBottom.add(AD);
		rigthBottom.add(encr);
		main.add(third);
		
		third.add(Mess);
		main.add(fourth);
		fourth.add(Enc);
		frame.setSize(600, 650);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		

	}
	public static int getPosition(char r)
	{
		int n = 0;
		
			
			switch(r)
			{
			case ' ':n=100;break;
			case 'a':n=0;break;
			case 'b':n=1;break;
			case 'c':n=2;break;
			case 'd':n=3;break;
			case 'e':n=4;break;
			case 'f':n=5;break;
			case 'g':n=6;break;
			case 'h':n=7;break;
			case 'i':n=8;break;
			case 'j':n=9;break;
			case 'k':n=10;break;
			case 'l':n=11;break;
			case 'm':n=12;break;
			case 'n':n=13;break;
			case 'o':n=14;break;
			case 'p':n=15;break;
			case 'q':n=16;break;
			case 'r':n=17;break;
			case 's':n=18;break;
			case 't':n=19;break;
			case 'u':n=20;break;
			case 'v':n=21;break;
			case 'w':n=22;break;
			case 'x':n=23;break;
			case 'y':n=24;break;
			case 'z':n=25;break;
			default:n=-1;
				
		}
		return n;
	}
	
	public static char getCharFromPosition(int c)
	{
		char n = ' ';
		switch(c)
		{
		case 100:n=' ';break;
		case 0:n='a';break;
		case 1:n='b';break;
		case 2:n='c';break;
		case 3:n='d';break;
		case 4:n='e';break;
		case 5:n='f';break;
		case 6:n='g';break;
		case 7:n='h';break;
		case 8:n='i';break;
		case 9:n='j';break;
		case 10:n='k';break;
		case 11:n='l';break;
		case 12:n='m';break;
		case 13:n='n';break;
		case 14:n='o';break;
		case 15:n='p';break;
		case 16:n='q';break;
		case 17:n='r';break;
		case 18:n='s';break;
		case 19:n='t';break;
		case 20:n='u';break;
		case 21:n='v';break;
		case 22:n='w';break;
		case 23:n='x';break;
		case 24:n='y';break;
		case 25:n='z';break;
		default:n='ó';
		}
		return n;
	}
	public static char encodeLetter(int l)
	{
		char eL = ' ';
		if(l==100)
		{
			eL=' ';
		}else{
		int k = (a * l + b)%26;
		eL = getCharFromPosition(k);
		//System.out.print(k + " ");
		}
		return eL;
		
	}
	
	public static int multiplicativeNumber(int a)
	{
		int mul = 0;
		int i = 1;
		boolean check = true;
		if(a==0||a==1||a==2||a%26==0)
		{
			System.out.println(a + " Not coprime number with 26!");
		}else{
		while(check)
		{
			
			if((i*26+1)%a==0)
			{
				check = false;
				mul = (i*26+1)/a;
			}
			//System.out.println(i);
			
			i++;
			
		}
		}
		return mul;
		
		
	}
	//checks whether an int is prime or not.
	public static boolean isPrime(int n) {
	    //check if n is a multiple of 2
	   // if (n%2==0) return false;
		if(n==0||n==1||n==2||n==13)return false;
	    //if not, then just check the odds
	    for(int i=2;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}


}
