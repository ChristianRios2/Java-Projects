/*
 * Written by Christian Rios
 */
public class Database {
	//This is the basic class for the database. This file is used to create methods of type Database to make it easier to store the lines from the database of video games.
	private String game;
	private String console;
	public Database()
	{
		this.game = this.console = "none";
	}
	public Database(String aGame, String aConsole)
	{
		this.setGame(aGame);
		this.setConsole(aConsole);
	}
	public String getGame()
	{
		return this.game;
	}
	public String getConsole()
	{
		return this.console;
	}
	public void setGame(String aGame)
	{
		if(aGame != null)
			this.game = aGame;
		else
			this.game = "none";
	}
	public void setConsole(String aConsole)
	{
		if(aConsole != null)
			this.console = aConsole;
		else
			this.console = "none";
	}
	public String toString()
	{
		return this.game+"\t"+this.console;
	}

}
