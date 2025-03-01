package ChessGame;

import ChessGame.Piece.KnightPiece;
import ChessGame.Piece.PawnPiece;
import ChessGame.Player.Player;

import java.util.Deque;

public class Board {
    private Cell[][] cells;
    private Deque<Player> playerList;

    public Board() {
        this.cells = new Cell[8][8];

        Player p1 = new Player(PlayerAndPieceType.WHITE, "Kaushik");
        Player p2 = new Player(PlayerAndPieceType.BLACK, "Borah");

        this.playerList.add(p1);
        this.playerList.add(p2);

        initializeCells();

    }

    private void initializeCells() {
        // paws rows
        // 1, 7

        for (int col = 0; col < 8; col++) {
            cells[1][col] = new Cell(1, col, new PawnPiece(PlayerAndPieceType.BLACK));
            cells[6][col] = new Cell(6, col, new PawnPiece(PlayerAndPieceType.WHITE));
        }

        cells[0][1] = new Cell(0, 1, new KnightPiece(PlayerAndPieceType.BLACK));
        cells[7][1] = new Cell(7, 1, new KnightPiece(PlayerAndPieceType.WHITE));
    }
}
