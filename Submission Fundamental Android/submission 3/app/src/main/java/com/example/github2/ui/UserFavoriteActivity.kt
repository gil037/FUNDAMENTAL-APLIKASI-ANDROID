package com.example.github2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github2.R
import com.example.github2.adapter.UserFavoriteAdapter
import com.example.github2.data.database.UserFavorite
import com.example.github2.databinding.ActivityUserFavoriteBinding

class UserFavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserFavoriteBinding
    private lateinit var userFavoriteViewModel: UserFavoriteViewModel

    private fun setUserFavoriteData(userFavorites: List<UserFavorite>) {
        val userFavoriteAdapter = UserFavoriteAdapter(userFavorites, object : UserFavoriteAdapter.OnItemClickCallback {
            override fun onClick(userFavorites: UserFavorite) {
                val intent = Intent(this@UserFavoriteActivity, DetailUserActivity::class.java).apply {
                    putExtra(DetailUserActivity.EXTRA_LOGIN, userFavorites.login)
                    putExtra(DetailUserActivity.EXTRA_ID, userFavorites.id)
                    putExtra(DetailUserActivity.EXTRA_AVATAR, userFavorites.avatar)
                }
                startActivity(intent)
            }
        })
        binding.itemUserRecyclerview.adapter = userFavoriteAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            elevation = 0F
            title = getString(R.string.favorite)
            setDisplayHomeAsUpEnabled(true)
        }

        val layoutManager = LinearLayoutManager(this@UserFavoriteActivity)
        binding.itemUserRecyclerview.layoutManager = layoutManager

        userFavoriteViewModel = ViewModelProvider(this)[UserFavoriteViewModel::class.java]
        userFavoriteViewModel.getAllUserFavorites.observe(this) {
            setUserFavoriteData(it)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}