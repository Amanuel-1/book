package model;



import java.time.LocalDate;


class Administrator extends Person{

    public Administrator() {};
    public Administrator(String name){
        setName(name);
    }
    public Book[] searchBooks(String title){
        // TODO: algorithm
        return null;
    }
    public Book[] searBooks(Author author){
        // TODO: algorithm
        return null;
    }
    public Book[] searchBooks(Double price){
        // TODO: algorithm
        return null;
    }
    public Book[] searchBooks(Publisher publisher){
        // TODO: algorithm
        return null;
    }
    public Book[] searchBooks(LocalDate pubDate){
        // TODO: algorithm
        return null;
    }
    public Book[] searchBooks(Integer id){
        // TODO: algorithm
        return null;
    }
    public Book[] searchBooks(Genre genre){
        // TODO: algorithm
        return null;
    }
    public Book[] sortBooks(SortBy mode){
        switch(mode){
            case TITLE:
                // TODO
                break; 
            case AUTHOR:
                // TODO
                break;    
            case ID:
                // TODO
                break;  
            case PRICE:
                // TODO
                break;  
            case QUANTITY_SOLD:
                // TODO
                break;    
            case STOCK_QUANTITY:
                // TODO
                break;    
            default:

        }
        return null;
    }
    public void addBook(){
        // TODO: prompts for all book details and stores in database
    }
    public void removeBook(Book book){
        // TODO: removes the book from the db
    }
    public void applyDiscount(Book book, Double percent){
        // TODO: applies a discount on the book's price
    }
    public void trackBook(){
        // TODO
    }
    public void salesReport(){
        // TODO: Calls method from Sales class
        Sales.generateSalesReport();
    }
    public void addEmployee(){
        // TODO
    }
    public void editEmployee(Employee employee){
        // TODO
    }
    public void generateCustomerReport(){
        // TODO
    }
}

