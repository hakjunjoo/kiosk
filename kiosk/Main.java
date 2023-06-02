package kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            //메뉴 초기화
            MenuList.menuData();
            //1. 메인 메뉴판 화면 출력
            Kiosk.mainMeun();
            int n = sc.nextInt();
            // 2. 상품 메뉴판 화면 출력
            try {
                if (n == 5) { // Order 메뉴판
                    if (Order.getWish().size() == 0) { //장바구니가 비어있는 경우 처리
                        Kiosk.emptiedWish();
                        continue;
                    } else {
                        Kiosk.choiceMenu(n);
                        Kiosk.orderComplete();
                        continue;
                    }
                } else if (n == 6) { // Cancel, 주문 취소
                    Kiosk.choiceMenu(n);
                    int c = sc.nextInt();
                    if(c==1) {
                        Order.getWish().clear();
                        Order.getCntWish().clear();
                        System.out.println("진행하던 주문이 취소되었습니다.\n");
                        continue;
                    } else {
                        continue;
                    }
                } else if (n == 0) { // 관리자 메뉴
                    Kiosk.choiceMenu(n);
                    int d = sc.nextInt();
                    if(d==1) {
                        continue;
                    }
                }
                else { // case 1,2,3,4
                    Kiosk.choiceMenu(n); // 상품 메뉴판 출력
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 3. 장바구니
            int m = sc.nextInt();
            if (n == 1){ //burgers 추가옵션
                Kiosk.addOptions(n, m);
                int e = sc.nextInt();
                if (e == 1) { // 사이즈 업을 선택하면
                    Kiosk.sizeUp(n, m); //메뉴이름이 Burgers(사이즈업)으로 바뀌고, 가격이 3.0 비싸진다.
                    Kiosk.wishList(n, m);
                } else {
                    Kiosk.wishList(n, m);
                }
            } else {
                Kiosk.wishList(n, m);
            }
            int k = sc.nextInt();
            Kiosk.putInBasket(n, m, k); // 장바구니에 담는 메소드
        }
    }
}
