package com.kishy.j_comp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Music_album {
    private String name;
    private String artist;
    private int ID;
    private ArrayList<Song> songs;
    private ArrayList<Integer> songIds;

    public Music_album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public Music_album(String name, int ID) {
        this.ID = ID;
        this.name = name;
        this.songIds = new ArrayList<Integer>();

    }

    public Song LookforSong(String title) {

        for (Song checkedSong : songs) {
            if (checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    public boolean addSong(String title, double duration) {
        if (LookforSong(title) == null) {
            songs.add(new Song(title, duration));

            return true;
        } else {
            return false;
        }
    }


    public void addSong(int songID) {

        songIds.add(songID);


    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList) {
        int index = trackNumber - 1;
        if (index > 0 && index <= this.songs.size()) {
            PlayList.add(this.songs.get(index));
            return true;
        }
//        System.out.println("this album does not have song with trackNumber "+trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> PlayList) {
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                PlayList.add(checkedSong);
                return true;
            }
        }
//        System.out.println(title + "there is no such song in album");
        return false;
    }


    public void addToPlayList(int ID, PriorityQueue<Integer> PlayList) {
        PlayList.addAll(this.songIds);

    }
}