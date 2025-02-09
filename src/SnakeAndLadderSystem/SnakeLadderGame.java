package SnakeAndLadderSystem;

import SnakeAndLadderSystem.GameElements.Board;
import SnakeAndLadderSystem.GameElements.Cell;
import SnakeAndLadderSystem.GameElements.Dice;
import SnakeAndLadderSystem.GameElements.Player;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SnakeLadderGame {
    private Board board;
    private Dice dice;
    private Deque<Player> playersList;
    private Player winner;

    public SnakeLadderGame() {
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        playersList = new LinkedList<>();

        Player p1 = new Player("p1", "KKB");
        Player p2 = new Player("p2", "Borah");

        playersList.addAll(Arrays.asList(p1, p2));
    }

    public void startGame() {
        System.out.println();
        System.out.println("##### Game start #####");
        while (winner == null) {
            // find current player
            Player currentPlayer = findPlayerTurn();

            System.out.println("Current player is: " + currentPlayer.getName() + " current position is: " + currentPlayer.getCurrentPosition());

            //roll the dice
            int diceNumber = dice.rollDice();

            System.out.println("Dice -> " + diceNumber);

            int playerNewPosition = currentPlayer.getCurrentPosition() + diceNumber;
            playerNewPosition = checkForJump(playerNewPosition);

            if (playerNewPosition <= board.getBoardSize() * board.getBoardSize() - 1) {
                currentPlayer.setCurrentPosition(playerNewPosition);
                System.out.println("Current player is: " + currentPlayer.getName() + " new position is: " + currentPlayer.getCurrentPosition());
            }

            if (playerNewPosition == board.getBoardSize() * board.getBoardSize() - 1) {
                winner = currentPlayer;
            }

            System.out.println("----------------");
        }
        System.out.println("Winner is: " + winner);
    }

    private int checkForJump(int playerNewPosition) {
        if (playerNewPosition >= board.getBoardSize() * board.getBoardSize()) {
            System.out.println("Out of board range");
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);

        if (!cell.isJumpAvailable()) {
            return playerNewPosition;
        }

        if (cell.getJump().getStart() == playerNewPosition) {
            String jumpBy = cell.getJump().getStart() < cell.getJump().getEnd() ? "Ladder" : "Snake";
            System.out.println("Jump done by: " + jumpBy);
            return cell.getJump().getEnd();
        }
        return playerNewPosition;
    }

    private Player findPlayerTurn() {
        Player currentPlayer = this.playersList.removeFirst();
        this.playersList.addLast(currentPlayer);
        return currentPlayer;
    }
}
