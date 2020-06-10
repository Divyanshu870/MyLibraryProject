package com.asus.mylibrary.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asus.mylibrary.R;
import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyBooksAdapter extends RecyclerView.Adapter<MyBooksAdapter.ViewHolder> {
    private Context context;
    File files;

    public MyBooksAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_books_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        files = Constant.alldocumentList.get(position);
        holder.textViewMyBooksTitle.setText(files.getName());
        //we will load thumbnail using glid library
        Uri uri = Uri.fromFile(files);

        Glide.with(context)
                .load(uri).thumbnail(0.1f).into((holder).imageViewMyBooksThumbnail);

    }

    @Override
    public int getItemCount() {
        return Constant.alldocumentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageViewMyBooksThumbnail)
        ImageView imageViewMyBooksThumbnail;
        @BindView(R.id.textViewMyBooksTitle)
        TextView textViewMyBooksTitle;
        @BindView(R.id.rootViewMyBooks)
        LinearLayout rootViewMyBooks;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}