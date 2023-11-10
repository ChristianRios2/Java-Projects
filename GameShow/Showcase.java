/*
 * Written by Christian Rios
 */

import java.io.File;
import java.util.*;
import java.util.Random;
public class Showcase {	
public static Prize[] readFile(String fileName)
	{
		try
		{
		//This method aims to create an array with an instance of a prize name and price for each prize that follows the tab delimited rule.
			Scanner fileScanner = new Scanner(new File(fileName));
			int counter = 0;
			while(fileScanner.hasNextLine())
				{
				 	String  currentLine = fileScanner.nextLine();
				 	String[] delimiter = currentLine.split("\t");
				 
				 	if(delimiter.length==2)
				 	{
				 		counter++;
				 	}
				}
		//This first while loop looks through the prize list file and finds all of the prizes that are tab delimited, and adds it to a counter. This counter is used for the second while loop to create an array with a size of this counter.
			fileScanner = new Scanner(new File(fileName));
			Prize[] PrizeList = new Prize[counter];
			int counter2 = 0;
			while(fileScanner.hasNextLine())
				{
					String  currentLine = fileScanner.nextLine();
					String[] delimiter = currentLine.split("\t");
					if(delimiter.length==2)
					{
						String aName = delimiter[0];
						int aPrice = Integer.parseInt(delimiter[1]);
					
						PrizeList[counter2] = new Prize(aName,aPrice);
						counter2++;
					}	
			}
			return PrizeList;
		/*
		 * The second while loop took the applicable prizes and checked for the tab delimiter again, and split the prizes between its name and its price. These prizes are then appended to the PrizeList
		 * array (which is an instance of Prize[]) and has its name and price included separately. This list is returned by the method for use in the game show class. 
		 */
			
		
		}
		catch(Exception e)
		{
		     System.out.println(e.getMessage());
		     return null;
		}
	}
	
public static Prize[] populateShowcase()
	{
		/*
		 * This method populates the prizes to be shown in the game. two arrays are created, one for the list of possible prizes, and one for the prizes to be displayed in game.
		 * A random prize from the list is chosen, and then that prize is appended to the final prize list array to be used for the game show. This occurs in a for loop, which will be done 5 times
		 * as there are 5 prizes.
		 */
		while(true)
		{	
		Prize[] PrizeListFinal= new Prize[5];
		Prize[] MyPrizeList= readFile("./prizeList.txt");
		Random randomprize= new Random();
		for (int i=0;i<PrizeListFinal.length;i++)
		{
			int numA = randomprize.nextInt(MyPrizeList.length);
			Prize prize1 = MyPrizeList[numA];
			PrizeListFinal[i] = prize1;
		}
		
			return PrizeListFinal;
		}
				
	}
}