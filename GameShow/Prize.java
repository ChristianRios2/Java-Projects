/*
 * Written by Christian Rios
 */
public class Prize {
	
	
//-----------instance variables---------------------------------------------------------
	private String prizeName;
	private int prizePrice;
//-----------default constructors-------------------------------------------------------
	public Prize()
	{
		this.prizeName = "Default Prize Name";
		this.prizePrice = 0;
	}
//-----------parameter constructors-----------------------------------------------------
	  public Prize(String aName,int aPrice)
	  {
		  this.analyzeName(aName); 
		  this.analyzePrice(aPrice);
	  }
	  
	  
 //-----------mutators------------------------------------------------------------------
	  private void analyzeName(String aName)
	  {
		  this.prizeName = aName;		  
	  }
	  
	  private void analyzePrice(int aPrice)
	  {
		  this.prizePrice = aPrice;
	  }
	 
//------------accessors-----------------------------------------------------------------
	
	public String getprizeName()
	{
		return this.prizeName;
	}
	public int getprizePrice()
	{
		return this.prizePrice;
	}

}
