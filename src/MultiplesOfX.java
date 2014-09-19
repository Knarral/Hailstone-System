import java.util.ArrayList;


/**
 * This class creates an ArrayList that contains the multiples of a specified number up to a constant limit.
 * @author Samuel Livingston
 * @Version 9/18/2014
 */
public class MultiplesOfX {
    private final int UPPERLIMIT = 10000;
    private ArrayList<Integer> arrayListOfMultiples = new ArrayList<Integer>();
    private int originalMultiple;
    
    /**
     * Constructor
     * 
     * @param mult The number that will get multiplied
     */
    public MultiplesOfX(int mult)
    {
        originalMultiple = mult;
    }
    
    /**
     * This method returns an array of multiples.
     * We consider 0 to be a universal multiple.
     */
    public void calcMultiples()
    {
        int currentNumber = 0;
        while(currentNumber < UPPERLIMIT)
        {
            arrayListOfMultiples.add(currentNumber);
            currentNumber = currentNumber + originalMultiple;
        }
    }
    
    /**
     * Prints as many multiples (starting from 0 which is the first multiple of any number) as it's told to.
     * Example: prints = 15  The method will print 15 multiples.
     * @param prints  The number of multiples that will get printed.
     */
    public void printUpTo(int prints)
    {
        for(int i=0; (i<arrayListOfMultiples.size() && i < prints) ; i++)
        {
            int multiplePrint = arrayListOfMultiples.get(i);
            System.out.print(multiplePrint + ", ");
        }
        System.out.println("End of multiples");
    }
    
    /**
     * Prints every multiple in the arrayList of multiples (starting from 0 the first multiple of any number). 
     */
    public void printAll()
    {
        for(int i=0; (i<arrayListOfMultiples.size()) ; i++)
        {
            int multiplePrint = arrayListOfMultiples.get(i);
            System.out.println(multiplePrint);
        }
    }
    
    public ArrayList<Integer> getAllMultiples()
    {
        return arrayListOfMultiples;
    }
    
    public int getOneMultiple(int i)
    {
        return arrayListOfMultiples.get(i);
    }
    
    public int getOriginalMultiple()
    {
        return originalMultiple;
    }
}