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
    public String publisher;
    public String datePublished; //the variable for the book's publishing date
    public String categories; //the varible for the book's genre
    public String barcode; //the variable for the book's barcode
    public Review review;
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
        review = new Review(barcode);
    }
    
    public void writeReview(String s,int rating){
        review.addReview(s,rating);
    }
    
    public double getAverageReview(){
        return review.calculateBookRating();
    }
    
    /**
     *
     */
    public Book(){
    }
    public void comment(){
        //review.addReview();
    }
}
