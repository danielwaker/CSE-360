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
	private int size = 10;

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
	 * are all increased by 1.If the list was initially full, 
	 * increase its size by 50% so there will be room.
	 * 
	 * @param	newListNum	This is the integer being added to the list.
	 */
	public void add(int newListNum)
	{
		/**
		 * If the list was initially full:
		 * 1) Create a temporary list.
		 * 2) Increase the max list size by 50%.
		 * 3) Copy the list to the temporary list.
		 * 4) Increase the size of the list array in accordance with max size.
		 * 5) Copy the temporary list back to the list.
		 */
		if (count == size)
		{
			int[] tempList = new int[size];
			size = (int)(size * 1.5);
			
			for (int i = 0; i < count; i++)
			{
				tempList[i] = list[i];
			}
			
			list = new int[size];
			
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
	 * If the list has more than 25% empty places, decrease the list size by 25%
	 * to a minimum of length 1.
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
		 * This follows the same procedure as in add with a few differences:
		 * 1) Decreases by 25% instead of increasing by 50%.
		 * 2) Minimum list size is set to 1.
		 */
		if (size * 0.75 > count)
		{
			int[] tempList = new int[size];
			size = (int)(size * 0.75);
			if (size < 1)
			{
				size = 1;
			}
			
			for (int i = 0; i < count; i++)
			{
				tempList[i] = list[i];
			}
			
			list = new int[size];
			
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
	
	/**
	 * Append the integer to the end of the list.
	 * If the list is full, increase the size by 50% so there will be room.
	 * Lastly increment the count.
	 * 
	 * @param	append		This is the integer being appended to the list.
	 */
	public void append(int append)
	{
		/**
		 * This is the same list expanding as in add().
		 */
		if (count == size)
		{
			int[] tempList = new int[size];
			size = (int)(size * 1.5);
			
			for (int i = 0; i < count; i++)
			{
				tempList[i] = list[i];
			}
			
			list = new int[size];
			
			for (int i = 0; i < count; i++)
			{
				list[i] = tempList[i];
			}
		}
		
		list[count] = append;		
		count++;
	}
	
	/**
	 * Return the first element of the list.
	 * If the list is empty, return -1.
	 * 
	 * @return	first	This is the first element in the list.
	 */
	public int first()
	{
		int first = -1;
		
		if (count > 0)
		{
			first = list[0];
		}
		
		return first;
	}
	
	/**
	 * Return the last element of the list.
	 * If the list is empty, return -1.
	 * 
	 * @return	last	This is the last element in the list.
	 */
	public int last()
	{
		int last = -1;
		
		if (count > 0)
		{
			last = list[count - 1];
		}
		
		return last;
	}
	
	/**
	 * Return the size of the list array.
	 * 
	 * @return	size	This is the size of the list array.
	 */
	public int size()
	{
		return size;
	}
	
}
