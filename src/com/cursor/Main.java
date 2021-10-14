package com.cursor;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        library.takeBook(LocalDate.of(2021, 10, 13), "Book1");
        library.takeBook(LocalDate.of(2021, 10, 14), "Book2");
        library.takeBook(LocalDate.of(2021, 10, 15), "Book3");
        library.takeBook(LocalDate.of(2021, 10, 15), "Book4");

        System.out.println("Search on the map by dates:");
        library.getBooksByDate(LocalDate.of(2021, 10, 14));
        library.getBooksByDate(LocalDate.of(2021, 10, 10));


        System.out.println("Range of names of taken books:" + library.getNameBook());
        System.out.println("Range of dates of taken books:" + library.getAllDates());

        System.out.println("Range of dates for ONE month" + library.getBooksMyMonth(Month.OCTOBER.name()));

    }
}