package com.example.player.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.player.R
import com.example.player.extension.loadImage
import com.example.player.model.PlayerModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.PlayerVH>() {

    private val list = mutableListOf<PlayerModel>()
    private lateinit var clickListener: ClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerVH {
        return PlayerVH(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlayerVH, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
                clickListener.click(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    fun update(list: MutableList<PlayerModel>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun setOnClick(clickListener: ClickListener) {
        this.clickListener =clickListener
    }


    class PlayerVH(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun onBind(playerModel: PlayerModel) {
            itemView.image_main.loadImage(playerModel.coverImage, R.drawable.song_image)
            itemView.artist_name.text = playerModel.artists
            itemView.song_name.text = playerModel.song
        }
    }

    interface ClickListener{
        fun click(item: PlayerModel)
    }
}