package Engine;

import java.io.File; //the import used to access exterior files
import java.io.FileNotFoundException; //this is the import for the file not found exception
import java.io.FileWriter; //the import for the file writer
import java.io.IOException; //the import for the IOException
import java.io.PrintWriter; //the import for the print writer class
import java.util.ArrayList; //the import for the ArrayList class
import java.util.Arrays;
import java.util.Scanner; //the import used to access the scanner function

/**
 * This file is for when a user wants to leave a review on a book.
 *
 * @author North Star Inc. Team
 */
public class Review {

    private File f = null; //create a new file linked to bookinfo
    private Scanner input = null; //create a new scanner
    private PrintWriter pw = null; //create a new print writer
    private String barcode = null; //the variable for the barcode of the book
    public static final String delim = ";;"; //the variable for the delimeter. Two semicolons

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
            setPw(new PrintWriter(new FileWriter(getF(), true))); //makes a new print writer for the file
        } catch (IOException e) { //if not then print an error
            System.out.println("IOException reading " + getF().getName());
            System.exit(0); //shuts the program down
        }
    }

    /**
     * This method tries to open a scanner, if it cannot it will return an
     * error.
     */
    public void initiateScanner() {
        try { //checks to see if a scanner can be opened
            setInput(new Scanner(getF())); //makes a new scanner for the file
        } catch (FileNotFoundException e) { //if not then print an error
            System.out.println("FileNotFoundException reading " + getF().getName());
            System.exit(0); //shuts the program down
        }
    }

    /**
     * This method is initiated by the user, this will allow them to add a
     * comment, rating and identification to a book.
     *
     * @param comment the comment made by the user
     * @param rating the rating made by the user
     * @param id the identification of the book
     */
    public void addReview(String comment, int rating, String id) {
        initiatePrintWriter(); //open the print writer
        getPw().println(comment + delim + rating + delim + id); //adds the review to the file
        getPw().close(); //close the print writer
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
     * This method updates the rating of a book by re-calculating the average.
     *
     * @return the rating of the book
     */
    public double calculateBookRating() {
        try { //if they equal 0 then try to calculate it
            return (double)getRatingValues(1) / (double)getRatingValues(0); //calculate the average
        } catch (ArithmeticException e) { //if the average cannot be calculated
            return 0; //return 0
        }
    }

    /**
     * This method checks if the books file is empty, meaning it has no
     * comments, ratings or id.
     *
     * @return returns true if it is empty, returns false if it is not empty
     */
    public boolean fileEmpty() {
        try { //trys to see if the scanner can take in the next line
            getInput().hasNextLine(); //goes to the next line in the file
        } catch (NullPointerException e) { //if the file is empty
            return true; //return true
        }
        return false; //if not then return false
    }

    /**
     * This method is used to get the comments, ratings, and the identification
     * of a book using an Integer.
     *
     * @param choice 0 would be used for comments, 1 would be used for ratings,
     * 2 would be for the identification
     * @return returns either the comments, ratings, or the id entry
     */
    public String[] getReview(int choice) {
        initiateScanner(); //opens the scanner
        //creates temporary varibles
        ArrayList<String> list = new ArrayList<>();
        String[] s = null, temp = null;
        if (fileEmpty()) { //checks if the file is empty
            return null; //return null if true
        }
        while (getInput().hasNextLine()) { //runs until there are no more lines in the file
            s = getInput().nextLine().split(delim); //splits the comments from the ratings
            list.add(s[choice]); //adds the comment to the list
        }
        getInput().close(); //closes the scanner
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
                while (getInput().hasNextLine()) { //runs until there are no more lines in the file
                    getInput().nextLine(); //iterates through the file
                    count++; //adds to the count
                }
                break;
            }
            case 1: { //case statement for the sum of ratings
                while (getInput().hasNextLine()) { //runs until there are no more lines in the file
                    s = getInput().nextLine().split(delim); //splits the ratings from the comments
                    count += Integer.parseInt(s[choice]); //sets the counter to the arrays values
                }
                break;
            }
        }
        getInput().close(); //closes the scanner
        return count; //returns the total sum of ratings
    }

    /**
     * This method gets the file.
     *
     * @return the file
     */
    public File getF() {
        return f;
    }

    /**
     * This method sets a file.
     *
     * @param f the file that is being set
     */
    public void setF(File f) {
        this.f = f;
    }

    /**
     * This method gets the scanner.
     *
     * @return the scanner
     */
    public Scanner getInput() {
        return input;
    }

    /**
     * This method sets the scanner.
     *
     * @param input the scanner to be set
     */
    public void setInput(Scanner input) {
        this.input = input;
    }

    /**
     * This method gets the print writer.
     *
     * @return the pw
     */
    public PrintWriter getPw() {
        return pw;
    }

    /**
     * This method sets the print writer.
     *
     * @param pw the pw to set
     */
    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }

    /**
     * This method gets the barcode of the book.
     *
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * This method sets the barcode of the book.
     *
     * @param barcode the barcode to be set
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
