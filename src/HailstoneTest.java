import java.util.ArrayList;
/**
 * This is a class for testing the other classes in this project and doing the desired "multiples of 13" and "prime numbers" tests. 
 * @author Seth Martin
 * @version 9/18/2014
 */

public class HailstoneTest {

	public static void main() {
		hailstoneSequenceTest();
		hailstoneSystemTest();
		multiplesOfXTest();
		primeNumberTest();
		
	}
	
	/**
	 * This method tests the HailstoneSequence class by creating a hailstone sequence starting at 23.
	 */
	public static void hailstoneSequenceTest() {
		System.out.println("This is the test for HailstoneSequence.");
		HailstoneSequence a = new HailstoneSequence(23); //23 is a randomly chosen positive integer.
		a.createSequence();
		a.printSequence();
		System.out.print(a.getSequenceMaxValue());
		System.out.print(" is the maximum value of a hailstone sequence starting at 23: ");
		System.out.println(a.getSequenceMaxValue() == 160); //160 is the maximum value of a hailstone sequence starting at 23.
		System.out.print(a.getSequenceLength());
		System.out.print(" is the length of a hailstone sequence starting at 23: ");
		System.out.println(a.getSequenceLength() == 16); //16 is the length of a hailstone sequence starting at 23.
	}
	
	/**
	 * This method tests the HailstoneSystem class
	 */
	public static void hailstoneSystemTest() {
		System.out.println("This is the test for HailstoneSystem.");
		ArrayList<Integer> tempArray = new ArrayList<Integer>();	
		HailstoneSystem a = new HailstoneSystem();
		a.findLongestSequence();
		System.out.print(a.getStartingValue());
		System.out.print(" is the longest hailstone sequence in a group of hailstone sequences starting at 1, 2, 3, 16, and 23: ");
		System.out.println(a.getStartingValue() == 23); //The hailstone sequence starting at 23 is the longest hailstone sequence of this group.
		System.out.print(a.getLongestLength());
		System.out.print("is the length of the longest hailstone sequence of this group: ");
		System.out.println(a.getLongestLength() == 16); //16 is the length of the hailstone sequence starting at 23
	}
	
	/**
	 * This is a method to test the MultiplesOfX class using the starting value of 13.
	 * I will write the rest of this test when the class is finished
	 */
	public static void multiplesOfXTest() {
		System.out.println("This is the test for MultiplesOfX.");
		MultiplesOfX temp = new MultiplesOfX(13);
		HailstoneSystem a = new HailstoneSystem();
		ArrayList<HailstoneSequence> tempArray = new ArrayList<HailstoneSequence>();
		tempArray = a.getAllSequences();
		int arrayLength = tempArray.size();
		for (int i = 0; i < arrayLength; i++) {
			System.out.print(tempArray.get(i).getStartingValue());
			System.out.print(" is the starting value of a hailstone sequence with a maximum value of ");
			System.out.println(tempArray.get(i).getSequenceMaxValue());
		}
	}
	
	/**
	 * This is a method to test the Prime Number class. It will also use HailstoneSystem to find the hailstone sequence with the longest length
	 */
	public static void primeNumberTest() {
		System.out.println("This is the test for PrimeNumber.");
		PrimeNumber temp = new PrimeNumber();
		temp.calcPrimes();
		HailstoneSystem a = new HailstoneSystem();
		a.findLongestSequence();
		System.out.print(a.getStartingValue());
		System.out.print(" is the starting value of the longest hailstone sequence starting with a prime number, which has a length of ");
		System.out.println(a.getLongestLength());
	}
	
	
}
