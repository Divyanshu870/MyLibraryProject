package com.asus.mylibrary.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.asus.mylibrary.daos.BookDao;
import com.asus.mylibrary.daos.QuoteCategoryDao;
import com.asus.mylibrary.daos.QuoteDao;
import com.asus.mylibrary.models.Book;
import com.asus.mylibrary.models.Quote;
import com.asus.mylibrary.models.QuoteCategory;

@Database(entities = {Book.class, Quote.class, QuoteCategory.class}, version = 1, exportSchema = false)
public abstract class LibraryDatabase extends RoomDatabase{

    public abstract BookDao BookDao();
    public abstract QuoteDao QuoteDao();
    public abstract QuoteCategoryDao QuoteCategoryDao();

    private static volatile LibraryDatabase libraryDatabaseInstance;

    public static LibraryDatabase getDatabase(final Context context){
        if(libraryDatabaseInstance ==null){
            synchronized (LibraryDatabase.class){
                if (libraryDatabaseInstance ==null){
                    libraryDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                            LibraryDatabase.class,"library_database").build();
                }
            }
        }
        return libraryDatabaseInstance;
    }

}
