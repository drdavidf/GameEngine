package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OpeningScreen extends JFrame {
    private JLabel titleLabel;
    private JTextField nameField;
    private JButton startButton;
    private JLabel nameLabel;
    public static String playerName;


    public OpeningScreen() {
        // Set the layout manager of the JFrame
        setLayout(new GridBagLayout());
        // Set the background color of the JFrame
        getContentPane().setBackground(new Color(64,64,64));

        // Set the title of the screen
        setTitle("Pacman BSP");

        // Create a label for the title
        titleLabel = new JLabel("PACMAN");
        titleLabel.setForeground(new Color(255, 255, 0));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5,5,5,5);
        add(titleLabel, gbc);

        // Create a label for the player's name
        nameLabel = new JLabel("Write your name:");
        nameLabel.setVisible(true);
        nameField = new JTextField();
        nameField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                nameLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                nameLabel.setVisible(true);
            }
        });

        // Create a text field for the player's name
        nameField.setColumns(10);
        nameField.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5,5,5,5);
        add(nameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(nameField, gbc);

        // Create a button to start the game
        startButton = new JButton("Start Game");
        startButton.setBackground(new Color(0, 255, 0));
        startButton.setForeground(Color.BLACK);
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerName = nameField.getText();
                // Start the game here
                setVisible(false);  
                dispose();
                new GameScreen();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(startButton, gbc);
        // Set the size and location of the screen
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Make the screen visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new OpeningScreen();
    }
}