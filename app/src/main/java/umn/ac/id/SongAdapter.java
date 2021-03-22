package umn.ac.id;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.VH> {

    private List<Song> songList;

    public SongAdapter(List<Song> songList) {
        this.songList = songList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VH vh = new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list, parent, false));
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        Song song = songList.get(position);

        if(song!=null) {
            holder.title.setText(song.title);
            holder.artist.setText(song.artistName);
        }
    }

    @Override
    public int getItemCount() {
        return songList!=null?songList.size():0;
    }

    public class VH extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView title, artist;
        Context nContext;

        public VH(@NonNull View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.songTitle);
            artist = (TextView)itemView.findViewById(R.id.songArtist);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getAdapterPosition();

            Intent intent = new Intent(nContext, NowPlayingActivity.class);
            intent.putExtra("music", songList.get(mPosition));
        }
    }
}
