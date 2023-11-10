/*
 * Written by Christian Rios
 */
import java.util.*;

public class ShowcaseGameShow {

	public static final String FILE_NAME = "./prizeList.txt"; 
	
		public static void main(String[] args) {
			while(true)
/*
 * This is the main class, and the file that runs the game show. The program reads the file prizeList.txt, and outputs to the console 5 random prizes. A for loop is used to print these prizes to
 * the terminal. A while loop is used for this program just in case the user no longer wants to play. Then, the loop will break and the program will end.
 */
			{
				Scanner keyboard = new Scanner(System.in);
				System.out.println("Welcome to the Showcase Showdown game show!");
				Prize[] item = Showcase.populateShowcase();
				System.out.println("Your five prizes are: ");
				for(int i=0;i<item.length;i++)
					{
						System.out.println(item[i].getprizeName());
					}
				
				System.out.println("You must guess the combined price of all of the prizes without going over.\n");
				int total=0;
				for(int i=0;i<item.length;i++)
					{
						int sum = item[i].getprizePrice()+total;
						total = sum;
					}
			
				System.out.println("Enter your guess (an integer number): ");
				int answer = keyboard.nextInt();
				System.out.println("Your guess was "+answer+" and the actual price was "+total+".");
/*
 * A series of if statements are used to calculate how close the user's guess to the total amount of the prizes is. There are 3 scenarios: The user's guess goes over, is within $2000 of the sum but still under,
 * or is lower than $2000 from the sum. These scenarios will determine whether or not the player loses or wins. After the result, the user will be asked to play again. 				
 */
				if(answer<=total && answer>=total-2000)
					{
						System.out.println("Your guess was within $2000 of the combined price of the prizes. You win!");
					}
				if(answer>total)
					{
						System.out.println("Your guess went over the combined price of the prizes. You lose!");
					}
				if(answer<=total && answer<total-2000)
					{
						System.out.println("Your guess was well below the combined price of the prizes. You lose!");
					}
				
				System.out.println("Play again? Enter Yes or No.");
				Scanner keyboard2 = new Scanner(System.in);
				String playagain = keyboard2.nextLine();
				
				if(playagain.equalsIgnoreCase("yes"))
					{
						System.out.println("\n");
					}
				else
					{
						System.out.println("Goodbye!");
						break;
					}
			}
	}
}