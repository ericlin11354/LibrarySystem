/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.Arrays;

/**
 *
 * @author 349361337
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int arr[] = {64, 25, 12, 22, 11};
        SelectionSort ss = new SelectionSort(arr);
        System.out.println(Arrays.toString(ss.sort()));
    }
    
}
