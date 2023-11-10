/*
 * Written by Christian Rios
 */
import java.util.Scanner;
public class SortSort {
	public static final int SIZE = 10;
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		SortCounter[] sorts = new SortCounter[SIZE];
		System.out.println("Enter any number of strings and I will sort by sort's. Once you're done entering sentences enter \"quit\".");
		String input = "";
		int count = 0;
		while(count < SIZE)
		{
			input = keyboard.nextLine();
			if(input.equalsIgnoreCase("quit"))
				break;
			sorts[count] = new SortCounter(input);
			count++;
		}
		mergeSort(sorts);
		System.out.println("sort SORTED!");
		for(SortCounter s : sorts)
		{
			if(s == null)
				break;
			System.out.println(s.getStr());
		}
	}
	public static void mergeSort(SortCounter[] sortArr)
	{
		int size = sortArr.length;
		if(size < 2)
			return;
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		SortCounter[] left = new SortCounter[leftSize];
		SortCounter[] right = new SortCounter[rightSize];
		for(int i=0;i<mid;i++)
			left[i] = sortArr[i];
		for(int i=mid;i<size;i++)
			right[i-mid] = sortArr[i];
		mergeSort(left);
		mergeSort(right);
		merge(left,right,sortArr);
	}
	public static void merge(SortCounter[] left, SortCounter[] right, SortCounter[] a)
	{
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0;//index l
		int j = 0;//index r
		int k = 0;//index a
		while(i < leftSize && j < rightSize)
		{
			if(left[i] == null || right[j] == null)
				break;
			if(left[i].getNumOfSorts() <= right[j].getNumOfSorts())
			{
				a[k] = left[i];
				i++;
				k++;
			}
			else
			{
				a[k] = right[j];
				j++;
				k++;
			}
		}
		while(i<leftSize)
		{
			a[k] = left[i];
			i++;
			k++;
		}
		while(j<rightSize)
		{
			a[k] = right[j];
			j++;
			k++;
		}
	}

}
