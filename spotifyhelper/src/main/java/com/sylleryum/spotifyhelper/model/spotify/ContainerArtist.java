package com.sylleryum.spotifyhelper.model.spotify;

import java.util.List;

public class ContainerArtist {

    private String artist;
    private List<AlbumStats> albumStatsList;

    public ContainerArtist() {
    }

    public ContainerArtist(String artist, List<AlbumStats> albumStatsList) {
        this.artist = artist;
        this.albumStatsList = albumStatsList;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<AlbumStats> getAlbumStatsList() {
        return albumStatsList;
    }

    public void setAlbumStatsList(List<AlbumStats> albumStatsList) {
        this.albumStatsList = albumStatsList;
    }
}
