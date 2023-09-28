package main; // Package declaration

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteNthElementAction implements ActionListener {
    private JFrame menuFrame; // Reference to the menu frame for displaying messages
    private int[] numbers; // An array of numbers where the element will be deleted

    // Constructor to initialize the DeleteNthElementAction with a menu frame and an array of numbers
    public DeleteNthElementAction(JFrame menuFrame) {
        this.menuFrame = menuFrame; // Initialize the menu frame reference
        this.numbers = new int[10]; // Initialize the array of numbers with size 10
    }

    public void actionPerformed(ActionEvent e) {
        // Ask the user to input 10 numbers separated by spaces
        String input = JOptionPane.showInputDialog(menuFrame, "Enter 10 numbers separated by spaces:");

        try {
        	
            String[] inputArray = input.split(" "); // Split the input into an array of strings
            if (inputArray.length != 10) {
                JOptionPane.showMessageDialog(menuFrame, "Please enter exactly 10 numbers separated by spaces.");
                
                return; // Exit the action if the input does not contain 10 numbers
            }

            for (int i = 0; i < 10; i++) {
                numbers[i] = Integer.parseInt(inputArray[i]); // Parse each input as an integer
            }

            // Ask the user for the index to delete
            String indexInput = JOptionPane.showInputDialog(menuFrame, "Enter the index of the element to delete:");

            try {
                int index = Integer.parseInt(indexInput); // Parse the user's input as an integer

                if (index >= 0 && index < numbers.length) {
                    // Create a new array with one less element than the original array
                    int[] newArray = new int[numbers.length - 1];

                    // Copy elements from the original array to the new array, excluding the element at the specified index
                    for (int i = 0, j = 0; i < numbers.length; i++) {
                        if (i != index) {
                            newArray[j++] = numbers[i];
                        }
                    }

                    // Update the numbers array with the new array
                    numbers = newArray;

                    // Display the updated array
                    StringBuilder result = new StringBuilder("Updated array: ");
                    for (int number : numbers) {
                        result.append(number).append(" ");
                    }
                    JOptionPane.showMessageDialog(menuFrame, result.toString());
                } else {
                    // Display an error message if the index is invalid
                    JOptionPane.showMessageDialog(menuFrame, "Invalid index. Please enter a valid index.");
                }
            } catch (NumberFormatException ex) {
                // Display an error message if the user's input is not valid
                JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter a valid index.");
            }
        } catch (NumberFormatException ex) {
            // Display an error message if the input is not valid
            JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter 10 valid numbers separated by spaces.");
        }
    }
}
