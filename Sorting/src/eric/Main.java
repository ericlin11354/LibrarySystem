/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eric;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Main Class converts unsorted data into StockInfo array, sorts the array and outputs the result into a seperate data file
 * @author Eric
 */
public class Main {

    /*
        data: https://www150.statcan.gc.ca/t1/tbl1/en/tv.action?pid=1310037101
        Data has been manipulated so to exclude unncessary information
    
        ANSWER TO PART E):
        If I had to sort an array using two pieces of information, I would compare elements by one piece of information and then
        the second piece depending on if they share the first piece of information. 
        In order for me to implement this, all I need to do is change my compareTo method within StockInfo class. 
        For example, if I were sorting an array by life expectancy and province I would first compare the life expectancies
        just like in this program. If the life expectancies equal, I then compare by province names (given that I plan to
        sort province names in alphabetical order). 
    
    */
    
    /**
     * method converts unsortedData.csv to StockInfo array
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        //gets the unsorted file
        File unSortedData = new File("src/eric/unsortedData.csv");
        //reads the file
        Scanner sc = new Scanner(unSortedData);
        //arraylist used first to calculate the size of the file
        ArrayList<StockInfo> list = new ArrayList<>();
        
        //loops through file
        while (sc.hasNext()) {
            //converts each row of data into an array to be used for every instance of StockInfo
            list.add(new StockInfo(sc.nextLine().split(",")));
        }
        
        //converts the arraylist into an array
        StockInfo arr[] = new StockInfo[list.size()];
        list.toArray(arr);
        
         //sorts the array by life expectancy (lowest to greatest) using selection sort algorithm
        arr = selectionSort(arr);
        
        //outputs sorted array to "sortedData.csv"
        File sortedData = new File("src/eric/sortedData.csv");
        //overwrites each time
        PrintWriter pw = new PrintWriter(sortedData);
        for (StockInfo getArr : arr) {
            pw.println(getArr);
        }
        
        pw.close();
        
    }

    /**
     * Sorts StockInfo array by life expectancy(lowest to greatest)
     * @param arr gets StockInfo array
     * @return returns sorted StockInfo array
     */
    public static StockInfo[] selectionSort(StockInfo arr[]) {
        //index stores index of smallest life expectancy in order to swap elements
        int index = 0;
        //index stores first element to be swapped with element with smallest life expectancy
        StockInfo temp;
        //gets maximum possible life expectancy. This allows the first element to switch with itslelf if it has the smallest life expectancy
        String[] max = {null, null, null, null, String.valueOf((1 << 31) - 1)};
        
        //loops through array
        for (int i = 0; i < arr.length; i++) {
            //compares StockInfo a and b
            StockInfo a;
            StockInfo b = new StockInfo(max);
            
            //loops from i through rest of array
            for (int j = i; j < arr.length; j++) {
                //gets an instance of StockInfo in the array
                a = arr[j];
                //compares the life expectancy of instance a with instance b
                //if a is less, than a becomes b and the program gets the index of a
                if (a.compareTo(b) < 0) {
                    b = a;
                    index = j;
                }
                
            }//end of nested for loop
            
            //swaps first instance of StockInfo checked with the smallest instance in the loop
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            
        }//end of for loop
        
        //returns the sorted array
        return arr;
    }
}
