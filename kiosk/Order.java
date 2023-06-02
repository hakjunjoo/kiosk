package kiosk;

import java.util.ArrayList;

public class Order {
    private static ArrayList<Product> wish = new ArrayList<Product>(); // default list
    private static ArrayList<Product> cntWish = new ArrayList<>(); // count list
    private static ArrayList<Product> totalWish = new ArrayList<Product>(); // total list

    public static double salePriceTotal() {
        double salePrice = 0.0;
        for (int i = 0; i < wish.size(); i++) {
            salePrice += wish.get(i).getPrice();
        }
        return salePrice;
    }

    public static ArrayList<Product> getWish() {
        return wish;
    }

    public static ArrayList<Product> getCntWish() {
        return cntWish;
    }

    public static ArrayList<Product> getTotalWish() {
        return totalWish;
    }

}
