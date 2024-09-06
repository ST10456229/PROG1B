/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class TicTacToe {
     private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X'; // X starts the game
        initializeBoard();
    }

    // Initialize the game board with empty spaces
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Print the current state of the board
    public void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    // Make a move for the current player
    public boolean makeMove(int row, int col) {
        if (row >= 1 && row <= 3 && col >= 1 && col <= 3 && board[row - 1][col - 1] == ' ') {
            board[row - 1][col - 1] = currentPlayer;
            return true;
        }
        return false;
    }

    // Check if there's a winner
    public boolean checkForWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;

        return false;
    }

    // Check if the board is full
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    // Switch players
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public static void main(String[] args) {
    TicTacToe game = new TicTacToe();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        game.printBoard();
        System.out.println("Player " + game.getCurrentPlayer() + "'s turn");
        System.out.print("Enter row and column (e.g., 1 2): ");

        if (scanner.hasNextInt()) {
            int row = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int col = scanner.nextInt();
                if (game.makeMove(row, col)) {
                    if (game.checkForWin()) {
                        game.printBoard();
                        System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                        break;
                    } else if (game.isBoardFull()) {
                        game.printBoard();
                        System.out.println("The game is a draw!");
                        break;
                    } else {
                        game.switchPlayer();
                    }
                } else {
                    System.out.println("This move is not valid. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter two integers separated by a space.");
                scanner.next(); // Consume the invalid input
            }
        } else {
            System.out.println("Invalid input. Please enter two integers separated by a space.");
            scanner.next(); // Consume the invalid input
        }
    }
    scanner.close();
    }
    }

