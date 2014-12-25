package org.nirbo.businessfragment.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.nirbo.businessfragment.R;

public class ServicesRecyclerAdapter extends RecyclerView.Adapter<ServicesRecyclerAdapter.ServicesViewHolder> {

    private int[] mServiceImages;

    public ServicesRecyclerAdapter(int[] serviceImages) {
        this.mServiceImages = serviceImages;
    }

    @Override
    public ServicesRecyclerAdapter.ServicesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.service_image_layout, parent, false);

        return new ServicesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ServicesRecyclerAdapter.ServicesViewHolder holder, int position) {
        int image = mServiceImages[position];
        ServicesViewHolder.mServiceImage.setImageResource(image);
    }

    @Override
    public int getItemCount() {
        return mServiceImages.length;
    }

    // ViewHolder Class
    public static class ServicesViewHolder extends RecyclerView.ViewHolder {

        protected static ImageView mServiceImage;

        public ServicesViewHolder(View itemView) {
            super(itemView);
            mServiceImage = (ImageView) itemView.findViewById(R.id.service_image);
        }
    }


}
