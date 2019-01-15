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
            pw.print(book.numRatings + delimiter);
            pw.print(book.comments + delimiter);
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
     * This method searches for a book by its title.
     */
//    public void searchBook() {
//    }
    /**
     * This method looks at book selection based on categories.
     *
     * @param category the genre to be looked through
     * @throws IOException
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
        /*
         System.out.println(cover);
         System.out.println(title);
         System.out.println(author);
         System.out.println("Description: "+desc);
         */
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
        Book book = new Book();
        book.barcode = "0101010";
        book.title = "whatsup";
        book.author = "asdasd";
        lib.addBook(book);
        Book b1 = new Book();
        b1.author = "yo";
        b1.barcode = "2222";
        b1.title = "asadasdasd";
        lib.addBook(b1);
        Book b2 = new Book();
        b2.barcode = "2222";
        b2.author = "eru";
        lib.addBook(b2);
        Book b3 = new Book();
        b3.barcode = "2222";
        b3.author = "eru";
        lib.addBook(b3);

    }
}
