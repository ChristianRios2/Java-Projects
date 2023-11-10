/*
 * Written by Christian Rios
 */
import java.util.Scanner;
import java.io.*;
public class GameDBManager 
{
	public static final String FILE_NAME = "./GameDatabase.txt";
	public static final String DELIM = "\t";
	private LinkedList<Database> DBofGames;
	public GameDBManager()
	{
		DBofGames = new LinkedList<Database>();
		
	}
	public void LoadDatabase(Database aDatabase)
	{
		DBofGames.add(aDatabase);
	}
	// The method below prints the entire text file of games to the console.
	public void printDatabaseFile(String filename)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(filename));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length == 2)
				{
					String game = splitLines[0];
					String console = splitLines[1];
					Database aDB = new Database(game,console);
					this.LoadDatabase(aDB);
					DBofGames.print();
				}
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//The method below reads the database file and splits it along the tab delimiter. When you type in your query, it will only search for the games and ignores the consoles.
	public void PrintGameSearch(String filename)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(filename));
			DBofGames.reset();
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length == 2)
				{
					String game = splitLines[0];
					String console = splitLines[1];
					Database aDB = new Database(game,console);
					this.LoadDatabase(aDB);
				}
			}
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Type in your query:");
			String query = keyboard.nextLine();
			String realquery = query.toLowerCase();
			SearchByGame(realquery);
			System.out.println("\nWould you like to save the results to a file? Y/N");
			Scanner keyboard2 = new Scanner(System.in);
			String choice2 = keyboard2.nextLine();
			if(choice2.equalsIgnoreCase("Y"))
			{
				Scanner keyboard3 = new Scanner(System.in);
				System.out.println("Enter your desired file name:");
				String file = keyboard3.nextLine();
				WriteGameResultsToFile(realquery, file);
				System.out.println("Done. Resarting program...\n");
			}	
			else
			{
				System.out.println("File not written. Restarting program...\n");
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//The method below reads the database file and splits it along the tab delimiter. When you type in your query, it will only search for the console and ignores the titles.
	public void PrintConsoleSearch(String filename)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(filename));
			DBofGames.reset();
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length == 2)
				{
					String game = splitLines[0];
					String console = splitLines[1];
					Database aDB = new Database(game,console);
					this.LoadDatabase(aDB);	
				}
			}
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Type in your query:");
			String query = keyboard.nextLine();
			String realquery = query.toLowerCase();
			SearchByConsole(realquery);
			System.out.println("\nWould you like to save the results to a file? Y/N");
			Scanner keyboard2 = new Scanner(System.in);
			String choice2 = keyboard2.nextLine();
			if(choice2.equalsIgnoreCase("Y"))
			{
				Scanner keyboard3 = new Scanner(System.in);
				System.out.println("Enter your desired file name:");
				String file = keyboard3.nextLine();
				WriteConsoleResultsToFile(realquery, file);
				System.out.println("Done. Resarting program...\n");
			}	
			else
			{
				System.out.println("File not written. Restarting program...\n");
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	// The method below searches the database for the games, turning the lines into strings and ignoring case from the query. The code will look through each line for your query and will print any line that matches.
	public void SearchByGame(String aQuery)
	{	
			
			while(DBofGames.hasMore())
			{
				String GameLine = DBofGames.toastring();
				String GameLineLower = GameLine.toLowerCase();
				String[] parts = GameLineLower.split("\t");
				String GameOnly = parts[0];
				if(GameOnly.contains(aQuery))
				{
					DBofGames.printCurrent();
					DBofGames.gotoNext();
				}
				else
				{
					DBofGames.gotoNext();
				}
			
			}
	}
	// The method below searches the database for the console that matches your query, turning the lines into strings and ignoring case from the query. The code will look through each line for your query and will print any line that matches.
	public void SearchByConsole(String aQuery)
	{	
			
			while(DBofGames.hasMore())
			{
				String GameLine = DBofGames.toastring();
				String GameLineLower = GameLine.toLowerCase();
				String[] parts = GameLineLower.split("\t");
				String ConsoleOnly = parts[1];
				if(ConsoleOnly.contains(aQuery))
				{
					DBofGames.printCurrent();
					DBofGames.gotoNext();
				}
				else
				{
					DBofGames.gotoNext();
				}
			
			}
	}
	// This method writes the entire text file into a file for the user to keep.
	public void WriteAllToFile(String aName)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));
			DBofGames.reset();
			while(DBofGames.hasMore())
			{
				fileWriter.println(DBofGames.getCurrent());
				DBofGames.gotoNext();
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void WriteGameResultsToFile(String aQuery, String aName)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));
			DBofGames.reset();
			while(DBofGames.hasMore())
			{
				String GameLine = DBofGames.toastring();
				String GameLineLower = GameLine.toLowerCase();
				String[] parts = GameLineLower.split("\t");
				String GameOnly = parts[0];
				if(GameOnly.contains(aQuery))
				{
					fileWriter.println(DBofGames.getCurrent());
					DBofGames.gotoNext();
				}
				else
				{
					DBofGames.gotoNext();
				}
				
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void WriteConsoleResultsToFile(String aQuery, String aName)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));
			DBofGames.reset();
			while(DBofGames.hasMore())
			{
				String GameLine = DBofGames.toastring();
				String GameLineLower = GameLine.toLowerCase();
				String[] parts = GameLineLower.split("\t");
				String GameOnly = parts[1];
				if(GameOnly.contains(aQuery))
				{
					fileWriter.println(DBofGames.getCurrent());
					DBofGames.gotoNext();
				}
				
				
				else
				{
					DBofGames.gotoNext();
				}
				
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
