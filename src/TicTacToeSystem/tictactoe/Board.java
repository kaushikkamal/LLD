package TicTacToeSystem.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public int getSize() {
        return size;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }

    public boolean addPiece(int row, int col, PlayingPiece piece) {
        if (row >= 0 && row < this.size && col >= 0 && col < this.size && board[row][col] == null) {
            board[row][col] = piece;
            return true;
        }
        return false;
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCellsList = new ArrayList<>();
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (board[row][col] == null) {
                    Pair<Integer, Integer> pair = new Pair<>(row, col);
                    freeCellsList.add(pair);
                }
            }
        }

        return freeCellsList;
    }

    public void printBoard() {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (board[row][col] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(" " + board[row][col].getPieceType().name() + " ");
                }
                if (col != this.size - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }
}
