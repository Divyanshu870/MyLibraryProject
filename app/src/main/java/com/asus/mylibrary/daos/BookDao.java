package com.asus.mylibrary.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.asus.mylibrary.models.Book;

@Dao
public interface BookDao {

    @Insert
    void insert(Book book);

    @Update
    void update(Book book);

    @Delete
    void delete(Book book);

    @Query("SELECT * FROM books")
    LiveData<List<Book>> getAllBooks();

    @Query("Select * FROM books WHERE status=:status")
    LiveData<List<Book>> getBooksWithStatus(int status);

    @Query("SELECT * FROM books WHERE id=:bookId")
    LiveData<Book> getBook(String bookId);


}