/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.miller_analyzeandselectdatastructureslo5;

/**
 *
 * @author bearb
 */

import javax.swing.*; // For GUI
import java.util.*;

public class Miller_AnalyzeAndSelectDataStructureSLO5 {
    // LinkedList to store numbers entered by user
    private LinkedList<Integer> numberList = new LinkedList<>();

    // Separate list to keep the original input order
    private LinkedList<Integer> originalOrder = new LinkedList<>();

    // GUI parts
    private JTextArea displayArea;
    private JTextField inputField;

    // Constructor sets up the GUI
    public Miller_AnalyzeAndSelectDataStructureSLO5() {
        // Create the main window
        JFrame frame = new JFrame("Simple Number Manager");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 

        // Input field for entering numbers
        inputField = new JTextField();
        inputField.setBounds(20, 20, 100, 25);
        frame.add(inputField);

        // Button to add number to the list
        JButton addButton = new JButton("Add");
        addButton.setBounds(130, 20, 80, 25);
        frame.add(addButton);

        // Button to sort the list
        JButton sortButton = new JButton("Sort");
        sortButton.setBounds(220, 20, 80, 25);
        frame.add(sortButton);

        // Button to shuffle the list
        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.setBounds(310, 20, 80, 25);
        frame.add(shuffleButton);

        // Button to reverse the list
        JButton reverseButton = new JButton("Reverse");
        reverseButton.setBounds(20, 60, 100, 25);
        frame.add(reverseButton);

        // Text area to display the list
        displayArea = new JTextArea();
        displayArea.setBounds(20, 100, 360, 140);
        displayArea.setEditable(false);
        frame.add(displayArea);

        // Add functionality to buttons
        addButton.addActionListener(e -> addNumber());
        sortButton.addActionListener(e -> showSorted());
        shuffleButton.addActionListener(e -> showShuffled());
        reverseButton.addActionListener(e -> showReversed());

        // Make the window visible
        frame.setVisible(true);
    }

    // Adds a number to the list if it is valid
    private void addNumber() {
        try {
            int num = Integer.parseInt(inputField.getText());

            if (!numberList.contains(num)) {
                if (numberList.size() < 15) {
                    numberList.add(num); // Add to main list
                    originalOrder.add(num); // Save original order
                    displayArea.setText("Original:\n" + originalOrder.toString());
                } else {
                    displayArea.setText("Max 15 numbers reached.");
                }
            } else {
                displayArea.setText("Duplicate. Not added.");
            }

            inputField.setText(""); // Clear input field
        } catch (NumberFormatException ex) {
            displayArea.setText("Enter a valid number.");
        }
    }

    // Displays the sorted version of the list
    private void showSorted() {
        LinkedList<Integer> sorted = new LinkedList<>(numberList);
        Collections.sort(sorted);
        displayArea.setText("Sorted:\n" + sorted.toString());
    }

    // Displays a shuffled version of the list
    private void showShuffled() {
        LinkedList<Integer> shuffled = new LinkedList<>(numberList);
        Collections.shuffle(shuffled);
        displayArea.setText("Shuffled:\n" + shuffled.toString());
    }

    // Displays the reversed version of the original list
    private void showReversed() {
        LinkedList<Integer> reversed = new LinkedList<>(numberList);
        Collections.reverse(reversed);
        displayArea.setText("Reversed:\n" + reversed.toString());
    }

    // Main method
    public static void main(String[] args) {
        new Miller_AnalyzeAndSelectDataStructureSLO5();
    }
}
