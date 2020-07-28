import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Name:        Pablo Portillo
 * Date:        10/17/2019
 * Professor:   Fahringer
 * 
 * Program Purpose: To parse text file scores, count scores, 
 *                  assign letter grades and calculate the class average.
 */

public class pepTestGrades
{
    public static void main(String[] args) throws IOException
    {
        //File to be parsed
        String filename = "test1.txt";

        //We start by using a method to count the items in the file
        int count = countData(filename);

        //Now we initialize an array with the same number of elements
        int testScores[] = new int[count];

        //We shall now use a method to load the data into the array.
        testScores = dataParse(filename, count);

        //We can now count letter grades and calculate the class average
        int gradeACount = grade(testScores, 90, 100);
        int gradeBCount = grade(testScores, 80, 89);
        int gradeCCount = grade(testScores, 70, 79);
        int gradeDCount = grade(testScores, 60, 69);
        int gradeFCount = grade(testScores, 0, 59);
        double classAvg = avg(testScores);

        //Showing the counts and average
        JOptionPane.showMessageDialog(null, String.format(
                                    "Students:              " + count + "\n" +
                                     "A Grade Count:    " + gradeACount + "\n" +
                                     "B Grade Count:    " + gradeBCount + "\n" +
                                     "C Grade Count:    " + gradeCCount + "\n" +
                                     "D Grade Count:    " + gradeDCount + "\n" +
                                     "F Grade Count:    " + gradeFCount + "\n" +
                                     "Class Average:    %.2f" + "\n", classAvg) );

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
     * Data parse takes a file and a size of array to return the file data as an
     * array.
     * @param filename The name of the file to read
     * @param size The size of the array to create and return
     * @return Array of the file contents
     */
    public static int[] dataParse(String filename, int size) throws IOException
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
     * The count method takes an array and counts the total number of
     * instances of the set element.
     * @param array The array to be checked
     * @return Total number of instances of particular element.
     */
    public static int grade(int[] array, int lowerBound, int upperBound)
    {
        int scoreCount = 0;
        for (int index = 0; index < array.length; index++)
        {
            if (array[index] > lowerBound && array[index] < upperBound)
            {
                scoreCount++;
            }
        }
        return scoreCount;
    }

    /**
     * The avg method takes an array and calculates the average of all elements
     * @param array The array to be checked
     * @return The average of all elements of the passed array.
     */
    public static double avg(int[] array)
    {
        double runningSum = 0;
        double average;
        for (int index = 0; index < array.length; index++)
        {
            runningSum += array[index];
        }
        
        average = (runningSum / (double)array.length);

        return average;
    }
}