package main; // Package declaration

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
        int[] numbers = new int[10]; // Create an array to store user-input numbers

        // Loop to collect 10 numbers from the user
        for (int i = 0; i < 10; i++) {
            String input = JOptionPane.showInputDialog(menuFrame, "Enter number " + (i + 1) + ":"); // Prompt the user for input
            
            try {
                numbers[i] = Integer.parseInt(input); // Parse the user's input as an integer
            } catch (NumberFormatException ex) {
                // Display an error message if the input is not a valid number and return from the action
                JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter a valid number.");
                return; // Exit the action if the input is not a valid number
            }
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
