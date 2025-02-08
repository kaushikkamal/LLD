package SnakeAndLadderSystem.GameElements;

public class Cell {
    private Jump jump;

    public Cell(Jump jump) {
        this.jump = jump;
    }

    public boolean isJumpAvailable() {
        return this.jump != null;
    }

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }
}
