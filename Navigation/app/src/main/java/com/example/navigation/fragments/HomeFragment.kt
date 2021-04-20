package com.example.navigation.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigation.R
import com.example.navigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.button.setOnClickListener {
            if(!TextUtils.isEmpty(binding.editTextTextPersonName.text.toString())) {
                val bundle: Bundle =
                    bundleOf("user_input" to binding.editTextTextPersonName.text.toString())
                it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment)
            }else{
                Toast.makeText(activity,"Please insert your name",Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }


}