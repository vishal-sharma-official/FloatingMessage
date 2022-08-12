package com.custom.floatingmessage

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

/**
 * Created by Vishal on 12/08/22.
 */

class MyToast(context: Context) : Toast(context) {
    companion object {
        const val INFO = 0
        const val SUCCESS = 1
        const val WARNING = 2
        const val ERROR = 3

        var LENGTH_LONG = Toast.LENGTH_LONG
        var LENGTH_SHORT = Toast.LENGTH_SHORT

        fun myToastShort(mContext: Context, message: String, type: Int, font: Typeface?) {
            val myToast = MyToast(mContext)
            val inflater: LayoutInflater =
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view: View = inflater.inflate(R.layout.custom_toast_layout, null)

            val icon = view.findViewById<View>(R.id.icon) as ImageView
            val text = view.findViewById<View>(R.id.text) as TextView

            when (type) {
                SUCCESS -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            mContext,
                            R.drawable.ic_baseline_check_circle_24
                        )
                    )
                    view.background = ContextCompat.getDrawable(
                        mContext,
                        R.drawable.bg_success
                    )
                }
                WARNING -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            mContext,
                            R.drawable.ic_baseline_warning_24
                        )
                    )
                    view.background = ContextCompat.getDrawable(
                        mContext,
                        R.drawable.bg_warning
                    )
                }
                ERROR -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            mContext,
                            R.drawable.ic_baseline_error_24
                        )
                    )
                    view.background = ContextCompat.getDrawable(
                        mContext,
                        R.drawable.bg_error
                    )
                }
                else -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            mContext,
                            R.drawable.ic_baseline_info_24
                        )
                    )
                    view.background = ContextCompat.getDrawable(
                        mContext,
                        R.drawable.bg_info
                    )
                }
            }
            font?.let {
                text.typeface = it
            }

            text.text = message
            myToast.duration = LENGTH_SHORT
            myToast.view = view
            myToast.show()
        }

        fun myToastLong(mContext: Context, message: String, type: Int, font: Typeface?) {
            val myToast = MyToast(mContext)
            val inflater: LayoutInflater =
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view: View = inflater.inflate(R.layout.custom_toast_layout, null)

            val icon = view.findViewById<View>(R.id.icon) as ImageView
            val text = view.findViewById<View>(R.id.text) as TextView

            when (type) {
                SUCCESS -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            mContext,
                            R.drawable.ic_baseline_check_circle_24
                        )
                    )
                    view.background = ContextCompat.getDrawable(
                        mContext,
                        R.drawable.bg_success
                    )
                }
                WARNING -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            mContext,
                            R.drawable.ic_baseline_warning_24
                        )
                    )
                    view.background = ContextCompat.getDrawable(
                        mContext,
                        R.drawable.bg_warning
                    )
                }
                ERROR -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            mContext,
                            R.drawable.ic_baseline_error_24
                        )
                    )
                    view.background = ContextCompat.getDrawable(
                        mContext,
                        R.drawable.bg_error
                    )
                }
                else -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            mContext,
                            R.drawable.ic_baseline_info_24
                        )
                    )
                    view.background = ContextCompat.getDrawable(
                        mContext,
                        R.drawable.bg_info
                    )
                }
            }

            font?.let {
                text.typeface = it
            }
            text.text = message
            myToast.duration = LENGTH_LONG
            myToast.view = view
            myToast.show()
        }
    }
}