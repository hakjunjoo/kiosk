package kiosk;

import java.util.Scanner;

public class Kiosk {
    static Scanner sc = new Scanner(System.in);
    static Product[][] products = {MenuList.getBurgerArr(), MenuList.getFrozenCustardArr(), MenuList.getDrinkArr(), MenuList.getBeerArr()};
    static int cnt = 1; // 주문 번호 초기화

    // 메인 메뉴판 화면 출력
    public static void mainMeun() {
        MenuList.menuData();
        System.out.println("\n================================================\n");
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 번호를 입력해주세요.");
        System.out.println("\n[ SHAKESHAKCK MENU ]");
        int i = 0;
        for (Menu m : MenuList.getMenuArr()) {
            i++;
            System.out.println(i + ". " + m.toString());
        }
        System.out.println("\n[ ORDER MENU ]");
        for (Menu o : MenuList.getOrderArr()) {
            i++;
            System.out.println(i+". " + o.toString());
        }
        System.out.print("\n여기에 번호를 입력하세요 => ");
    }

    //상품 메뉴판 화면 출력
    public static void choiceMenu(int n) throws InterruptedException {
        int i=0;
        switch (n) {
            case 0 -> {
                double salePrice = 0.0;
                for (int j = 0; j < Order.getTotalWish().size(); j++) {  // 총 판매금액 합치기
                    salePrice += Order.getTotalWish().get(j).getPrice();
                }
                System.out.println("\n================================================\n");
                System.out.println("[ 총 판매상품 목록 현황 ]");
                for (Product totalPro : Order.getTotalWish()) {
                    System.out.println("- " + totalPro.getName() + "| " + totalPro.getPrice());
                }
                System.out.println("\n[ 총 판매금액 현황 ]");
                System.out.println("현재까지 총 판매된 금액은 [ W " + (Math.round(salePrice * 10.0) / 10.0) + " ] 입니다.");
                System.out.println("\n1. 돌아가기");
                System.out.print("\n여기에 번호를 입력하세요 => ");
            }
            case 1 -> {
                System.out.println("\n================================================\n");
                System.out.println("[ Burgers Menu ]");
                for (Product b : MenuList.getBurgerArr()) {
                    i++;
                    System.out.println(i + ". " + b.toString());
                }
                System.out.print("\n여기에 번호를 입력하세요 => ");
            }
            case 2 -> {
                System.out.println("\n================================================\n");
                System.out.println("[ FrozenCustard Menu ]");
                for (Product b : MenuList.getFrozenCustardArr()) {
                    i++;
                    System.out.println(i + ". " + b.toString());
                }
                System.out.print("\n여기에 번호를 입력하세요 => ");
            }
            case 3 -> {
                System.out.println("\n================================================\n");
                System.out.println("[ Drink Menu ]");
                for (Product b : MenuList.getDrinkArr()) {
                    i++;
                    System.out.println(i + ". " + b.toString());
                }
                System.out.print("\n여기에 번호를 입력하세요 => ");

            }
            case 4 -> {
                System.out.println("\n================================================\n");
                System.out.println("[ Beer Menu ]");
                for (Product b : MenuList.getBeerArr()) {
                    i++;
                    System.out.println(i + ". " + b.toString());
                }
                System.out.print("\n여기에 번호를 입력하세요 => ");

            }
            case 5 -> { // order
                System.out.println("\n================================================\n");
                System.out.println("아래와 같이 주문하시겠습니까?\n");
                System.out.println("[ Orders ]");
                for (int j = 0; j < Order.getCntWish().size(); j++) {
                    System.out.println(Order.getCntWish().get(j).toString_cnt());
                }
                System.out.println("\n[ Total ]");
                System.out.println("W " + (Math.round(Order.salePriceTotal() * 10.0) / 10.0));
                System.out.println("\n1. 주문      2. 메뉴판");
                System.out.print("\n여기에 번호를 입력하세요 => ");
            }
            case 6 -> { // cancel
                System.out.println("\n================================================\n");
                System.out.println("\n진행하던 주문을 취소하시겠습니까?");
                System.out.println("1. 확인        2. 취소 ");
                System.out.print("\n여기에 번호를 입력하세요 => ");
            }
            default -> {
                System.out.println("\n================================================\n");
                System.out.println("번호를 잘못 입력하셨습니다.");
                System.out.println("메인 메뉴로 돌아갑니다.");
            }
        }
    }

    //burgers 추가 옵션
    public static void addOptions(int n, int m) {
        System.out.println("\n================================================\n");
        System.out.println(products[n-1][m-1].toString());
        System.out.println("옵션을 추가하시겠습니까?");
        System.out.println("1. 사이즈 업( + W 3.0 )     2. 추가 안함");
        System.out.print("\n여기에 번호를 입력하세요 => ");
    }

    public static void sizeUp(int n, int m) {
        products[n-1][m-1].setName(products[n-1][m-1].getName()+"(사이즈업)"); // 메뉴이름 Burgers(사이즈업)
        products[n-1][m-1].setPrice(products[n-1][m-1].getPrice()+3.0); // 메뉴 가격 +3.0
    }

    // 구매 화면
    public static void wishList(int n, int m) {
        System.out.println("\n================================================\n");
        System.out.println("\"" + products[n-1][m-1].toString() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        System.out.print("\n여기에 번호를 입력하세요 => ");
    }

    //주문 완료 화면
    static int c;
    public static void orderComplete() throws InterruptedException {
        Order.getTotalWish().addAll(Order.getWish());
        c = sc.nextInt();
        if(c == 1) {
            Order.getWish().clear();
            Order.getCntWish().clear();
            System.out.println("\n================================================\n");
            System.out.println("주문이 완료되었습니다!");
            System.out.println("대기번호는 [ " + (cnt++) +" ] 번 입니다.");
            System.out.println("(3초 후 메뉴판으로 돌아갑니다.) \n");
            Thread.sleep(3000); // 3초 지연
        }
    }

    // 장바구니가 비어있을 때
    public static void emptiedWish() {
        System.out.println("\n================================================\n");
        System.out.println("장바구니가 비어있습니다.");
        System.out.println("메뉴판으로 돌아갑니다\n");
    }

    // 장바구니에 추가
    public static void putInBasket(int n, int m, int k) {
        if (k != 1) {
            System.out.println("취소되었습니다.");
        } else {
            Order.getWish().add(products[n-1][m-1]);
            boolean exists = false;
            //기존 장바구니에 상품이 있는 경우
            for(int i=0; i<Order.getCntWish().size(); i++) {
                if (Order.getCntWish().get(i).toString().equals(Kiosk.products[n-1][m-1].toString())) {
                    exists = true;
                    Product existingProduct = Order.getCntWish().get(i);
                    existingProduct.setCount(existingProduct.getCount() + 1); // 상품의 카운트 +1
                    System.out.println("\n================================================\n");
                    System.out.println(existingProduct.getName() + "가 장바구니에 추가되었습니다.");
                }
            }
            //기존 장바구니에 상품이 없는 경우
            if(!exists) {
                Order.getCntWish().add(products[n-1][m-1]);
                System.out.println("\n================================================\n");
                System.out.println(products[n-1][m-1].getName() + " 가 장바구니에 추가되었습니다.");
            }
        }
    }
}
