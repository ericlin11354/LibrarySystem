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
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;
import javax.swing.text.html.HTML;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * The file for the library class.
 *
 * @author 349361337
 */
public class Library {

    public String title; //the variable for book's title
    public String author; //the variable for the author of the book
    public URL cover; //the variable book's cover
    public String desc; //the variable for the description of the book.

    /**
     * The constructor for the library class.
     */
    public Library() {
        title = author = desc = "";
        cover = null;
    }

    /**
     * This method adds a new book to the library.
     *
     * @param book the book to be added
     * @throws java.io.IOException
     */
    public void addBook(Book book) throws IOException {
        File f = new File("bookinfo.txt");
        Scanner input = new Scanner(f);
        boolean exist = false;
        PrintWriter pw = new PrintWriter(new FileWriter(f, true));
        String delimiter = ",,";
        //Checks if the file already has the book stored already
        while (input.hasNext()) {
            String[] codes = input.nextLine().split(delimiter);
            if (codes[0].equals(book.barcode)) {
                exist = true;
                break;
            } else {
                exist = false;
            }
        }
        input.close();

        if (exist == false) {
            pw.print(book.barcode + delimiter);
            pw.print(book.title + delimiter);
            pw.print(book.author + delimiter);
            pw.print(book.datePublished + delimiter);
            pw.print(book.categories + delimiter);
            pw.print(book.synopsis);
            pw.println();
            pw.close();
        }
    }

//         String barcodes[] = input.nextLine().split(",");
//             for(int i = 0; i<8;i++)
//             System.out.println(barcodes[i]);
//            if (barcodes[0].equals(book.barcode)) {
//    }

    /**
     * Searches up a barcode and gets book info
     * @param barcode barcode number
     * @return returns Book class containing info
     * @throws IOException throws Exception initializing Document and calling addBook method
     */
    public Book browseBook(String barcode) throws IOException{
        //test barcode
        barcode = "9780807286012";
        //connects to website
        String url = "https://www.worldcat.org/search?qt=worldcat_org_bks&q=" + barcode + "&fq=dt%3Abks";
        WebDriver driver = new HtmlUnitDriver();
        //turn off htmlunit warnings
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        driver.get(url);
        //gets first item in liust
        WebElement item = driver.findElement(By.id("result-1"));
        if (item == null) {
            System.out.println("no book");
        }
        item.click();
        //parses book info page
        Document doc = null;
        doc = Jsoup.connect(driver.getCurrentUrl()).get();
        //gets title,author,publisher
        String title = doc.getElementsByClass("title").get(0).text();
        String author = doc.getElementsByAttributeValue("title", "Search for more by this author").get(0).text();
        String[] publisher = doc.getElementById("bib-publisher-cell").text().split(",");
        //gets publisher name and date
        String pub = publisher[0];
        String pubDate = publisher[1];
        //gets genres
        Elements elements = doc.getElementsByClass("subject-term");
        String genres = "";
        for (Element element : elements) {
            genres += element.text();
        }
        //gets cover image file
        String cover = "https:" + doc.getElementsByClass("cover").get(0).attr("src");
        String summ = doc.getElementById("summary").text();
        Book b = new Book(title, author, summ, pub, pubDate, genres, barcode);
        addBook(b);
        return b;
        //test
        /*System.out.println(title);
         System.out.println(author);
         System.out.println(publisher);
         System.out.println(genres);
         System.out.println(summ);
         System.out.println(cover);*/
    }

    /**
     * This method sorts the books by categories.
     */
    public void sortBook() {
    }

    /**
     * This main method is only used for testing.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Library lib = new Library();
        // lib.browseBook("s");
        Book book = lib.browseBook("9780807286012");
        Book book1 = lib.browseBook("9780807286012");
        /*book.writeReview("I hate this book",1);
        book.writeReview("This book is ok",3);
        book.writeReview("I can't live without this book",5);*/
        //System.out.printf("%f",book.getAverageReview());
        //System.exit(0);
    }
}
