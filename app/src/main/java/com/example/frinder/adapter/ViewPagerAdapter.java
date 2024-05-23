package com.example.frinder.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frinder.R;
import com.example.frinder.model.Card;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {

    private List<Card> dataList;

    public ViewPagerAdapter(List<Card> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        // Ensure the ViewGroup.LayoutParams are match_parent
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Card data = dataList.get(position);
        holder.cardTitle.setText(data.getTitle());
        holder.interestsLayout.removeAllViews();
        for (String interest : data.getInterests()) {
            TextView interestTextView = new TextView(holder.itemView.getContext());
            interestTextView.setText(interest);
            interestTextView.setPadding(8, 8, 8, 8);
            interestTextView.setBackground(holder.itemView.getContext().getDrawable(R.drawable.interest_background));
            holder.interestsLayout.addView(interestTextView);
        }
        holder.cardDescription.setText(data.getDescription());
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView cardTitle;
        LinearLayout interestsLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.card_image);
            cardTitle = itemView.findViewById(R.id.card_title);
            cardDescription = itemView.findViewById(R.id.card_description);
            interestsLayout = itemView.findViewById(R.id.interests_layout);
        }

        TextView cardDescription;
    }
}
