package trekroulette.controller;

import trekroulette.entity.*;
import java.util.List;

/**
 * RouletteController is responsible for providing random selection attributes for the selection of a Star Trek episode
 * by the application servlet.
 *
 * @author tlmirkes
 */
public class RouletteController {
    private int maximumEpisodeId = 0;
    private int randomEpisodeId = 0;

    /**
     * Identify the maximum id available, get a random integer from 1 to the maximum value, and return the random
     * integer to the calling servlet.
     *
     * @param library List of all available episodes
     * @return id value of selected episode
     */
    public int getRecommendation(List<Episode> library) {
        getMaximumEpisodeId(library);
        getRandomEpisodeId();
        return randomEpisodeId;
    }

    /**
     * Set the maximumEpisodeId variable equal to the size() attribute of the parameter List
     *
     * @param library List of all available episodes
     */
    public void getMaximumEpisodeId(List<Episode> library) {
        maximumEpisodeId = (int) library.size();
    }

    /**
     * Set the randomEpisodeId value by generating an integer from 1 to the established maximumEpisodeId
     */
    public void getRandomEpisodeId() {
        randomEpisodeId = (int)(Math.random() * (maximumEpisodeId - 1)) + 1;
    }
}