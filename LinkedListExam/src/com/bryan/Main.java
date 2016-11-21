package com.bryan;

import java.util.*;

public class Main {

    private static ArrayList<Album> albumList = new ArrayList<Album>();
    private static LinkedList<Song> playList = new LinkedList<Song>();

    public static void main(String[] args) {

        // Create ACDC Album
        Album acdc = new Album("ACDC");
        // Add songs to ACDC Album
        acdc.addSongToAlbum(Song.createSong("Rock or Bust", 360));
        acdc.addSongToAlbum(Song.createSong("Highway to Hell", 320));
        acdc.addSongToAlbum(Song.createSong("Thunderstruck", 240));
        acdc.addSongToAlbum(Song.createSong("You shook mo all night long", 280));
        acdc.listAlbumSongs();
        // Add ACDC Album to array list
        albumList.add(acdc);

        // Create Metallica Album
        Album metallica = new Album("Metallica");
        // Add songs to Metallica Album
        metallica.addSongToAlbum(Song.createSong("Master of puppets", 400));
        metallica.addSongToAlbum(Song.createSong("Enter Sandman", 350));
        metallica.addSongToAlbum(Song.createSong("Nothing else matters", 250));
        metallica.addSongToAlbum(Song.createSong("Fade to black", 240));
        metallica.listAlbumSongs();
        // Add Metallica Album to array list
        albumList.add(metallica);

        // Add songs to playlist
        addInOrder(playList, "Thunderstruck");
        addInOrder(playList, "Rock or bust");
        addInOrder(playList, "Fade to black");

        // Remove a song from the playlist
        removeSong(playList, "thunderstruck");

        // Run playlist
        play(playList);

    }

    private static void printList(LinkedList<Song> playList) {
        ListIterator<Song> listIterator = playList.listIterator();
        while(listIterator.hasNext()) {
            System.out.println(listIterator.next().getTitle());
        }
        System.out.println("========================");
    }

    private static void removeSong(LinkedList<Song> playList, String title) {

        ListIterator<Song> listIterator = playList.listIterator();
        while (listIterator.hasNext()) {
            int compare = listIterator.next().getTitle().compareToIgnoreCase(title);
            if (compare == 0) {
                System.out.println(title + "removed from playlist.");
                listIterator.remove();
            } else {
                System.out.println(title + "not found on your playlist.");
            }
        }

    }
    private static boolean addInOrder(LinkedList<Song> playList, String title) {
        Song song = findSong(title);
        if (song != null) {
            ListIterator<Song> listIterator = playList.listIterator();
            while (listIterator.hasNext()) {
                int compare = listIterator.next().getTitle().compareToIgnoreCase(title);
                if (compare == 0) {
                    System.out.println(title + " is already in this playlist.");
                    return false;
                } else if (compare > 0) {
                    System.out.println(title + " has been added to your playlist.");
                    listIterator.previous();
                    listIterator.add(song);
                    return true;
                }
            }
            System.out.println(title + " has been added to your playlist.");
            listIterator.add(song);
        }
        return false;
    }

    private static Song findSong(String title) {
        System.out.println("===============================");
        System.out.println("Main.findSong() is called");
        for (int i = 0; i <albumList.size(); i++) {
            for (int x = 0; x < albumList.get(i).getSongList().size(); x++) {
                 if (albumList.get(i).getSongList().get(x).getTitle().equalsIgnoreCase(title)) {
                     System.out.println("Song title " + title + " was found on " + albumList.get(i).getName() + " album!");
                     return albumList.get(i).getSongList().get(x);
                 }
            }
        }
        System.out.println("The song title " + title + " was not found in any albums.");
        return null;
    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = false;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.isEmpty()) {
            System.out.println("No songs found in the playlist.");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().getTitle());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("All songs played.");
                    quit = true;
                    break;

                case 1:
                    if (!goingForward) {
                        if(listIterator.hasNext()) {
                            System.out.println("Running listIterator.next();");
                            listIterator.next();
                        }
                        System.out.println("set goingForward = true");
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().getTitle());
                    } else {
                        System.out.println("Reached the end of the list");
                        System.out.println("set goingForward = false");
                        goingForward = false;
                    }

                    System.out.println("goingForward = " + goingForward);
                    break;

                case 2:
                    if (goingForward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Running listIterator.previous();");
                            listIterator.previous();
                        }
                        System.out.println("set goingForward = false");
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("We are now at the start of the list");
                        System.out.println("set goingForward = true");
                        goingForward = true;
                    }

                    System.out.println("goingForward = " + goingForward);
                    break;
                case 3:
                    printMenu();
                    break;
                case 4:
                    printList(playList);
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions: \npress: ");
        System.out.println("0 - to quiet\n" +
                                   "1 - go to next song.\n" +
                                   "2 - go to previous song.\n" +
                                   "3 - print menu.\n" +
                                    "4 - list all songs.");
    }

}
