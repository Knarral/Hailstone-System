import java.util.ArrayList;
/**
* This class takes in an ArrayList of numbers then sends those to be turned into Hailstone Sequences.
* Once the Hailstone Sequences are created by the HailstoneSequence class, this class can compare the
* lengths of all the Sequences to determine which one is the longest and which ones have the highest numbers.
* @author Shannon
* @author Samuel Livingston - Added removeAllSequences method
* @version 9/18/2014
*/
public class HailstoneSystem {
	private ArrayList<HailstoneSequence> arrayListOfSequences = new ArrayList<HailstoneSequence>();
	private int startingValue = 0;
	private int longestLength = 0;
	private int indexForLongestSequence;
	
	/**
	* This method will fill the arrayListOfSequences with hailstone sequences starting with numbers
	* provided from the parameter array list. For example: This will create every sequence
	* for every prime number less than 10000.
	* @param ArrayList<Integer> in - A list of numbers used to create hailstone sequences.
	*/
	public void createAllSequences (ArrayList<Integer> in)
	{
		for(int i = 0; i < in.size(); i++)
		{
			HailstoneSequence temp = new HailstoneSequence(in.get(i));
			temp.createSequence();
			arrayListOfSequences.add(temp);
		}
	}
	
	/**
	 * Finds the longest sequence by comparing the lengths of every sequence in arrayListOfSequences.
	 * @return HailstoneSequence - Returns the hailstone sequence with the longest length.
	 */
	public void findLongestSequence()
	{
		indexForLongestSequence = 0;
		startingValue = arrayListOfSequences.get(0).getStartingValue();
		longestLength = arrayListOfSequences.get(0).getSequenceLength();
		for(int i = 0; i < arrayListOfSequences.size() - 1 ; i++)
		{
			if(longestLength < arrayListOfSequences.get(i+1).getSequenceLength())
			{
				startingValue = arrayListOfSequences.get(i+1).getStartingValue();
				longestLength = arrayListOfSequences.get(i+1).getSequenceLength();
				indexForLongestSequence = i + 1;
			}
		}
	}
	
	/**
	 * Creates and adds an individual sequence to the arrayListOfSequences.
	 * @param Integer individual - A single integer used as a starting value for a new sequence.
	 */
	public void addSequence(Integer individual)
	{
		HailstoneSequence temp = new HailstoneSequence(individual);
		temp.createSequence();
		arrayListOfSequences.add(temp);
	}
	
	/**
	 * Removes every sequence inside of arrayListOfSequences. Useful for reusing the same
	 * HailstoneSystem object for testing rather than making multiple objects.
	 */
	public void removeAllSequences()
	{
		for (int i = arrayListOfSequences.size()-1; i >= 0; i--)
		{
			arrayListOfSequences.remove(i);
		}
	}	
	
	public ArrayList<HailstoneSequence> getAllSequences()
	{
		return arrayListOfSequences;
	}
	
	public int getStartingValue()
	{
		return startingValue;
	}
	
	public int getLongestLength()
	{
		return longestLength;
	}
	
	public int getIndexForLongestSequence()
	{
		return indexForLongestSequence;
	}
}




