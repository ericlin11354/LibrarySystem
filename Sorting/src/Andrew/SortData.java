/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Andrew;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Data obtained from:
 * https://www.ontario.ca/data/2006-commercial-vehicle-survey-traffic-volumes-survey-stations
 * Made minor adjustments to reduce the number of columns
 *
 * @author Andrew
 */
public class SortData {

    /*
    Answer to part E of the assignment:
    If I were to sort a set of data by two pieces of information, I would first compare the elements by one piece of information
    and sort it that way. And then if the elements have the same value of that property, I would compare the elements by the other 
    property to find the order based on both properties. So, in this sorting method, one property will be primary and one property will be
    secondary. For example, if I wanted to sort my array based on car total and truck total, i can choose car total as the primary property, so 
    I know the elements will be sorted 100% on the car total, but the truck total is only used to help to sort when two elements have the same car total.
    To implement this change, I would change my compareTo method in the StockInfo class. Instead of returning 0 when the two car totals are equal, I will have
    it to compare the other property of the two elements.
 
     */
    public static void main(String[] args) throws IOException {
        //Initializes the unsorted data file as a comma delimited excel file 
        File unsortedRawData = new File("src/Andrew/stockDataUnsorted.csv");
        //Initializes a scanner to read from the file
        Scanner sn = new Scanner(unsortedRawData);

        //counts the number of rows in the file
        int numOfRows = 0;
        //while the file has one more line
        while (sn.hasNext()) {
            sn.nextLine();
            //Adds one to the counter for number of rows
            numOfRows++;
        }
        //Close the scanner
        sn.close();
        //Initializes a new scanner to read from the beginning since the first scanner
        //was used to count the number of rows in the data to set an array size
        sn = new Scanner(unsortedRawData);
        //Initializes an array of StockInfo objects
        StockInfo[] list = new StockInfo[numOfRows];
        //Loops from the first row to the last row
        for (int i = 0; i < numOfRows; i++) {
            list[i] = new StockInfo(sn.nextLine().split(","));
        }
        //Closes scanner
        sn.close();

        //Uses bubble sort to sort the data
        bubbleSort(list);

        //Initialize the output file and the print writer
        File output = new File("src/Andrew/stockDataSorted.csv");
        PrintWriter pw = new PrintWriter(output);
        //Prints the sorted lines to the output csv file 
        for (StockInfo list1 : list) {
            pw.println(list1);
        }
        //Closes printwriter
        pw.close();
    }

    /**
     * Sorts the data from lowest car total to highest truck total
     *
     * @param list
     */
    public static void bubbleSort(Comparable[] list) {
        boolean swap = true;
        //Placeholder for swapping the two items
        Comparable temp;
        //Loops through the array until all the elements are sorted
        while (swap) {
            //Sets swap to false to see if the array is sorted and does not need a swap
            swap = false;
            //Loops from the first item to the second last item
            //Doesn't go to the last index because it will go out of bounds since at the second last index, i + 1 will cover the last index
            for (int i = 0; i < list.length - 1; i++) {
                //If the first number is greater than the second number
                //Swap the position of the items
                if (list[i].compareTo(list[i + 1]) > 0) {
                    temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    //Sets to true when a swap occurs
                    swap = true;
                }

            }
        }
    }

}
