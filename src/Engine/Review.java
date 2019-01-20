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
    String barcode; //the variable for the barcode of the book
    public static final String delim = ",,"; //the variable for the delimeter

    /**
     * This is the constructor for the review class.
     *
     * @param barcode takes in the barcode of the book
     */
    public Review(String barcode) {
        this.barcode = barcode;
        f = new File("reviews/" + barcode + ".txt");
        if (!f.exists()) { //checks if the file already exist
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("IOException creating new file");
            }
        }
    }

    /**
     * This method tries to open a print writer, if it cannot it will return an
     * error.
     */
    public void initPW() {
        try { //checks to see if a print writer can be opened
            pw = new PrintWriter(new FileWriter(f, true));
        } catch (IOException e) { //if not then print an error
            System.out.println("IOException reading " + f.getName());
            System.exit(0);
        }
    }

    /**
     * This method tries to open a scanner, if it cannot it will return an
     * error.
     */
    public void initScanner() {
        try { //checks to see if a scanner can be opened
            input = new Scanner(f);
        } catch (FileNotFoundException e) { //if not then print an error
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
        initPW();
        pw.println(comment + delim + rating);
        pw.close();
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
        switch (choice) { //decides to get comments or ratings
            case 0: { //case statement for comments
                initScanner(); //opens the scanner
                ArrayList<String> list = new ArrayList<>();
                //creates temporary varibles
                String[] s = null;
                if (fileEmpty()) { //checks if the file is empty
                    return null;
                }
                while (input.hasNextLine()) { //runs until there are no more lines in the file
                    s = input.nextLine().split(delim); //splits the comments from the ratings
                    list.add(s[choice]);
                }
                input.close();
                String[] temp = new String[list.size()];
                temp = list.toArray(temp); //converts the list into a String array
                return temp;
            }
            case 1: { //case statement for ratings
                initScanner(); //opens the scanner
                ArrayList<String> list = new ArrayList<>();
                //creates temporary varibles
                String[] s = null;
                if (fileEmpty()) { //checks if the file is empty
                    return null;
                }
                while (input.hasNextLine()) { //runs until there are no more lines in the file
                    s = input.nextLine().split(delim); //splits the comments from the ratings
                    list.add(s[choice]);
                }
                input.close();
                String[] temp = new String[list.size()];
                temp = list.toArray(temp); //converts the list into a String array
                return temp;
            }
            default: //if an unacceptable entry is made
                return null;
        }
    }

    /**
     * This method gets either the sum of ratings, or the number of ratings made
     * on a book.
     *
     * @param choice 0 is for sum of ratings, 1 is for number of ratings
     * @return returns the sum of ratings, or number of ratings, if an error
     * occurs -1 is returned
     */
    public int getRatingValues(int choice) {
        switch (choice) { //decides to get the sum or number of ratings
            case 0: { //case statement for the sum of ratings
                initScanner(); //opens the scanner
                //creates temporary varibles
                String[] s = null;
                int count = 0;
                if (fileEmpty()) { //checks if the file is empty
                    return 0;
                }
                while (input.hasNextLine()) { //runs until there are no more lines in the file
                    s = input.nextLine().split(delim); //splits the ratings from the comments
                    count += Integer.parseInt(s[1]); //sets the counter to the arrays values
                }
                input.close();
                return count;
            }
            case 1: { //case statement for the number of ratings
                initScanner(); //opens the scanner
                //creates temporary varibles
                String[] s = null;
                int count = 0;
                if (fileEmpty()) { //checks if the file is empty
                    return 0;
                }
                while (input.hasNextLine()) { //runs until there are no more lines in the file
                    s = input.nextLine().split(delim); //splits the ratings from the comments
                    count++;
                }
                input.close();
                return count;
            }
            default: //for an incorrect use of method
                return -1;
        }
    }
    
    /**
     * This method updates the rating of a book by re-calculating the average.
     *
     * @return the rating of the book
     */
    public double calculateBookRating() {
        return getRatingValues(0) / getRatingValues(1);
    }

    /**
     * This method checks if the books file is empty, meaning it has no comments
     * or ratings.
     *
     * @return returns true if it is empty, returns false if it is not empty
     */
    public boolean fileEmpty() {
        try { //trys to see if the scanner can take in the next line
            input.hasNextLine();
        } catch (NullPointerException e) {
            return true;
        }
        return false;
    }
}
