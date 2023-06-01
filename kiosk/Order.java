package kiosk;

import java.util.ArrayList;

public class Order {
    static ArrayList<Product> wish = new ArrayList<Product>();
    static ArrayList<Product> cntWish = new ArrayList<>();
    static ArrayList<Product> totalWish = new ArrayList<Product>();

    public static double salePriceTotal() {
        double salePrice = 0.0;
        for (int i = 0; i < wish.size(); i++) {
            salePrice += wish.get(i).getPrice();
        }
        return salePrice;
    }
}
