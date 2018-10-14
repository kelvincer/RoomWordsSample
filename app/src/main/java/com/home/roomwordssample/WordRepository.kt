package com.home.roomwordssample

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import android.app.Application

class WordRepository(application: Application) {

    private var mWordDao: WordDao? = null
    private var mAllWords: LiveData<List<Word>>? = null

    init {
        val db = WordRoomDatabase.getDatabase(application)
        mWordDao = db?.wordDao()
        mAllWords = mWordDao?.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>>? {
        return mAllWords
    }

    fun insert(word: Word) {
        insertAsyncTask(mWordDao).execute(word)
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: WordDao?) :
        AsyncTask<Word, Void, Void>() {

        override fun doInBackground(vararg params: Word): Void? {
            mAsyncTaskDao?.insert(params[0])
            return null
        }
    }
}