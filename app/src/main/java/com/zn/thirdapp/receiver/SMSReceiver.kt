package com.zn.thirdapp.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast

class SMSReceiver : BroadcastReceiver() {

    private var mPUDS = "pdus"

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        var bundle = intent.extras
        var messageArrays: Array<ByteArray> = bundle?.get(mPUDS) as Array<ByteArray>
        lateinit var content : String
        for (byte in messageArrays) {
            var message = SmsMessage.createFromPdu(byte)//format问题？
            content = message.messageBody
            Log.i("Received: ", content)
        }
        if(content.isNotBlank()){
            Toast.makeText(context, "收到信息: $content", Toast.LENGTH_SHORT).show();
        }
    }
}
