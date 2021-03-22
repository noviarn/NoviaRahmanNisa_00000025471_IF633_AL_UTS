package umn.ac.id;

import java.io.Serializable;

public class Song implements Serializable {
    public final String title;
    public final  String artistName;

    public Song() {
        title = "";
        artistName = "";
    }

    public Song(String title, String artistName) {
        this.title = title;
        this.artistName = artistName;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }
}
