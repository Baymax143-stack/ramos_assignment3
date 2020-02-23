import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	
	public static void quiz()
	{
		SecureRandom random = new SecureRandom();
		
		int x = random.nextInt(9);
		int y = random.nextInt(9);
		boolean answer;
		
		Scanner input = new Scanner(System.in);
		askQuestion(x, y);
		int z = readResponse(input);
		
		answer = isAnswerCorrect(x, y, z);																											
		while(answer == false)
		{
			displayIncorrectResponse();
			askQuestion(x, y);
			z = readResponse(input);
			
			answer = isAnswerCorrect(x, y, z);
		}
		displayCorrectResponse();
	}
	
	public static void askQuestion(int x, int y)
	{System.out.printf("How much is %d times %d?\n", x, y);}
	
	public static int readResponse(Scanner in)
	{return in.nextInt();}
	
	public static boolean isAnswerCorrect(int x, int y, int ans)
	{
		int correctAnswer = x * y;
		
		if(ans == correctAnswer)
			return true;
		
		return false;
	}
	
	public static void displayCorrectResponse()
	{
		//System.out.println("Very good!");
		
		SecureRandom r = new SecureRandom();
		int selection = r.nextInt(4);
		
		while(selection == 0) {r.nextInt(4);}
		
		switch (selection) 
		{
		case 1:
			System.out.println("Very good!");
			break;
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice work!");
			break;
		case 4:
			System.out.println("Keep up the good work!");
			break;
		}
	}
	
	public static void displayIncorrectResponse()
	{
		//System.out.println("No. Please try again.");
		
		SecureRandom r = new SecureRandom();
		int selection = r.nextInt(4);
		
		while(selection == 0) {selection = r.nextInt(4);}
		
		switch (selection) 
		{
		case 1:
			System.out.println("No. Please try again.");
			break;
		case 2:
			System.out.println("Wrong. Try once more.");
			break;
		case 3:
			System.out.println("Don't give up!");
			break;
		case 4:
			System.out.println("No. Keep trying.");
			break;
		}
	}
	
	public static void main(String[] args) {
		quiz();
	}

}
