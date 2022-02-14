package com.example.randomie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class YesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_yes, container, false)

        val back_button = view.findViewById<ImageButton>(R.id.back_button)
        back_button.setOnClickListener{
            findNavController().navigate(R.id.action_yesFragment_to_menuFragment)
        }

        val ball = view.findViewById<ImageView>(R.id.ball)
        val text = view.findViewById<TextView>(R.id.text)
        onBallTap(ball, text)
        return view
    }

    private fun onBallTap(ball: ImageView, text: TextView) {
        ball.setOnClickListener {
            val randomnumber = (1..20).random()

            val result = when (randomnumber) {
                1 -> R.string.It_is_certain
                2 -> R.string.It_is_decidedly_so
                3 -> R.string.Without_a_doubt
                4 -> R.string.Yes_definitely
                5 -> R.string.You_may_rely_on_it
                6 -> R.string.Very_doubtful
                7 -> R.string.Outlook_good
                8 -> R.string.Outlook_not_so_good
                9 -> R.string.My_sources_say_no
                10 -> R.string.My_reply_is_no
                11 -> R.string.Dont_count_on_it
                12 -> R.string.As_I_see_it_yes
                13 -> R.string.Most_likely
                14 -> R.string.Signs_point_to_yes
                15 -> R.string.Yes
                16 -> R.string.Reply_hazy_try_again
                17 -> R.string.Ask_again_later
                18 -> R.string.Better_not_tell_you_now
                19 -> R.string.Cannot_predict_now
                else -> R.string.Concentrate_and_ask_again
            }
            text.setText(result)
        }
    }
}
