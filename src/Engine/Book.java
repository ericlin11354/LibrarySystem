package Engine;

/**
 * This is the class for handling individual book information
 * This class only stores with the book's information, it does not do anything
 * with this information. The library class is responsible for actions on books.
 * Another function of this class is to have one instance of review associated with
 * a book since every book has their own reviews.
 * @author North Star Inc. Team
 */
public class Book {
    //Every book will have these elements of book associated with it
    private String title; //the variable for the book title
    private String author; //the variable for the book's author
    private String synopsis; //the variable for the book's description
    private String publisher; //the variable for the book's publisher
    private String datePublished; //the variable for the book's publishing date
    private String categories; //the varible for the book's genre
    private String cover; //the variable for the book's cover
    private String barcode; //the variable for the book's barcode
    private Review review; //the variable used to access the Review Class
    private String url; //The link of the book on the online data base

    /**
     * This is the constructor for the Book Class. Create a book with all the info
     * read from the database
     * @param title the title of the book
     * @param author the author of the book
     * @param synopsis the description of the book
     * @param datePublished the date the book was published
     * @param publisher the publisher of the book
     * @param categories the genre of the book
     * @param barcode the barcode of the book
     * @param cover the cover of the book
     */
    public Book(String barcode, String title, String author, String synopsis, String publisher, String datePublished, String categories, String cover,String url) {
        this.title = title;
        this.author = author;
        this.synopsis = synopsis;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.categories = categories;
        this.barcode = barcode;
        this.cover = cover;
        this.url = url;
        //Creates an instance of review for the current book
        review = new Review(barcode);
    }
    
    /**
     * This is the constructor to create a book by associating its title with 
     * its url on the database so this allows each book's title to be shown on
     * the search result screen, and when the user clicks on the title of one book,
     * it will bring up the book info screen for that particular book
     * 
     * @param title title of the book
     * @param link the url of the book
     */
    public Book(String title, String link){
        this.title = title;
        this.url = link;
    }

    /**
     * This method is used to add a review on a book using the Review Class.
     *
     * @param s the comment made on the book
     * @param rating the rating made on the book
     */
    public void writeReview(String s, int rating, String id) {
        getReview().addReview(s, rating,id);
    }

    /**
     * This method calculates the rating of the book using the Review Class.
     *
     * @return the average of the book
     */
    public double getAverageRating() {
        return getReview().calculateBookRating();
    }

    /**
     * This method gets the comments of a book using the Review Class.
     *
     * @return the comments on the book
     */
    public String[] getComments() {
        return getReview().getReview(0);
    }

    /**
     * This method gets the ratings of a book using the Review Class.
     *
     * @return the ratings of the book
     */
    public String[] getRatings() {
        return getReview().getReview(1);
    }
    
    public String[] getIds(){
        return getReview().getReview(2);
    }
    //Below is getters and setters for the variables and methods in book class
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * @param synopsis the synopsis to set
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the datePublished
     */
    public String getDatePublished() {
        return datePublished;
    }

    /**
     * @param datePublished the datePublished to set
     */
    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    /**
     * @return the categories
     */
    public String getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(String categories) {
        this.categories = categories;
    }

    /**
     * @return the cover
     */
    public String getCover() {
        return cover;
    }

    /**
     * @param cover the cover to set
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /**
     * @return the review
     */
    public Review getReview() {
        return review;
    }

    /**
     * @param review the review to set
     */
    public void setReview(Review review) {
        this.review = review;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
