package screens;

import javax.swing.*;
import java.awt.event.*;

public class GameoverScreen extends JFrame {
    public GameoverScreen(String playerName, int playerPoints) {
        // Set the layout and other properties of the game over screen
        setTitle("Game Over "+playerName);
        // Add a label or other components to display "Game Over"
        JLabel gameOverLabel = new JLabel("Game Over!");
        add(gameOverLabel);

        // Add a label to display the player's name and score
        JLabel playerInfoLabel = new JLabel("The player " + playerName + " has a score of " + playerPoints);
        add(playerInfoLabel);

        // Create a button to go to the next screen
        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current game over screen
                setVisible(false);
                dispose();

                // Open the next screen
                OpeningScreen openingScreen = new OpeningScreen();
                openingScreen.setVisible(true);
            }

        });

        add(playAgainButton);
    }
}