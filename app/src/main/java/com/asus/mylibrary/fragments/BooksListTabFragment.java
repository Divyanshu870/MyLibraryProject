package com.asus.mylibrary.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.asus.mylibrary.R;
import com.asus.mylibrary.viewmodels.BookViewModel;
import com.asus.mylibrary.adapters.BooksRecViewAdapter;
import com.asus.mylibrary.models.Book;

public class BooksListTabFragment extends Fragment{

    public static final int NEW_BOOK_ACTIVITY_REQUEST_CODE = 0;
    public static final int UPDATE_BOOK_ACTIVITY_REQUEST_CODE = 1;

    private Context context;
    private int tabBooksStatus;

    private RecyclerView booksRecView;
    private BooksRecViewAdapter booksRecViewAdapter;

    private BookViewModel bookViewModel;

    public BooksListTabFragment(int tabBooksStatus, Context context) {
        super();
        this.tabBooksStatus = tabBooksStatus;
        this.context = context;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        booksRecViewAdapter = new BooksRecViewAdapter(context);

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);

        bookViewModel.getBookWithStatus(tabBooksStatus).observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                booksRecViewAdapter.setBooks(books);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment_books_list, container, false);

        booksRecView = (RecyclerView) view.findViewById(R.id.booksRecView);
        booksRecView.setAdapter(booksRecViewAdapter);
        booksRecView.setLayoutManager(new GridLayoutManager(context, 2));

        return view;
    }

    public void setFilter(String filter) {
        booksRecViewAdapter.getFilter().filter(filter);
    }


    public BookViewModel getBookViewModel(){return bookViewModel;}
}
