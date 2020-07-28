package com.vkhooda24.arduinoledcontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

private const val DATABASE_FIELD_REFERENCE = "led_status"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firebaseDatabase = FirebaseDatabase.getInstance()
        val reference = firebaseDatabase.getReference(DATABASE_FIELD_REFERENCE)

        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                reference.setValue(true)
            } else {
                reference.setValue(false)
            }
        }
    }
}