package Engine;

import java.io.File; //the import used to access exterior files
import java.io.FileNotFoundException; //this is the import for the file not found exception
import java.io.FileWriter; //the import for the file writer
import java.io.IOException; //the import for the IOException
import java.io.PrintWriter; //the import for the print writer class
import java.util.Scanner; //the import used to access the scanner function

/**
 * This file is for when a user wants to leave a review on a book.
 *
 * @author 073685950 (Alex Weber)
 */
public class Review {
    File f = null; //create a new file linked to bookinfo
    Scanner input = null; //create a new scanner
    PrintWriter pw = null; //create a new print writer
    String barcode; //the variable for the barcode of the book
    int numRatings; //the varible for the number of ratings made on the book
    public static final String delim = ";"; //the variable for the delimeter

    /**
     * This is the constructor for the review class.
     * @param barcode takes in the barcode of the book
     */
    public Review(String barcode) {
        this.barcode = barcode;
        f = new File("reviews/" + barcode + ".txt");
        if(!f.exists()){
            try{
            f.createNewFile();
            }
            catch(IOException e){
                System.out.println("IOException creating new file");
            }
        }
    }

    /**
     * This method tries to open a print writer, if it cannot it will return an error.
     */
    public void initPW() {
        try {
            pw = new PrintWriter(new FileWriter(f, true));
        } catch (IOException e) {
            System.out.println("IOException reading " + f.getName());
            System.exit(0);
        }
    }

    /**
     * This method tries to open a scanner, if it cannot it will return an error.
     */
    public void initScanner() {
        try {
            input = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException reading " + f.getName());
            System.exit(0);
        }
    }

    /**
     * This method is initiated by the user, this will allow them to add a
     * comment or rating to a book.
     *
     * @param comment the comment made by the user
     * @param rating the rating made by the user
     */
    public void addReview(String comment, int rating) {
        //when the user iniciates the review class by clicking a button,
        //the user must enter a comment, and a rating for the book
        //then the comment and rating is stored to a text file based on the barcode
        initPW();
        pw.println(comment + delim + rating);
        pw.close();
        numRatings++;
    }

    /**
     * This method updates the rating of a book by re-calculating the average.
     *
     * @return the rating of the book
     */
    public double calculateBookRating() {
        double num = getAddedRatings();
        double den = getNumberRatings();
        return num / den;
    }

    /**
     * This method gets the comments of the book from the exterior document.
     *
     * @return returns all of the comments
     */
    public String getComments() {
        initScanner(); //opens the scanner
        //creates temporary varibles
        String[] s = null;
        String temp = "";
        while (input.hasNextLine()) { //runs until there are no more lines in the file
            s = input.nextLine().split(delim); //splits the comments from the ratings
            temp += s[0]; //sets the string to the comments
        }
        input.close();
        return temp;
    }

    /**
     * This method gets the sum of all the ratings.
     *
     * @return returns the value of all the ratings
     */
    public int getAddedRatings() {
        initScanner(); //opens the scanner
        //creates temporary varibles
        String[] s = null;
        int counter = 0;
        if(fileEmpty()){
            return 0;
        }
        while (input.hasNextLine()) { //runs until there are no more lines in the file
            s = input.nextLine().split(delim); //splits the ratings from the comments
            counter += Integer.parseInt(s[1]); //sets the counter to the arrays values
        }
        input.close();
        return counter;
    }

    /**
     * This method gets the number of ratings that have been made on the book.
     *
     * @return returns the number of ratings on the book
     */
    public int getNumberRatings() {
        initScanner(); //opens the scanner
        //creates temporary varibles
        String[] s = null;
        int count = 0;
        if(fileEmpty()){
            return 0;
        }
        while (input.hasNextLine()) { //runs until there are no more lines in the file
            s = input.nextLine().split(delim); //splits the ratings from the comments
            count++;
        }
        input.close();
        return count;
    }
    
    public boolean fileEmpty(){
        try{
            input.hasNextLine();
        }
        catch(NullPointerException e){
            return true;
        }
        return false;
    }
}
