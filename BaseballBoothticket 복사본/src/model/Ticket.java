package model;

public class Ticket {
    int matchId;
    private String date;
    private String time;
    private String homeTeam;
    private String awayTeam;
    private int price;
    private int adultQuantity;
    private int childQuantity;

    public Ticket(int matchId, String date, String time, String homeTeam, String awayTeam, int price, int adultQuantity, int childQuantity) {
        this.matchId = matchId;
        this.date = date;
        this.time = time;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.price = price;
        this.adultQuantity = adultQuantity;
        this.childQuantity = childQuantity;
    }

    public int getMatchId() {
        return matchId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getPrice() {
        return price;
    }

    public int getAdultQuantity() {
        return adultQuantity;
    }

    public void setAdultQuantity(int adultQuantity) {
        this.adultQuantity = adultQuantity;
    }

    public int getChildQuantity() {
        return childQuantity;
    }

    public void setChildQuantity(int childQuantity) {
        this.childQuantity = childQuantity;
    }

    public int getTotalQuantity() {
        return adultQuantity + childQuantity;
    }

    public double getTotalPrice() {
        return (adultQuantity * price) + (childQuantity * (price * 0.5));
    }

    @Override
    public String toString() {
        return "Match ID: " + matchId + ", Date: " + date + ", Time: " + time + ", Home Team: " + homeTeam + ", Away Team: " + awayTeam +
                ", Price: " + price + ", Adult Quantity: " + adultQuantity + ", Child Quantity: " + childQuantity;
    }
}