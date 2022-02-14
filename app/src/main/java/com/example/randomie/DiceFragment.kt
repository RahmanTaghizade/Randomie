package com.example.randomie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import kotlin.random.Random

class DiceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dice, container, false)

        val dice1: ImageView = view.findViewById(R.id.dice1)
        val dice2: ImageView = view.findViewById(R.id.dice2)
        val roll: Button = view.findViewById(R.id.roll)

        roll.setOnClickListener {
            roll(dice1, dice2)
            }

        val back_button = view.findViewById<ImageButton>(R.id.back_button)
        back_button.setOnClickListener{
            findNavController().navigate(R.id.action_diceFragment_to_menuFragment)
        }

        return view
    }

    private fun roll(dice1: ImageView, dice2: ImageView) {
        val random1 = Random.nextInt(6)+1
        val random2 = Random.nextInt(6)+1
        val drawable1 = when(random1) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        val drawable2 = when(random2) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        dice1.setImageResource(drawable1)
        dice2.setImageResource(drawable2)
    }
}