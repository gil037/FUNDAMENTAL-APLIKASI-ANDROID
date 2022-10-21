package com.example.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.aplikasigithubuser.User

class Detail : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
//        const val EXTRA_USERNAME = "extra_username"
//        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.title = "Github User"

        val tvName : TextView = findViewById(R.id.detail_tv_item_name)
        val tvUsername : TextView = findViewById(R.id.detail_tv_item_username)
        val ivPhoto : ImageView = findViewById(R.id.detail_img_item_user)
        val tvLocation : TextView = findViewById(R.id.detail_location)

        val akun = intent.getParcelableExtra<User>(EXTRA_USER) as User
        tvName.text = akun.name
        tvUsername.text = "@${akun.username}"
        akun.photo?.let { ivPhoto.setImageResource(it) }




//        val tvName = intent.getParcelableExtra<User>("extra_name")
    }
}