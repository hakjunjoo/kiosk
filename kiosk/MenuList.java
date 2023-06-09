package kiosk;

public class MenuList {
    private static Menu[] menuArr = new Menu[4];
    private static Menu[] orderArr = new Menu[2];
    private static Product[] burgerArr = new Product[5];
    private static Product[] frozenCustardArr = new Product[5];
    private static Product[] drinkArr = new Product[5];
    private static Product[] beerArr = new Product[2];

    public static void menuData() {
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

    public static Product[] getBurgerArr() {
        return burgerArr;
    }

    public static Product[] getFrozenCustardArr() {
        return frozenCustardArr;
    }

    public static Product[] getDrinkArr() {
        return drinkArr;
    }

    public static Product[] getBeerArr() {
        return beerArr;
    }

    public static Menu[] getMenuArr() {
        return menuArr;
    }

    public static Menu[] getOrderArr() {
        return orderArr;
    }
}


