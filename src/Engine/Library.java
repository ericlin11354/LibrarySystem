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
        String url = "https://openlibrary.org/works/OL16313124W/Harry_Potter_and_the_Chamber_of_Secrets";
        url = "https://openlibrary.org/works/OL271685W/Star_Wars";
        Document doc = Jsoup.connect(url).get();
        Elements itemprops = doc.getElementsByAttributeStarting("itemprop");
        String title = itemprops.get(0).text();
        String author = itemprops.get(1).text();
        System.out.println(title +" by "+author);
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
