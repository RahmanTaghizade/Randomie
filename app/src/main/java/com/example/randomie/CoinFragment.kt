package com.example.randomie

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kotlin.random.Random

class CoinFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_coin, container, false)
        val back_button = view.findViewById<ImageButton>(R.id.back_button)
        back_button.setOnClickListener {
            findNavController().navigate(R.id.action_coinFragment_to_menuFragment)
        }
        val coin = view.findViewById<ImageView>(R.id.coin)
        val fell = view.findViewById<TextView>(R.id.fell)
        onCoinTap(fell, coin)

        return view
    }

    private fun onCoinTap(onfell: TextView, oncoin: ImageView) {
            oncoin.setOnClickListener{
                val randomnumber = (1..2).random()

                val tails:String = resources.getString(R.string.tails);
                val head:String = resources.getString(R.string.head);

                if (randomnumber == 1){
                    flipCoin(onfell, oncoin, R.drawable.coin1, head)
                }
                else{
                    flipCoin(onfell, oncoin, R.drawable.coin0, tails)
                }
            }
        }

    private fun flipCoin(onfell: TextView, oncoin: ImageView, imageId: Int, CoinSide: String) {
            oncoin.animate().apply {
                duration = 1000
                rotationYBy(1800f)
                oncoin.isClickable = false
            }.withEndAction{
                oncoin.setImageResource(imageId)
                onfell.setText(CoinSide)
                oncoin.isClickable = true
            }.start()
    }
}