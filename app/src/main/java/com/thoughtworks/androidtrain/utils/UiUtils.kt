package com.thoughtworks.androidtrain.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class UiUtils {
    companion object {
        fun replaceFragmentAndAddToBackStack(
            fm: FragmentManager,
            fragment: Fragment,
            fragmentId: Int,
            tag: String?
        ) {
            val fragmentTransaction = fm.beginTransaction()
            fragmentTransaction.replace(fragmentId, fragment, tag)
            fragmentTransaction.addToBackStack(tag)
            fragmentTransaction.commitAllowingStateLoss()
        }
    }
}