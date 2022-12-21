package com.example.valuta_kursi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Switch
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.example.valuta_kursi.fragment.Fragment1
import com.example.valuta_kursi.fragment.Fragment2
import com.example.valuta_kursi.fragment.fragment3

class MainActivity : AppCompatActivity() {
    lateinit var dialog: MaterialAlertDialogBuilder

    @SuppressLint("MissingInflatedId", "UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment11 = findViewById<ImageView>(R.id.image2)
        val fragment22 = findViewById<ImageView>(R.id.imageView)
        val fragment33 = findViewById<ImageView>(R.id.imageView3)


        fragment33.setOnClickListener {
            changeFragment(fragment3())
        }

        fragment22.setOnClickListener {
            changeFragment(Fragment2())
        }
            changeFragment(Fragment1())

        fragment11.setOnClickListener {
        }

        val chat = findViewById<ImageView>(R.id.imagechat)
        chat.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.game1, null)

            val kirilcha = view.findViewById<Switch>(R.id.switch1)
            kirilcha.setOnClickListener {

            }
            dialog = MaterialAlertDialogBuilder(this)
                .setTitle("Tillar")
                .setView(view)
                .setMessage("tilni tanlang")

                .setNeutralButton("Ok") { dialog, which ->
                    dialog.dismiss()
                }
                .setPositiveButton("Orqaga") { dialog, which ->
                    dialog.cancel()
                }
            dialog.show()
        }
    }
    private fun changeFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_ly, fragment)
        fragmentTransaction.commit()
    }

}