package Engine;

import java.util.List;
import java.io.IOException; //the import for the input, ouput exception
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File; //the import used to access exterior files
import java.io.FileNotFoundException;
import java.io.FileWriter; //the import for the File Writer
import java.io.PrintWriter; //the import for the Print Writer
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner; //the import for the Scanner
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * The file for handling books from book class
 *
 * @author North Star Inc. Team
 */
public class Library {

    static final String delimiter = ",,"; //Two backslash

    /**
     * The constructor for the library class.
     */
    public Library() {
    }

    /**
     * Handles FileNotFound Exception when initializing Scanner class
     *
     * @param f gets file
     * @return returns Scanner object. Returns null if FileNotFoundException
     * occurs
     */
    public Scanner initScanner(File f) {
        try {
            return new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * Handles FileNotFound Exception when initializing PrintWriter class
     *
     * @param f gets file
     * @return returns PrintWriter object. Returns null if FileNotFoundException
     * occurs
     */
    public PrintWriter initPW(File f) {
        try {
            return new PrintWriter(new FileWriter(f, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method adds a new book to the library.
     *
     * @param book the book to be added
     */
    public void addBook(Book book) {
        //reads bookinfo file
        File f = new File("bookinfo.txt");
        Scanner input = initScanner(f);
        PrintWriter pw = initPW(f);
        input.close();
        //adds book info to the file
        pw.print(book.getBarcode() + delimiter);
        pw.print(book.getTitle() + delimiter);
        pw.print(book.getAuthor() + delimiter);
        pw.print(book.getSynopsis() + delimiter);
        pw.print(book.getPublisher() + delimiter);
        pw.print(book.getDatePublished() + delimiter);
        pw.print(book.getCategories() + delimiter);
        pw.print(book.getCover() + delimiter);
        pw.print(book.getUrl() + delimiter);
        pw.println();
        pw.close();
    }

    /**
     * Checks that book exists in bookinfo.txt
     *
     * @param barcode gets the barcode of the book
     * @return returns true if the book exists in the file. Returns false if
     * not.
     */
    public boolean bookExists(String barcode) {
        File f = new File("bookinfo.txt");
        Scanner input = initScanner(f);
        input.nextLine();
        //As long as there is still things to read from the file
        while (input.hasNext()) {
            //Separates each line into elements by the commas
            String[] codes = input.nextLine().split(delimiter);
            //first element of each row is the barcode
            if (codes[0].equals(barcode)) {
                return true;
            }
        }
        input.close();
        return false;
    }

    /**
     * Gets a book in bookinfo.txt
     *
     * @param barcode gets the barcode for the book
     * @return returns Book class for the book. Returns null if book cannot be
     * found
     */
    public Book searchBook(String barcode) {
        File f = new File("bookinfo.txt");
        Scanner input = initScanner(f);
        //stores book info
        String[] codes = null;
        while (input.hasNext()) {
            //Separates each line into elements by using a comma as a delimiter
            codes = input.nextLine().split(delimiter);
            //Exits the loop when the barcode matches
            if (codes[0].equals(barcode)) {
                break;
            }
        }
        input.close();
        //When the barcode does not match, the book does not exist in the file
        if (!codes[0].equals(barcode)) {
            System.out.println("Book not found");
            return null;
        } else {
            //Use the elements read from the file to make a new book
            Book temp = new Book(codes[0], codes[1], codes[2], codes[3], codes[4], codes[5], codes[6], codes[7], codes[8]);
            return temp;
        }
    }

    /**
     * Gets book info from book page
     *
     * @param url gets book page url
     * @return returns Book class containing info
     */
    public Book getBookInfo(String url) {
        Book b;
        //stores html for book info page
        Document doc = null;
        try {
            //Jsoup is used to parse html
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //gets barcode and formats it
        String barcode = doc.getElementById("details-standardno").tagName("td").text().replaceFirst("ISBN: ", "");
        barcode = barcode.substring(0, barcode.indexOf(" "));
        //checks if book exists already in bookinfo.txt
        if (bookExists(barcode)) {
            b = searchBook(barcode);
            return b;
        } else {
            //gets title,author,publisher
            String title = doc.getElementsByClass("title").get(0).text();
            String author = doc.getElementsByAttributeValue("title", "Search for more by this author").get(0).text();
            String[] publisher = doc.getElementById("bib-publisher-cell").text().split(",");
            //gets publisher name and date
            String pub = "";
            String pubDate = "";
            try {
                pub = publisher[0];
            } catch (ArrayIndexOutOfBoundsException e) {
                pub = "Not Available";
            }
            try {
                pubDate = publisher[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                pubDate = "Not Available";
            }
            //gets and formats genres
            String genres;
            try {
                genres = doc.getElementById("details-genre").text();
            } catch (NullPointerException e) {
                genres = "Not Available";
            }
            genres = genres.replaceFirst("Genre/Form: ", "");
            //gets cover image file
            String cover = "https:" + doc.getElementsByClass("cover").get(0).attr("src");
            String summ = doc.getElementsByClass("abstracttxt").text();
            if (summ == "") {
                summ = "Not Available";
            }
            //initializes Book class and adds it to bookinfo.txt
            b = new Book(barcode, title, author, summ, pub, pubDate, genres, cover, url);
            addBook(b);
            return b;
        }
    }

    /**
     * Provides a list of books from a title/barcode
     *
     * @param search gets title/barcode search
     * @return returns a Book array containing items
     */
    public Book[] browseBook(String search) {
        //connects to website
        String url = "https://www.worldcat.org/search?qt=worldcat_org_bks&q=" + search + "&fq=dt%3Abks";
        //WebDriver is used to interact with WorldCat website
        WebDriver driver = new HtmlUnitDriver();
        //turn off htmlunit warnings
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        driver.get(url);
        //stores items from search results
        List<WebElement> items = new ArrayList<>();
        //max 6 results as WorldCat can only store that many on one page
        for (int i = 1; i <= 6; i++) {
            //gets items
            try {
                items.add(driver.findElement(By.id("result-" + i)));
            } catch (NoSuchElementException e) {
                //does nothing
            }
        }
        //Book array uses special constructor which only takes in title and url in order to associate the two
        Book[] temp = new Book[items.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new Book(items.get(i).getText(), items.get(i).getAttribute("href"));
        }
        return temp;
    }

    /**
     * This main method is only used for testing.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Library lib = new Library();
        lib.getBookInfo("https://www.worldcat.org/title/harry-potter-and-the-chamber-of-secrets/oclc/660230089&referer=brief_results");
        //System.out.println(lib.bookExists("9780807286012"));
        //Scanner pw = new Scanner(new File("bookinfo.txt"));
        //System.out.println(Arrays.toString(pw.nextLine().split(delimiter)));
        System.exit(0);
    }
}
