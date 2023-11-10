/*
 * Written by Christian Rios
 */
import java.util.*;
import java.io.*;
public class RobotQueueDriver {
	public static final int BOARD_LENGTH = 110;
	//This is the length of the board. 100 characters, plus 10 \n's.
	public static String[] test1 = LoadBoard();
	public static QueueI <String> qu = getCommandQueue();
	public static void main(String[] args) 
	{
//-----------------------------Main Method---------------------------------------------------------
//This is the main method. Here, i call the size of the command file so the program knows how many movements the robot needs to take.
		int commandsize = qu.size();
		for(int i=0;i<commandsize;i++)
		{
			String command = qu.dequeue();
			if(command.equals("Move Right"))
				goRight();
			else if(command.equals("Move Left"))
				goLeft();
			else if(command.equals("Move Up"))
				goUp();
			else if(command.equals("Move Down"))
				goDown();
			else
				break;
		}
		System.out.println("Robot simulation complete. No obstacles encountered.");
		

	}
//-------------------------------Load Board Method---------------------------------------------------------------
//This method asks the user for the board file, and loads it in. It converts the file into an array of strings to make the robot movements easier.
	public static String[] LoadBoard()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the robot queue simulator! Enter the filename of your board (filename.txt).");
		String filename = keyboard.nextLine();
		String[] test = new String[BOARD_LENGTH];
		int number = 0;
		try
		{
			Scanner fileScanner = new Scanner(new File(filename));
			for(int i=0;i<10;i++)
			{
			String board = fileScanner.nextLine();
			String space = board.substring(0,1);
			String space1 = board.substring(1,2);
			String space2 = board.substring(2,3);
			String space3 = board.substring(3,4);
			String space4 = board.substring(4,5);
			String space5 = board.substring(5,6);
			String space6 = board.substring(6,7);
			String space7 = board.substring(7,8);
			String space8 = board.substring(8,9);
			String space9 = board.substring(9,10);
			test[number] = space;
			test[number+1] = space1;
			test[number+2] = space2;
			test[number+3] = space3;
			test[number+4] = space4;
			test[number+5] = space5;
			test[number+6] = space6;
			test[number+7] = space7;
			test[number+8] = space8;
			test[number+9] = space9;
			test[number+10] = "\n";
			number+=11;
			}
			fileScanner.close();
			test[0] = "O";
			System.out.println("Here is the starting board.\n");
			for(int i=0;i<test.length;i++)
				System.out.print(test[i]);
			System.out.println("\n");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return test;
	}
//------------------------------------------Get Command Method--------------------------------------
//This method asks the user for the command file, and adds each line of the text file into a queue.
	public static QueueI <String> getCommandQueue()
	{
		QueueI<String> q;
		q = new LLQueue();
		Scanner keyboard2 = new Scanner(System.in);
		System.out.println("Enter the name of your robot command file (filename.txt).");
		String filename2 = keyboard2.nextLine();
			try
			{
				Scanner fileScanner2 = new Scanner(new File(filename2));
				while(fileScanner2.hasNextLine())
				{
					String command = fileScanner2.nextLine();
					q.enqueue(command);
				}
				fileScanner2.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return q;
		
	}
//-----------------------------------------Robot Movement Methods----------------------------------------------
//This method finds where the "O" is on the board.
	public static int getOLocation()
	{
		int count = 0;
		int index = 0;
		boolean missingO = true;
		while(missingO)
		{
			String whereO = test1[index];
			if(whereO.equals("O"))
			{	
				count = index;
				missingO = false;
			}	
			else
				index++;
		}
		return count;
	}
	public static void goDown()
//These methods are for movement. For down, the "O" just gets sent down 11 spaces in the array, which is one line down.
	{
		System.out.println("Moving down...");
		if(test1[getOLocation()+11].equals("_"))
		{
			test1[getOLocation()+11] = "O";
			test1[getOLocation()] = "_";
		}
		else
		{	
			System.out.println("CRASH\nObstacle encountered. Terminating program.");
			System.exit(0);
		}
		for(int i=0;i<test1.length;i++)
			System.out.print(test1[i]);
		System.out.println("\n");
	}
	public static void goUp()
//For up, the "O" gets sent up 11 spaces in the array, which is one line up.
	{
		System.out.println("Moving up...");
		if(test1[getOLocation()-11].equals("_"))
		{
			int location = getOLocation();
			test1[getOLocation()-11] = "O";
			test1[location] = "_";
		}
		else
		{	
			System.out.println("CRASH\nObstacle encountered. Terminating program.");
			System.exit(0);
		}
		for(int i=0;i<test1.length;i++)
			System.out.print(test1[i]);
		System.out.println("\n");
	}
	public static void goLeft()
//For left, the "O" gets sent left one space in the array.
	{
		System.out.println("Moving left...");
		if(test1[getOLocation()-1].equals("_"))
		{
			int location = getOLocation();
			test1[getOLocation()-1] = "O";
			test1[location] = "_";
		}
		else
		{	
			System.out.println("CRASH\nObstacle encountered. Terminating program.");
			System.exit(0);
		}
		for(int i=0;i<test1.length;i++)
			System.out.print(test1[i]);
		System.out.println("\n");
	}
	public static void goRight()
//For right, the "O" gets sent right one space in the array.
	{
		System.out.println("Moving right...");
		if(test1[getOLocation()+1].equals("_"))
		{
			test1[getOLocation()+1] = "O";
			test1[getOLocation()] = "_";
		}
		else
		{	
			System.out.println("CRASH\nObstacle encountered. Terminating program.");
			System.exit(0);
		}
		for(int i=0;i<test1.length;i++)
			System.out.print(test1[i]);
		System.out.println("\n");
	}
}
