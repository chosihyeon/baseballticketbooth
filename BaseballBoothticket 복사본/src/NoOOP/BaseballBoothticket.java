package NoOOP;

import java.io.IOException;
import java.util.Scanner;
import model.Cart;
import model.Customer;
import model.Ticket;
import model.TicketStorage;
import view.ConsoleView;

public class BaseballBoothticket {

    static final int NUM_MENU = 4;

    public static void main(String[] args) throws IOException {
        ConsoleView view = new ConsoleView();
        TicketStorage ticketStorage = new TicketStorage();
        Cart cart = new Cart();
        Customer customer = new Customer();

        view.displayWelcome();

        boolean quit = false;
        while (!quit) {
            String[] menuList = {
                "0. 종료",
                "1. 야구 경기 보기",
                "2. 장바구니 보기",
                "3. 장바구니에 야구경기 티켓 추가",
                "4. 장바구니 비우기"
            };
            int menu = view.selectMenu(menuList);
            switch (menu) {
                case 1:
                    view.displayInfo(ticketStorage);
                    break;
                case 2:
                    view.displayCart(cart);
                    break;
                case 3:
                    int matchId = view.selectTicketId(ticketStorage);
                    int adultQuantity = view.inputQuantity(0, 10);
                    int childQuantity = view.inputQuantity(0, 10);
                    Ticket ticket = ticketStorage.getTicketById(matchId);
                    ticket.setAdultQuantity(adultQuantity);
                    ticket.setChildQuantity(childQuantity);
                    cart.addItem(ticket);
                    break;
                case 4:
                    cart.resetCart();
                    System.out.println("장바구니를 비웠습니다.");
                    break;
                case 0:
                    view.displayOrder(cart, customer);
                    quit = true;
                    break;
                default:
                    System.out.println("없는 메뉴입니다. 0부터 " + (NUM_MENU) + "번까지의 메뉴 중에서 선택하세요.");
            }
        }
    }
}