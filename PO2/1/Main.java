
public class Main{
public static void main(String args[])
{
	try{
	int []wsk=new int[3];
	for (int i = 0; i < args.length; i++)
      		wsk[i]=Integer.parseInt(args[i]);
	int a=wsk[0];
	int b=wsk[1];
	int c=wsk[2];
	double delta=b*b-4*a*c;
	double x=0;
	double x2=0;
	double pierwiastek=Math.sqrt(delta);
	if(delta<0)
		System.out.println("Rownanie nie ma rozwiazan");
	else if(delta==0)
		{ x=-1*b/(2*a);
		System.out.print("Pierwiastek x= "+x);}
	else
		{x=(-1*b+pierwiastek)/(2*a);
		x2=(-1*b-pierwiastek)/(2*a);
		System.out.println("Pierwiastki");
		System.out.println("x= "+x);
		System.out.println("x2= "+x2);
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Nie podano argumentow");
	}

	
	
}
}

