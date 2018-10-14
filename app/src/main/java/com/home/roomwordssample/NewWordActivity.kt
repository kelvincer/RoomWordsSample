package com.home.roomwordssample

import android.content.Intent
import android.text.TextUtils
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_word.*


class NewWordActivity : AppCompatActivity() {

    private var mEditWordView: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        mEditWordView = findViewById(R.id.edit_word)

        button_save.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(mEditWordView!!.text)) {
                setResult(RESULT_CANCELED, replyIntent)
            } else {
                val word = mEditWordView!!.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        val EXTRA_REPLY = "com.example.android.roomwordssample.REPLY"
    }
}
