package ChessGame.Piece;

import ChessGame.Cell;
import ChessGame.PlayerAndPieceType;

public abstract class Piece {

    private PlayerAndPieceType color;

    public Piece(PlayerAndPieceType color) {
        this.color = color;
    }

    abstract public void move(Cell start, Cell end);
}
