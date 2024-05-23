package com.example.frinder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.frinder.R
import com.example.frinder.model.Card

class CardAdapter(private val cards: List<Card>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.card_title)
        private val description: TextView = itemView.findViewById(R.id.card_description)
        private val image: ImageView = itemView.findViewById(R.id.card_image)
        private val interestsLayout: LinearLayout = itemView.findViewById(R.id.interests_layout)

        fun bind(card: Card) {
            title.text = card.title
            Glide.with(itemView.context).load(card.imageUrl).into(image)
            interestsLayout.removeAllViews()

            for (interest in card.interests) {
                val interestTextView = TextView(itemView.context).apply {
                    text = interest
                    setPadding(8, 8, 8, 8)
                    background = itemView.context.getDrawable(R.drawable.interest_background)
                }
                interestsLayout.addView(interestTextView)
            }
            description.text = card.description
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cards[position])
    }

    override fun getItemCount() = cards.size
}
