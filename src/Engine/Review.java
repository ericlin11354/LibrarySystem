package Engine;

import java.io.File; //the import used to access exterior files
import java.io.FileNotFoundException;
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

    /*
        Hey Alex, me and Andrew decided that the reviews should have a file called "reviews" which uses comma delimited format.
        It would look something like this: "barcode ; comment1 ; comment2 ; comment3"
    */
    
    
    //good practice to not initialize variables outside of construct methods
    File f = null; //create a new file linked to bookinfo
    Scanner input = null; //create a new scanner
    PrintWriter pw = null; //create a new print writer
    //Book book = null; //making a book so all the variables can be used
    public static final String delim = ";";
    String barcode;
    int numRatings;
    
    /**
     * This is the constructor for the Review class.
     *
     * @throws IOException this is thrown because the program needs to check
     * that the file exists 
     * Edited//we don't need to catch exceptions
     */
    public Review(){
    }
    
    public Review(String barcode){
        this.barcode = barcode;
        f = new File("reviews/"+barcode+".txt");
    }
    
    public void initPW(){
        try{
            pw = new PrintWriter(new FileWriter(f,true));
        }
        catch(IOException e){
            System.out.println("IOException reading "+f.getName());
        }
    }
    
    public void initScanner(){
        try{
            input = new Scanner(f);
        }
        catch(FileNotFoundException e){
            System.out.println("FileNotFoundException reading "+f.getName());
        }
    }

    /**
     * This method is initiated by the user, this will allow them to add a
     * comment or rating to a book.
     *
     * @param book the book that the review is going to be made on
     */
    public void addReview(String review, int rating){
        //on the BookIntoScreen, the user will have the option to leave a review
        //the user to can choose if they want to leave a rating (using a slider)
        //or leave a comment (using a text boxt)
        //Psudocode_________________________________________________________________________________
        //if user populates the text box when the window is changed, the addComment() method is called
        //if the user user uses the slider, when the window changes,
        //the computer will take in the value of the slider and call the addRating() method
        //link the netbeans file and an exterior file
        
        initPW();
        //added this-Eric
        pw.println(review+delim+rating);
        pw.close();
    }
    
    /**
     * This method updates the rating of a book by re-calculating the average.
     *
     * @return the rating of the book
     */
    public double calculateBookRating() {
    //    double averageRating = book.addedRatings / book.numRatings; //calculates the average
       // return averageRating; //returns the calculated average
       
       
       //Added this -Eric
       f = new File("reviews/"+barcode+".txt");
       initScanner();
       int ratings = 0;
       int count = 0;
       String[] s = null;
       while(input.hasNextLine()){
           s = input.nextLine().split(delim);
           ratings += Integer.parseInt(s[1]);
           count++;
       }
       input.close();
       //updates number of ratings
       numRatings = count;
       return ratings/count;
    }
    
    

    
    //This is unnecessary. GUI will just take info from file and implement code to show it-Eric
    /**
     * This method allows the user to add a comment to a book. It is initiated
     * by a button.
     *
     * @return the text that the user enters
     */
    /*
    private void addComment(String saveText) {
        //from the GUI, connect to a text box and just save the text as an String
        //textboxText = saveText;
        storeComment(saveText); //stores the comment back into the file
    }*/

    //This is unncessary, look at previous comment-Eric
    /**
     * This method allows the user to add a rating to a book. It is initiated by
     * a button.
     *
     * @return the rating the user enters
     */
    /*
    private void addRating(int saveRating) {
        //from the GUI, connect to a slider and use that variable as the rating variable
        //slider = saveRating;
        storeRating(saveRating); //stores the rating
        //book.numRatings++; //adds one to the counter
    }
    
    //This method has been covered by addReview -Eric
    /**
     * This is the method used to store the users comment under the books name
     * and bar code.
     *
     * @param comment the text to be saved
     */
    
    //Comments will be stored in separate review file
    /*
    private void storeComment(String comment) {
    //    book.comments += comment; //adds the most recent comment to all the other files
    }

    //This method has been covered by addReview -Eric
    //reviews will be stored in seperate review file
    /**
     * This is the method used to store the users rating under the books name
     * and bar code.
     *
     * @param rating the rating to be saved
     */
    /*
    private void storeRating(int rating) {
    //    book.addedRatings += rating; //adds the most recent rating to all the ratings
    }*/

    /**
     * This method gets the value for the addedRatings of the book.
     *
     * @return the value of addedRatings
     */
    /*public int getAddedRatings() {
     //   return book.addedRatings; //returns all the ratings added together
        return 0;
    }

    //Getter for numRatings -Eric
    /**
     * This method gets the number of ratings made on the book.
     *
     * @return the number of ratings made
     */
    /*public int getNumberRatings() {
        //return book.numRatings; //returns the number of ratings made
        return 0;
    }
    /**
     * This method gets the comments for the book.
     *
     * @return the comments made on the book
     */
    /*public String getComments() {
        //return book.comments; //returns all the comments
        return "";
    }
    /**
     * This main method is purely for testing purposes.
     *
     * @param args
     */
    /*public static void main(String[] args) {
    }*/
}
