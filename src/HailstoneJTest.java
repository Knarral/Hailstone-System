import java.util.ArrayList;
import org.junit.Test;

/**
 * This is a class for testing the other classes in this project and doing the desired "multiples of 13" and "prime numbers" tests. 
 * This class is called HailstoneJTest because HailstoneTest was originally written and then scrapped upon the rewrite
 * of the rest of the classes. It was not a JUnit test. HailstoneJTest is a JUnit test case.
 * @author Seth Martin
 * @version 9/18/2014
 */
public class HailstoneJTest {

	@Test
	public void test() {
		hailstoneSequenceTest();
		hailstoneSystemTest();
		multiplesOfXTest();
		primeNumberTest();
	}


	/**
	 * This method tests the HailstoneSequence class by creating a hailstone sequence starting at 23. It then tests the methods which find the 
	 * maximum value and length of the sequence.
	 */
	public static void hailstoneSequenceTest() {
		System.out.println("This is the test for HailstoneSequence. \n");
		HailstoneSequence sequence = new HailstoneSequence(23); //23 is a randomly chosen positive integer.
		sequence.createSequence(); 
		sequence.printSequence();
		System.out.println(sequence.getSequenceMaxValue() + " is the maximum value of a hailstone sequence starting at 23: " + (sequence.getSequenceMaxValue() == 160)); //160 is the maximum value of a hailstone sequence starting at 23.
		System.out.println(sequence.getSequenceLength() + " is the length of a hailstone sequence starting at 23: " + (sequence.getSequenceLength() == 16) + "\n \n");//16 is the length of a hailstone sequence starting at 23.
	}
	
	
	/**
	 * This method tests the HailstoneSystem class. It passes an ArrayList into HailstoneSystem and then creates sequences for all of the starting values,
	 * then it runs the method for comparing lengths. 
	 */
	public static void hailstoneSystemTest() {
		System.out.println("This is the test for HailstoneSystem. \n");
		ArrayList<Integer> startingValueArray = new ArrayList<Integer>();	
		startingValueArray.add(1);
		startingValueArray.add(2);
		startingValueArray.add(3);
		startingValueArray.add(16);
		startingValueArray.add(13);
		startingValueArray.add(5);
		startingValueArray.add(7);
		startingValueArray.add(11);
		startingValueArray.add(531);
		startingValueArray.add(-2);
		/*
		 * The numbers in this array list aside from -2, 1, 2, 3, and 16 are random.
		 * 1 was chosen because it has the smallest sequence aside from 0
		 * 2 was chosen because it is the smallest even number
		 * 3 was chosen because it is the smallest odd prime number aside from 1
		 * 16 was chosen because it is a power of 2
		 * -2 was chosen because it is a negative of a previously tested value
		 */
		HailstoneSystem system = new HailstoneSystem();
		system.createAllSequences(startingValueArray);
		ArrayList<HailstoneSequence> sequencesArray = new ArrayList<HailstoneSequence>();
		sequencesArray = system.getAllSequences(); //everything following this is printing to the console the results
		for (int i = 0; i < startingValueArray.size(); i++) {
			sequencesArray.get(i).printSequence();
			System.out.println("The length of the sequence is: " + sequencesArray.get(i).getSequenceLength() + "\n");
		}
		system.findLongestSequence();
		System.out.println("The longest sequence is " + system.getLongestLength() + " long, and starts at " + system.getStartingValue() + "\n \n");
	}
	
	
	/**
	 * This is a method to test the MultiplesOfX class using the starting value of 13.
	 * It takes an array of values from MultiplesOfX and creates a HailstoneSystem using that array, and then proceeds to 
	 */
	public static void multiplesOfXTest() {
		System.out.println("This is the test for MultiplesOfX. \n");
		MultiplesOfX num = new MultiplesOfX(13);
		num.calcMultiples();
		HailstoneSystem system = new HailstoneSystem();
		system.createAllSequences(num.getAllMultiples());
		System.out.print("The first 20 multiples of " + num.getOriginalMultiple() + " are: "); //20 was chosen because it seems like a reasonable sample size, and testing anything much larger seems redundant
		num.printUpTo(20);
		ArrayList<HailstoneSequence> sequencesArray = new ArrayList<HailstoneSequence>();
		sequencesArray = system.getAllSequences(); //everything following this is printing to the console the results
		for (int i = 0; i < 20; i++) {
			System.out.println("The maximum value for the hailstone sequence which starts at " + sequencesArray.get(i).getStartingValue() + " is: " + sequencesArray.get(i).getSequenceMaxValue());
		}
		System.out.println("\n");
	}
	
	
	/**
	 * This is a method to test the Prime Number class. It will also use HailstoneSystem to find the hailstone sequence with the longest length.
	 * It runs the method which compares the lengths of the sequences which have starting values which are prime numbers. 
	 */
	public static void primeNumberTest() {
		System.out.println("This is the test for PrimeNumber. \n");
		PrimeNumber prime = new PrimeNumber(); 
		prime.calcPrimes();
		System.out.print("The first 20 prime numbers are: "); //20 seems like a reasonable sample size
		prime.printUpTo(20);
		HailstoneSystem system = new HailstoneSystem();
		system.createAllSequences(prime.getAllPrimes());
		ArrayList<HailstoneSequence> sequencesArray = new ArrayList<HailstoneSequence>();
		sequencesArray = system.getAllSequences(); //everything following this is printing to the console the results
		for (int i = 0; i < 20; i++) {
			System.out.println("The hailstone sequence starting at " + sequencesArray.get(i).getStartingValue() + " is " + sequencesArray.get(i).getSequenceLength() + " values long");
		}
		system.findLongestSequence();
		System.out.print(system.getStartingValue() + " is the starting value of the longest hailstone sequence starting with a prime number, which has a length of " + system.getLongestLength());
	}
}
