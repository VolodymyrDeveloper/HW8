package com.cursor;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Library {

    private final Map<LocalDate, ArrayList<String>> libraryReport = new HashMap<>();

    public void getBooksByDate(LocalDate date) {
        List<String> booksName = libraryReport.get(date);
        if (booksName == null) {
            System.out.println("There are no books for this date");
        } else {
            System.out.println(libraryReport.get(date));
        }
    }

    public void takeBook(LocalDate date, String bookName) {
        ArrayList<String> booksName = libraryReport.get(LocalDate.now());
        if (booksName != null) {
            libraryReport.get(LocalDate.now()).add(bookName);
        } else {
            ArrayList<String> books = new ArrayList<>();
            books.add(bookName);
            libraryReport.put(date, books);

        }
    }

    public Map<LocalDate, Integer> getBooksMyMonth(String monthName) {
        Map<LocalDate, Integer> map = new HashMap<>();
        Month month = Month.valueOf(monthName);
        LocalDate localDateNow = LocalDate.now();
        LocalDate dayOfMonth = LocalDate.of(localDateNow.getYear(), month, 1);

        for (int i = 0; i <= month.maxLength(); i++) {

            if (libraryReport.get(dayOfMonth.plusDays(i)) != null) {
                map.put(dayOfMonth.plusDays(i), libraryReport.get(dayOfMonth.plusDays(i)).size());
            } else {
                map.put(dayOfMonth.plusDays(i), 0);
            }
        }
        return map;
    }

    public Collection<ArrayList<String>> getNameBook() {
        return libraryReport.values();
    }

    public Collection<LocalDate> getAllDates() {
        return libraryReport.keySet();
    }
}



