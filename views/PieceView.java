package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PieceView extends JButton {
    static int pieceSpawned = 0; // max: 28

    public PieceView() {
        super(new ImageIcon("assets/arrow-y.jpg"));
        // add image

        setPreferredSize(new Dimension(50, 50));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }
}
