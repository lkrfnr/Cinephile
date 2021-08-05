package com.lkrfnr.cinephileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.lkrfnr.cinephileapp.persistance.LocalDatabase
import com.lkrfnr.cinephileapp.persistance.entities.User
import com.lkrfnr.cinephileapp.persistance.entities.dao.FilmDao
import com.lkrfnr.cinephileapp.persistance.entities.dao.UserDao
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val localDatabase : LocalDatabase = LocalDatabase.getInstance(this)

        val user : User = User(1,"ilker", "lkrfnr@gmail.com","I am Jr. Android Developer", "my description")

    }
}