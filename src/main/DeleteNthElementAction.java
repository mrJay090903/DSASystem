
package main; // Package declaration

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteNthElementAction implements ActionListener {
    private JFrame menuFrame; // Reference to the menu frame for displaying messages
    private int[] numbers; // An array of numbers where the element will be deleted

    // Constructor to initialize the DeleteNthElementAction with a menu frame and an array of numbers
    public DeleteNthElementAction(JFrame menuFrame, int[] numbers) {
        this.menuFrame = menuFrame; // Initialize the menu frame reference
        this.numbers = numbers; // Initialize the array of numbers
    }


    public void actionPerformed(ActionEvent e) {
        // Check if the array contains 10 numbers, as expected
        if (numbers.length != 10) {
            JOptionPane.showMessageDialog(menuFrame, "Please input 10 numbers first.");
            return; // Exit the action if the array does not contain 10 numbers
        }

        String indexInput = JOptionPane.showInputDialog(menuFrame, "Enter the element to delete:"); // Prompt the user for the index to delete

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

                // Display a message indicating the successful deletion
                JOptionPane.showMessageDialog(menuFrame, "Element at index " + index + " deleted.");
            } else {
                // Display an error message if the index is invalid
                JOptionPane.showMessageDialog(menuFrame, "Invalid index. Please enter a valid index.");
            }
        } catch (NumberFormatException ex) {
            // Display an error message if the user's input is not valid
            JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter a valid index.");
        }
    }
}
