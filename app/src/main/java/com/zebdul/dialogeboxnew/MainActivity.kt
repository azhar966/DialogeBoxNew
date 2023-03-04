package com.zebdul.dialogeboxnew

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mybutton = findViewById<Button>(R.id.btnClick)
        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))

        var buttonGood = dialog.findViewById<Button>(R.id.btnGood)
        var buttonFeedback = dialog.findViewById<Button>(R.id.btnFeedback)

        buttonGood.setOnClickListener {
            dialog.dismiss()
        }
        buttonFeedback.setOnClickListener {
            val multipleOption1 = arrayOf("1", "2", "3", "4", "5")
            val alertBox = AlertDialog.Builder(this)
            alertBox.setTitle("Choose an option")
            alertBox.setSingleChoiceItems(multipleOption1, 0, DialogInterface.OnClickListener
            { dialog, which -> })
            alertBox.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "Thanks for your feedback", Toast.LENGTH_SHORT).show()
            })
            dialog.dismiss()
            alertBox.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "Please Choose an option", Toast.LENGTH_SHORT).show()
            })
            alertBox.show()        }
        mybutton.setOnClickListener {
            dialog.show()        }
    }
}
