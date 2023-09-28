package main; // Package declaration

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchEvenNumbersAction implements ActionListener {
    private JFrame menuFrame; // Reference to the menu frame for displaying messages
    private int[] numbers; // An array of numbers to search for even numbers

    // Constructor to initialize the SearchEvenNumbersAction with a menu frame and an array of numbers
    public SearchEvenNumbersAction(JFrame menuFrame, int[] numbers) {
        this.menuFrame = menuFrame; // Initialize the menu frame reference
        this.numbers = numbers; // Initialize the array of numbers
    }

 
    public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog(menuFrame, "Enter an odd number:"); // Prompt the user for input

        try {
            int userInput = Integer.parseInt(input); // Parse the user's input as an integer

            // Check if the user input is an even number between 1 and 10
            if (userInput % 2 == 0 && userInput >= 1 && userInput <= 10) {
                String result = "Even numbers in the array: ";

                // Iterate through the array of numbers and find even numbers
                for (int number : numbers) {
                    if (number % 2 == 0) {
                        result += number + " "; // Add even numbers to the result string
                    }
                }

                // Display the result in a dialog box
                JOptionPane.showMessageDialog(menuFrame, result);
            } else {
                // Display an error message if the input is not a valid even number within the specified range
                JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter an odd number between 1 and 10.");
            }
        } catch (NumberFormatException ex) {
            // Display an error message if the user's input is not a valid number
            JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter a valid number.");
        }
    }
}
