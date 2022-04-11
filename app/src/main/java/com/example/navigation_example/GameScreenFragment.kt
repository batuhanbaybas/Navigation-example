package com.example.navigation_example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigation_example.databinding.FragmentGameScreenBinding


class GameScreenFragment : Fragment() {
    private var _binding: FragmentGameScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      _binding = FragmentGameScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val randomNumber = (1..100).random()

        var hak = 10



        binding.button.setOnClickListener {
            binding.turnText.text = "Turn: $hak"
            val number = binding.editTextTextPersonName.text.toString().toInt()
            if (number > randomNumber) {
                binding.helperText.text = "Daha Küçük"
                hak--
            } else if (number < randomNumber) {
                binding.helperText.text = "Daha Büyük"
                hak--
            } else {
                val action = GameScreenFragmentDirections.gameToResult(true)
                findNavController().navigate(action)
            }
            if (hak==0){
            val action = GameScreenFragmentDirections.gameToResult(false)
            findNavController().navigate(action)
        }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}