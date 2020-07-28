import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Name:        Pablo Portillo
 * Date:        11/27/2019
 * Professor:   Fahringer
 * 
 * Program Purpose: To pass scores text file to array and 
 *                  count number of perfect scores.
 */

public class pepStandardizedTests
{
    public static void main(String[] args) throws IOException
    {
        //For keeping the total number of perfect scores.
        int perfectScore;
        String filename;

        filename = JOptionPane.showInputDialog("Input filename");

        //We start by using a method to count the items in the file
        int count = countData(filename);

        //Now we initialize an array with the same number of elements
        int testScores[] = new int[count];

        //We shall now use a method to load the data into the array.
        testScores = dataParse(filename, count);

        //We can now count all the elements that are 50.
        perfectScore = countPerfects(testScores);

        //Showing the count of perfect scores.
        JOptionPane.showMessageDialog(null,"The number of perfect scores in " + 
                                            "this file is:\n" + perfectScore);

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


}