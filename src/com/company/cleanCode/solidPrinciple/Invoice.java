package com.company.cleanCode.solidPrinciple;


/*
Solid Principles:

S: Single Responsibility Principle
   One class should have only one responsibility means it should have only one reason to change
*/
public class Invoice {
    public int calculateTotal(Marker marker, int quantity) { // this class should only change when there is a
        // change in calculation logic, say we need to give discounts or add taxes
        return (marker.getPrice() * quantity);
    }

    public void printInvoice(){ // This method violates the single responsibility principle since
        // print invoice
    }

    public void saveToDB(){  // This method violates the single responsibility principle since
                            // saving to DB is another responsibility which should not reside in this class

    }
}

/*
To solve this problem we can create two more classes for printing and saving to db */

class PrintInvoice {
    public void printInvoice(){
        //print invoice
    }
}

// O: Open close principle
// A Class should be open for extension but closed for modifications. Why to modify a class which is already tested and running in prod
class InvoiceDao {
    public void saveToDb(){
        //save to db
    }
// If there is a requirement to save to file, we should be adding one more function. this function is breaking the open close principle
    public void saveToFile(){
        //
    }

}

// To solve that create interface

interface InvoiceDaoI {
    public void save(Invoice invoice);
}

class DatabaseInvoiceDao implements InvoiceDaoI{

    @Override
    public void save(Invoice invoice) {
        //
    }
}

class FileInvoiceDao implements InvoiceDaoI {
    @Override
    public void save(Invoice invoice) {
        //
    }
}

// 3. Liskov Principle:
// subclass should not narrow down the capability

interface Bike {
    void turnEngineOn();
}

class Bicycle implements Bike {
    public void turnEngineOn(){
        // Bicycle does not have engine
    }
}

// Bike bicycle = new Bicycle();
// bicycle.turnOnEngine()
// 4. Interface Segregation
// Interface should be such that, client do not implement unnecessary methods

interface RestaurantEmployee{
    void washDish();
    void serveCustomer();
    void prepareFood();
}

class Waiter implements RestaurantEmployee {

    @Override
    public void washDish() {
        // not my job
    }

    @Override
    public void serveCustomer() {

    }

    @Override
    public void prepareFood() {
        // not my job
    }
}

// Dependency Inversion: Class should depend on interfaces not concrete classes
//

class Macbook {
    private Keyboard keyboard;
    private Mouse mouse;
    public Macbook(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public static void main(String[] args) {
        Keyboard wiredKeyboard = new WiredKeyboard();
        Macbook macbook = new Macbook(wiredKeyboard, new WiredMouse());
    }
}


interface Keyboard {

}

class WiredKeyboard implements Keyboard{

}
interface Mouse {

}

class WiredMouse implements Mouse{

}