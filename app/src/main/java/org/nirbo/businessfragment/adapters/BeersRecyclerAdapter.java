package org.nirbo.businessfragment.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.nirbo.businessfragment.R;

public class BeersRecyclerAdapter extends RecyclerView.Adapter<BeersRecyclerAdapter.BeersViewHolder> {

    private int[] mDrinksLogos;

    public BeersRecyclerAdapter(int[] drinkLogos) {
        this.mDrinksLogos = drinkLogos;
    }

    @Override
    public BeersViewHolder onCreateViewHolder(ViewGroup parent, final int position) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.beer_logos_layout, parent, false);

        return new BeersViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BeersViewHolder beersViewHolder, int position) {
        int logo = mDrinksLogos[position];
        BeersViewHolder.mDrinkLogo.setImageResource(logo);
    }

    @Override
    public int getItemCount() {
        return mDrinksLogos.length;
    }

    // ViewHolder Class
    public static class BeersViewHolder extends RecyclerView.ViewHolder {

        protected static ImageView mDrinkLogo;

        public BeersViewHolder(View itemView) {
            super(itemView);
            mDrinkLogo = (ImageView) itemView.findViewById(R.id.drink_logo);
        }
    }

}
