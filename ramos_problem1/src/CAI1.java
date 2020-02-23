import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	
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
	{System.out.println("Very good!");}
	
	public static void displayIncorrectResponse()
	{System.out.println("No. Please try again.");}
	
	public static void main(String[] args) {
		quiz();
	}

}
