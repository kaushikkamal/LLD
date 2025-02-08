package SnakeAndLadderSystem.GameElements;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int boardSize;
    private Cell[][] cell;

    public Board(int boardSize, int numberOfSnake, int numOfLadder) {
        this.boardSize = boardSize;
        initializeBoard(boardSize);
        addSnakeToBoard(numberOfSnake);
        addLadderToBoard(numOfLadder);
    }


    private void initializeBoard(int boardSize) {
        this.cell = new Cell[boardSize][boardSize];

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                this.cell[row][col] = new Cell(null);
            }
        }
    }

    private void addSnakeToBoard(int numberOfSnake) {
        int snakeAdded = 0;

        System.out.println("///// Snake's positions start /////");

        while (snakeAdded < numberOfSnake) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, (this.boardSize * this.boardSize) - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(0, snakeHead);

            if (snakeHead <= snakeTail) {
                continue;
            }

            System.out.println("Snake " + (snakeAdded + 1) + ": Head -> " + snakeHead + " Tail-> " + snakeTail);

            Jump jump = new Jump(snakeHead, snakeTail);

            Cell targetCell = getCell(snakeHead);
            targetCell.setJump(jump);

            snakeAdded++;
        }
        System.out.println("///// Snake's positions end /////");
    }

    private void addLadderToBoard(int numOfLadder) {
        int ladderAdded = 0;

        System.out.println("///// Ladder's positions start /////");
        while (ladderAdded < numOfLadder) {
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, (this.boardSize * this.boardSize) - 1);
            int ladderStart = ThreadLocalRandom.current().nextInt(0, ladderEnd);

            if (ladderStart >= ladderEnd) {
                continue;
            }

            System.out.println("Ladder " + (ladderAdded + 1) + ": Start -> " + ladderStart + " End-> " + ladderEnd);

            Jump jump = new Jump(ladderStart, ladderEnd);

            Cell targetCell = getCell(ladderStart);
            targetCell.setJump(jump);

            ladderAdded++;
        }
        System.out.println("///// Ladder's positions end /////");
    }

    public Cell getCell(int playerPosition) {
        int row = playerPosition / this.boardSize;
        int col = playerPosition % this.boardSize;

        return cell[row][col];
    }

    public int getBoardSize() {
        return boardSize;
    }
}
