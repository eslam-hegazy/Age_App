package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var title=findViewById<TextView>(R.id.textTitle)
        var inputField=findViewById<EditText>(R.id.textField1)
        var subButton=findViewById<Button>(R.id.submitButton)
        var visibleButton=findViewById<Button>(R.id.visibleButton)


        ////Actions
        subButton.setOnClickListener {
           if(inputField.text.toString()==""){
               Toast.makeText(this@MainActivity,"Please Enter Your BirthDay!!",Toast.LENGTH_LONG).show()
           }else{
               val currentYear=Calendar.getInstance().get(Calendar.YEAR)
               val yearOfBirth=inputField.text.toString().toInt()
               var result=currentYear-yearOfBirth
               title.text="Your BirthDay Is : ${result.toString()}"
           }
        }

        ///Action Visiability Button
        visibleButton.setOnClickListener {
            var intent= Intent(this,second::class.java)
            intent.putExtra("USER",inputField.text.toString())
            startActivity(intent)
        }
    }
}