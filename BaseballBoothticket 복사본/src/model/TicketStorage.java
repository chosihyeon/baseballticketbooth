package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TicketStorage {
    private ArrayList<Ticket> ticketList = new ArrayList<>();
    private final String TicketFilename = "ticketlist.txt";

    public TicketStorage() throws IOException {
        loadTicketListFromFile();
    }

    private void loadTicketListFromFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(TicketFilename))) {
            String line;
            while ((line = br.readLine()) != null) {
                int matchId = Integer.parseInt(line);
                String date = br.readLine();
                String time = br.readLine();
                String homeTeam = br.readLine();
                String awayTeam = br.readLine();
                int price = Integer.parseInt(br.readLine());
                int adultQuantity = Integer.parseInt(br.readLine());
                int childQuantity = Integer.parseInt(br.readLine());
                ticketList.add(new Ticket(matchId, date, time, homeTeam, awayTeam, price, adultQuantity, childQuantity));
            }
        }
    }

    public int getNumTickets() {
        return ticketList.size();
    }

    public String getTicketInfo(int index) {
        return ticketList.get(index).toString();
    }

    public boolean isValidTicket(int matchId) {
        for (Ticket ticket : ticketList) {
            if (ticket.getMatchId() == matchId) {
                return true;
            }
        }
        return false;
    }

    public Ticket getTicketById(int matchId) {
        for (Ticket ticket : ticketList) {
            if (ticket.getMatchId() == matchId) {
                return ticket;
            }
        }
        return null;
    }
}