package main; // Package declaration

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class {
    private JFrame frame; // Declare a JFrame for the main window
    private JTextField usernameField; // Text field for entering username
    private JPasswordField passwordField; // Password field for entering password
    private int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Array of numbers
    private JButton button1; // Button for Search Odd Numbers
    private JButton button2; // Button for Search Even Numbers
    private JButton button3; // Button for Search O Numbers
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;

    // Constructor for the Main_class
    public Main_class() {
        frame = new JFrame("Login Program"); // Create a JFrame with the title "Login Program"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application on window close
        frame.setSize(300, 150); // Set the size of the frame
        frame.setLayout(new FlowLayout()); // Use FlowLayout as the layout manager for the frame

        JLabel usernameLabel = new JLabel("Username:"); // Create a label for the username field
        usernameField = new JTextField(15); // Create the username text field with a width of 15 characters
        JLabel passwordLabel = new JLabel("Password:"); // Create a label for the password field
        passwordField = new JPasswordField(15); // Create the password field with a width of 15 characters
        JButton loginButton = new JButton("Login"); // Create a "Login" button

        // Add components to the frame
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);

        // Add an ActionListener to the "Login" button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText(); // Get the entered username
                char[] passwordChars = passwordField.getPassword(); // Get the entered password as an array of characters
                String password = new String(passwordChars); // Convert the password characters to a string

                // Validate the username and password
                boolean loggedIn = login(username, password);

                if (loggedIn) {
                    // Display a success message if login is successful
                    JOptionPane.showMessageDialog(frame, "Login successful. Welcome, " + username + "!");
                    // Close the login frame
                    frame.dispose();
                    // Show the menu
                    showMenu();
                } else {
                    // Display an error message if login fails
                    JOptionPane.showMessageDialog(frame, "Login failed. Invalid username or password.");
                }
            }
        });

        frame.setVisible(true); // Make the frame visible
    }

    // Method to show the menu
    private void showMenu() {
        // Create a menu frame with options numbered from 1 to 10
        JFrame menuFrame = new JFrame("Menu");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application when this frame is closed
        menuFrame.setSize(400, 300); // Set the size of the menu frame
        menuFrame.setLayout(new GridLayout(10, 1)); // Use a grid layout with 10 rows and 1 column for options

        // Create buttons for menu options
        button1 = new JButton("1. Search Odd Numbers");
        button2 = new JButton("2. Search Even Numbers");
        button3 = new JButton("3. Swap Odd and Even Numbers");
        button4 = new JButton("4. Search for the Largest Number");
        button5 = new JButton("5. Search for the Smallest Number");
        button6 = new JButton("6. Swap the Largest and Smallest Numbers");
        button7 = new JButton("7. Delete nth Element");
        button8 = new JButton("8. Insertion of Elements");
        button9 = new JButton("9. Delete Elements Divisible by 3");
        button10 = new JButton("10. Delete Elements Divisible by User Input");

        // Create instances of action classes and attach them to buttons 
        button1.addActionListener(new SearchOddNumbersAction(menuFrame, numbers));
        button2.addActionListener(new SearchEvenNumbersAction(menuFrame, numbers));
        button3.addActionListener(new SwapOddEvenNumbersAction(menuFrame));
        button4.addActionListener(new SearchLargestNumberAction(menuFrame));
        button5.addActionListener(new SearchSmallestNumberAction(menuFrame));
        button6.addActionListener(new SwapLargestSmallestNumbersAction(menuFrame));
        button7.addActionListener(new DeleteNthElementAction(menuFrame, numbers));
        button8.addActionListener(new InsertionOfElementsAction(menuFrame, numbers));

        // Add buttons to the menu frame
        menuFrame.add(button1);
        menuFrame.add(button2);
        menuFrame.add(button3);
        menuFrame.add(button4);
        menuFrame.add(button5);
        menuFrame.add(button6);
        menuFrame.add(button7);
        menuFrame.add(button8);
        menuFrame.add(button9);
        menuFrame.add(button10);

        // Make the menu frame visible
        menuFrame.setVisible(true);
    }

    // Method to validate login credentials
    private boolean login(String username, String password) {
        // Define valid username-password pairs
        String[] validUsernames = {"1", "cope", "barcelona", "belaos", "dacillo", "broqueza"};
        String[] validPasswords = {"1", "admin1", "admin2", "admin3", "admin4", "admin5"};

        // Check if the entered username and password match any of the valid pairs
        for (int i = 0; i < validUsernames.length; i++) {
            if (username.equals(validUsernames[i]) && password.equals(validPasswords[i])) {
                return true; // Match found, login successful
            }
        }

        return false; // No match found, login failed
    }

    // Main method to start the application

 // This code snippet ensures that the GUI is created and updated in a thread-safe manner.
 // The main method is the entry point of the program.
       public static void main(String[] args) {
 // The SwingUtilities.invokeLater() method is used to execute the specified code on the event dispatch thread.
            SwingUtilities.invokeLater(new Runnable() {
 // The run() method is the implementation of the Runnable interface.
        public void run() {
 // Create an instance of the Main_class when the Swing event dispatch thread is ready.
      new Main_class();
 }
 });
 }
}
