package com.asus.mylibrary.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import com.asus.mylibrary.daos.QuoteCategoryDao;
import com.asus.mylibrary.database.LibraryDatabase;
import com.asus.mylibrary.models.QuoteCategory;

public class QuoteCategoryViewModel extends AndroidViewModel {
    QuoteCategoryDao categoryDao;
    LibraryDatabase database;

    public QuoteCategoryViewModel(@NonNull Application application) {
        super(application);
        database = LibraryDatabase.getDatabase(application);
        categoryDao = database.QuoteCategoryDao();
    }

    public LiveData<List<QuoteCategory>> getAllCategories() {
        return categoryDao.getAllQuoteCategories();
    }

    public LiveData<QuoteCategory> getCategoryByName(String name) {
        return categoryDao.getQuoteCategory(name);
    }

    public void insert(QuoteCategory quote) {
        new InsertAsyncTask(categoryDao).execute(quote);
    }

    public void update(QuoteCategory quote) {
        new UpdateAsyncTask(categoryDao).execute(quote);
    }

    public void delete(QuoteCategory quote) {
        new DeleteAsyncTask(categoryDao).execute(quote);
    }


    //inner classes
    private class OperationAsyncTask extends AsyncTask<QuoteCategory, Void, Void> {
        protected QuoteCategoryDao asyncTaskDao;

        public OperationAsyncTask(QuoteCategoryDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(QuoteCategory... categories) {
            return null;
        }
    }

    private class InsertAsyncTask extends OperationAsyncTask {

        public InsertAsyncTask(QuoteCategoryDao dao) {
            super(dao);
        }

        @Override
        protected Void doInBackground(QuoteCategory... categories) {
            asyncTaskDao.insert(categories[0]);
            return null;
        }
    }

    private class UpdateAsyncTask extends OperationAsyncTask {
        public UpdateAsyncTask(QuoteCategoryDao dao) {
            super(dao);
        }

        @Override
        protected Void doInBackground(QuoteCategory... categories) {
            asyncTaskDao.update(categories[0]);
            return null;
        }
    }

    private class DeleteAsyncTask extends OperationAsyncTask {
        public DeleteAsyncTask(QuoteCategoryDao dao) {
            super(dao);
        }

        @Override
        protected Void doInBackground(QuoteCategory... categories) {
            asyncTaskDao.delete(categories[0]);
            return null;
        }
    }
}
