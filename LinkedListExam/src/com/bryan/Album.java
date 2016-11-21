package com.bryan;

import java.util.ArrayList;

/**
 * Created by johnbryansazon on 21/11/2016.
 */
public class Album {
    private String name;
    private ArrayList<Song> songList = new ArrayList<Song>();

    public Album(String name) {
        this.name = name;
    }

    public void addSongToAlbum(Song song) {
        this.songList.add(song);
    }

    public void listAlbumSongs() {
        System.out.println("===============================");
        System.out.println("Album Name: " + this.name + "\n");
        for (int i=0; i <this.songList.size(); i++) {
            Song song = this.songList.get(i);
            System.out.println((i+1) + ". Title: " + song.getTitle() + ", Duration: " + song.getDurationInSeconds());
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }
}
