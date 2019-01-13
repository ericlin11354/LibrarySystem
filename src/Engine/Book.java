/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 *
 * @author 349361337
 */
public class Book {
    String title;
    String author;
    String synopsis;
    int addedRatings;
    int numRatings;
    String comments;
    public int numComments;
    String datePublished;
    String categories;
    String barcode;
    
    
    public Book(String title, String author, String synopsis, int addedRatings, int numRatings, String comments, int numComments, String datePublished, String categories, String barcode){
        this.title = title;
        this.author = author;
        this.synopsis = synopsis;
        this.addedRatings = addedRatings;
        this.numRatings = numRatings;
        this.comments = comments;
        this.numComments = numComments;
        this.datePublished = datePublished;
        this.categories = categories;
        this.barcode = barcode;
    }
    
    public Book(){
        
    }
}
