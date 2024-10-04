package com.example.lessonsapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class SongListAdapter(private val context: Context, private val list: List<SongModel>) : ArrayAdapter<SongModel>(context, R.layout.it_song_list, list) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.it_song_list, parent, false)

        val song = list[position]

        val songCover: ImageView = view.findViewById(R.id.ivSongCover)
        val songTitle: TextView = view.findViewById(R.id.tvSongTitle)
        val songArtist: TextView =view.findViewById(R.id.tvSongArtist)

        songCover.setImageResource(song.image)
        songTitle.text = song.title
        songArtist.text = song.artist

        return view
    }

}