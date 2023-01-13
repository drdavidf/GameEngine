package screens;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {
    private int[][] map = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1}, 
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    private JPanel gameField;
    private int playerPoints=0;
    public static int playerLives=3;
    public static String playerName;
    public GameScreen() {
        // Set the layout manager of the JFrame
        setLayout(new BorderLayout());

        // Set the title of the screen
        setTitle("Pacman BSP " + OpeningScreen.playerName);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.black);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        add(topPanel, BorderLayout.NORTH);

        // Create a label for the player's name
        JLabel playerNameLabel = new JLabel("Player Name: " + OpeningScreen.playerName);
        playerNameLabel.setForeground(Color.white);
        playerNameLabel.setFont(new Font("Arial", Font.BOLD, 28));
        topPanel.add(playerNameLabel);

        // Add horizontal glue between the labels
        topPanel.add(Box.createHorizontalGlue());

        // Create a label for the player's points
        JLabel pointsLabel = new JLabel("Points: " + playerPoints);
        pointsLabel.setForeground(Color.white);
        pointsLabel.setFont(new Font("Arial", Font.BOLD, 28));
        topPanel.add(pointsLabel);

        // Add horizontal glue between the labels
        topPanel.add(Box.createHorizontalGlue());

        // Create a label for the player's lives
        JLabel livesLabel = new JLabel("Lives: " + playerLives);
        livesLabel.setForeground(Color.white);
        livesLabel.setFont(new Font("Arial", Font.BOLD, 28));
        topPanel.add(livesLabel);

        
        gameField = new JPanel();
        gameField.setBackground(Color.BLACK);
        gameField.setLayout(new GridLayout(map.length, map[0].length));
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                JPanel cell = new JPanel();
                if (map[i][j] == 1) {
                    cell.setBackground(Color.GRAY);
                } else {
                    cell.setBackground(Color.WHITE);
                }
                gameField.add(cell);
            }
        }
        // Add the game field to the JFrame
        add(gameField, BorderLayout.CENTER);

        // Set the size and location of the screen
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the screen visible
        setVisible(true);

        // Start the game loop here
        // ...
    }
    public void updatePoints(int points) {
    	playerPoints += points;
    }
    public void updateLives() {
    	playerLives--;
    }

    public void update() {
        // Update the game's state
        if (playerLives == 0) {
            // Close the current game screen
            setVisible(false);
            dispose();

            // Open a new game over screen
            GameoverScreen gameOverScreen = new GameoverScreen(playerName, playerPoints);
            gameOverScreen.setVisible(true);
        }
    }
}
