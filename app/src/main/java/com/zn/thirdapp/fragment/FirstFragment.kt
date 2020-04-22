package com.zn.thirdapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zn.thirdapp.R
import com.zn.thirdapp.activity.SecondActivity
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_first.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("text", textview_first.text.toString())
            val intent = Intent(activity, SecondActivity::class.java).apply {
                this.putExtra("BUNDLE",bundle)
            }
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var bundle = data?.getBundleExtra("BUNDLE")
        var text = bundle?.get("text")
        textview_first.text = text.toString()
    }
}
