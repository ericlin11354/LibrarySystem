package Engine;

/**
 * This file is for when a user wants to leave a review on a book.
 *
 * @author 073685950 (Alex Weber)
 */
public class Review {

    Book book = new Book(); //making a book so all the variables can be used

    /**
     * This method is initiated by the user, this will allow them to add a
     * comment or rating to a book.
     *
     * @param book the book that the review is going to be made on
     */
    public void addReview(Book book) {
        //on the BookIntoScreen, the user will have the option to leave a review
        //the user to can choose if they want to leave a rating (using a slider)
        //or leave a comment (using a text boxt)
        //Psudocode_________________________________________________________________________________
        //if user populates the text box when the window is changed, the addComment() method is called
        //if the user user uses the slider, when the window changes,
        //the computer will take in the value of the slider and call the addRating() method
    }

    /**
     * This method allows the user to add a comment to a book. It is initiated
     * by a button.
     *
     * @return the text that the user enters
     */
    private void addComment(String saveText) {
        //from the GUI, connect to a text box and just save the text as an String
        storeComment(saveText);
        book.numComments++; //adds one to the counter
    }

    /**
     * This method allows the user to add a rating to a book. It is initiated by
     * a button.
     *
     * @return the rating the user enters
     */
    private void addRating(int saveRating) {
        //from the GUI, connect to a slider and use that variable as the rating variable
        storeRating(saveRating);
        book.numRatings++; //adds one to the counter
    }

    /**
     * This is the method used to store the users comment under the books name
     * and bar code.
     *
     * @param comment the text to be saved
     */
    private void storeComment(String comment) {
        //stores the comment to the exterior file
        //can be read from using another method in Book (may be changed later)
    }

    /**
     * This is the method used to store the users rating under the books name
     * and bar code.
     *
     * @param rating the rating to be saved
     */
    private void storeRating(int rating) {
        //stores the rating to the exterior file
        //can be read from using another method in Book (may be changed later)
    }

    /**
     * This method updates the rating of a book by re-calculating the average.
     *
     * @return the rating of the book
     */
    private double calculateBookRating() {
        double averageRating = book.addedRatings / book.numRatings; //calculates the average
        return averageRating;
    }

    /**
     * This method gets the value for the addedRatings of the book.
     *
     * @return the value of addedRatings
     */
    public int getAddedRatings() {
        return book.addedRatings;
    }

    /**
     * This method gets the number of comments made on the book.
     *
     * @return the number of comments
     */
    public int getNumberComments() {
        return book.numComments;
    }

    /**
     * This method gets the number of ratings made on the book.
     *
     * @return the number of ratings made
     */
    public int getNumberRatings() {
        return book.numRatings;
    }

    /**
     * This main method is purely for testing purposes.
     *
     * @param args
     */
    public static void main(String[] args) {
    }
}
