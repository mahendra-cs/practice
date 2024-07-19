package com.company.java.test;

// Java Program to Show
// working of Enum keyword
// with Switch statement

// Main class
public class MainClass {

    // Declaring Enum keyword
    // inside main class
    enum Webseries {
        GOT,
        Breakingbad,
        Lucifer,
        Boys,
        Mirzapur,
        Moneyheist;
    }
    public static void main(String[] args)
    {
        // Declaring and Assigning choice to variable 'wb'

//        String fsn = null;
//        String fsn1 = "null";
//
//        if (fsn == null || fsn.equals("null")){
//            System.out.println(fsn1);
//        }
        try {
            getEntityType("fs");
        }catch (Exception e){
            System.out.println("incorrect value");
        }
        System.out.println(getEntityType("PRODUCT").name());
        Webseries mySeries = Webseries.GOT;
        System.out.println("need "+mySeries);
        //Webseries wb = Webseries.GOT;

        // Switch Keyword

        //System.out.println(extracted(wb));
    }

    private static EntityType getEntityType(String entityType){
        return EntityType.valueOf(entityType);
    }

    private static int extracted(Webseries wb) {
        switch (wb) {
            case Breakingbad:
                return 1;
            case Lucifer:
                return 2;
            case Boys:
                return 3;
            case Mirzapur:
                return 4;
            case Moneyheist:
                return 5;
            case GOT:
            default:
                return 0;

        }
    }
}

