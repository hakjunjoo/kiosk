package kiosk;

import java.util.Scanner;

public class Kiosk2 {
    static Product[][] products = {MenuList.getBurgerArr(), MenuList.getFrozenCustardArr(), MenuList.getDrinkArr(), MenuList.getBeerArr()};
    static int cnt = 1; // 주문 번호 초기화
    static Scanner sc = new Scanner(System.in);

    public static void kioskDisplay() {
        boolean start = true;
        while(start) {
//            MenuList.menuData(); //메뉴 초기화
            System.out.println("================================================\n");
            System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
            System.out.println("원하시는 작업을 선택해주세요.");
            System.out.println("1. 메뉴     2. 관리자 메뉴     3. 시스템 종료");
            System.out.print("\n여기에 번호를 입력하세요 => ");
            int menuClick = sc.nextInt();
            switch (menuClick) {
                case 1 :  // 메뉴 주문
                    menuOrder(); // 메뉴 리스트 출력
                    break;
                case 2 :  // 관리자 메뉴
                    break;
                case 3 :  //시스템 종료
                    System.out.println("프로그램을 종료합니다.");
                    System.out.println("감사합니다.");
                    start = false; //반복문을 벗어나서 프로그램이 종료된다.
                    break;
                default :
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            } // switch
        } // while
    } // kioskDisplay

    private static void menuOrder() { // 메뉴 주문
        Loop : while (true) { // 초기 메뉴 화면을 위해 이름 붙은 반복문을 활용
            System.out.println("\n================================================\n");
            System.out.println("메뉴를 선택하셨습니다.");
            System.out.println("원하시는 작업을 선택해주세요.");
            System.out.println("1. 메뉴 주문     2. 장바구니 조회     3. 주문 취소     4. 초기 메뉴");

            System.out.print("\n여기에 번호를 입력하세요 => ");
            int menuSelect = sc.nextInt();
            switch (menuSelect) {
                case 1 :
                    MenuList.menuData(); //메뉴 초기화
                    mainMenu(); // 메뉴 주문
                    break;
                case 2 :
                    orderList(); // 장바구니 조회
                    break;
                case 3 :
                    orderCancel(); // 주문 취소
                    break;
                case 4 :
                    break Loop; //초기 메뉴로 돌아가기
                default :
                    System.out.println("잘못된 입력입니다. 번호를 다시 입력해주세요.");
                    break;
            } //switch
        } //while
    } //menuSelect

