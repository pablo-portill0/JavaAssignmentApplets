import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Name:        Pablo Portillo
 * Date:        12/08/2019
 * Professor:   Fahringer
 * 
 * Program Purpose: To pass scores text file to array and count number of
 * perfect scores; compile average score, max score, min score, mode scores;
 * and create frequency distribution table for all scores.
 */

public class pepStandardizedTestsExtended
{
    public static void main(String[] args) throws IOException
    {
        //For keeping the total number of perfect scores.
        int perfectScore;
        String filename;

        filename = JOptionPane.showInputDialog("Input filepath");

        //We start by using a method to count the items in the file
        int count = countData(filename);

        //Now we initialize an array with the same number of elements
        int testScores[] = new int[count];

        //We shall now use a method to load the data into the array.
        testScores = arrayFill(filename, count);

        //We can now count all the elements that are 50.
        perfectScore = countPerfects(testScores);

        //Showing the count of perfect scores.
        JOptionPane.showMessageDialog(null,"The number of perfect scores in " + 
                                            "this file is:\n" + perfectScore);

        //We now use the dataParse method to calculate & display our statistics
        dataParse(testScores);

    }

    /**
     * The countData method accepts a filename to open and count the individual
     * elements of data within.
     * @param filename The name of the file to read.
     * @return Int count of total elements within file.
     */
    public static int countData(String filename) throws IOException
    {
        //Opening the file.
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        //Initializing total variable.
        int totalElements = 0;
        
        totalElements = inputFile.nextLine().split(" ").length;

        // Closing file
        inputFile.close();
        
        return totalElements;

    }

    /**
     * The arrayFill method takes a file and a size of array to return the file 
     * data as an array.
     * @param filename The name of the file to read
     * @param size The size of the array to create and return
     * @return Array of the file contents
     */
    public static int[] arrayFill(String filename, int size) throws IOException
    {
        //opening the same file
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        int[] data = new int[size];
        int index = 0;

        while (inputFile.hasNext() && index < size)
        {
            data[index] = inputFile.nextInt();
            index++;
        }

        inputFile.close();
        return data;
    }

    /**
     * The dataParse method checks data & compiles statistical summaries:
     * Average, Maximum, Minimum, Mode, and a Frequency Distribution table.
     * @param array
     */
    public static void dataParse(int[] array) 
    {
        double average;
        int maximum;
        int minimum;
        ArrayList<Integer> mode = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> freqTable = new ArrayList<ArrayList<Integer>>(2);


        //We'll use methods to get all of our statistical measures.
        average = getAvr(array);

        maximum = getMax(array);

        minimum = getMin(array);

        freqTable = freqDist(array);

        mode = getMde(freqTable);

        //Showing all statistical measures.
        JOptionPane.showMessageDialog(null, String.format("Data Summary" +
                                            "\nAverage: \t %.2f" +
                                            "\nMaximum: \t" + maximum +
                                            "\nMinimum: \t" + minimum + 
                                            "\nMode(s): \t" + mode, average));
        //Printing frequency table.
        print2DArrayList(freqTable);
    
    }

    /**
     * The countPerfects method takes an array and counts the total number of
     * instances of the set element.
     * @param array The array to be checked
     * @return Total number of instances of particular element.
     */
    public static int countPerfects(int[] array)
    {
        int scoreCount = 0;

        for (int index = 0; index < array.length; index++)
        {
            if (array[index] == 50)
            {
                scoreCount++;
            }
        }

        return scoreCount;
    }

    /**
     * The getAvr method finds the average of all elements in the given array.
     * @param array The array to be averaged.
     * @return A double of the average.
     */
    public static double getAvr(int[] array)
    {
        int arrayTotal = 0;

        for (int i = 0; i < array.length; i++)
        {
            arrayTotal += array[i];
        }

        double average = (double)arrayTotal / (double)array.length;

        return average;
    }

    /**
     * The getMax method finds the maximum of a given array.
     * @param array The array to be searched.
     * @return The max integer
     */
    public static int getMax(int[] array)
    {
        int max = array[0];

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] > max)
                max = array[i];
        }

        return max;
    }

    /**
     * The getMin method finds the minimum of a given array.
     * @param array The array to be searched.
     * @return The min integer
     */
    public static int getMin(int[] array)
    {
        int min = array[0];

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] < min)
                min = array[i];
        }

        return min;
    }

    /**
     * The getMde method finds the mode(s) of a given array
     * @param array The array to be searched
     * @return An ArrayList of the mode(s) in the given array.
     */
    public static ArrayList<Integer> getMde(ArrayList<ArrayList<Integer>> freqArray)
    {
        ArrayList<Integer> modeAL = new ArrayList<Integer>();
        int max = freqArray.get(1).get(0);
        
        for (int i = 0; i < freqArray.get(1).size(); i++)
        {
            if (freqArray.get(1).get(i) > max)
            {
                modeAL.clear();
                modeAL.add(freqArray.get(0).get(i));
                max = freqArray.get(1).get(i);
            }
            else if(freqArray.get(1).get(i) == max)
            {
                modeAL.add(freqArray.get(0).get(i));
            }
        }
    
        return modeAL;
    }

    /**
     * The freqDist method finds the unique elements of an array and
     * counts the total appearances in the array.
     * @param array The array to be seached and counted.
     */
    public static ArrayList<ArrayList<Integer>> freqDist(int[] array)
    {
        //We begin by initializing our holding variables for the original array.
        int count = 0;
        int key = 0;
        //We initialize our ArrayList of ArrayLists and define the objects the
        //nested ArrayLists hold--<Integer>
        ArrayList<ArrayList<Integer>> freqAL = new ArrayList<ArrayList<Integer>>(2);
        ArrayList<Integer> elements = new ArrayList<Integer>();
        ArrayList<Integer> eCount = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++)
        {
            key = array[i];

            //Check if key was already counted; if not, add key to elements
            //ArrayList, count all of that element, and add count to eCount.
            if (!elements.contains(key))
            {
                elements.add(key);

                int j;

                for (j = 0; j < array.length; j++)
                {
                    if (key == array[j])
                    count++;
                }
                eCount.add(count);

                //Reseting count
                count = 0;
            }
        }

        //Adding elements and eCount ArrayLists as rows to freqAL ArrayList
        freqAL.add(elements);
        freqAL.add(eCount);
        return freqAL;
    }

    /**
     * The print2DArrayList method creates a JOptionPane-friendly string and 
     * prints it out
     * @param arrayList The Arraylist<ArrayList<Integer>> to parse
     * @return
     */
    public static void print2DArrayList(ArrayList<ArrayList<Integer>> arrayList)
    {
        String outputString = "Value......................Count\n  ";
        for (int i = 0; i < arrayList.get(0).size(); i++)
        {
            outputString += arrayList.get(0).get(i) + 
            "  ......................  " + arrayList.get(1).get(i) + "  \n  ";
        }

        JOptionPane.showMessageDialog(null, outputString, "Freq. Dist.", 1);
    }
}