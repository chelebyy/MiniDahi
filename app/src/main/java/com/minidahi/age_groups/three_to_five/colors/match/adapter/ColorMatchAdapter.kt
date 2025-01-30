package com.minidahi.age_groups.three_to_five.colors.match.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.minidahi.R
import com.minidahi.age_groups.three_to_five.colors.match.model.ColorCard
import com.minidahi.databinding.ItemColorCardBinding

class ColorMatchAdapter(
    private val onCardClicked: (ColorCard) -> Unit
) : ListAdapter<ColorCard, ColorMatchAdapter.ColorCardViewHolder>(ColorCardDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorCardViewHolder {
        val binding = ItemColorCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ColorCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ColorCardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ColorCardViewHolder(
        private val binding: ItemColorCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(card: ColorCard) {
            with(binding) {
                if (card.isFlipped || card.isMatched) {
                    colorView.setBackgroundColor(
                        ContextCompat.getColor(root.context, card.colorResId)
                    )
                } else {
                    colorView.setBackgroundColor(
                        ContextCompat.getColor(root.context, R.color.card_back)
                    )
                }

                root.setOnClickListener {
                    if (!card.isMatched && !card.isFlipped) {
                        onCardClicked(card)
                    }
                }
            }
        }
    }
}

private class ColorCardDiffCallback : DiffUtil.ItemCallback<ColorCard>() {
    override fun areItemsTheSame(oldItem: ColorCard, newItem: ColorCard): Boolean {
        return oldItem.position == newItem.position
    }

    override fun areContentsTheSame(oldItem: ColorCard, newItem: ColorCard): Boolean {
        return oldItem == newItem
    }
}
