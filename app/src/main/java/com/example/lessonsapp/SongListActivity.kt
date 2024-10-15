package com.example.lessonsapp

import android.os.Bundle
import android.util.LayoutDirection
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class SongListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_list)

        val recyclerView: RecyclerView = findViewById(R.id.rvSongList)


        val songList = listOf(
            SongModel("Numb", "Linkin Park", "Meteora", R.drawable.linkin_park),
            SongModel("Título 2", "Artista 2", "Álbum 2", R.drawable.linux),
            SongModel("Blinding Lights", "The Weeknd", "Blinding Lights", R.drawable.the_weeknd),
            SongModel("Título 4", "Artista 4", "Álbum 4", R.drawable.linux),
            SongModel("Título 5", "Artista 5", "Álbum 5", R.drawable.the_weeknd),
            SongModel("Título 6", "Artista 6", "Álbum 6", R.drawable.the_weeknd),
            SongModel("Título 7", "Artista 7", "Álbum 7", R.drawable.linkin_park),
        )
        // Adapter de ListView
        val adapter = SongRecyclerAdapter(this, songList) {
            showMessage(this, "clicou na música: ${it.title}")
        }

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.apply {
            this.adapter = adapter
            this.layoutManager = layoutManager
        }
    }
}