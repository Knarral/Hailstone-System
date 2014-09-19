import java.util.ArrayList;
/**
* This class creates an ArrayList that contains a Hailstone sequence starting with any number specified.
* @author Samuel Livingston
* @author Shannon Marshall - Added variable startingValue with appropriate accessor method & Added printSequence method.
* @version 9/18/2014
*/
public class HailstoneSequence {
	private ArrayList<Integer> arrayListOfHailstoneNumbers = new ArrayList<Integer>();
	private int sequenceLength;
	private int sequenceMaxValue = 0;
	private int sequenceStartingValue;

	/**
	 * Takes the integer value provided and sets it to the starting value for the hailstone sequence.
	 * @param int s
	 */
	public HailstoneSequence(int s)
	{
		sequenceStartingValue = s;
	}
	
	/**
	 * Constructor
	 * Creates a hailstone sequence based off of the starting value. We decided to treat 0 as an
	 * odd number so that it could reach 1 and exit the loop. We decided to treat negative numbers
	 * as positive numbers because when we tested negative numbers, each sequence fell to different
	 * numbers and it was inconsistent.
	 */
	public void createSequence()
	{
		int currentNum = sequenceStartingValue;
		currentNum = Math.abs(currentNum);
		while(currentNum != 1)
		{
			arrayListOfHailstoneNumbers.add(currentNum);
			if(currentNum == 0)
			{
				currentNum = (currentNum * 3) + 1; //We treat 0 as odd
			}
			if(currentNum%2 == 0) //Is even
			{
				currentNum = currentNum / 2;
			}
			else //Is Odd
			{
				currentNum = (currentNum * 3) + 1;
			}
			if(currentNum > sequenceMaxValue)
			{
				sequenceMaxValue = currentNum;
			}
		}
		arrayListOfHailstoneNumbers.add(1); //We want to include 1 to show when the sequence ends.
		sequenceLength = arrayListOfHailstoneNumbers.size();
	}
	
	/**
	 * Prints the hailstone sequence stored.
	 */
	public void printSequence()
	{
		System.out.println("Hailstone Sequence for: " + sequenceStartingValue);
		for(int i = 0; i < arrayListOfHailstoneNumbers.size(); i++)
		{
			System.out.print(arrayListOfHailstoneNumbers.get(i) + ", ");
		}
		System.out.println("End of Sequence" + "\n");
	}
	
	public ArrayList<Integer> getHailstoneSequence()
	{
		return arrayListOfHailstoneNumbers;
	}
	
	public int getSequenceLength()
	{
		return sequenceLength;
	}
	
	public int getSequenceMaxValue()
	{
		return sequenceMaxValue;
	}
	
	public int getStartingValue()
	{
		return sequenceStartingValue;
	}
}
