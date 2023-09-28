package main; // Package declaration

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteElementsByDivisibilityAction implements ActionListener {
    private JFrame menuFrame; // Reference to the menu frame for displaying messages
    private int[] numbers; // An array of numbers where elements will be deleted

    // Constructor to initialize the DeleteElementsByDivisibilityAction with a menu frame
    public DeleteElementsByDivisibilityAction(JFrame menuFrame) {
        this.menuFrame = menuFrame; // Initialize the menu frame reference
    }

    public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog(menuFrame, "Enter 10 numbers separated by spaces:"); // Prompt the user for input

        // Split the user's input into an array of strings
        String[] inputNumbers = input.split(" ");

        // Check if the user provided exactly 10 numbers
        if (inputNumbers.length != 10) {
            JOptionPane.showMessageDialog(menuFrame, "Please enter exactly 10 numbers separated by spaces.");
            return; // Exit the action if the input does not contain 10 numbers
        }

        numbers = new int[10]; // Create an array to store user-input numbers

        // Loop to parse and store the 10 numbers
        for (int i = 0; i < 10; i++) {
            try {
                numbers[i] = Integer.parseInt(inputNumbers[i]); // Parse the user's input as an integer
            } catch (NumberFormatException ex) {
                // Display an error message if any input is not a valid number and return from the action
                JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter valid numbers separated by spaces.");
                return; // Exit the action if any input is not a valid number
            }
        }

        // Create a new array to store the non-divisible-by-3 elements
        int[] newArray = new int[numbers.length];
        int newSize = 0; // Variable to keep track of the size of the new array

        // Loop through the original array and copy non-divisible-by-3 elements to the new array
        for (int number : numbers) {
            if (number % 3 != 0) {
                newArray[newSize] = number;
                newSize++;
            }
        }

        // Update the numbers array with the new array (containing non-divisible-by-3 elements)
        numbers = new int[newSize];
        System.arraycopy(newArray, 0, numbers, 0, newSize);

        // Display the updated array
        StringBuilder result = new StringBuilder("Updated array after deleting elements divisible by 3: ");
        for (int number : numbers) {
            result.append(number).append(" ");
        }
        JOptionPane.showMessageDialog(menuFrame, result.toString());
    }
}
