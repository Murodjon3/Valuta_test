package com.example.valuta_kursi

import SliderView.SliderAdapter
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
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class MainActivity : AppCompatActivity() {
    lateinit var dialog: MaterialAlertDialogBuilder

    @SuppressLint("MissingInflatedId", "UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sliderView = findViewById<SliderView>(R.id.imageSlider)
        changeFragment(Fragment2())
        val myList = listOf(
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,
        )
        findViewById<ImageView>(R.id.menu).setOnClickListener {
            changeFragment(Fragment2())
        }

        findViewById<ImageView>(R.id.settings).setOnClickListener {
            changeFragment(fragment3())
        }

        findViewById<ImageView>(R.id.value).setOnClickListener {
            changeFragment(Fragment1())
        }

        findViewById<ImageView>(R.id.imagechat).setOnClickListener {
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
        sliderView.apply {
            setSliderAdapter(SliderAdapter(myList))//set adapter
            setIndicatorAnimation(IndicatorAnimationType.WORM)// indicator animatsiya turi
            setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
            scrollTimeInSec = 1//set scroll delay in seconds
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
            startAutoCycle()
        }
    }
    private fun changeFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_ly, fragment)
        fragmentTransaction.commit()
    }

    }
