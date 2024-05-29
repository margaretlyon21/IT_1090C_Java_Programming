package Lab_10_Tic_Tac_Toe;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        //declare variables
        Scanner in = new Scanner(System.in);
        String currentPlayer = "X";
        int row, col;

        //while the user still wants to continue
        do {
            clearBoard();
            //while the game is not over yer
            while (!isTie() && !isWin("X") && !isWin("O")) {
                //show the board
                display();
                boolean validMove;
                do {
                    //get the riw and column from the user
                    row = SafeInput.getRangedInt(in, currentPlayer + ": Enter the row you would like to play ", 1, 3) - 1;
                    col = SafeInput.getRangedInt(in, currentPlayer + ": Enter the column you would like to play ", 1, 3) - 1;
                    //check if the move was valid
                    validMove = isValidMove(row, col);
                    if (!validMove) {
                        System.out.println("That is not a valid move! Try again!");
                    }
                } while (!validMove);
                //add the move to the board
                board[row][col] = currentPlayer;
                //toggle player - ternary expression
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            }
            //show the board
            display();
            //check if its a tie or a win
            if (isTie()) {
                System.out.println("It's a tie!");
            } else {
                System.out.println((currentPlayer.equals("X") ? "O" : "X") + " Wins!");
            }
            //check if the user wants to play again
        } while (SafeInput.getYNConfirm(in, "Do you want to play again?"));
    }

    //all our variables and expressions
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];

    //clearBoard sets all the spaves back to null
    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }

    //display shows the board
    private static void display() {
        System.out.println("Current Board:");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
    }

    //checks if there is alreadu something in the space
    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    //checks if any of the win conditions are met
    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }

    //checks if a column is made
    private static boolean isColWin(String player) {
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    //checks if there is a row win
    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    //checks if it is a diaganol win
    private static boolean isDiagonalWin(String player) {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        return false;
    }

    //checks if it is a tie
    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return !isWin("X") && !isWin("O");
    }
}
