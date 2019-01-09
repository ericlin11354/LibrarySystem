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
    int rating;
    String comments;
    String datePublished;
    String categories;
    int barcode;
    
    
    public Book(String title, String author, String synopsis, int rating, String comments, String datePublished, String categories){
        this.title = title;
        this.author = author;
        this.synopsis = synopsis;
        this.rating = rating;
        this.comments = comments;
        this.datePublished = datePublished;
        this.categories = categories;
    }
    
    public Book(){
        
    }
}
