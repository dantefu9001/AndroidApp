package com.zn.thirdapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zn.thirdapp.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var bundle = intent.getBundleExtra("BUNDLE")
        var text = bundle?.get("text")
        textview_activity_second.text = text.toString()
        //change data on click
        button_activity_second.setOnClickListener {
            var randomString = (0..100).random()
            bundle?.putString("text","random Number: $randomString")
            intent.putExtra("BUNDLE",bundle)
            setResult(1,intent)
            finish()
        }
    }
}
