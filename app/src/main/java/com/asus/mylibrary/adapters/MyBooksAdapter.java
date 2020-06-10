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
import com.asus.mylibrary.model.MyBooksList;
import com.asus.mylibrary.utils.Constant;
import com.bumptech.glide.Glide;
import com.folioreader.FolioReader;

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
        if (!Constant.alldocumentList.isEmpty()) {
            holder.textViewMyBooksTitle.setText(myBooksList.get(position).getTitle());
//            //we will load thumbnail using glid library
//            Uri uri = Uri.fromFile(Constant.alldocumentList.get(position));
            holder.imageViewMyBooksThumbnail.setImageResource(myBooksList.get(position).getThumbnail());
//            // 3rd party library Glide and Picasso for image loading
//            Glide.with(context)
//                    .load(uri).thumbnail(0.1f).into((holder).imageViewMyBooksThumbnail);

            holder.rootViewMyBooks.setOnClickListener(v -> {

                FolioReader folioReader = FolioReader.get();
                folioReader.openBook("");
            });

        }


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