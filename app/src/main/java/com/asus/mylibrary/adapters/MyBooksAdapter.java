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
import com.asus.mylibrary.utils.Constant;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyBooksAdapter extends RecyclerView.Adapter<MyBooksAdapter.ViewHolder> {
    private Context context;

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
        holder.textViewMyBooksTitle.setText(Constant.alldocumentList.get(position).getName());
        //we will load thumbnail using glid library
        Uri uri = Uri.fromFile(Constant.alldocumentList.get(position));

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