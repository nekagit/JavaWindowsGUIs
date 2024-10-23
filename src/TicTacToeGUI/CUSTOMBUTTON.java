package TicTacToeGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Custom button class
public class CUSTOMBUTTON extends JButton {
    private final int position;

    public CUSTOMBUTTON(int position) {
        this.position = position;
        setPreferredSize(new Dimension(100, 100));
        setFont(new Font("Arial", Font.BOLD, 40));
    }

    public int getPosition() {
        return position;
    }
}
