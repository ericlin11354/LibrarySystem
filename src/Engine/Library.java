/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Arrays;
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
        String url = "https://openlibrary.org/works/OL16313124W/Harry_Potter_and_the_Chamber_of_Secrets";
        //url = "https://openlibrary.org/works/OL271685W/Star_Wars";
        //url = "https://openlibrary.org/books/OL9287378M/Calculus";
        Document doc = Jsoup.connect(url).get();
        String title = doc.select(".BookTitle").get(0).text();
        String author = doc.select(".Author").get(0).text();
        Elements imgs = doc.getElementsByTag("img");
        for(Element img : imgs){
            if(img.hasAttr("src") && img.hasClass("cover")){
                System.out.println(img.attr("src"));
                break;
            }
        }
        String desc = "";
        String line = null;
        Elements paragraphs = doc.getElementsByTag("p");
        for(Element para : paragraphs){
            line = para.text();
            if(line.contains("Source"))
                break;
            desc += line + "\n";
        }
        desc = desc.substring(0,desc.length()-1);
        //test output
        System.out.println(title);
        System.out.println(author);
        System.out.println("Description: "+desc);
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
