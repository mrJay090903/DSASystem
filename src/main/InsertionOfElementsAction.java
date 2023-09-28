package main; // Package declaration

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertionOfElementsAction implements ActionListener {
    private JFrame menuFrame; // Reference to the menu frame for displaying messages
    private int[] numbers; // An array of numbers where the element will be inserted

    // Constructor to initialize the InsertionOfElementsAction with a menu frame and an array of numbers
    public InsertionOfElementsAction(JFrame menuFrame, int[] numbers) {
        this.menuFrame = menuFrame; // Initialize the menu frame reference
        this.numbers = numbers; // Initialize the array of numbers
    }

  
    public void actionPerformed(ActionEvent e) {
        String elementInput = JOptionPane.showInputDialog(menuFrame, "Enter the element to insert:"); // Prompt the user for the element
        String indexInput = JOptionPane.showInputDialog(menuFrame, "Enter the index where you want to insert the element:"); // Prompt the user for the index

        try {
            int element = Integer.parseInt(elementInput); // Parse the user's input as an integer
            int index = Integer.parseInt(indexInput); // Parse the user's input as an integer

            if (index >= 0 && index <= numbers.length) {
                // Create a new array with one more element than the original array
                int[] newArray = new int[numbers.length + 1];

                // Copy elements from the original array to the new array before the specified index
                for (int i = 0; i < index; i++) {
                    newArray[i] = numbers[i];
                }

                // Insert the element at the specified index
                newArray[index] = element;

                // Copy elements from the original array to the new array after the specified index
                for (int i = index; i < numbers.length; i++) {
                    newArray[i + 1] = numbers[i];
                }

                // Update the numbers array with the new array
                numbers = newArray;

                // Display a message indicating the successful insertion
                JOptionPane.showMessageDialog(menuFrame, "Element " + element + " inserted at index " + index + ".");
            } else {
                // Display an error message if the index is invalid
                JOptionPane.showMessageDialog(menuFrame, "Invalid index. Please enter a valid index.");
            }
        } catch (NumberFormatException ex) {
            // Display an error message if the user's input is not valid
            JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter a valid element and index.");
        }
    }
}
