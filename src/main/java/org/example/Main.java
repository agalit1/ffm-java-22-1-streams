package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Exercises with streams

public class Main {
    public static void main(String[] args) {

        // Exercise 1
        // Sort numbers
        int[] numbers = new int[] {9, 1, 8, 2, 7, 3, 6, 4, 5};
        Arrays.stream(numbers).sorted().forEach(System.out::println);
        System.out.println();

        // Calculate the sum
        int sum = Arrays.stream(numbers).sum();
        System.out.println("Sum:" + sum + "\n");

        // Find the max. value in the array
        int max = Arrays.stream(numbers).max().getAsInt();
        System.out.println("Max. value: " + max + "\n");

        // Calculate the product
        int product = Arrays.stream(numbers).reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product + "\n");

        // Calculate the average
        double average = Arrays.stream(numbers).average().getAsDouble();
        System.out.println("Average:" + average + "\n");


        // Exercise 2
        // Create a new list to add the lines from "students.csv" file
        List<Student> students = new ArrayList<>();
        // Reading the "students.csv" file line by line
        try {
            Files.lines(Path.of("students.csv"))
                     // Splitting the row into parts on the "," character
                    .map(row -> row.split(","))
                    .skip(1)
                    // deleting the split rows that have less than 4 parts
                    .filter(parts -> parts.length >= 4)
                    // creating students from the parts
                    .map(parts -> new Student(parts[0], parts[1], parts[2], parts[3]))
                    // returning a stream containing only unique values
                    .distinct()
                    // add the students to the list
                    .forEach(students::add);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(students);







    }
}


