/*
 * Written by Christian Rios
 */
public interface QueueI <T> 
{
//The basic QueueI interface, with the size function added to find the size of the command list.
	public void enqueue(T aData);
	public T dequeue();
	public T peek();
	public void print();
	public int size();
}