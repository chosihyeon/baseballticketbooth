package Controller;

import java.util.Scanner;

public class BaseBallTicketController {
	 static String[][] baseballMatchList = {
	            {"ID2401", "240614", "18:30", "한화", "SSG"},
	            {"ID2402", "240615", "17:00", "한화", "SSG"},
	            {"ID2403", "240616", "17:00", "한화", "SSG"}
	    };
	    static int[] cartList = {0, 0, 0};
	    static int numCartItem = 0;

	    public static void main(String[] args) {
	        welcome();
	        boolean quit = false;
	        while (!quit) {
	            int choice = menuList();
	            switch (choice) {
	                case 0:
	                    quit = true;
	                    break;
	                case 1:
	                    matchList();
	                    break;
	                case 2:
	                    viewCart();
	                    break;
	                case 3:
	                    addTicketCart();
	                    break;
	                case 4:
	                    deleteTicketCart();
	                    break;
	                case 5:
	                    cartPeopleChange();
	                    break;
	                case 6:
	                    clearCart();
	                    break;
	                case 7:
	                    buy();
	                    break;
	                case 8:
	                    adminMode();
	                    break;
	                default:
	                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
	            }
	        }
	    }

	    static void welcome() {
	   
	        System.out.println(">>한화이글스 야구 경기 목록⚾");
	        System.out.println("づ￣ 3￣)づ(づ￣ 3￣)づ");
	    }

	    static int menuList() {
	        Scanner input = new Scanner(System.in);
	        System.out.println("\nづ￣ 3￣)づ(づ￣ 3￣)づ");
	        System.out.println("0. 종료");
	        System.out.println("1. 야구 경기 보기");
	        System.out.println("2. 장바구니 보기");
	        System.out.println("3. 장바구니에 경기 티켓 추가");
	        System.out.println("4. 장바구니에서 경기 티켓 삭제");
	        System.out.println("5. 장바구니 인원수 변경");
	        System.out.println("6. 장바구니 비우기");
	        System.out.println("7. 예매");
	        System.out.println("8. 관리자 모드");
	        System.out.println("づ￣ 3￣)づ(づ￣ 3￣)づ");
	        System.out.print("\n메뉴 선택: ");
	        return input.nextInt();
	    }

	    static void matchList() {
	        System.out.println(">> 야구 경기 목록:");
	        for (String[] match : baseballMatchList) {
	            System.out.printf("ID: %s, 날짜: %s, 시간: %s, 팀: %s vs %s\n",
	                    match[0], match[1], match[2], match[3], match[4]);
	        }
	    }

	    static void viewCart() {
	        System.out.println(">> 장바구니 내용:");
	        for (int i = 0; i < cartList.length; i++) {
	            if (cartList[i] > 0) {
	                System.out.printf("경기 ID: %s, 티켓 수량: %d\n",
	                        baseballMatchList[i][0], cartList[i]);
	            }
	        }
	    }

	    static void addTicketCart() {
	        Scanner input = new Scanner(System.in);
	        System.out.print("추가할 경기 ID 입력: ");
	        String id = input.next();
	        System.out.print("티켓 수량 입력: ");
	        int quantity = input.nextInt();
	        boolean matchFound = false;
	        for (int i = 0; i < baseballMatchList.length; i++) {
	            if (baseballMatchList[i][0].equals(id)) {
	                cartList[i] += quantity;
	                numCartItem += quantity;
	                matchFound = true;
	                System.out.println("장바구니에 추가되었습니다.");
	                break;
	            }
	        }
	        if (!matchFound) {
	            System.out.println("해당 ID의 경기를 찾을 수 없습니다.");
	        }
	    }

	    static void deleteTicketCart() {
	        Scanner input = new Scanner(System.in);
	        System.out.print("삭제할 경기 ID 입력: ");
	        String id = input.next();
	        boolean matchFound = false;
	        for (int i = 0; i < baseballMatchList.length; i++) {
	            if (baseballMatchList[i][0].equals(id)) {
	                numCartItem -= cartList[i];
	                cartList[i] = 0;
	                matchFound = true;
	                System.out.println("장바구니에서 삭제되었습니다.");
	                break;
	            }
	        }
	        if (!matchFound) {
	            System.out.println("해당 ID의 경기를 찾을 수 없습니다.");
	        }
	    }

	    static void cartPeopleChange() {
	        Scanner input = new Scanner(System.in);
	        System.out.print("변경할 경기 ID 입력: ");
	        String id = input.next();
	        System.out.print("변경할 티켓 수량 입력: ");
	        int newQuantity = input.nextInt();
	        boolean matchFound = false;
	        for (int i = 0; i < baseballMatchList.length; i++) {
	            if (baseballMatchList[i][0].equals(id)) {
	                numCartItem = numCartItem - cartList[i] + newQuantity;
	                cartList[i] = newQuantity;
	                matchFound = true;
	                System.out.println("티켓 수량이 변경되었습니다.");
	                break;
	            }
	        }
	        if (!matchFound) {
	            System.out.println("해당 ID의 경기를 찾을 수 없습니다.");
	        }
	    }

	    static void clearCart() {
	        for (int i = 0; i < cartList.length; i++) {
	            cartList[i] = 0;
	        }
	        numCartItem = 0;
	        System.out.println("장바구니가 비워졌습니다.");
	    }


	    static void buy() {
	        if (numCartItem == 0) {
	            System.out.println("장바구니가 비어있습니다. 티켓을 추가하세요.");
	        } else {
	            System.out.println("구매가 완료되었습니다. 즐거운 관람 되세요!");
	            clearCart();
	        }
	    }

	    static void adminMode() {
	        System.out.println("관리자 모드 기능은 아직 구현되지 않았습니다.");
	    }
	}


