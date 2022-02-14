package com.example.randomie

import android.R.attr
import android.content.ClipData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import java.lang.StringBuilder
import java.util.*
import android.R.attr.label
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.widget.*
import androidx.core.content.ContextCompat

import androidx.core.content.ContextCompat.getSystemService





class PasswordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_password, container, false)

        val maxnumber: EditText = view.findViewById(R.id.maxnumber)
        val generate: Button = view.findViewById(R.id.randomize)
        val copy: ImageButton = view.findViewById(R.id.copy)
        val result: EditText = view.findViewById(R.id.result)

        generate.setOnClickListener {
            val max_number: String = maxnumber.text.toString()
            val max = max_number.toIntOrNull()
                val answer = pass(max)
                result.setText(answer)
            }

        val back_button = view.findViewById<ImageButton>(R.id.back_button)
        back_button.setOnClickListener {
            findNavController().navigate(R.id.action_passwordFragment_to_menuFragment)
        }

        copy.setOnClickListener{
            copyTextToClipboard(result)
            Toast.makeText(getActivity(),R.string.copy,Toast.LENGTH_SHORT).show()
        }

        return view
    }
    private val chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ()?!._"
    private fun pass(max:Int?): String {
        if (max != null) {
            if (max < 61) {
                val sb = StringBuilder(max)
                for (x in 0 until max) {
                    val random = (chars.indices).random()
                    sb.append(chars[random])
                }
                return sb.toString()
            }
            else{
                return ("").toString()
            }
        }
        else{
            return ("").toString()
        }
    }

    private fun copyTextToClipboard(etTextToCopy: EditText) {
        val textToCopy = etTextToCopy.text
        val clipboardManager: ClipboardManager = activity?.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", textToCopy)
        clipboardManager.setPrimaryClip(clipData)
    }
}