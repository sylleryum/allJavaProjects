package com.sylleryum.spotifyhelper.model.spotify;

public class AlbumStats {

    private String album;
    private int trackAmount;
    private int year;
    private String artist;
    public AlbumStats() {
        trackAmount = 0;
    }

    public AlbumStats(String album, int trackAmount, int year, String artist) {
        this.album = album;
        this.trackAmount = trackAmount;
        this.year = year;
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getTrackAmount() {
        return trackAmount;
    }

    public void setTrackAmount(int trackAmount) {
        this.trackAmount = trackAmount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
