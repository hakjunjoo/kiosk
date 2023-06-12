package kiosk;

import java.util.ArrayList;

public class Order {
//    private static ArrayList<Product> wish = new ArrayList<Product>(); // default list
    private static ArrayList<Product> cntWish = new ArrayList<>(); // count list
    private static ArrayList<Product> totalWish = new ArrayList<Product>(); // total list



//    public static ArrayList<Product> getWish() {
//        return wish;
//    }

    public static ArrayList<Product> getCntWish() {
        return cntWish;
    }

    public static ArrayList<Product> getTotalWish() {
        return totalWish;
    }

}
