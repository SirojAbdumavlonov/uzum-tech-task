package org.example;

import org.example.library.Book;
import org.example.library.BookService;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // todo: task 1
        String counter = wordCounter("hello world qwerty hello world", 1);
        System.out.println(counter);


        // todo: task 2
        int[] arr = {1, 2, 5, 6, 7, 8};
        String twoPointers = twoSums(arr, 9);
        System.out.println("twoPointers = " + twoPointers);


        // todo: task 3
        BookService bookService = new BookService();

        Book book1 = new Book(UUID.randomUUID(), "Book", "Me");
        Book book2 = new Book(UUID.randomUUID(), "Book-2", "Me");

        bookService.addBook(book1);
        bookService.addBook(book2);

        System.out.println("\nAll books: ");
        bookService.getBooks().forEach(System.out::println);

        UUID bookId2 = book2.getId();

        bookService.removeBook(bookId2);

        System.out.println("\nAll books: ");
        bookService.getBooks().forEach(System.out::println);

        Book book3 = new Book(UUID.randomUUID(), "Book-3", "Who");
        System.out.println("\nbook 3 = " + book3);


        // todo: task 4
        List<Integer> array = sortedArray(Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3));
        System.out.println("array = " + array);
    }


    public static String wordCounter(String str, int n){
        String[] words = str.split(" ");

        Map<String, Integer> wordAndCount = new HashMap<>();

        for (String word : words) {
            if (wordAndCount.containsKey(word)) {
                wordAndCount.put(word, wordAndCount.get(word) + 1); // if word in hashMap, add to it +1 occurrence
            } else {
                wordAndCount.put(word, 1); // else add to hashMap with number 1
            }
        }

        for (Map.Entry<String, Integer> entry : wordAndCount.entrySet()) {
            if (entry.getValue() == n) {
                return entry.getKey();
            }
        }
        return "not found";
    }

    public static String twoSums(int[] sortedNumbers, Integer target) { //two pointers approach
        int left = 0;
        int right = sortedNumbers.length - 1;

        while (left < right) {
            int sum = sortedNumbers[left] + sortedNumbers[right];

            if (sum == target) {
                return String.format("%d+%d=%d", sortedNumbers[left], sortedNumbers[right], target);
            } else if (sum < target) {
                left++; // move from left to right to find greater number
            } else {
                right--; // move from right to left to find less numb
            }
        }
        return "not found";
    }

    public static List<Integer> sortedArray(List<Integer> arr) {

        List<Integer> mutableList = new ArrayList<>(arr);

        if (arr.size() <= 1) {
            return arr;
        }

        int left = 0;
        int right = 1;
        
        int index = mutableList.size();

        while (right < index) {
            if (mutableList.get(left).equals(mutableList.get(right))) {
                mutableList.remove(right);
                index--;

            } else {
                left++;
                right++;
            }
        }
        return mutableList;
    }
}