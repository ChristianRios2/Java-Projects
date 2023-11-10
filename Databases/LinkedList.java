/*
 * Written by Christian Rios
 */
public class LinkedList <T>
// The general linked list from the lecture. Extra methods are added for functionality.
{
	private class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	public LinkedList()
	{
		head = current = previous = null;
	}
	public void add(T aData)
	{
		ListNode newNode = new ListNode(aData,null);
		if(head == null)
		{
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.link != null)
			temp = temp.link;
		temp.link = newNode;
	}
	public void print()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public void addAfterCurrent(T aData)
	{
		if(current == null)
			return;
		ListNode newNode = new ListNode(aData,current.link);
		current.link = newNode;
	}
	public T getCurrent()
	{
		if(current == null)
			return null;
		return current.data;
	}
	// The method below prints the current line. I was having trouble doing just that so I made a method to fix it.
	public void printCurrent()
	{
		if(current == null)
			return;
		System.out.println(current.data);
	}
	public void setCurrent(T aData)
	{
		if(aData == null || current == null)
			return;
		current.data = aData;
	}
	public void gotoNext()
	{
		if(current == null)
			return;
		previous = current;
		current = current.link;
	}
	public void reset()
	{
		current = head;
		previous = null;
	}
	public boolean hasMore()
	{
		return current != null;
	}
	public void removeCurrent()
	{
		if(current == head)
		{
			head = head.link;
			current = head;
		}
		else
		{
			previous.link = current.link;
			current = current.link;
		}
	}
	// This method changes a line from the file into a string, as before they are of type Database. This makes it easy to parse the data in each line.
	public String toastring()
	{
		
		String oof = current.data.toString();
		return oof;
	}
}