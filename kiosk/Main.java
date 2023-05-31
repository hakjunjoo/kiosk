package kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 메뉴 초기화
            Kiosk.allMenu();
            //1. 메인 메뉴판 화면 출력
            Kiosk.mainMeun();
            int n = sc.nextInt();
            // 2. 상품 메뉴판 화면 출력
            try {
                if (n == 5) {
                    if (Order.wish.size() == 0) { //장바구니가 비어있는 경우 처리
                        Kiosk.emptiedWish();
                        continue;
                    } else {
                        Kiosk.coiceMeun(n);
                        Kiosk.orderComplete();
                        continue;
                    }
                } else if (n == 6) { // 주문 취소
                    Kiosk.coiceMeun(n);
                    int c = sc.nextInt();
                    if(c==1) {
                        Order.wish.clear();
                        System.out.println("진행하던 주문이 취소되었습니다.\n");
                        continue;
                    } else {
                        continue;
                    }
                } else{
                    Kiosk.coiceMeun(n); // 상품 메뉴판 출력
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 3. 장바구니
            int m = sc.nextInt();
            Kiosk.wishList(n, m);

            int k = sc.nextInt();
            Kiosk.putInBasket(n, m, k); // 장바구니에 담는 메소드
        }








    }
}
