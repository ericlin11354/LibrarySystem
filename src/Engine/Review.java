package Engine;

import java.io.File; //the import used to access exterior files
import java.io.FileNotFoundException; //this is the import for the file not found exception
import java.io.FileWriter; //the import for the file writer
import java.io.IOException; //the import for the IOException
import java.io.PrintWriter; //the import for the print writer class
import java.util.ArrayList; //the import for the ArrayList class
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
    String barcode = null; //the variable for the barcode of the book
    public static final String delim = ",,"; //the variable for the delimeter

    /**
     * This is the constructor for the review class.
     *
     * @param barcode takes in the barcode of the book
     */
    public Review(String barcode) {
        this.barcode = barcode; //gets the barcode of the book
        f = new File("reviews/" + barcode + ".txt"); //creates a file under the name of the barcode
        if (!f.exists()) { //checks if the file already exist
            try { //try to open new file
                f.createNewFile(); //creates a new file
            } catch (IOException e) { //if not then return an error
                System.out.println("IOException creating new file.");
            }
        }
    }

    /**
     * This method tries to open a print writer, if it cannot it will return an
     * error.
     */
    public void initiatePrintWriter() {
        try { //checks to see if a print writer can be opened
            pw = new PrintWriter(new FileWriter(f, true)); //makes a new print writer for the file
        } catch (IOException e) { //if not then print an error
            System.out.println("IOException reading " + f.getName());
            System.exit(0); //shuts the program down
        }
    }

    /**
     * This method tries to open a scanner, if it cannot it will return an
     * error.
     */
    public void initiateScanner() {
        try { //checks to see if a scanner can be opened
            input = new Scanner(f); //makes a new scanner for the file
        } catch (FileNotFoundException e) { //if not then print an error
            System.out.println("FileNotFoundException reading " + f.getName());
            System.exit(0); //shuts the program down
        }
    }

    /**
     * This method is initiated by the user, this will allow them to add a
     * comment or rating to a book.
     *
     * @param comment the comment made by the user
     * @param rating the rating made by the user
     * @param id the identification of the book
     */
    public void addReview(String comment, int rating, String id) {
        initiatePrintWriter(); //open the print writer
        pw.println(comment + delim + rating + delim + id); //adds the review to the file
        pw.close(); //close the print writer
    }

    /**
     * This method deletes all the reviews for a specific book.
     *
     * @param f the file to be deleted
     */
    public void deleteReview(File f) {
        f.delete(); //actually deletes the file
    }

    /**
     * This method is used to get the comments and ratings of a book using an
     * Integer.
     *
     * @param choice 0 would be used for comments, 1 would be used for ratings
     * @return returns either the comments, ratings, or null for an incorrect
     * entry
     */
    public String[] getReview(int choice) {
        initiateScanner(); //opens the scanner
        //creates temporary varibles
        ArrayList<String> list = new ArrayList<>();
        String[] s = null, temp = null;
        if (fileEmpty()) { //checks if the file is empty
            return null; //return null if true
        }
        while (input.hasNextLine()) { //runs until there are no more lines in the file
            s = input.nextLine().split(delim); //splits the comments from the ratings
            list.add(s[choice]); //adds the comment to the list
        }
        input.close(); //closes the scanner
        temp = new String[list.size()]; //makes it the size of the list
        temp = list.toArray(temp); //converts the list into a String array
        return temp; //return the String array of comments
    }

    /**
     * This method gets either the sum of ratings, or the number of ratings made
     * on a book.
     *
     * @param choice 0 is for number of ratings, 1 is for sum of ratings
     * @return returns the sum of ratings, or number of ratings
     */
    public int getRatingValues(int choice) {
        initiateScanner(); //opens the scanner
        //creates temporary varibles
        String[] s = null;
        int count = 0;
        if (fileEmpty()) { //checks if the file is empty
            return 0; //return 0 if true
        }
        switch (choice) { //decides to get the sum or number of ratings
            case 0: { //case statement for the number of ratings
                while (input.hasNextLine()) { //runs until there are no more lines in the file
                    s = input.nextLine().split(delim); //splits the ratings from the comments
                    count++; //adds to the count
                }
            }
            case 1: { //case statement for the sum of ratings
                while (input.hasNextLine()) { //runs until there are no more lines in the file
                    s = input.nextLine().split(delim); //splits the ratings from the comments
                    count += Integer.parseInt(s[choice]); //sets the counter to the arrays values
                }
            }
        }
        input.close(); //closes the scanner
        return count; //returns the total sum of ratings
    }

    /**
     * This method updates the rating of a book by re-calculating the average.
     *
     * @return the rating of the book
     */
    public double calculateBookRating() {
        try { //if they equal 0 then try to calculate it
            return getRatingValues(1) / getRatingValues(0); //calculate the average
        } catch (ArithmeticException e) { //if the average cannot be calculated
            return 0; //return 0
        }
    }

    /**
     * This method checks if the books file is empty, meaning it has no comments
     * or ratings.
     *
     * @return returns true if it is empty, returns false if it is not empty
     */
    public boolean fileEmpty() {
        try { //trys to see if the scanner can take in the next line
            input.hasNextLine(); //goes to the next line in the file
        } catch (NullPointerException e) { //if the file is empty
            return true; //return true
        }
        return false; //if not then return false
    }
}
