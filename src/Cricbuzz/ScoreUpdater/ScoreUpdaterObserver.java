package Cricbuzz.ScoreUpdater;

import Cricbuzz.Inning.BallDetails;

public interface ScoreUpdaterObserver {
    public void update(BallDetails ballDetails);
}
