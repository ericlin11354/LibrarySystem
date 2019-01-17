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
            }
        }
        input.close();

        if (exist == false) {
            pw.print(book.barcode + delimiter);
            pw.print(book.title + delimiter);
            pw.print(book.author + delimiter);
            pw.print(book.synopsis + delimiter);
            pw.print(book.publisher + delimiter);
            pw.print(book.datePublished + delimiter);
            pw.print(book.categories + delimiter);
            pw.print(book.cover + delimiter);
            pw.println();
            pw.close();
        }
    }
    
    //I feel like we can code this to be faster -Eric
    public void deleteBook(Book book) throws IOException{
        File f = new File("bookinfo.txt");
        Scanner input = new Scanner(f);
        PrintWriter pw = new PrintWriter(new FileWriter(f, true));
        String delimiter = ",,";
        String s = "";
        String remove = "";
        //Checks if the file already has the book stored already
        while (input.hasNext()) {
            s += input.nextLine();
            if(s.split(delimiter)[0].equals(book.barcode))
                remove = s;
        }
        input.close();
        //System.out.println(remove);
        s = s.replaceAll(remove, "");
        f.delete();
        f.createNewFile();
        pw = new PrintWriter(new FileWriter(f,true));
        pw.println(s);
        pw.close();
        
        //System.out.println(s);
    }
    public boolean bookExists(String barcode)throws IOException{
        File f = new File("bookinfo.txt");
        Scanner input = new Scanner(f);
        PrintWriter pw = new PrintWriter(new FileWriter(f, true));
        String delimiter = ",,";
        //Checks if the file already has the book stored already
        while (input.hasNext()) {
            String[] codes = input.nextLine().split(delimiter);
            if (codes[0].equals(barcode)) {
                return true;
            }
        }
        input.close();
        return false;
    }
    
    public Book searchBook(String barcode) throws IOException{
        File f = new File("bookinfo.txt");
        Scanner input = new Scanner(f);
        PrintWriter pw = new PrintWriter(new FileWriter(f, true));
        String delimiter = ",,";
        String[] codes = null;
        //Checks if the file already has the book stored already
        while (input.hasNext()) {
            codes = input.nextLine().split(delimiter);
            if (codes[0].equals(barcode)) {
                break;
            }
        }
        Book temp = new Book(codes[0],codes[1],codes[2],codes[3],codes[4],codes[5],codes[6],codes[7]);
        input.close();
        return temp;
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
        Book b = null;
        if(bookExists(barcode)){
            b = searchBook(barcode);
        }
        else{
        //connects to website
        String url = "https://www.worldcat.org/search?qt=worldcat_org_bks&q=" + barcode + "&fq=dt%3Abks";
        WebDriver driver = new HtmlUnitDriver();
        //turn off htmlunit warnings
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        driver.get(url);
        //gets first item in liust
        WebElement item = null;
        try{
        item = driver.findElement(By.id("result-1"));
        }
        catch(Exception e){
            System.out.println("No such item can be found");
            System.exit(0);
        }
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
        String pub = "";
        String pubDate = "";
        try{
            pub = publisher[0];
        }
        catch(ArrayIndexOutOfBoundsException e){
        }
        try{
            pubDate = publisher[1];
        }
        catch(ArrayIndexOutOfBoundsException e){
        }
        //gets genres
        Elements elements = doc.getElementsByClass("subject-term");
        String genres = "";
        for (Element element : elements) {
            genres += element.text();
        }
        //gets cover image file
        String cover = "https:" + doc.getElementsByClass("cover").get(0).attr("src");
        String summ;
        try{
            summ = doc.getElementById("summary").text();
            System.out.println(summ);
        }
        catch(NullPointerException e){
            try{
            summ = doc.getElementsByClass("nielsen-review").get(0).text();
            }
            catch(IndexOutOfBoundsException f){
                summ = "";
            }
        }
         b = new Book(barcode,title, author,summ, pub, pubDate, genres,cover);
        addBook(b);
        //test
        /*System.out.println(title);
         System.out.println(author);
         System.out.println(publisher);
         System.out.println(genres);
         System.out.println(summ);
         System.out.println(cover);*/
        }
        return b;
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
        lib.deleteBook(lib.browseBook("1853267333"));
    }
}
