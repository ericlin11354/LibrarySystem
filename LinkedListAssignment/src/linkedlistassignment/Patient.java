/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistassignment;

/**
 *
 * @author Eric Lin
 */
public class Patient implements Comparable<Patient>{
    private String fname;
    private String lname;
    
    public Patient(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }
    
    @Override
    public int compareTo(Patient other){
        return (this.getFname()+this.getLname()).compareTo(other.getFname()+other.getLname());
    }
    
    @Override
    public String toString(){
        return getFname() + " "+getLname();
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }
}
