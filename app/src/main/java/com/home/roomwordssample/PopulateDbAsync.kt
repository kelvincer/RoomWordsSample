package com.home.roomwordssample

import android.os.AsyncTask


 class PopulateDbAsync internal constructor(db: WordRoomDatabase?) : AsyncTask<Void, Void, Void>() {

    private val mDao: WordDao?
    internal var words = arrayOf("dolphin", "crocodile", "cobra")

    init {
        mDao = db?.wordDao()
    }

    override fun doInBackground(vararg params: Void): Void? {
        // Start the app with a clean database every time.
        // Not needed if you only populate the database
        // when it is first created
        mDao!!.deleteAll()

        for (i in 0 until words.size) {
            val word = Word(words[i])
            mDao.insert(word)
        }
        return null
    }
}