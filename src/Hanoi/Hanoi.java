/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hanoi;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author 349361337
 */
public class Hanoi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number of disks");
        int disk = sc.nextInt();
        System.out.println("");
        hanoi(disk, 1, 2, 3);
    }

    public static void hanoi(int disk, int start, int helper, int end) {
        if (disk == 1) {
            System.out.println(start + " --> " + end);
        } else {
            hanoi(disk - 1, start, end, helper);
            System.out.println(start + " --> " + end);
            hanoi(disk - 1, helper, start, end);
        }
    }

    public static void swap(int a, int b) {
    }
}
