package com.example.instagram.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.instagram.R
import com.example.instagram.databinding.FragmentHomeBinding
import com.example.instagram.ui.image.ImageFragment

class HomeFragment : Fragment() {
    class MyAdapter(fa: HomeFragment):FragmentStateAdapter(fa){

        private val resource = listOf(
            R.drawable.slide00,R.drawable.slide01,
            R.drawable.slide02,R.drawable.slide03,
            R.drawable.slide04,R.drawable.slide05,
            R.drawable.slide06,R.drawable.slide07,
            R.drawable.slide08,R.drawable.slide09,
        )

        override fun getItemCount(): Int = resource.size

        override fun createFragment(position: Int): Fragment =ImageFragment.newInstance(resource[position])

    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        homeViewModel.text.observe(viewLifecycleOwner) {
            binding.pager.adapter=MyAdapter(this)
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}