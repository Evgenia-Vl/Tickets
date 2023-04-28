package ru.netology.tickets;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
    int flightTime1 = o1.getTimeTo() - o1.getTimeFrom();
    int flightTime2 = o2.getTimeTo() - o2.getTimeFrom();

    return flightTime1 - flightTime2;

    }

}
