package com.example.hw1a2.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hw1a2.News
import com.example.hw1a2.News_Adapter
import com.example.hw1a2.R
import com.example.hw1a2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
private lateinit var adapter: News_Adapter
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = News_Adapter {
val  news = adapter.getItem(it)
            Toast.makeText(requireContext(),news.title,Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fap.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
        }
        parentFragmentManager.setFragmentResultListener(
            "rk_news",
            viewLifecycleOwner
        ) { _, bundle ->
            val news = bundle.getSerializable("news") as News
            Log.e("Home","text - $news")
            adapter.addItem(news)

            binding.imgdelete.setOnClickListener(AdapterView.OnItemLongClickListener()) {

            }
        }
        binding.recycleView.adapter = adapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun ImageButton.setOnClickListener(
    onItemLongClickListener: AdapterView.OnItemLongClickListener,
    function: () -> Unit
) {

}
