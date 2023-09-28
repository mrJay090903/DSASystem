package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchLargestNumberAction implements ActionListener {
    private JFrame menuFrame; // Reference to the menu frame for displaying messages

    // Constructor to initialize the SearchLargestNumberAction with a menu frame
    public SearchLargestNumberAction(JFrame menuFrame) {
        this.menuFrame = menuFrame; // Initialize the menu frame reference
    }

    public void actionPerformed(ActionEvent e) {
        // Prompt the user to enter 10 numbers separated by spaces
        String input = JOptionPane.showInputDialog(menuFrame, "Enter 10 numbers separated by spaces:");

        // Split the input string into an array of numbers
        String[] inputNumbers = input.split(" ");

        // Check if the user entered exactly 10 numbers
        if (inputNumbers.length != 10) {
            JOptionPane.showMessageDialog(menuFrame, "Please enter exactly 10 numbers separated by spaces.");
            return; // Exit the action if the input is not valid
        }

        int[] numbers = new int[10]; // Create an array to store user-input numbers

        try {
            // Convert the input strings into integers and store them in the numbers array
            for (int i = 0; i < inputNumbers.length; i++) {
                int number = Integer.parseInt(inputNumbers[i]);
                numbers[i] = number;
            }
        } catch (NumberFormatException ex) {
            // Display an error message if any of the inputs are not valid numbers
            JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter valid numbers.");
            return; // Exit the action if there are invalid inputs
        }

        int largest = numbers[0]; // Assume the first number is the largest

        // Loop to find the largest number among the user-input numbers
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i]; // Update the largest number if a larger one is found
            }
        }

        // Display the largest number in a dialog box
        JOptionPane.showMessageDialog(menuFrame, "The largest number is: " + largest);
    }
}
