package com.example.lessonsapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class SongListAdapter(
    private val context: Context,
    private val list: List<SongModel>,
    private val onClickListener: (songModel: SongModel) -> Unit,
) : ArrayAdapter<SongModel>(context, R.layout.it_song_list, list) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // Criando a view (layout) que vamos colocar os dados do elemento[i]
        val view = LayoutInflater.from(context).inflate(R.layout.it_song_list, parent, false)

        // pegando o elemento[i] atual da lista
        val song = list[position]

        // Acessando as views do layout através dos IDs
        val songCover: ImageView = view.findViewById(R.id.ivSongCover)
        val songTitle: TextView = view.findViewById(R.id.tvSongTitle)
        val songArtist: TextView = view.findViewById(R.id.tvSongArtist)

        // colocando a imagem do elemento[i] da lista no ImageView
        songCover.setImageResource(song.image)

        // colocando o titulo do elemento[i] da lista no TextView
        songTitle.text = song.title

        // colocando o artista do elemento[i] da lista no Textview
        songArtist.text = song.artist

        // passar o que acontece quando clica em uma view
        view.setOnClickListener {
            onClickListener(song)
        }

        return view
    }

}
