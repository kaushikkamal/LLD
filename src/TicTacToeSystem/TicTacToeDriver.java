package TicTacToeSystem;

public class TicTacToeDriver {
    public static void execute() {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame(3);
        String result = game.startGame();
        System.out.println(result);
    }
}
