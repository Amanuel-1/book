package controllers;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    private static String dbName = "BOOK_STORE_MANGEMENT", user = "root", password = "123";
    private static Database db = new Database(dbName, user, password);
    
    public static void addBook(String title, String author,
        String price, String publisher, LocalDate publicationYear, 
        Object genre, Object quantity){   

        db.executeQuery("INSERT INTO TABLE book ()");

    };

    public static void editBook(Integer id, String n_title, String n_author,
     String n_price, String n_publisher, LocalDate n_publicationYear, Object n_genre, 
     Object n_quantity){

        db.executeQuery("ALTER TABLE ... "); 

    };

    public static ArrayList<Object[]> retrieveAllBooks(){
        return db.executeQuery("SELECT * FROM BOOK;");
    }

    public static Object[][] retrieveAllBookObjects(){
        ArrayList<Object[]> objs = retrieveAllBooks();
        Object[][] ret = new Object[objs.size()][];
        
        int i = 0;
        for(Object[] obj : objs){
            ret[i++] = obj;
        }
        
        return ret;
    }

    public static void discountBook(Integer id, Object discountedPrice){

    }


    public static Object[] getGenres(){
        return Genre.values();
    }

    /** More database manipulation functions HERE */
}
