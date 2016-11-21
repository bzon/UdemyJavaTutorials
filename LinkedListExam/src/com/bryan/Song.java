package com.bryan;

import java.util.ArrayList;

/**
 * Created by johnbryansazon on 21/11/2016.
 */
public class Song {
    private String title;
    private int durationInSeconds;

    public Song(String title, int durationInSeconds) {
        this.title = title;
        this.durationInSeconds = durationInSeconds;
    }

    public static Song createSong(String title, int durationInSeconds) {
        return new Song(title, durationInSeconds);
    }

    public String getTitle() {
        return title;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }
}

