/**
 * Name: Daniel Verhagen
 * ID: 344
 * Assignment: 1
 * Description: This contains the class SimpleList. It allows you to 
 * 				create a list of integers, add and remove integers,
 * 				return how long the list is, search for an integers, and
 * 				and return a string of the list of integers.
 */

package cse360assign2;

public class SimpleList
{
	
	private int list[];
	private int count;
	
	/**
	 * 10 is initially the maximum number of integers in the list.
	 */
	private int full = 10;

	/**
	 * Constructor for the class SimpleList.
	 * Instantiates the list of integers with a size of 10.
	 * Sets the count of integers in the list to 0.
	 */
	public SimpleList()
	{
		list = new int[10];
		count = 0;
	}
	
	/**
	 * Adds an integer to the list at index 0.
	 * If there are other integers in the list, their indexes 
	 * are all increased by 1. If the list is full,
	 * the last item in the list (index 9) is dropped off the list.
	 * 
	 * @param	newListNum	This is the integer being added to the list.
	 */
	public void add(int newListNum)
	{	
		/**
		 * If the list is full, decrease the size by 1.
		 * The purpose of this is to get rid of the integer on the end of the list.
		 */
		if (count == full)
		{
			/**
			 * If the list was initially full:
			 * 1) Create a temporary list.
			 * 2) Increase the max list size by 50%.
			 * 3) Copy the list to the temporary list.
			 * 4) Increase the size of the list array in accordance with max size.
			 * 5) Copy the temporary list back to the list.
			 */
			int[] tempList = new int[full];
			full = (int)(full*1.5);
			for (int i = 0; i < count; i++)
			{
				tempList[i] = list[i];
			}
			list = new int[full];
			for (int i = 0; i < count; i++)
			{
				list[i] = tempList[i];
			}
		}
		
		for (int index = count; index > 0; index--)
		{
			list[index] = list[index - 1];
		}
		
		list[0] = newListNum;		
		count++;
	}
	
	/**
	 * Removes an integer from the list.
	 * If there are other integers in the list, their indexes are decreased by 1
	 * if they were after the removed integer.
	 * If the integer appears in the list multiple times, 
	 * only the first instance is removed.
	 * 
	 * @param	removeFromListNum	This is the integer being removed form the list.
	 */
	public void remove(int removeFromListNum)
	{
		/**
		 * Only remove the first instance of the integer.
		 */
		boolean removed = false;
		
		/**
		 * Only remove if the integer is found in the list.
		 */
		if (search(removeFromListNum) != -1)
		{
			for (int indexRemove = 0; indexRemove < count; indexRemove++)
			{
				if (list[indexRemove] == removeFromListNum && !removed)
				{			
					count--;
					for (int indexAdjust = indexRemove; indexAdjust < count; indexAdjust++)
					{
						list[indexAdjust] = list[indexAdjust + 1];
					}
					removed = true;
				}
			}
		}
		
		/**
		 * If the list has more than 25% empty places, decrease the list size by 25%.
		 * This follows the same procedure as in add with a few differences:
		 * 1) Decreases by 25% instead of increasing by 50%.
		 * 2) Minimum list size is set to 1.
		 */
		if (full*0.75 >= count)
		{
			int[] tempList = new int[full];
			full = (int)(full*0.75);
			if (full < 1)
			{
				full = 1;
			}
			for (int i = 0; i < count; i++)
			{
				tempList[i] = list[i];
			}
			list = new int[full];
			for (int i = 0; i < count; i++)
			{
				list[i] = tempList[i];
			}
		}
	}
	
	/**
	 * Return the number of integers in the list.
	 * 
	 * @return	count	This is the number of integers in the list.
	 */
	public int count()
	{
		return count;
	}
	
	/**
	 * Create a string showing every integer in the list.
	 * After every integer there is a space to show separation.
	 * 
	 * @return	listString	This is the string of integers in the list.
	 */
	public String toString()
	{
		String listString = "";
		
		for (int index = 0; index < count; index++)
		{
			if (index > 0)
			{
				listString = listString + " ";
			}
			
			listString = listString + list[index];
		}
		
		return listString;
	}
	
	/**
	 * Search the list for an integer and return its earlier index in the list.
	 * If the integer is not found in the list, return -1.
	 * 
	 * @param	searchNum		This is the integer being searched for.
	 * @return	searchIndex		This is the earliest index of searchNum.
	 */
	public int search(int searchNum)
	{
		int searchIndex = -1;
		
		for (int index = count - 1; index >= 0; index--)
		{
			if (list[index] == searchNum)
			{
				searchIndex = index;
			}
		}
		
		return searchIndex;
	}
	
//	public static void main(String args[])
//	{
//		SimpleList list = new SimpleList();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.remove(2);
//		System.out.println(list.toString());
//		System.out.println(list.full);
//		
//		list = new SimpleList();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		list.add(6);
//		list.add(7);
//		list.add(8);
//		list.add(9);
//		list.add(10);
//		list.add(11);
//		list.add(12);
//		list.remove(2);
//		System.out.println(list.toString());
//		System.out.println(list.full);
//		
//		list = new SimpleList();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.remove(2);
//		System.out.println(list.toString());
//		System.out.println(list.full);
//	}
}
