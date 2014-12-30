package org.nirbo.businessfragment.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.nirbo.businessfragment.R;

import java.util.List;

public class OffersRecyclerAdapter extends RecyclerView.Adapter<OffersRecyclerAdapter.OffersViewHolder> {

    private Activity mContext;
    private List<String> mOffersList;

    public OffersRecyclerAdapter(List<String> offersList, Activity context) {
        this.mContext = context;
        this.mOffersList = offersList;
    }

    @Override
    public OffersViewHolder onCreateViewHolder(ViewGroup parent, final int position) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.offers_recycler_card, parent, false);

        return new OffersViewHolder(itemView,
                new OffersViewHolder.OnItemClickListener() {

                    @Override
                    public void OnItemClick(View item, int position) {
                        Toast.makeText(mContext, "Offer Clicked: " + (position + 1), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onBindViewHolder(OffersViewHolder offersViewHolder, int position) {
        offersViewHolder.mOffer.setText(mOffersList.get(position));
    }

    @Override
    public int getItemCount() {
        return mOffersList.size();
    }

    // ViewHolder Class
    public static class OffersViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        protected TextView mOffer;
        protected OnItemClickListener mItemClickListener;

        public OffersViewHolder(View itemView, OnItemClickListener itemClickListener) {
            super(itemView);
            mOffer = (TextView) itemView.findViewById(R.id.offer_content);
            mItemClickListener = itemClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mItemClickListener.OnItemClick(view, getPosition());
        }

        public static interface OnItemClickListener {
            public void OnItemClick(View item, int position);
        }
    }

}
