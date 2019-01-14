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
import java.io.File;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;
import javax.swing.text.html.HTML;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author 349361337
 */
public class Library {

    public String title;
    public String author;
    public URL cover;
    public String desc;

    public Library() {
        title = author = desc = "";
        cover = null;
    }

    /**
     * Adds a new book
     *
     * @param book
     */
    public void addBook(Book book) throws IOException {
   
        File f = new File("bookinfo.txt");
        Scanner input = new Scanner(f);
        PrintWriter pw = new PrintWriter(f);
        String delimiter = ",";
        //Checks if the file already has the book stored already
        boolean exist = isBookExisting(book);
        input.close();

        if (exist == false) {
            pw.print(book.barcode+delimiter);
            pw.print(book.title+delimiter);
            pw.print(book.author+delimiter);
            pw.print(book.datePublished+delimiter);
            pw.print(book.categories+delimiter);
            pw.print(book.numRatings+delimiter);
            pw.print(book.comments+delimiter);
            pw.print(book.synopsis);
            pw.println();
            pw.close();
        }
    }

    /**
     * Removes a book
     *
     * @param book
     */
    public void removeBook(Book book) throws IOException {
        File f = new File("bookinfo.txt");
        Scanner input = new Scanner(f);
        boolean exist = isBookExisting(book);
        if(exist == true){
            
        }
    }   
    
    /**
     * Helper method to see if the book exists already in the file
     * @param book
     * @return
     * @throws IOException 
     */
    public boolean isBookExisting(Book book) throws IOException {
        File f = new File("bookinfo.txt");
        Scanner input = new Scanner(f);
        while (input.hasNext()) {
            if (input.nextLine().contains(book.barcode)) {
                return true;
            } 
        }
        return false;
    }

    /**
     * Searches for a book by its title
     */
    public void searchBook() {

    }

    /**
     * Looks at book selection based on categories
     */
    public void browseBook(String category) throws IOException {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=9780807286012");
        WebElement element = driver.findElement(By.name("q"));

        /*System.out.println(driver.getCurrentUrl());*/
        String url = "https://openlibrary.org/works/OL16313124W/Harry_Potter_and_the_Chamber_of_Secrets";
        Document doc = Jsoup.connect(url).get();
        title = doc.select(".BookTitle").get(0).text();
        author = doc.select(".Author").get(0).text();
        Elements imgs = doc.getElementsByTag("img");
        for (Element img : imgs) {
            if (img.hasAttr("src") && img.hasClass("cover")) {
                cover = new URL("https:" + img.attr("src"));
                break;
            }
        }
        String line = null;
        Elements paragraphs = doc.getElementsByTag("p");
        for (Element para : paragraphs) {
            line = para.text();
            if (line.contains("Source")) {
                break;
            }
            desc += line + "\n";
        }
        desc = desc.substring(0, desc.length() - 1);
        //test output
        /*System.out.println(cover);
         System.out.println(title);
         System.out.println(author);
         System.out.println("Description: "+desc);*/
    }

    //testing
    public static void main(String[] args) throws IOException {
        Library lib = new Library();
       // lib.browseBook("s");
        Book book = new Book();
        book.title = "whatsup";
        book.author = "asdasd";
        lib.addBook(book);
//        Book b1 = new Book();
//        b1.author = "yo";
//        b1.title = "asadasdasd";
//        lib.addBook(b1);
        
    }

    /**
     * Sorts the books by categories
     */
    public void sortBook() {

    }
}
