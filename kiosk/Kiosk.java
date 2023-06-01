package kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
    static Scanner sc = new Scanner(System.in);

    static Menu[] menuArr = new Menu[4];
    static Menu[] orderArr = new Menu[2];
    static Product[] burgerArr = new Product[5];
    static Product[] frozenCustardArr = new Product[5];
    static Product[] drinkArr = new Product[5];
    static Product[] beerArr = new Product[2];

    static Product[][] products = {burgerArr, frozenCustardArr, drinkArr, beerArr};

    static int cnt = 1; // 주문 번호 초기화

    //데이터 초기화
    public static void allMenu() {
        // 메인 메뉴판
        menuArr[0] = new Menu("Burgers         ", "앵거스 비프 통살을 다져만든 버거");
        menuArr[1] = new Menu("Forzen Custard  ", "매장에서 신선하게 만드는 아이스크림");
        menuArr[2] = new Menu("Drinks          ", "매장에서 직접 만드는 음료");
        menuArr[3] = new Menu("Beer            ", "뉴욕 브루클린 브루어리에서 양조한 맥주");

        orderArr[0] = new Menu("Order       ", "장바구니를 확인 후 주문합니다.");
        orderArr[1] = new Menu("Cancel      ", "진행중인 주문을 취소합니다.");

        //burger
        burgerArr[0] = new Product("ShackBurger           ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        burgerArr[1] = new Product("SmokeShack            ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        burgerArr[2] = new Product("Shroom Burger         ", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거");
        burgerArr[3] = new Product("Cheeseburger          ", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        burgerArr[4] = new Product("Hamburger             ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        //burger 추가 메뉴
        //custard
        frozenCustardArr[0] = new Product("Shakes                ", 5.9, "바닐라, 초콜렛, 솔티드 카라멜, 스트로베리, 커피");
        frozenCustardArr[1] = new Product("Shake of the Week     ", 6.5, "특별한 커스터드 플레이버");
        frozenCustardArr[2] = new Product("Red Bean Shake        ", 6.5, "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크");
        frozenCustardArr[3] = new Product("Floats                ", 5.9, "루트 비어, 퍼플 카우, 크림시클");
        frozenCustardArr[4] = new Product("Cups & Cones          ", 4.9, "바닐라, 초콜릿, Flavor of the Week");

        //drink
        drinkArr[0] = new Product("Drinks                ", 3.9, "매장에서 직접 만드는 상큼한 레몬에이드");
        drinkArr[1] = new Product("Fresh Brewed Iced Tea ", 3.4, "직접 유기농 홍자를 우려낸 아이스티");
        drinkArr[2] = new Product("Fifty/Fifty           ", 3.5, "레몬에이드와 아이스티의 만남");
        drinkArr[3] = new Product("Fountain Soda         ", 2.7, "콜라, 사이다, 환타");
        drinkArr[4] = new Product("Abita Root Beer       ", 4.4, "미국식 무알콜 탄산음료");

        //beer
        beerArr[0] = new Product("ShackMeister Ale      ", 9.8, "뉴욕 브루클린 브루어리에서 특별히 양조한 예일 맥주");
        beerArr[1] = new Product("Magpie Brewing Co.    ", 6.8, "");
    }

    // 메인 메뉴판 화면 출력
    public static void mainMeun() {
        int i = 0;
        System.out.println("================================================");
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 번호를 입력해주세요.");
        System.out.println("\n[ SHAKESHAKCK MENU ]");
        for (Menu m : menuArr) {
            i++;
            System.out.println(i + ". " + m.getName() + "| " + m.getExplanation());
        }
        System.out.println("\n[ ORDER MENU ]");
        for (Menu o : orderArr) {
            i++;
            System.out.println((i)+". " + o.getName() + "| " + o.getExplanation());
        }
        System.out.print("\n여기에 번호를 입력하세요 => ");
    }

    //상품 메뉴판 화면 출력
    public static void choiceMenu(int n) throws InterruptedException {
        int i=0;
        switch (n) {
            case 0 -> {
                double salePrice = 0.0;
                for (int j = 0; j < Order.totalWish.size(); j++) {  // 총 판매금액 합치기
                    salePrice += Order.totalWish.get(j).getPrice();
                }
                System.out.println("================================================");
                System.out.println("[ 총 판매상품 목록 현황 ]");
                for (Product totalPro : Order.totalWish) {
                    System.out.println("- " + totalPro.getName() + "| " + totalPro.getPrice());
                }
                System.out.println("\n[ 총 판매금액 현황 ]");
                System.out.println("현재까지 총 판매된 금액은 [ W " + (Math.round(salePrice * 10.0) / 10.0) + " ] 입니다.");
                System.out.println("\n1. 돌아가기");
                System.out.print("\n여기에 번호를 입력하세요 => ");
            }
            case 1 -> {
                System.out.println("================================================");
                System.out.println("[ Burgers Menu ]");
                for (Product b : burgerArr) {
                    i++;
                    System.out.println(i + ". " + b.toString());
                }
                System.out.print("\n여기에 번호를 입력하세요 => ");
            }
            case 2 -> {
                System.out.println("================================================");
                System.out.println("[ FrozenCustard Menu ]");
                for (Product b : frozenCustardArr) {
                    i++;
                    System.out.println(i + ". " + b.toString());
                }
                System.out.print("\n여기에 번호를 입력하세요 => ");
            }
            case 3 -> {
                System.out.println("================================================");
                System.out.println("[ Drink Menu ]");
                for (Product b : drinkArr) {
                    i++;
                    System.out.println(i + ". " + b.toString());
                }
                System.out.print("\n여기에 번호를 입력하세요 => ");

            }
            case 4 -> {
                System.out.println("================================================");
                System.out.println("[ Beer Menu ]");
                for (Product b : beerArr) {
                    i++;
                    System.out.println(i + ". " + b.toString());
                }
                System.out.print("\n여기에 번호를 입력하세요 => ");

            }
            case 5 -> { // order
                double total = 0.0;
                System.out.println("================================================");
                System.out.println("아래와 같이 주문하시겠습니까?\n");
                System.out.println("[ Orders ]");
                for (int j = 0; j < Order.cntWish.size(); j++) {
//                    System.out.println(Order.wish.get(j).getName() + "| W "+ Order.wish.get(j).getPrice() + " | " + Order.wish.get(j).getExplanation());
                    System.out.println(Order.cntWish.get(j).toString_cnt());
                }
                for (int j = 0; j < Order.wish.size(); j++) {
                    total += Order.wish.get(j).getPrice();
                }
                System.out.println("\n[ Total ]");
                System.out.println("W " + (Math.round(Order.salePriceTotal() * 10.0) / 10.0));
                System.out.println("\n1. 주문      2. 메뉴판");
                System.out.print("\n여기에 번호를 입력하세요 => ");
            }
            case 6 -> { // cancel
                System.out.println("================================================");
                System.out.println("\n진행하던 주문을 취소하시겠습니까?");
                System.out.println("1. 확인        2. 취소 ");
                System.out.print("\n여기에 번호를 입력하세요 => ");
            }
            default -> {
                System.out.println("================================================");
                System.out.println("번호를 잘못 입력하셨습니다.");
                System.out.println("메인 메뉴로 돌아갑니다.");
            }
        }
    }

    //burgers 추가 옵션
    public static void addOptions(int n, int m) {
        System.out.println("================================================");
        System.out.println(products[n-1][m-1].toString());
        System.out.println("옵션을 추가하시겠습니까?");
        System.out.println("1. 사이즈 업( + W 3.0 )     2. 추가 안함");
        System.out.print("\n여기에 번호를 입력하세요 => ");
    }

    public static void sizeUp(int n, int m, int e) {
        products[n-1][m-1].setName(products[n-1][m-1].getName()+"(사이즈업)"); // 메뉴이름 Burgers(사이즈업)
        products[n-1][m-1].setPrice(products[n-1][m-1].getPrice()+3.0); // 메뉴 가격 +3.0
    }

    // 구매 화면
    public static void wishList(int n, int m) {
        System.out.println("================================================");
        System.out.println("\"" + products[n-1][m-1].toString() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        System.out.print("\n여기에 번호를 입력하세요 => ");
    }

    //주문 완료 화면
    static int c;
    public static void orderComplete() throws InterruptedException {
        Order.totalWish.addAll(Order.wish);
        c = sc.nextInt();
        if(c == 1) {
            Order.wish.clear();
            Order.cntWish.clear();
            System.out.println("================================================");
            System.out.println("주문이 완료되었습니다!");
            System.out.println("대기번호는 [ " + (cnt++) +" ] 번 입니다.");
            System.out.println("(3초 후 메뉴판으로 돌아갑니다.) \n");
            Thread.sleep(3000); // 3초 지연
        }
    }

    // 장바구니가 비어있을 때
    public static void emptiedWish() {
        System.out.println("================================================");
        System.out.println("장바구니가 비어있습니다.");
        System.out.println("메뉴판으로 돌아갑니다\n");
    }

    // 장바구니에 추가
    public static void putInBasket(int n, int m, int k) {
        if (k != 1) {
            System.out.println("취소되었습니다.");
        } else {
            Order.wish.add(products[n-1][m-1]);
            boolean exists = false;
            //기존 장바구니에 상품이 있는 경우
            for(int i=0; i<Order.cntWish.size(); i++) {
                if (Order.cntWish.get(i).toString().equals(Kiosk.products[n-1][m-1].toString())) {
                    exists = true;
                    Product existingProduct = Order.cntWish.get(i);
                    existingProduct.setCount(existingProduct.getCount() + 1); // 상품의 카운트 +1
                    System.out.println(existingProduct.getName() + "가 장바구니에 추가되었습니다.");
                }
            }
            //기존 장바구니에 상품이 없는 경우
            if(!exists) {
                Order.cntWish.add(products[n-1][m-1]);
                System.out.println(products[n-1][m-1].getName() + " 가 장바구니에 추가되었습니다.");
            }
        }
    }
}
