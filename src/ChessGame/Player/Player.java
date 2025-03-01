package ChessGame.Player;

import ChessGame.PlayerAndPieceType;

public class Player {
    private PlayerAndPieceType playerType;
    private String name;

    public Player(PlayerAndPieceType playerType, String name) {
        this.playerType = playerType;
        this.name = name;
    }

    public Player(PlayerAndPieceType playerType) {
        this.playerType = playerType;
    }

    public PlayerAndPieceType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerAndPieceType playerType) {
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
