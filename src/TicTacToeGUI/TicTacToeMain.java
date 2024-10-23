package TicTacToeGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


// Main GUI class
public class TicTacToeMain extends JFrame {
    private MODEL gameModel;
    private CUSTOMBUTTON[] buttons;

    public TicTacToeMain() {
        gameModel = new MODEL();

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        buttons = new CUSTOMBUTTON[9];
        for (int i = 0; i < 9; i++) {
            buttons[i] = new CUSTOMBUTTON(i);
            final int position = i;

            buttons[i].addActionListener(e -> buttonClicked(position));
            add(buttons[i]);
        }

        pack();
        setLocationRelativeTo(null);
    }

    private void buttonClicked(int position) {
        if (gameModel.makeMove(position)) {
            buttons[position].setText(gameModel.isPlayer1Turn() ? "O" : "X");
            buttons[position].setEnabled(false);

            if (gameModel.checkWin()) {
                JOptionPane.showMessageDialog(this,
                        (gameModel.isPlayer1Turn() ? "Spieler 2" : "Spieler 1") + " hat gewonnen!");
                resetGame();
            }
        }
    }

    private void resetGame() {
        gameModel.resetGame();
        for (CUSTOMBUTTON button : buttons) {
            button.setText("");
            button.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TicTacToeMain().setVisible(true);
        });
    }
}