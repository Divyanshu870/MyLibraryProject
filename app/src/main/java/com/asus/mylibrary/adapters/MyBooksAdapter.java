package com.asus.mylibrary.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asus.mylibrary.R;
import com.asus.mylibrary.listener.ClickListener;
import com.asus.mylibrary.model.MyBooksList;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.folioreader.FolioReader;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyBooksAdapter extends RecyclerView.Adapter<MyBooksAdapter.ViewHolder> {

    private Context context;
    List<MyBooksList> myBooksList;
    ClickListener clickListener;

    public MyBooksAdapter(Context context, List<MyBooksList> myBooksList) {
        this.context = context;
        this.myBooksList = myBooksList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_books_item, parent, false);
        return new ViewHolder(view);
    }


    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (!myBooksList.isEmpty()) {
            holder.textViewMyBooksTitle.setText(myBooksList.get(position).getTitle());
            Glide.with(context).load(myBooksList.get(position).getThumbnail()).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.imageViewMyBooksThumbnail);
            holder.rootViewMyBooks.setOnClickListener(v -> {
                if(clickListener != null){
                    clickListener.ItemClicked(holder.rootViewMyBooks, position);
                }
            });

        }


    }

    @Override
    public int getItemCount() {
        return myBooksList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageViewMyBooksThumbnail)
        ImageView imageViewMyBooksThumbnail;
        @BindView(R.id.textViewMyBooksTitle)
        TextView textViewMyBooksTitle;
        @BindView(R.id.rootViewMyBooks)
        MaterialCardView rootViewMyBooks;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}