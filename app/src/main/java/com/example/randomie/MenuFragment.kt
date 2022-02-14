package com.example.randomie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val options_button = view.findViewById<ImageButton>(R.id.options_button)
        val number_button = view.findViewById<Button>(R.id.number_button)
        val password_button = view.findViewById<Button>(R.id.password_button)
        val dice_button = view.findViewById<Button>(R.id.dice_button)
        val coin_button = view.findViewById<Button>(R.id.coin_button)
        val magic_button = view.findViewById<Button>(R.id.magic_button)


        options_button.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_optionsFragment)
        }
        number_button.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_numberFragment)
        }
        password_button.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_passwordFragment)
        }
        dice_button.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_diceFragment)
        }
        coin_button.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_coinFragment)
        }
        magic_button.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_yesFragment)
        }
        return view
    }
}