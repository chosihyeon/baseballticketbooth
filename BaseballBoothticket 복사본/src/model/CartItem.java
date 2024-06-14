package model;

public class CartItem {
    Ticket ticket;

    public CartItem(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void addAdultQuantity(int quantity) {
        ticket.setAdultQuantity(ticket.getAdultQuantity() + quantity);
    }

    public void addChildQuantity(int quantity) {
        ticket.setChildQuantity(ticket.getChildQuantity() + quantity);
    }

    public void setAdultQuantity(int quantity) {
        ticket.setAdultQuantity(quantity);
    }

    public void setChildQuantity(int quantity) {
        ticket.setChildQuantity(quantity);
    }

    public double getPrice() {
        return ticket.getTotalPrice();
    }

    @Override
    public String toString() {
        return ticket.toString();
    }
}