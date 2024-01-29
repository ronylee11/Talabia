package views;

import java.awt.*;
import javax.swing.*;

import models.Board;
import models.File;
import models.Game;
import controllers.BoardController;

// Wong Guang Yu, Lee Rong Yi
@SuppressWarnings("serial")
public class BoardView extends JFrame {
    private Board model;
    private BoardController controller;
    private JButton saveButton; // Added saveButton
    private JButton loadButton; // Added loadButton
    private File file;

    private JLabel roundLabel;
    private JLabel playerTurnLabel;

    // Board
    // 'a6', 'b6', 'c6', 'd6', 'e6', 'f6', 'g6',
    // 'a5', 'b5', 'c5', 'd5', 'e5', 'f5', 'g5',
    // 'a4', 'b4', 'c4', 'd4', 'e4', 'f4', 'g4',
    // 'a3', 'b3', 'c3', 'd3', 'e3', 'f3', 'g3',
    // 'a2', 'b2', 'c2', 'd2', 'e2', 'f2', 'g2',
    // 'a1', 'b1', 'c1', 'd1', 'e1', 'f1', 'g1',

    public BoardView(Board model) {
        super("Talabia Chess");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(6, 7));
        mainPanel.add(boardPanel, BorderLayout.CENTER);

        this.model = model;
        controller = new BoardController(model, this);

        file = new File(this, controller);

        // update Board to specified dimension
        controller.updateBoard(); 
        // generate board notations
        controller.generateBoardNotations(boardPanel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        setSize(model.getDimensionX(), model.getDimensionY());
        // at West, create a column of numbers from 1 to 6 starting bottom
        JPanel numbersPanel = new JPanel();
        numbersPanel.setLayout(new GridLayout(6, 1));
        controller.generateBoardNumbers(numbersPanel);
        mainPanel.add(numbersPanel, BorderLayout.WEST);
        // add padding to the left and right of the numbers panel
        numbersPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        // at South, create a row of letters from a to g starting left
        JPanel lettersPanel = new JPanel();
        lettersPanel.setLayout(new GridLayout(1, 7));
        controller.generateBoardLetters(lettersPanel);
        // mainPanel.add(lettersPanel, BorderLayout.SOUTH);
        bottomPanel.add(lettersPanel);
        // add padding to the top and left of the letters panel
        lettersPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 10, 0));

         // at North, show round number and which player turn
        JPanel roundPanel = new JPanel();
        roundPanel.setLayout(new GridLayout(1, 2));
        roundLabel = new JLabel("Round: " + Game.getRound());
        playerTurnLabel = new JLabel("Player: " + Game.getPlayerTurn());
        roundPanel.add(roundLabel);
        roundPanel.add(playerTurnLabel);
        mainPanel.add(roundPanel, BorderLayout.NORTH);
         // add padding to the top, bottom and left of the round panel
         roundPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 0));

        // at East, show captured pieces if any, else, show nothing and add padding
        JPanel capturedPiecesPanel = new JPanel();
        capturedPiecesPanel.setLayout(new GridLayout(6, 1));
        //controller.generateCapturedPiecesPanel(capturedPiecesPanel);
        mainPanel.add(capturedPiecesPanel, BorderLayout.EAST);
        // add padding to the left and right of the captured pieces panel
        capturedPiecesPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));

        
        JPanel buttonsPanel = new JPanel();

        // Added save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Enter a file name to save the game:", "Save Game",
                    JOptionPane.PLAIN_MESSAGE);
            if (fileName != null && !fileName.trim().isEmpty()) {
                file.saveGame(fileName);
            } else {
                JOptionPane.showMessageDialog(this, "No file name entered.");
            }
        });

        // Added load button
        loadButton = new JButton("Load");
        loadButton.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Enter the file name to load the game from:", "Load Game",
                    JOptionPane.PLAIN_MESSAGE);
            if (fileName != null && !fileName.trim().isEmpty()) {
                file.loadGame(fileName);
            } else {
                JOptionPane.showMessageDialog(this, "No file name entered.");
            }
        });
        buttonsPanel.add(saveButton);
        buttonsPanel.add(loadButton);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 10, 0));
        bottomPanel.add(buttonsPanel);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void repaint() {
        super.validate();
        super.repaint();
        super.pack();
        super.setSize(model.getDimensionX(), model.getDimensionY());
    }

    public void updateRoundAndPlayerLabels() {
        roundLabel.setText("Round: " + Game.getRound());
        playerTurnLabel.setText("Player: " + Game.getPlayerTurn());
    }
}
