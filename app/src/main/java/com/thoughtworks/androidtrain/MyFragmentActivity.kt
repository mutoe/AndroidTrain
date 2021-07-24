package com.thoughtworks.androidtrain

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.thoughtworks.androidtrain.fragments.AndroidFragment
import com.thoughtworks.androidtrain.fragments.JavaFragment
import com.thoughtworks.androidtrain.utils.UiUtils

class MyFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_fragment_activity)

        displayAndroidFragment(null)
    }

    fun displayAndroidFragment(view: View?) {
        UiUtils.replaceFragmentAndAddToBackStack(
            supportFragmentManager,
            AndroidFragment(),
            R.id.fragment,
            null
        )
    }

    fun displayJavaFragment(view: View?) {
        UiUtils.replaceFragmentAndAddToBackStack(
            supportFragmentManager,
            JavaFragment(),
            R.id.fragment,
            null
        )
    }
}
