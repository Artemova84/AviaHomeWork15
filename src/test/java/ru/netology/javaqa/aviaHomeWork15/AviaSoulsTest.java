package ru.netology.javaqa.aviaHomeWork15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    @Test
    public void compareToTest() {

        Ticket ticket = new Ticket("Москва", "Сочи", 3500, 11, 13);
        Ticket ticket2 = new Ticket("Москва", "Краснодар", 2100, 9, 11);
        Ticket ticket3 = new Ticket("Казань", "Москва", 4000, 15, 17);
        Ticket ticket4 = new Ticket("Владивосток", "Москва", 7000, 22, 2);
        Ticket ticket5 = new Ticket("Санкт-Петербург", "Белгород", 4500, 12, 14);

        Ticket[] tickets = {ticket, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets);
    }

    @Test
    public void compareToTest2() {

        Ticket ticket = new Ticket("Москва", "Сочи", 3500, 11, 13);
        Ticket ticket2 = new Ticket("Москва", "Краснодар", 2100, 9, 11);
        Ticket ticket3 = new Ticket("Казань", "Москва", 4000, 15, 17);
        Ticket ticket4 = new Ticket("Владивосток", "Москва", 7000, 22, 2);
        Ticket ticket5 = new Ticket("Санкт-Петербург", "Белгород", 4500, 12, 14);

        Ticket[] expected = {ticket2, ticket, ticket3, ticket5, ticket4};
        Ticket[] actual = {ticket2, ticket, ticket3, ticket5, ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void compareToTest3() {

        Ticket ticket = new Ticket("Москва", "Сочи", 3500, 11, 13);
        Ticket ticket2 = new Ticket("Москва", "Краснодар", 2100, 9, 11);

        Assertions.assertEquals(1, ticket.compareTo(ticket2));
    }

    @Test
    public void searchTest() {

        AviaSoulsManager avia = new AviaSoulsManager();

        Ticket ticket = new Ticket("Москва", "Белгород", 3500, 11, 13);
        Ticket ticket2 = new Ticket("Москва", "Белгород", 2100, 9, 11);
        Ticket ticket3 = new Ticket("Москва", "Белгород", 4000, 15, 17);
        Ticket ticket4 = new Ticket("Москва", "Белгород", 7000, 22, 2);
        Ticket ticket5 = new Ticket("Москва", "Белгород", 4500, 12, 14);

        avia.add(ticket);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {ticket2, ticket, ticket3, ticket5, ticket4};
        Ticket[] actual = avia.search("Москва", "Белгород");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TicketTimeComparatorTest() {
        AviaSoulsManager avia = new AviaSoulsManager();
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket ticket = new Ticket("Москва", "Сочи", 3500, 11, 13);
        Ticket ticket2 = new Ticket("Москва", "Краснодар", 2100, 9, 15);

        avia.add(ticket);
        avia.add(ticket2);

        Assertions.assertEquals(-1, comparator.compare(ticket, ticket2));
    }

    @Test
    public void searchAndSortByTest() {
        AviaSoulsManager avia = new AviaSoulsManager();
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket ticket = new Ticket("Москва", "Белгород", 3500, 11, 13);
        Ticket ticket2 = new Ticket("Москва", "Белгород", 2100, 9, 12);
        Ticket ticket3 = new Ticket("Москва", "Белгород", 4000, 2, 22);
        Ticket ticket4 = new Ticket("Москва", "Белгород", 7000, 11, 17);
        Ticket ticket5 = new Ticket("Москва", "Белгород", 4500, 12, 13);

        avia.add(ticket);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {ticket5, ticket, ticket2, ticket4, ticket3};
        Ticket[] actual = avia.searchAndSortBy("Москва", "Белгород", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}



