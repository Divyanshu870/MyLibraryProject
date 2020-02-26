package com.asus.mylibrary.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import com.asus.mylibrary.R;
import com.asus.mylibrary.models.Cover;

public class CoversRevViewAdapter extends RecyclerView.Adapter<CoversRevViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Cover> bookCovers = new ArrayList<>();

    public CoversRevViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_cover_rec_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(bookCovers.get(position).getUrl()).into(holder.bookCover);
    }

    @Override
    public int getItemCount() {
       return bookCovers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView bookCover;
        ViewHolder(View itemView) {
            super(itemView);
            bookCover= (ImageView) itemView.findViewById(R.id.bookCover);

        }
    }
}