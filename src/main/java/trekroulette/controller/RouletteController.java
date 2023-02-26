package trekroulette.controller;

import trekroulette.entity.*;
import java.util.List;

public class RouletteController {
    private int maximumEpisodeId = 0;
    private int randomEpisodeId = 0;

    public int getRecommendation(List<Episode> library) {
        getMaximumEpisodeId(library);
        getRandomEpisodeId();
        return randomEpisodeId;
    }

    public void getMaximumEpisodeId(List<Episode> library) {
        maximumEpisodeId = (int) library.size();
    }

    public void getRandomEpisodeId() {
        randomEpisodeId = (int)(Math.random() * (maximumEpisodeId - 1)) + 1;
    }
}