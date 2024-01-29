package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import controllers.BoardController;
import views.BoardView;

public class File {
    private BoardView view;
    private BoardController controller;

    public File(BoardView view, BoardController controller) {
        this.view = view;
        this.controller = controller;
    }

    // New method to save the game
    public void saveGame(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"))) {
            for (Piece piece: PieceCoordinate.getPieceCoordinate().getCoordinateMap().values()) {
                if (piece != null) {
                    writer.write(piece.toFileString());
                    writer.newLine();
                }
            }
            // round count 
            writer.write(Game.getCurrentPlayerIndex() + "," + Game.getRoundCount() + "," + Game.getPlayCount());

            JOptionPane.showMessageDialog(view, "Game saved successfully to " + fileName + ".txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(view, "Failed to save the game: " + e.getMessage());
        }
    }

    // New method to load the game
    public void loadGame(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"))) {
            PieceCoordinate.getPieceCoordinate().getCoordinateMap().clear();

            String line;

            while ((line = reader.readLine()) != null) {
                Piece piece = null;
                try {
                    String[] parts = line.split(",");

                    if (parts.length == 3) {
                        Game.setCurrentPlayer(Integer.parseInt(parts[0]));
                        Game.setRoundCount(Integer.parseInt(parts[1]));
                        Game.setPlayCount(Integer.parseInt(parts[2]));
                    }
                        
                    else {
                        // Adjust this based on your Piece class structure
                        String pieceName = parts[0];
                        PieceColor color = PieceColor.valueOf(parts[1]);
                        String coordinate = parts[2];
                        String imageUrl = parts[3];
                        if (parts.length > 4) { // point piece
                            String imageUrl2 = parts[4];
                            String forward = parts[5];
                            String switchDone = parts[6];
                            Point point = new Point(imageUrl, coordinate, color);
                            point.setImageUrl2(imageUrl2);
                            point.setForward(Boolean.valueOf(forward));
                            point.setSwitchDone(Boolean.valueOf(switchDone));
                            PieceCoordinate.getPieceCoordinate().placePiece(coordinate, point);
                    }
                    // Create specific concrete subclasses based on your piece types
                    if ("Sun".equals(pieceName)) 
                        piece = new Sun(imageUrl, coordinate, color); // Replace with your SunPiece constructor

                    else if ("Hourglass".equals(pieceName)) 
                        piece = new Hourglass(imageUrl, coordinate, color); 
                    
                    else if ("Plus".equals(pieceName)) 
                        piece = new Plus(imageUrl, coordinate, color); 
                    
                    else if ("Time".equals(pieceName)) 
                        piece = new Time(imageUrl, coordinate, color); 

                    if (piece != null)
                        PieceCoordinate.getPieceCoordinate().placePiece(coordinate, piece);
                    }
                    
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(view, "Error parsing numbers from the file. Invalid number format: " + e.getMessage());
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(view, "Error accessing array elements. Check the number of elements in the line: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(view, "Error with piece creation: " + e.getMessage());
                }
            }

            controller.updateView();

            JOptionPane.showMessageDialog(view, "Game loaded successfully from " + fileName + ".txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(view, "Failed to load the game: " + e.getMessage());
        }
    }  
}