package com.custom.floatingmessage

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.custom.floatingmessage.MyToast.Companion.ERROR
import com.custom.floatingmessage.MyToast.Companion.INFO
import com.custom.floatingmessage.MyToast.Companion.SUCCESS
import com.custom.floatingmessage.MyToast.Companion.WARNING
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Vishal on 12/08/22.
 */

object MySnackBar {
    fun Context.showSnackBarShort(view: View, title: String, type: Int, font: Typeface?) {
        val snackBar = Snackbar.make(view, "", Snackbar.LENGTH_SHORT)
        snackBar.animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE
        val layout: Snackbar.SnackbarLayout = snackBar.view as Snackbar.SnackbarLayout
        layout.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))
        val inflater: LayoutInflater =
            this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val snackView: View = inflater.inflate(R.layout.custom_snackbar_layout, null)
        val text = snackView.findViewById<View>(R.id.text) as TextView
        val rootView = snackView.findViewById<View>(R.id.rootView) as View
        rootView.setBackgroundResource(getBackground(type))
        text.text = title
        font?.let {
            text.typeface = it
        }
        layout.setPadding(0, 0, 0, 0)
        layout.addView(snackView)
        snackBar.show()
    }

    fun Context.showSnackBarLong(view: View, title: String, type: Int, font: Typeface?) {
        val snackBar = Snackbar.make(view, "", Snackbar.LENGTH_LONG)
        snackBar.animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE
        val layout: Snackbar.SnackbarLayout = snackBar.view as Snackbar.SnackbarLayout
        layout.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))
        val inflater: LayoutInflater =
            this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val snackView: View = inflater.inflate(R.layout.custom_snackbar_layout, null)
        val text = snackView.findViewById<View>(R.id.text) as TextView
        val rootView = snackView.findViewById<View>(R.id.rootView) as View
        rootView.setBackgroundResource(getBackground(type))

        font?.let {
            text.typeface = it
        }

        text.text = title
        layout.setPadding(0, 0, 0, 0)
        layout.addView(snackView)
        snackBar.show()
    }

    fun Context.showSnackBarIndefinite(
        view: View,
        title: String,
        buttonText: String?,
        type: Int, font: Typeface?
    ) {
        val snackBar = Snackbar.make(view, "", Snackbar.LENGTH_INDEFINITE)
        snackBar.animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE
        val layout: Snackbar.SnackbarLayout = snackBar.view as Snackbar.SnackbarLayout
        layout.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))
        val inflater: LayoutInflater =
            this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val snackView: View = inflater.inflate(R.layout.custom_snackbar_layout_2, null)
        val text = snackView.findViewById<View>(R.id.text) as TextView
        val tvOK = snackView.findViewById<View>(R.id.tvOK) as TextView
        val rootView = snackView.findViewById<View>(R.id.rootView) as View
        rootView.setBackgroundResource(getBackground(type))

        font?.let {
            text.typeface = it
            tvOK.typeface = it
        }

        text.text = title
        tvOK.setOnClickListener {
            snackBar.dismiss()
        }
        tvOK.text =
            if (buttonText != null && buttonText.isNotEmpty()) buttonText else this.getString(R.string.ok)

        layout.setPadding(0, 0, 0, 0)
        layout.addView(snackView)
        snackBar.show()
    }

    fun Context.showSnackBarProfileView(
        view: View,
        title: String,
        info: String?,
        image: String?, font: Typeface?
    ) {
        val snackBar = Snackbar.make(view, "", Snackbar.LENGTH_INDEFINITE)
        snackBar.animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE
        val layout: Snackbar.SnackbarLayout = snackBar.view as Snackbar.SnackbarLayout
        layout.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))
        val inflater: LayoutInflater =
            this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val snackView: View = inflater.inflate(R.layout.custom_snack_profile_view, null)
        val rootView = snackView.findViewById<View>(R.id.rootView) as View
        rootView.setBackgroundResource(R.drawable.bg_white_stroke)
        val text = snackView.findViewById<View>(R.id.text) as TextView
        val tvInfo = snackView.findViewById<View>(R.id.tvInfo) as TextView
        val tvOK = snackView.findViewById<View>(R.id.tvOK) as TextView
        val imProfile = snackView.findViewById<View>(R.id.imProfile) as ShapeableImageView

        font?.let {
            text.typeface = it
            tvInfo.typeface = it
            tvOK.typeface = it
        }

        text.text = title
        info?.let {
            tvInfo.text = info
            tvInfo.visibility = View.VISIBLE
        } ?: kotlin.run {
            tvInfo.visibility = View.INVISIBLE
        }

        Glide
            .with(this)
            .load(image)
            .centerCrop()
            .placeholder(R.drawable.ic_avatar)
            .into(imProfile)

        tvOK.setOnClickListener {
            snackBar.dismiss()
        }
        layout.setPadding(0, 0, 0, 0)
        layout.addView(snackView)
        snackBar.show()
    }

    private fun getBackground(type: Int): Int {
        when (type) {
            SUCCESS -> return R.drawable.bg_success_snack
            ERROR -> return R.drawable.bg_error_snack
            WARNING -> return R.drawable.bg_warning_snack
            INFO -> return R.drawable.bg_info_snack
        }
        return R.drawable.bg_success_snack
    }
}