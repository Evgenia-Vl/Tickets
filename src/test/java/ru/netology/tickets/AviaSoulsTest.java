package ru.netology.tickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
@Test
public void shouldCompareTickets(){
    AviaSouls manager = new AviaSouls();
    Ticket ticket1 = new Ticket("DME","AER",20_000,10,14);
    Ticket ticket2 = new Ticket("AER","LED",6_000,15,20);
    Ticket ticket3 = new Ticket("SVO","KGD",10_000,8,10);
    Ticket ticket4 = new Ticket("DME","AER",11_000,12,15);
    Ticket ticket5 = new Ticket("EGO","svo",7_000,11,12);
    Ticket ticket6 = new Ticket("SVO","LED",15_000,20,22);
    Ticket ticket7 = new Ticket("DME", "AER", 9_000, 13, 16);
    Ticket ticket8 = new Ticket("DME", "AER", 17_000, 21, 23);
    manager.add(ticket1);
    manager.add(ticket2);
    manager.add(ticket3);
    manager.add(ticket4);
    manager.add(ticket5);
    manager.add(ticket6);
    manager.add(ticket7);
    manager.add(ticket8);

    Ticket[] expected = {ticket7, ticket4, ticket8, ticket1};
    Ticket[] actual = manager.search("DME", "AER");
    Assertions.assertArrayEquals(expected, actual);
}

    @Test
    public void shouldCompareNonexistableTickets(){
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("DME","AER",20_000,10,14);
        Ticket ticket2 = new Ticket("AER","LED",6_000,15,20);
        Ticket ticket3 = new Ticket("SVO","KGD",10_000,8,10);
        Ticket ticket4 = new Ticket("DME","AER",11_000,12,15);
        Ticket ticket5 = new Ticket("EGO","svo",7_000,11,12);
        Ticket ticket6 = new Ticket("SVO","LED",15_000,20,22);
        Ticket ticket7 = new Ticket("DME", "AER", 9_000, 13, 16);
        Ticket ticket8 = new Ticket("DME", "AER", 17_000, 21, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("DME", "LED");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareOneTicket(){
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("DME","AER",20_000,10,14);
        Ticket ticket2 = new Ticket("AER","LED",6_000,15,20);
        Ticket ticket3 = new Ticket("SVO","KGD",10_000,8,10);
        Ticket ticket4 = new Ticket("DME","AER",11_000,12,15);
        Ticket ticket5 = new Ticket("EGO","svo",7_000,11,12);
        Ticket ticket6 = new Ticket("SVO","LED",15_000,20,22);
        Ticket ticket7 = new Ticket("DME", "AER", 9_000, 13, 16);
        Ticket ticket8 = new Ticket("DME", "AER", 17_000, 21, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.search("AER", "LED");
        Assertions.assertArrayEquals(expected, actual);
    }
@Test
    public void shouldCompareTicketsByFlightTimeWithComparator(){
    AviaSouls manager = new AviaSouls();
    Ticket ticket1 = new Ticket("DME","AER",20_000,10,14); //4
    Ticket ticket2 = new Ticket("AER","LED",6_000,15,20);
    Ticket ticket3 = new Ticket("SVO","KGD",10_000,8,10);
    Ticket ticket4 = new Ticket("DME","AER",11_000,12,15); //3
    Ticket ticket5 = new Ticket("EGO","svo",7_000,11,12);
    Ticket ticket6 = new Ticket("SVO","LED",15_000,20,22);
    Ticket ticket7 = new Ticket("DME", "AER", 9_000, 13, 16); //3
    Ticket ticket8 = new Ticket("DME", "AER", 17_000, 21, 23); //2
    manager.add(ticket1);
    manager.add(ticket2);
    manager.add(ticket3);
    manager.add(ticket4);
    manager.add(ticket5);
    manager.add(ticket6);
    manager.add(ticket7);
    manager.add(ticket8);
    Comparator<Ticket> comparator = new TicketTimeComparator();
    Ticket[] expected = {ticket8, ticket4, ticket7, ticket1};
    Ticket[] actual = manager.search("DME", "AER", comparator);
    Assertions.assertArrayEquals(expected, actual);
}

}
