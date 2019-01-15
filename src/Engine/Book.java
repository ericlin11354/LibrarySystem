package Engine;

/**
 * This is the file for the book class.
 * 
 * @author 349361337
 */
public class Book {
    String title; //the variable for the book title
    String author; //the variable for the book's author
    String synopsis; //the variable for the book's description
    int addedRatings; //the variable for all the ratings on the book added togethor
    int numRatings; //the variable for the number of ratings made on the book
    String comments; //the variable for all the comments made on the book
    String datePublished; //the variable for the book's publishing date
    String categories; //the varible for the book's genre
    String barcode; //the variable for the book's barcode
    
    /**
     * 
     * @param title
     * @param author
     * @param synopsis
     * @param numRatings
     * @param comments
     * @param datePublished
     * @param categories
     * @param barcode 
     */
    public Book(String title, String author, String synopsis, String datePublished, String categories, String barcode){
        this.title = title;
        this.author = author;
        this.synopsis = synopsis;
        this.datePublished = datePublished;
        this.categories = categories;
        this.barcode = barcode;
    }
    
    /**
     *
     */
    public Book(){
    }
}
