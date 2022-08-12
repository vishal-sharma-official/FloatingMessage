package com.custom.toast


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.custom.floatingmessage.MySnackBar
import com.custom.floatingmessage.MySnackBar.showSnackBarProfileView
import com.custom.floatingmessage.MyToast
import com.custom.floatingmessage.MyToast.Companion.ERROR
import com.custom.floatingmessage.MyToast.Companion.INFO
import com.custom.floatingmessage.MyToast.Companion.SUCCESS
import com.custom.floatingmessage.MyToast.Companion.WARNING


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val typeface = ResourcesCompat.getFont(this, R.font.poppins_semi_bold)
        findViewById<Button>(R.id.button).setOnClickListener {
          //  MyToast.myToastShort(this, "Success", SUCCESS, typeface)
            this.showSnackBarProfileView(it, "hello SNack", null, "", null)
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            MyToast.myToastShort(this, "Error", ERROR, typeface)
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            MyToast.myToastShort(this, "Info", INFO, typeface)
        }

        findViewById<Button>(R.id.button4).setOnClickListener {
            MyToast.myToastShort(this, "Warning", WARNING, typeface)
        }
    }
}