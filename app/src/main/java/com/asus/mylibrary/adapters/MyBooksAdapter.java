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

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (!myBooksList.isEmpty()) {
            holder.textViewMyBooksTitle.setText(myBooksList.get(position).getTitle());
            Glide.with(context).load(myBooksList.get(position).getThumbnail()).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.imageViewMyBooksThumbnail);
            holder.rootViewMyBooks.setOnClickListener(v -> {
                FolioReader folioReader = FolioReader.getInstance(context);

                // Opening Books(EPUB) from there postions
                if (position == 0) {
                    folioReader.openBook("file:///android_asset/mil_and_honey.epub");
                }
                if (position == 1) {
                    folioReader.openBook("file:///android_asset/the_sun_and_her_flowers.epub");
                }
                if (position == 2) {
                    folioReader.openBook("file:///android_asset/burroughs_lost_continent.epub");
                }
                if (position == 3) {
                    folioReader.openBook("file:///android_asset/dent_lost_oasis.epub");
                }
                if (position == 4) {
                    folioReader.openBook("file:///android_asset/wells_time_machine.epub");
                }
                if (position == 5) {
                    folioReader.openBook("file:///android_asset/blyton_secret_island.epub");
                }
                if (position == 6) {
                    folioReader.openBook("file:///android_asset/howard_worms_of_the_earth.epub");
                }
                if (position == 7) {
                    folioReader.openBook("file:///android_asset/shelley_frankenstein.epub");
                }
                if (position == 8) {
                    folioReader.openBook("file:///android_asset/verne_around_the_world_in_80_days.epub");
                }
                if (position == 9) {
                    folioReader.openBook("file:///android_asset/forester_happy_return.epub");
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