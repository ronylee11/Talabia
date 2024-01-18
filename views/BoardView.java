package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import models.Board;
import controllers.BoardController;
import controllers.PieceController;
import controllers.PieceControllerFactory;

@SuppressWarnings("serial")
public class BoardView extends JFrame implements ActionListener {
    private Board model;
    private BoardController controller;

    // Board
    // 'a6', 'b6', 'c6', 'd6', 'e6', 'f6', 'g6',
    // 'a5', 'b5', 'c5', 'd5', 'e5', 'f5', 'g5',
    // 'a4', 'b4', 'c4', 'd4', 'e4', 'f4', 'g4',
    // 'a3', 'b3', 'c3', 'd3', 'e3', 'f3', 'g3',
    // 'a2', 'b2', 'c2', 'd2', 'e2', 'f2', 'g2',
    // 'a1', 'b1', 'c1', 'd1', 'e1', 'f1', 'g1',

    public BoardView(Board model) {
        super("Talabia Chess");
        JPanel p = new JPanel();
        add(p);

        this.model = model;
        controller = new BoardController(model, this);

        // update Board to specified dimension
        controller.updateBoard(); 
        // generate board notations
        controller.generateBoardNotations(p);

        p.setLayout(new GridLayout(6, 7));
        setSize(model.getDimensionX(), model.getDimensionY());
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

    public void actionPerformed(ActionEvent e) {
        controller.resetIcon();
        PieceView btn = (PieceView) e.getSource();
        System.out.println("Button clicked! This button is " + btn.getCoordinate());

        PieceController pieceController = PieceControllerFactory.getController(btn.getCoordinate(), btn);
        pieceController.getPossibleMove();
        controller.addHint();
        
    }
}
