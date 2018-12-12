/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistassignment;

/**
 *
 * @author 349361337
 */
public class Patient implements Comparable<Patient>{
    String fname;
    String lname;
    public Patient(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }
    @Override
    public int compareTo(Patient Other){
        return 0;
    }
}
