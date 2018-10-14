package com.home.roomwordssample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


class WordViewModel(app: Application) : AndroidViewModel(app) {

    private var mRepository: WordRepository? = null
    private var mAllWords: LiveData<List<Word>>? = null

    init {
        mRepository = WordRepository(app)
        mAllWords = mRepository?.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>>? {
        return mAllWords
    }

    fun insert(word: Word) {
        mRepository?.insert(word)
    }
}