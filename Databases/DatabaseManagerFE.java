/*
 * Written by Christian Rios
 */
import java.util.Scanner;
public class DatabaseManagerFE
{

	private static Scanner keyboard = new Scanner(System.in);
	private static GameDBManager gameDBManager = new GameDBManager();
	public static void main(String[] args) 
	{
		System.out.println("Welcome to the game database!");
		boolean quit = false;
		while(!quit)
		{
			System.out.println("Enter \"title\" to search by title\n"
					+ "Enter \"console\" to search by console\n"
					+ "Enter * to search all titles/consoles\n"
					+ "Enter \"quit\" to quit");
			String choice = keyboard.nextLine();
			//Search by title
			if(choice.equalsIgnoreCase("title"))
			{	
				gameDBManager.PrintGameSearch("./GameDatabase.txt");
			}
			//Search by console
			else if(choice.equalsIgnoreCase("console"))
			{	
				gameDBManager.PrintConsoleSearch("./GameDatabase.txt");
			}
			//Search by all titles
			else if(choice.equals("*"))
			{
				gameDBManager.printDatabaseFile("./GameDatabase.txt");
				System.out.println("\nWould you like to save the results to a file? Y/N");
				Scanner keyboard2 = new Scanner(System.in);
				String choice2 = keyboard2.nextLine();
				if(choice2.equalsIgnoreCase("Y"))
				{
					Scanner keyboard3 = new Scanner(System.in);
					System.out.println("Input file name:");
					String fileName = keyboard3.nextLine();
					gameDBManager.WriteAllToFile(fileName);
					System.out.println("Results written to new file successfully. Restarting program...");
				}
				else
				{
					System.out.println("File not written. Restarting program...\n");
				}
			}
			//quit
			else if(choice.equals("quit"))
			{
				System.out.println("Bye.");
				quit = true;
			}
				
		}
	
	}
	
}