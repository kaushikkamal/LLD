package TicTacToeSystem;

import TicTacToeSystem.tictactoe.*;

import java.util.*;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(int size) {
        this.gameBoard = new Board(size);

        players = new LinkedList<>();

        Player player1 = new Player("KKB", new PlayingPieceX());
        Player player2 = new Player("BORAH", new PlayingPieceO());

        players.add(player1);
        players.add(player2);

    }

    public String startGame() {

        boolean noWinner = true;

        while (noWinner) {
            // find the player
            Player playerTurn = players.removeFirst();
            // find empty space is present or not

            List<Pair<Integer, Integer>> freeCells = gameBoard.getFreeCells();

            if (freeCells.isEmpty()) {
                noWinner = false;
                continue;
            }
            gameBoard.printBoard();
            // ask for input for row and col
            Scanner sc = new Scanner(System.in);

            // add validations for row and col
            System.out.println(playerTurn.getName() + " turn");
            System.out.print("Enter row: ");
            int row = sc.nextInt();
            System.out.println("Enter col: ");
            int col = sc.nextInt();

            // after placing the piece, check for winning cases

            boolean isSuccessfullyPlaced = gameBoard.addPiece(row, col, playerTurn.getPlayingPiece());

            if (!isSuccessfullyPlaced) {
                System.out.println("Incorrect row, col value");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean winner = checkForWinner(row, col, playerTurn.getPlayingPiece().getPieceType());

            if (winner) {
                return playerTurn.getName() + " is winner";
            }
        }
        return "DRAW";
    }

    public boolean checkForWinner(int row, int col, PieceType pieceType) {
        int size = gameBoard.getSize();
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // row
        for (int i = 0; i < size; i++) {
            if (gameBoard.getBoard()[row][i] == null || gameBoard.getBoard()[row][i].getPieceType() != pieceType) {
                rowMatch = false;
            }
        }

        // col
        for (int i = 0; i < size; i++) {
            if (gameBoard.getBoard()[i][col] == null || gameBoard.getBoard()[i][col].getPieceType() != pieceType) {
                columnMatch = false;
            }
        }
        // diagonal
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getPieceType() != pieceType) {
                    diagonalMatch = false;
                }
            }
        }
        // Anti-diagonal
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= 0; j--) {
                if (gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getPieceType() != pieceType) {
                    antiDiagonalMatch = false;
                }
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
