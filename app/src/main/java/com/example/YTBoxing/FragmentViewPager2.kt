package com.example.YTBoxing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentViewPager2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.page_layout2, container, false)
    }
    companion object {
        fun newInstance(): FragmentViewPager2 {
            return FragmentViewPager2()
        }
    }
}