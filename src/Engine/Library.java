/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

/**
 *
 * @author 349361337
 */
public class Library {

    /**
     * Adds a new book
     *
     * @param book
     */
    public void addBook(Book book) {
        
    }

    /**
     * Removes a book
     *
     * @param book
     */
    public void removeBook(Book book) {

    }

    /**
     * Searches for a book by its title
     */
    public void searchBook() {

    }

    /**
     * Looks at book selection based on categories
     */
    public static void browseBook(String category) throws IOException {
        try {
            Document doc = Jsoup.connect("https://openlibrary.org/works/OL16313124W/Harry_Potter_and_the_Chamber_of_Secrets").get();
            Elements itemprops = doc.getElementsContainingText("J. K.");
            for(Element itemprop : itemprops){
                System.out.println(itemprop.text());
            }
            /*URL url = new URL("https://openlibrary.org/works/OL16313124W/Harry_Potter_and_the_Chamber_of_Secrets");
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String s = br.readLine();
             while(s!=null){
             System.out.println(s);
             s = br.readLine();
             }*/
            /*while(!s.contains("|author")){
             s = br.readLine();
             }
             System.out.println(s.substring(s.indexOf("=")+2));*/
            //br.close();
        } catch (MalformedURLException e) {
            System.out.println("URL cannot be found or does not exist.");
        }

    }

    //driver method (FOR TESTING)

    public static void main(String[] args) throws IOException {
        browseBook("test");
    }

    /**
     * Sorts the books by categories
     */
    public void sortBook() {

    }
}
