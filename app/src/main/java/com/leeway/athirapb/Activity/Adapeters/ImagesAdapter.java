package com.leeway.athirapb.Activity.Adapeters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.leeway.athirapb.Activity.Interfaces.OnImageCloseSelected;
import com.leeway.athirapb.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jacek Kwiecień on 08.11.2016.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    OnImageCloseSelected onImageCloseSelected;
    private Context context;
    private List<byte[]> imagesFiles;

    public ImagesAdapter(Context context, List<byte[]> imagesFiles) {
        this.context = context;
        this.imagesFiles = imagesFiles;
    }
    public void ImageDeleteListner(OnImageCloseSelected onImageCloseSelected)
    {
        this.onImageCloseSelected=onImageCloseSelected;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ViewHolder(inflater.inflate(R.layout.view_image, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
//        Picasso.with(context)
//                .load(imagesFiles.get(position))
//                .fit()
//                .centerCrop()
//                .into(holder.imageView);

//        byte[] imageByteArray = Base64.decode(imagesFiles.get(position).toString(), Base64.DEFAULT);
        Log.e( "onBindViewHolder: ",""+imagesFiles.get(position));
        Glide.with(context)
                .load(imagesFiles.get(position))
                .asBitmap()
                .placeholder(R.drawable.user)
                .into(holder.imageView);


        holder.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageCloseSelected.OnClickImageClose(v,position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return imagesFiles.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public ImageView close;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.image_view);
            close=itemView.findViewById(R.id.close_icon);
        }


    }




}