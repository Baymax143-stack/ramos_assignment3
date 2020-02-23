import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {

	public static void quiz()
	{
		SecureRandom random = new SecureRandom();
		int x, y, z;
		boolean answer;
		
		Scanner input = new Scanner(System.in);
		
		boolean loop = true;
		while(loop == true)
		{
			int numCorrect = 0; 
			double score;
		
			int i;
			for(i = 0; i < 10; i++)
			{
				x = random.nextInt(9); y = random.nextInt(9);
			
				System.out.printf("Question %d: ", i + 1);
				askQuestion(x, y);
				z = readResponse(input);
				answer = isAnswerCorrect(x, y, z);		
				if(answer == true)
				{
					numCorrect++;
					displayCorrectResponse();
				}
				else
					displayIncorrectResponse();
			}
		
			score = ((double) numCorrect / 10.0) * 100;
			displayCompletionMessage(score);
			
			System.out.println("Would you like to complete a new problem set?");
			String response = input.next();
			if(response.contentEquals("Yes") || response.contentEquals("yes"))
				loop = true;
			else
				loop = false;
		}
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
		
		//while(selection == 0) {r.nextInt(4);}
		
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
		
		//while(selection == 0) {selection = r.nextInt(4);}
		
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
	
	public static void displayCompletionMessage(double score)
	{
		System.out.printf("Total Score: %.02f%%\n", score);
		if(score >= 75.0)
			System.out.println("Congratulations, you are ready to go to the next level!");
		else
			System.out.println("Please ask your teacher for extra help.");
	}
	
	public static void main(String[] args) {
		quiz();
	}
	
}