    private static void mainMenu() {
        System.out.println("================================================\n");
        System.out.println("메뉴 주문을 선택하셨습니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 번호를 입력해주세요.");
        System.out.println("\n[ SHAKESHAKCK MENU ]");
        int i = 0;
        for (Menu m : MenuList.getMenuArr()) {
            i++;
            System.out.println(i + ". " + m.toString());
        }

        while (true) {
            System.out.print("\n여기에 번호를 입력하세요 => ");
            int menuSelect = sc.nextInt();
            if(1 <= menuSelect && menuSelect <= 4) {
                menuSelect(menuSelect);
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    } //mainMenu

    private static void menuSelect(int menuSelect) {
        int i=0;
        switch (menuSelect) {
            case 1 : {
                System.out.println("\n================================================\n");
                System.out.println("[ Burgers Menu ]");
                for (Product b : MenuList.getBurgerArr()) {
                    i++;
                    System.out.println(i + ". " + b.toString());
                }
                System.out.print("\n여기에 번호를 입력하세요 => ");
                break;
            }
            case 2 : {
                System.out.println("\n================================================\n");
                System.out.println("[ FrozenCustard Menu ]");
                for (Product b : MenuList.getFrozenCustardArr()) {
                    i++;
                    System.out.println(i + ". " + b.toString());
                }
                System.out.print("\n여기에 번호를 입력하세요 => ");
                break;
            }
            case 3 : {
                System.out.println("\n================================================\n");
                System.out.println("[ Drink Menu ]");
                for (Product b : MenuList.getDrinkArr()) {
                    i++;
                    System.out.println(i + ". " + b.toString());
                }
                System.out.print("\n여기에 번호를 입력하세요 => ");
                break;
            }
            case 4 : {
                System.out.println("\n================================================\n");
                System.out.println("[ Beer Menu ]");
                for (Product b : MenuList.getBeerArr()) {
                    i++;
                    System.out.println(i + ". " + b.toString());
                }
                System.out.print("\n여기에 번호를 입력하세요 => ");
                break;
            }
        } //switch

        //while 추가해야할듯
        int detailMenuSelect = sc.nextInt();

        if(menuSelect == 1) {
            addOptions(menuSelect, detailMenuSelect);
        } else {
            wishList(menuSelect, detailMenuSelect);
        }
    } //menuSelect

    //burgers 추가 옵션
    private static void addOptions(int menuSelect, int detailMenuSelect) {
        System.out.println("\n================================================\n");
        System.out.println(products[menuSelect-1][detailMenuSelect-1].toString());
        System.out.println("옵션을 추가하시겠습니까?");
        System.out.println("1. 사이즈 업( + W 3.0 )     2. 추가 안함");
        System.out.print("\n여기에 번호를 입력하세요 => ");

        int options = sc.nextInt();

        if(options == 1) {
            sizeUp(menuSelect, detailMenuSelect);
            wishList(menuSelect, detailMenuSelect);
        } else if (options == 2) {
            wishList(menuSelect, detailMenuSelect);
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
    } //addOptions

    private static void sizeUp(int menuSelect, int detailMenuSelect) {
        products[menuSelect-1][detailMenuSelect-1].setName("(사이즈업)"+products[menuSelect-1][detailMenuSelect-1].getName()); // 메뉴이름 (사이즈업)Burgers
        products[menuSelect-1][detailMenuSelect-1].setPrice(products[menuSelect-1][detailMenuSelect-1].getPrice()+3.0); // 메뉴 가격 +3.0
    } //sizeUP

    private static void wishList(int menuSelect, int detailMenuSelect) {
        System.out.println("\n================================================\n");
        System.out.println("\"" + products[menuSelect-1][detailMenuSelect-1].toString() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        System.out.print("\n여기에 번호를 입력하세요 => ");

        int orderConfirmation = sc.nextInt();
        putInBasket(menuSelect, detailMenuSelect, orderConfirmation);
    } //wishList

    private static void putInBasket(int menuSelect, int detailMenuSelect, int orderConfirmation) {
        if (orderConfirmation != 1) {
            System.out.println("취소되었습니다.");
            MenuList.menuData(); //바뀌었던 메뉴이름 초기화
        } else {
            Order.getTotalWish().add(products[menuSelect-1][detailMenuSelect-1]);
            boolean exists = false;
            //기존 장바구니에 상품이 있는 경우
            for(int i=0; i<Order.getCntWish().size(); i++) {
                if (Order.getCntWish().get(i).toString().equals(Kiosk2.products[menuSelect-1][detailMenuSelect-1].toString())) {
                    exists = true;
                    Product existingProduct = Order.getCntWish().get(i);
                    existingProduct.setCount(existingProduct.getCount() + 1); // 상품의 카운트 +1
                    System.out.println("\n================================================\n");
                    System.out.println(existingProduct.getName() + "가 장바구니에 추가되었습니다.");
                }
            }
            //기존 장바구니에 상품이 없는 경우
            if(!exists) {
                Order.getCntWish().add(products[menuSelect-1][detailMenuSelect-1]);
                System.out.println("\n================================================\n");
                System.out.println(products[menuSelect-1][detailMenuSelect-1].getName().strip() + " 가 장바구니에 추가되었습니다.");
            }
        }
    } //putInBasket

    private static void orderList() {
        if(Order.getCntWish().size() == 0) {
            System.out.println("\n================================================\n");
            System.out.println("현재 장바구니가 비어있습니다.");
            System.out.println("초기화면으로 돌아갑니다.");
            delay(1000);
        } else {
            System.out.println("\n================================================\n");
            System.out.println("현재 까지의 주문 목록은 다음과 같습니다.");
            System.out.println("[ Orders ]");
            for (int j = 0; j < Order.getCntWish().size(); j++) {
                System.out.println(Order.getCntWish().get(j).toString_cnt());
            }
            System.out.println("\n[ Total ]");
            System.out.println("W " + (Math.round(salePriceTotal() * 10.0) / 10.0));
            System.out.println("\n위와 같이 주문하시겠습니까?");
            System.out.println("\n1. 주문      2. 메뉴로 돌아가기");

            while(true) {
                System.out.print("\n여기에 번호를 입력하세요 => ");
                int finalOrderComplete = sc.nextInt();
                if(finalOrderComplete == 1) {
                    orderComplete();
                    break;
                } else if (finalOrderComplete == 2) {
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 번호를 입력해주세요.");
                }
            } //while
        }//else
    }//orderList

    private static double salePriceTotal() {
        double salePrice = 0.0;
        for (int i = 0; i < Order.getCntWish().size(); i++) {
            salePrice += Order.getCntWish().get(i).getPrice() * Order.getCntWish().get(i).getCount();
        }
        return salePrice;
    }

    private static void orderComplete() {
//        Order.getTotalWish().addAll(Order.getWish());
//        Order.getWish().clear();
        Order.getCntWish().clear();
        System.out.println("\n================================================\n");
        System.out.println("주문이 완료되었습니다!");
        System.out.println("대기번호는 [ " + (cnt++) +" ] 번 입니다.");
        System.out.println("(3초 후 메뉴판으로 돌아갑니다.) \n");
        delay(3000);
    } //orderComplete

    private static void orderCancel() {
        if(Order.getCntWish().size() == 0) {
            System.out.println("\n================================================\n");
            System.out.println("현재 장바구니가 비어있어서 취소할 주문이 없습니다.");
            System.out.println("초기화면으로 돌아갑니다.\n");
            delay(1000);
        } else {
            System.out.println("현재 주문한 내용은 다음과 같습니다.");
            System.out.println("현재 까지의 주문 목록은 다음과 같습니다.");
            System.out.println("[ Orders ]");
            for (int j = 0; j < Order.getCntWish().size(); j++) {
                System.out.println((j+1)+ ". " + Order.getCntWish().get(j).toString_cnt());
            }

            System.out.println("\n 취소할 주문의 번호를 입력해주세요.");
            System.out.print("여기에 번호를 입력하세요 => ");
            int orderCancelNumber = sc.nextInt();

            if(Order.getCntWish().get(orderCancelNumber-1).getCount() == 1) { // 주문 개수가 1개인 경우는 list에서 원소를 remove한다.
                for(int i = 0; i < Order.getCntWish().size(); i++) {
                    if(orderCancelNumber == i+1) {
                        System.out.println(Order.getCntWish().get(i).toString_cnt());
                        System.out.println("해당 주문을 취소했습니다.");
                        Order.getCntWish().remove(i);
                        break;
                    }
                }
            } else { // 주문 개수가 2개 이상인 경우는 list에서 cnt를 줄인다.
                System.out.println(Order.getCntWish().get(orderCancelNumber-1).toString_cnt());
                System.out.println("몇 개를 취소하시겠습니까?");

                // 더 구현해야함
            }


        }
    }

    private static void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    } //delay

} //Kiosk2 class
