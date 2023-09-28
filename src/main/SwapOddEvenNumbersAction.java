package main; // Package declaration

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SwapOddEvenNumbersAction implements ActionListener {
    private JFrame menuFrame; // Reference to the menu frame for displaying messages

    // Constructor to initialize the SwapOddEvenNumbersAction with a menu frame
    public SwapOddEvenNumbersAction(JFrame menuFrame) {
        this.menuFrame = menuFrame; // Initialize the menu frame reference
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Integer> nums = new ArrayList<>(10); // Create a list to store user-input numbers

        // Loop to collect 10 numbers from the user
        for (int i = 0; i < 10; i++) {
            String input = JOptionPane.showInputDialog(menuFrame, "Enter number " + (i + 1) + ":"); // Prompt the user for input

            try {
                int n = Integer.parseInt(input); // Parse the user's input as an integer
                nums.add(n); // Add the parsed number to the list
            } catch (NumberFormatException ex) {
                // Display an error message if the input is not a valid number and return from the action
                JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter a valid number.");
                return; // Exit the action if the input is not a valid number
            }
        }

        List<Integer> oddnum = new ArrayList<>();
        List<Integer> evennum = new ArrayList<>();

        // Separate odd and even numbers into different lists
        for (int n : nums) {
            if (n % 2 == 0) {
                evennum.add(n); // Add even numbers to the evennum list
            } else {
                oddnum.add(n); // Add odd numbers to the oddnum list
            }
        }

        List<Integer> swapingnum = new ArrayList<>();
        swapingnum.addAll(oddnum); // Add odd numbers first
        swapingnum.addAll(evennum); // Then add even numbers

        // Create a message to display the swapped numbers
        StringBuilder result = new StringBuilder("Swapped numbers: ");
        for (int number : swapingnum) {
            result.append(number).append(" ");
        }

        // Display the result in a dialog box
        JOptionPane.showMessageDialog(menuFrame, result.toString());
    }
}
