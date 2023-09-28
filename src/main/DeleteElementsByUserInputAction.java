package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteElementsByUserInputAction implements ActionListener {
    private JFrame menuFrame; // Reference to the menu frame for displaying messages
    private int[] numbers; // An array of numbers where elements will be deleted

    // Constructor to initialize the DeleteElementsByUserInputAction with a menu frame and an array of numbers
    public DeleteElementsByUserInputAction(JFrame menuFrame, int[] numbers) {
        this.menuFrame = menuFrame; // Initialize the menu frame reference
        this.numbers = numbers; // Initialize the array of numbers
    }

    public void actionPerformed(ActionEvent e) {
        int[] newArray = new int[numbers.length];
        int newSize = 0; // Variable to keep track of the size of the new array

        // Prompt the user to enter 10 numbers separated by spaces
        String input = JOptionPane.showInputDialog(menuFrame, "Enter 10 numbers separated by spaces:");
        String[] inputNumbers = input.split(" "); // Split the input string into an array of numbers

        // Check if the user entered exactly 10 numbers
        if (inputNumbers.length != 10) {
            JOptionPane.showMessageDialog(menuFrame, "Please enter exactly 10 numbers separated by spaces.");
            return; // Exit the action if the input is not valid
        }

        // Convert the input strings into integers and store them in the numbers array
        try {
            for (int i = 0; i < inputNumbers.length; i++) {
                int number = Integer.parseInt(inputNumbers[i]);
                numbers[i] = number;
            }
        } catch (NumberFormatException ex) {
            // Display an error message if any of the inputs are not valid numbers
            JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter valid numbers.");
            return; // Exit the action if there are invalid inputs
        }

        String userInput = JOptionPane.showInputDialog(menuFrame, "Enter a number to delete elements divisible by it:"); // Prompt the user for the divisor

        try {
            int divisor = Integer.parseInt(userInput); // Parse the user's input as an integer

            // Loop through the original array and copy non-divisible elements to the new array
            for (int number : numbers) {
                if (number % divisor != 0) {
                    newArray[newSize] = number;
                    newSize++;
                }
            }

            // Update the numbers array with the new array (containing non-divisible elements)
            numbers = new int[newSize];
            System.arraycopy(newArray, 0, numbers, 0, newSize);

            // Display the updated array
            StringBuilder result = new StringBuilder("Updated array after deleting elements divisible by " + divisor + ": ");
            for (int number : numbers) {
                result.append(number).append(" ");
            }
            JOptionPane.showMessageDialog(menuFrame, result.toString());
        } catch (NumberFormatException ex) {
            // Display an error message if the user's input is not a valid number
            JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter a valid number.");
        }
    }
}
