package com.test.gamelistapp.ui.helper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.gamelistapp.data.model.games.Games
import com.test.gamelistapp.databinding.ListItemGameBinding
import com.test.gamelistapp.utillity.GlideApp

class ListGameAdapter : PagingDataAdapter<Games, ListGameAdapter.GamesViewHolder>(COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val binding = ListItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        val game = getItem(position)
        game?.let { holder.bind(it) }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Games>() {
            override fun areItemsTheSame(oldItem: Games, newItem: Games): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Games, newItem: Games): Boolean {
                return oldItem == newItem
            }
        }
    }

    class GamesViewHolder(private val binding: ListItemGameBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Games) {
            GlideApp.with(binding.imgGame)
                .load(game.backgroundImage)
                .into(binding.imgGame)

            binding.tvTitle.text = game.name
            binding.tvProducer.text = game.rating.toString()
        }
    }
}