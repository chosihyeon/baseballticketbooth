package model;

import java.util.ArrayList;

public class Cart {
    // 장바구니에 담긴 항목을 저장하는 리스트
    private ArrayList<CartItem> itemList = new ArrayList<>();

    // 장바구니가 비어 있는지 확인하는 메소드
    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    // 장바구니 항목 리스트를 반환하는 메소드
    public ArrayList<CartItem> getItemList() {
        return itemList;
    }

    // 장바구니에 담긴 항목의 수를 반환하는 메소드
    public int getNumItems() {
        return itemList.size();
    }

    // 특정 인덱스의 항목 정보를 문자열로 반환하는 메소드
    public String getItemInfo(int index) {
        return itemList.get(index).toString();
    }

    // 티켓을 장바구니에 추가하는 메소드
    public void addItem(Ticket ticket) {
        CartItem item = getCartItem(ticket.getMatchId());
        if (item == null) { // 장바구니에 해당 티켓이 없으면 새 항목으로 추가
            itemList.add(new CartItem(ticket));
        } else { // 장바구니에 해당 티켓이 이미 있으면 수량 증가
            item.addAdultQuantity(ticket.getAdultQuantity());
            item.addChildQuantity(ticket.getChildQuantity());
        }
    }

    // 티켓을 기반으로 장바구니 항목을 찾는 메소드
    private CartItem getCartItem(int matchId) {
        for (CartItem item : itemList) {
            if (item.getTicket().getMatchId() == matchId) {
                return item;
            }
        }
        return null; // 해당 티켓을 찾지 못한 경우 null 반환
    }

    // 장바구니를 초기화하는 메소드
    public void resetCart() {
        itemList.clear();
    }

    // 특정 티켓 ID가 장바구니에 있는지 확인하는 메소드
    public boolean isValidItem(int matchId) {
        for (CartItem item : itemList) {
            if (item.getTicket().getMatchId() == matchId) {
                return true;
            }
        }
        return false; // 해당 티켓 ID가 없으면 false 반환
    }

    // 특정 티켓 ID의 항목을 장바구니에서 삭제하는 메소드
    public void deleteItem(int matchId) {
        CartItem item = getCartItem(matchId);
        itemList.remove(item);
    }

    // 특정 티켓 ID의 항목 수량을 업데이트하는 메소드
    public void updateQuantity(int matchId, int adultQuantity, int childQuantity) {
        if (adultQuantity == 0 && childQuantity == 0) {
            deleteItem(matchId); // 수량이 0이면 항목 삭제
        } else {
            CartItem item = getCartItem(matchId);
            if (item != null) {
                item.setAdultQuantity(adultQuantity); // 성인 수량 업데이트
                item.setChildQuantity(childQuantity); // 소인 수량 업데이트
            }
        }
    }

    // 장바구니에 담긴 모든 항목의 총 가격을 계산하는 메소드
    public int getTotalPrice() {
        int totalPrice = 0;
        for (CartItem item : itemList) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}