package com.example.lessonsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SongRecyclerAdapter(
    private val context: Context,
    private val list: List<SongModel>,
    private val onClickListener: (SongModel) -> Unit,
) : RecyclerView.Adapter<SongRecyclerAdapter.SongViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        // Criando a view (layout) que vamos colocar os dados do elemento[i]
        val view = LayoutInflater.from(context).inflate(R.layout.it_song_list, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = list[position]
        holder.bind(song, onClickListener)
    }

    class SongViewHolder(view: View) : ViewHolder(view) {
        // Acessando as views do layout através dos IDs
        val songCover: ImageView = view.findViewById(R.id.ivSongCover)
        val songTitle: TextView = view.findViewById(R.id.tvSongTitle)
        val songArtist: TextView = view.findViewById(R.id.tvSongArtist)

        fun bind(song: SongModel, onClickListener: (SongModel) -> Unit) {
            // colocando a imagem do elemento[i] da lista no ImageView
            songCover.setImageResource(song.image)

            // colocando o titulo do elemento[i] da lista no TextView
            songTitle.text = song.title

            // colocando o artista do elemento[i] da lista no Textview
            songArtist.text = song.artist

            itemView.setOnClickListener {
                onClickListener(song)
            }
        }
    }
}