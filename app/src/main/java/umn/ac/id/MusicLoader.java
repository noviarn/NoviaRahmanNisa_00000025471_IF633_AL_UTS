package umn.ac.id;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class MusicLoader {

    public List<Song> getAllSongs(Context context) {

        List<Song> songList = new ArrayList<>();

        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = new String[] {
                "title",
                "artist"
        };
        String sortOrder = MediaStore.Audio.Media.DEFAULT_SORT_ORDER;
        Cursor cursor = context.getContentResolver().query(songUri, projection, null, null, sortOrder);

        if(cursor != null && cursor.moveToFirst()) {
            do {
                songList.add(new Song(cursor.getString(0), cursor.getString(1)));
            } while (cursor.moveToNext());

            if (cursor!=null) {
                cursor.close();
            }
        }

        return songList;
    }
}
