package TicTacToeGUI;
// Model class for Tic-Tac-Toe game logic
public class MODEL {
    private char[][] board;
    private boolean player1Turn;

    public MODEL() {
        board = new char[3][3];
        resetGame();
    }

    public void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        player1Turn = true;
    }

    public boolean makeMove(int position) {
        int row = position / 3;
        int col = position % 3;

        if (board[row][col] == ' ') {
            board[row][col] = player1Turn ? 'X' : 'O';
            player1Turn = !player1Turn;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    public boolean isPlayer1Turn() {
        return player1Turn;
    }
}
