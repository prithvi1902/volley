package com.org.codecraft.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import com.google.android.material.snackbar.Snackbar
import com.org.codecraft.MainActivity
import com.org.codecraft.R
import com.org.codecraft.utils.ViewUtils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.apply {
            this.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        btnLogin.setOnClickListener {
            ViewUtils.hideSoftKeyboard(it)
            if (isEmpty()) {
                Snackbar.make(it, getString(R.string.please_fill_in_details), Snackbar.LENGTH_SHORT).show()
            } else {
                progressBar.visibility = View.VISIBLE
                Handler().postDelayed({
                    progressBar.visibility = View.GONE
                    startActivity(Intent(this, MainActivity::class.java))
                }, 1000)
            }
        }
    }

    private fun isEmpty(): Boolean {
        return TextUtils.isEmpty(etUserName.text) && TextUtils.isEmpty(etPassword.text)
    }
}
