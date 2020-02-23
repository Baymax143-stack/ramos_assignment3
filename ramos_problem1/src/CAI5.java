import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	
	public static void quiz()
	{
		int x = 0, y = 0;
		boolean answer;
		
		Scanner input = new Scanner(System.in);
		
		boolean loop = true;
		while(loop == true)
		{
			int numCorrect = 0; 
			double score;
			
			int difficulty;
			difficulty = readDifficulty(input);
			
			int type = 0;
			System.out.println("Which of the following problem types would you like to complete: ");
			System.out.println("1) Addition");
			System.out.println("2) Multiplication");
			System.out.println("3) Subtraction");
			System.out.println("4) Division");
			System.out.println("5) Randomized");
			System.out.print("Please enter your option by entering the appropriate number: ");
			type = input.nextInt();
			
			int i;
			for(i = 0; i < 10; i++)
			{
				System.out.printf("Question %d: ", i + 1);
				if(type == 1)
					answer = addition(difficulty, x, y, input);
				else if(type == 2)
					answer = multiplication(difficulty, x, y, input);
				else if(type == 3)
					answer = subtraction(difficulty, x, y, input);
				else if(type == 4)
					answer = division(difficulty, x, y, input);
				else
					answer = randomized(difficulty, x, y, input);
						
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
	
	
	/*
	 * 
	 */
	public static boolean addition(int difficulty, int x, int y, Scanner in)
	{
		x = generateQuestionArgument(difficulty); y = generateQuestionArgument(difficulty);
		askQuestion(x, y, 1);
		
		int z = readResponse(in);
		
		return isAnswerCorrect(x, y, z, 1);
	}
	
	/*
	 * 
	 */
	public static boolean multiplication(int difficulty, int x, int y, Scanner in)
	{
		x = generateQuestionArgument(difficulty); y = generateQuestionArgument(difficulty);
		askQuestion(x, y, 2);
		
		int z = readResponse(in);
		
		return isAnswerCorrect(x, y, z, 2);
	}
	
	/*
	 * 
	 */
	public static boolean subtraction(int difficulty, int x, int y, Scanner in)
	{
		x = generateQuestionArgument(difficulty); y = generateQuestionArgument(difficulty);
		askQuestion(x, y, 3);
		
		int z = readResponse(in);
		
		return isAnswerCorrect(x, y, z, 3);
	}
	
	/*
	 * 
	 */
	public static boolean division(int difficulty, int x, int y, Scanner in)
	{
		x = generateQuestionArgument(difficulty); y = generateQuestionArgument(difficulty);
		askQuestion(x, y, 4);
		
		int z = readResponse(in);
		
		return isAnswerCorrect(x, y, z, 4);
	}
	
	/*
	 * 
	 */
	public static boolean randomized(int difficulty, int x, int y, Scanner in)
	{
		x = generateQuestionArgument(difficulty); y = generateQuestionArgument(difficulty);
		
		SecureRandom r = new SecureRandom();
		int t = r.nextInt(4);
		
		if(t == 1)
			askQuestion(x, y, 1);
		else if(t == 2)
			askQuestion(x, y, 2);
		else if(t == 3)
			askQuestion(x, y, 3);
		else if(y == 4)
			askQuestion(x, y, 4);
		
		int z = readResponse(in);
		
		return isAnswerCorrect(x, y, z, t);
	}
	
	
	/*
	 * 
	 */
	public static int readDifficulty(Scanner in)
	{
		int difficulty;
		
		System.out.print("Please choose a level of difficulty (1, 2, 3, or 4): ");
		difficulty = in.nextInt();
		
		return difficulty;
	}
	
	/*
	 * 
	 */
	public static int generateQuestionArgument(int difficult)
	{
		SecureRandom r = new SecureRandom();
		
		if(difficult == 1)
			return r.nextInt(9);
		else if(difficult == 2)
			return r.nextInt(99);
		else if(difficult == 3)
			return r.nextInt(999);
		else if(difficult == 4)
			return r.nextInt(9999);
		
		System.out.println("Level of Difficulty given was not valid.");
		return 0;
	}
	
	
	/*
	 * 
	 */
	public static void askQuestion(int x, int y, int type)
	{
		if(type == 1)
			System.out.printf("How much is %d plus %d?\n", x, y);
		else if(type == 2)
			System.out.printf("How much is %d times %d?\n", x, y);
		else if(type == 3)
			System.out.printf("How much is %d minus %d?\n", x, y);
		else if(type == 4)
			System.out.printf("How much is %d divided by %d?\n", x, y);
	}
	
	
	/*
	 * 
	 */
	public static int readResponse(Scanner in)
	{return in.nextInt();}
	
	/*
	 * 
	 */
	public static boolean isAnswerCorrect(int x, int y, int ans, int type)
	{
		int correctAnswer = 0;
		if(type == 1)
			correctAnswer = x + y;
		else if(type == 2)
			correctAnswer = x * y;
		else if(type == 3)
			correctAnswer = x - y;
		else if(type == 4)
			correctAnswer = x / y;
		
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
