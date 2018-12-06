/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hanoi;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author 349361337
 */
public class Hanoi {
    static ArrayList output = new ArrayList<String>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number of disks");
        int disk = 3;
        Stack start = new Stack<Integer>();
        Stack helper = new Stack<Integer>();
        Stack end = new Stack<Integer>();
        for (int i = 0; i < disk; i++) {
            end.add(disk-i);
        }
        hanoi(disk,start,helper,end);
    }

    public static void hanoi(int disk, Stack<Integer> start, Stack<Integer> helper, Stack<Integer> end) {
        if(helper.isEmpty() || helper.peek()>end.peek()){
            output.add(end.peek() + " --> "+helper.peek());
            helper.add(end.peek());
            end.pop();
        }
        else if(help)
        hanoi(--disk, start, helper, end);
    }
}
