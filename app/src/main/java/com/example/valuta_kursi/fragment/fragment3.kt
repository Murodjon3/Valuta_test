package com.example.valuta_kursi.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.valuta_kursi.BViewModel
import com.example.valuta_kursi.R
import com.example.valuta_kursi.databinding.Fragment1Binding

class fragment3 : Fragment() {
    private var _binding: Fragment1Binding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = Fragment1Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val share = view.findViewById<CardView>(R.id.share)
        share.setOnClickListener {
            shareLink("Salom")
        }
        val sayt = view.findViewById<CardView>(R.id.sayt)
        sayt.setOnClickListener {
            openUrl("https://cbu.uz/uz/arkhiv-kursov-valyut/")
        }
    }

    fun shareLink(url: String) {
        val share = Intent(Intent.ACTION_SEND)
        share.type = "text/plain"
        val shareText =
            getString(R.string.app_name) + ":\n" + url
        share.putExtra(Intent.EXTRA_TEXT, shareText)
        startActivity(Intent.createChooser(share, "Ulashish"))
    }

    private fun openUrl(url: String) {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(i)
    }
}

