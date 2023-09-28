package main; // Package declaration

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchEvenNumbersAction implements ActionListener {
    private JFrame menuFrame; // Reference to the menu frame for displaying messages
    private int[] numbers; // An array of numbers to search for odd numbers

    // Constructor to initialize the SearchOddNumbersAction with a menu frame and an array of numbers
    public SearchEvenNumbersAction(JFrame menuFrame, int[] numbers) {
        this.menuFrame = menuFrame; // Initialize the menu frame reference
        this.numbers = numbers; // Initialize the array of numbers
    }

    
    public void actionPerformed(ActionEvent e) {
        // Prompt the user to enter 10 numbers separated by spaces
        String input = JOptionPane.showInputDialog(menuFrame, "Enter 10 numbers separated by spaces:");

        try {
            // Split the user's input into an array of strings
            String[] numberStrings = input.split(" ");

            // Check if the user provided exactly 10 numbers
            if (numberStrings.length == 10) {
                // Parse the input strings into integers and store them in the numbers array
                for (int i = 0; i < 10; i++) {
                    numbers[i] = Integer.parseInt(numberStrings[i]);
                }

                String result = "Odd numbers in the array: ";

                // Iterate through the array of numbers and find odd numbers
                for (int number : numbers) {
                    if (number % 2 == 0) {
                        result += number + " "; // Add odd numbers to the result string
                    }
                }

                // Display the result in a dialog box
                JOptionPane.showMessageDialog(menuFrame, result);
            } else {
                // Display an error message if the user did not provide exactly 10 numbers
                JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter exactly 10 numbers.");
            }
        } catch (NumberFormatException ex) {
            // Display an error message if the user's input is not valid numbers
            JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter valid numbers.");
        }
    }
}
