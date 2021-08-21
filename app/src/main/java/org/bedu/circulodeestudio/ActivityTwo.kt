package org.bedu.circulodeestudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityTwo : AppCompatActivity() {

    private lateinit var msg : TextView
    private lateinit var but : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        msg = findViewById(R.id.msg)
        but = findViewById(R.id.button2)

        // Recibimos el paquete 📦
        val bundle = intent.extras

        // Hacemos el unboxing 😮
        val name = bundle?.getString(USER_NAME)

        msg.text = "Hello ${name}!!!"

        but.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply{}
            startActivity(intent)
        }

    }
}