package com.home.roomwordssample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "word_table")
data class Word(
    @ColumnInfo(name = "word")
    @PrimaryKey
    @NotNull
    var mWord: String
) {
}