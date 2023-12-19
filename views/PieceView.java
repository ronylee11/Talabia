package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PieceView extends JButton {
    public PieceView() {
        super();
        setPreferredSize(new Dimension(50, 50));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }
}
