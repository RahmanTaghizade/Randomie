package com.example.randomie

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import kotlin.random.Random

class NumberFragment : Fragment() {

    lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_number, container, false)

        pref = this.requireActivity().getSharedPreferences("STORAGE", Context.MODE_PRIVATE)

        val result: TextView = view.findViewById(R.id.result)
        val no: String = ""
        val preresult: String = ""
        val minnumber: EditText = view.findViewById(R.id.minnumber)
        val maxnumber: EditText = view.findViewById(R.id.maxnumber)
        val randomize: Button = view.findViewById(R.id.randomize)
        val back_button = view.findViewById<ImageButton>(R.id.back_button)

        back_button.setOnClickListener{
            val min_number: String = minnumber.text.toString()
            val max_number: String = maxnumber.text.toString()

            val min = min_number.toLongOrNull()
            val max = max_number.toLongOrNull()

            if (min != null) {
                saveData_min(min.toString())}
            if (max != null){
                saveData_max(max.toString())}
            findNavController().navigate(R.id.action_numberFragment_to_menuFragment)
        }

        val getmin:String = pref.getString("min", "")!!
        val getmax:String = pref.getString("max", "")!!
        val getpreresult:String = pref.getString("preresult", "")!!

        minnumber.setText(getmin, TextView.BufferType.EDITABLE)
        maxnumber.setText(getmax, TextView.BufferType.EDITABLE)
        result.setText(getpreresult, TextView.BufferType.EDITABLE)

        randomize.setOnClickListener {
            val min_number: String = minnumber.text.toString()
            val max_number: String = maxnumber.text.toString()

            val min = min_number.toLongOrNull()
            var max = max_number.toLongOrNull()

            if (max != null) {
                max += 1
            }
            if (max != null && min != null) {
                if (min < max) {
                    val numer = List(1) {
                        Random.nextLong(min, max)
                    }
                    val answer: String = numer.elementAt(0).toString()
                    result.text = answer
                    saveData_preresult(answer.toString())
                } else {
                    result.text = no
                }
            }
        }
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val min_number: String = minnumber.text.toString()
                val max_number: String = maxnumber.text.toString()

                val min = min_number.toLongOrNull()
                val max = max_number.toLongOrNull()

                if (min != null) {
                    saveData_min(min.toString())}
                if (max != null){
                    saveData_max(max.toString())}
                findNavController().navigate(R.id.action_numberFragment_to_menuFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback)
        return view

    }

    fun saveData_min(res: String){
        val editor = pref.edit()
        editor.putString("min", res)
        editor.apply()
    }

    fun saveData_max(res: String){
        val editor = pref.edit()
        editor.putString("max", res)
        editor.apply()
    }
    fun saveData_preresult(res: String){
        val editor = pref.edit()
        editor.putString("preresult", res)
        editor.apply()
    }

}