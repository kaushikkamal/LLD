package Cricbuzz.Team.Player;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PlayerBowlingController {
    Deque<Player> bowlersList;
    Map<Player, Integer> bowlerVsOverCount;
    Player currentBowler;

    public PlayerBowlingController(List<Player> bowlers) {
        setBowlersList(bowlers);
    }

    private void setBowlersList(List<Player> bowlersList) {
        this.bowlersList = new LinkedList<>();
        bowlerVsOverCount = new HashMap<>();
        for (Player bowler : bowlersList) {
            this.bowlersList.addLast(bowler);
            bowlerVsOverCount.put(bowler, 0);
        }
    }

    public void getNextBowler(int maxOverCountPerBowler) {
        Player player = bowlersList.poll();

        if (bowlerVsOverCount.get(player) + 1 == maxOverCountPerBowler) {
            currentBowler = player;
        } else {
            currentBowler = player;
            bowlersList.addLast(player);
            bowlerVsOverCount.put(player, bowlerVsOverCount.get(player) + 1);
        }
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }
}
