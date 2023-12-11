package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import models.Board;

public class BoardView extends JFrame {
    public BoardView() {
        super("Talabia Chess");

       Board b = new Board(500, 500) ;
        setSize(b.getDimensionX(), b.getDimensionY());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
