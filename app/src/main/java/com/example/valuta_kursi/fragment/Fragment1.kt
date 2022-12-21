package com.example.valuta_kursi.fragment

import com.example.valuta_kursi.Adapter.HomeAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.valuta_kursi.BViewModel
import com.example.valuta_kursi.R
import com.example.valuta_kursi.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    lateinit var baseViewModel: BViewModel
    private var _binding: Fragment1Binding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
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

        baseViewModel = ViewModelProvider(requireActivity())[BViewModel::class.java]

        recyclerView = binding.chatRecycler1
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        liveData()
        loadData()

        loadFlags()
        binding.swipeContainer.setOnRefreshListener {
            loadData()

        }
        binding.swipeContainer.isRefreshing = true
        binding.swipeContainer.setColorSchemeResources(
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light
        )
    }

    private fun liveData() {
        baseViewModel.apply {
            resultList.observe(viewLifecycleOwner, Observer {
                recyclerView.adapter =
                    HomeAdapter(it ?: emptyList())
                Log.d("getResponse", "list kiribkeldi")
            })

            progress.observe(viewLifecycleOwner, Observer { progressPos ->
                binding.swipeContainer.isRefreshing = progressPos
            })
            error.observe(viewLifecycleOwner, Observer {error->

                Log.d("getResponse", "Xatolik bor $error")
            })
        }

    }


    private fun loadData() {
        baseViewModel.loadResponse()
    }

    private fun loadFlags() {
//        NetManager.getFlagsApi().getFlags().enqueue(object : Callback<List<DataModel>> {
//            override fun onResponse(
//                call: Call<List<DataModel>>,
//                response: Response<List<DataModel>>
//            ) {
//                if (response.isSuccessful) {
//                    recyclerView.adapter =
//                        HomeAdapter(response.body() ?: emptyList())
//                }
//            }
//
//            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
//                Toast.makeText(requireContext(), "Internetda hato bor", Toast.LENGTH_SHORT).show()
//            }
//        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
