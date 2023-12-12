package com.sylleryum.spotifyhelper.model.spotify;

import java.util.List;

public class ContainerAlbumStats {
    private int year;
    private List<ContainerArtist> artistList;

    public ContainerAlbumStats() {
    }

    public ContainerAlbumStats(int year) {
        this.year = year;
    }

    public ContainerAlbumStats(int year, List<ContainerArtist> artistList) {
        this.year = year;
        this.artistList = artistList;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<ContainerArtist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<ContainerArtist> artistList) {
        this.artistList = artistList;
    }
}
