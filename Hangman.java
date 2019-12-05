import java.util.Scanner;
public class Hangman
{
	public static char string[] = {'A','P','P','L','E'};
	public static short ar[] = {1,0,0,1,0};
	public static boolean is_Winner =false;
	public final static Scanner scan = new Scanner(System.in);
	public static void main(String args[])
	{
		boolean gameIsActive = true;
		char[] guesses = new char[5];
		short counter = 0;
		System.out.println("Use uppercase letters only.");
		System.out.println("Game Starting...");
		do
		{
			if(counter==5)break;
			display();
			System.out.println("\nGuess a word");
			char c = scan.next().charAt(0);
			guesses[counter] = c;
			if(!contains(c))counter++;
			if(winnerknown()) {is_Winner=true;gameIsActive = false;}
			System.out.println("\nChance left : "+(5-counter));
		}while(gameIsActive);
		display();
		if(is_Winner)System.out.println("\nWinner Winner Chicken Dinner!");
		else System.out.println("\nGame Over!");
	}
	public static boolean winnerknown()
	{
		boolean flag = true;
		for(int i : ar)
		{
			if(i==0) {flag=false;break;}
		}
		return flag;
	}
	public static boolean contains(char ch)
	{
		boolean flag = false;
		for(short i=0;i<string.length;i++)
		{
			if(string[i]==ch) {ar[i]=1;flag=true;}
		}
		return flag;
	}
	public static void display()
	{
		for(short i=0;i<ar.length;i++)
		{
			if(ar[i]==1)System.out.print(string[i]);
			else System.out.print('_');
		}
	}
}
