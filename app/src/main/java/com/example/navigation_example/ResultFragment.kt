package com.example.navigation_example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.navigation_example.databinding.ActivityMainBinding
import com.example.navigation_example.databinding.FragmentGameScreenBinding
import com.example.navigation_example.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val args: ResultFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val result = args.result

        when (result) {
            true -> {
                binding.resultText.text = "You Win!"
            }
            false -> {
                binding.resultText.text = "You Lose!"
            }
        }



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}