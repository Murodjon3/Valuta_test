package com.example.valuta_kursi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valuta_kursi.R
import com.example.valuta_kursi.databinding.Fragment2Binding
import com.example.valuta_kursi.databinding.FragmentFragment3Binding

class Fragment2 : Fragment() {
    private var b: Fragment2Binding? = null
    private val binding get() = b!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        b = Fragment2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}