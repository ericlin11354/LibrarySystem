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
    String publisher;
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
    public Book(String title, String author, String synopsis, String publisher,String datePublished, String categories, String barcode){
        this.title = title;
        this.author = author;
        this.synopsis = synopsis;
        this.publisher = publisher;
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
