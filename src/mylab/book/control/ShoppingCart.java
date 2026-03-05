package mylab.book.control;

import java.util.ArrayList;
import java.util.List;
import mylab.book.entity.*;

public class ShoppingCart {
    private List<Publication> items = new ArrayList<>();

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.run();
    }

    public void run() {
        addItem(new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"));
        addItem(new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"));
        addItem(new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"));
        addItem(new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"));
        addItem(new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"));

        displayCart();
        printStatistics();

        removeItem("빠삐용");
        displayCart();
    }

    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
    }

    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다.");
                return true;
            }
        }
        return false;
    }

    public void displayCart() {
        System.out.println("====== 장바구니 내용 ======");
        int total = 0;
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getTitle() + " - " + items.get(i).getPrice() + "원");
            total += items.get(i).getPrice();
        }
        System.out.println("총 가격: " + total + "원");
        System.out.println("할인 적용 가격: " + calculateDiscountedPrice() + "원");
    }

    public int calculateDiscountedPrice() {
        int discountedTotal = 0;
        for (Publication p : items) {
            if (p instanceof Magazine) discountedTotal += p.getPrice() * 0.9;
            else if (p instanceof Novel) discountedTotal += p.getPrice() * 0.85;
            else if (p instanceof ReferenceBook) discountedTotal += p.getPrice() * 0.8;
            else discountedTotal += p.getPrice();
        }
        return discountedTotal;
    }

    public void printStatistics() {
        int mag = 0, nov = 0, ref = 0;
        for (Publication p : items) {
            if (p instanceof Magazine) mag++;
            else if (p instanceof Novel) nov++;
            else if (p instanceof ReferenceBook) ref++;
        }
        System.out.println("====== 장바구니 통계 ======");
        System.out.println("잡지: " + mag + "권");
        System.out.println("소설: " + nov + "권");
        System.out.println("참고서: " + ref + "권");
        System.out.println("총 출판물: " + items.size() + "권");
    }
}
