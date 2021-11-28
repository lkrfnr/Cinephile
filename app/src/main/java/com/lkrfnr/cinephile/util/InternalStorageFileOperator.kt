package com.lkrfnr.cinephile.util

import android.content.Context
import java.io.FileOutputStream

class InternalStorageFileOperator {

    fun writeFile(context: Context, content: String) {

        val fileName = "MoviePopularResultJsonFile.json"

        try {
            val fileOS: FileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
            fileOS.write(content.toByteArray())
        } catch (e: Exception) {

        }

    }

}
