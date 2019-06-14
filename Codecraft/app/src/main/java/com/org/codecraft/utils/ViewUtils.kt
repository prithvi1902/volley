package com.org.codecraft.utils

import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.inputmethod.InputMethodManager

class ViewUtils {
    companion object {
        /**
         * Hides the soft keyboard
         */
        fun hideSoftKeyboard(view: View?) {
            view?.let {
                val inputMethodManager = it.context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
            }
        }

        /**
         * Shows the soft keyboard
         */
        fun showSoftKeyboard(view: View?) {
            view?.let {
                val inputMethodManager = it.context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
                it.requestFocus()
                inputMethodManager?.showSoftInput(view, 0)
            }
        }
    }
}


