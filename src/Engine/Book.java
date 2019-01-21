package Engine;

/**
 * This is the file for the book class.
 *
 * @author 349361337
 */
public class Book {

    public String title; //the variable for the book title
    public String author; //the variable for the book's author
    public String synopsis; //the variable for the book's description
    public String publisher; //the variable for the book's publisher
    public String datePublished; //the variable for the book's publishing date
    public String categories; //the varible for the book's genre
    public String cover; //the variable for the book's cover
    public String barcode; //the variable for the book's barcode
    public Review review; //the variable used to access the Review Class
    public String link;

    /**
     * This is the constructor for the Book Class.
     *
     * @param title the title of the book
     * @param author the author of the book
     * @param synopsis the description of the book
     * @param datePublished the date the book was published
     * @param publisher the publisher of the book
     * @param categories the genre of the book
     * @param barcode the barcode of the book
     * @param cover the cover of the book
     */
    public Book(String barcode, String title, String author, String synopsis, String publisher, String datePublished, String categories, String cover,String link) {
        this.title = title;
        this.author = author;
        this.synopsis = synopsis;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.categories = categories;
        this.barcode = barcode;
        this.cover = cover;
        review = new Review(barcode);
    }
    public Book(String title, String link){
        this.title = title;
        this.link = link;
    }

    /**
     * This method is used to add a review on a book using the Review Class.
     *
     * @param s the comment made on the book
     * @param rating the rating made on the book
     */
    public void writeReview(String s, int rating) {
        review.addReview(s, rating);
    }

    /**
     * This method calculates the rating of the book using the Review Class.
     *
     * @return the average of the book
     */
    public double getAverageRating() {
        return review.calculateBookRating();
    }

    /**
     * This method gets the comments of a book using the Review Class.
     *
     * @return the comments on the book
     */
    public String[] getComments() {
        return review.getReview(0);
    }

    /**
     * This method gets the ratings of a book using the Review Class.
     *
     * @return the ratings of the book
     */
    public String[] getRatings() {
        return review.getReview(1);
    }
}
