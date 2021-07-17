package com.thoughtworks.androidtrain

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity Created")
    }

    fun openConstraintActivity(view: View) {
        val intent = Intent(this, ConstraintActivity::class.java)
        startActivity(intent)
    }
}