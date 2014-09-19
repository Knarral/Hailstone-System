import java.util.ArrayList;
/**
* This class creates an ArrayList that contains all prime numbers up to a constant limit.
* A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
* @author Samuel Livingston
* @author Shannon Marshall
* @version 9/18/2014
*/
public class PrimeNumber {
    private ArrayList<Integer> arrayListOfPrimeNumbers = new ArrayList<Integer>();
    private final int UPPERLIMIT = 10000;
    
    /**
     * Calculates all of the prime numbers from 2 to the UPPERLIMIT.
     */
    public void calcPrimes()
    {
        arrayListOfPrimeNumbers.add(2);
        for (int i = 3; i <= UPPERLIMIT; i++)
        {
            boolean isPrime = true;
            for(Integer j : arrayListOfPrimeNumbers)
            {
                if(i % j == 0)
                {
                    isPrime = false;
                }
            }
            if(isPrime == true)
            {
                arrayListOfPrimeNumbers.add(i);
            }
        }
    }
    
    /**
     * Prints as many prime numbers (starting from the first prime number) as it's told to.
     * Example: prints = 20  The method will print 20 prime numbers.
     * @param prints  The number of primes that will get printed.
     */
    public void printUpTo(int prints)
    {
        for(int i=0; (i<arrayListOfPrimeNumbers.size() && i < prints) ; i++)
        {
            int primePrint = arrayListOfPrimeNumbers.get(i);
            System.out.print(primePrint + ", ");
        }
        System.out.println("End of primes");
    }
    
    /**
     * Prints every prime number in the arrayList of prime numbers (starting from the first prime number). 
     */
    public void printAll()
    {
        for(int i=0; (i<arrayListOfPrimeNumbers.size()) ; i++)
        {
            int primePrint = arrayListOfPrimeNumbers.get(i);
            System.out.println(primePrint);
        }
    }
    
    public ArrayList<Integer> getAllPrimes()
    {
        return arrayListOfPrimeNumbers;
    }

    public int getOnePrime(int i)
    {
        return arrayListOfPrimeNumbers.get(i);
    }
}