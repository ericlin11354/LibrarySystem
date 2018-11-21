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
public class SelectionSort {

    private int arr[];

    public SelectionSort(int arr[]) {
        this.arr = arr;
    }

    public void sort() {
        int index = 0;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            int a;
            int b = (1 << 31) - 1;
            for (int j = i; j < arr.length; j++) {
                a = arr[j];
                if (a < b) {
                    b = a;
                    index = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
    
    @Override
    public String toString(){
        return Arrays.toString(arr);
    }

}
