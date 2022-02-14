package com.example.randomie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import java.util.*

class OptionsFragment : Fragment() {
    lateinit var locale: Locale
    private var currentLanguage = "en"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_options, container, false)
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()

        val english = view.findViewById<Button>(R.id.english);
        val german = view.findViewById<Button>(R.id.german);
        val russian = view.findViewById<Button>(R.id.russian);
        val french = view.findViewById<Button>(R.id.french);
        val spanish = view.findViewById<Button>(R.id.spanish);
        val italian = view.findViewById<Button>(R.id.italian);
        val japanese = view.findViewById<Button>(R.id.japanese);
        val korean = view.findViewById<Button>(R.id.korean);
        val chinese = view.findViewById<Button>(R.id.chinese);

        english.setOnClickListener{
            setLocale("en")
            ft.detach(this).attach(this).commit();
        }

        german.setOnClickListener{
            setLocale("ge")
            ft.detach(this).attach(this).commit();
        }

        russian.setOnClickListener{
            setLocale("ru")
            ft.detach(this).attach(this).commit();
        }

        french.setOnClickListener{
            setLocale("fr")
            ft.detach(this).attach(this).commit();
        }

        spanish.setOnClickListener{
            setLocale("es")
            ft.detach(this).attach(this).commit();
        }

        italian.setOnClickListener{
            setLocale("it")
            ft.detach(this).attach(this).commit();
        }
        japanese.setOnClickListener{
            setLocale("ja")
            ft.detach(this).attach(this).commit();
        }
        korean.setOnClickListener{
            setLocale("ko")
            ft.detach(this).attach(this).commit();
        }
        chinese.setOnClickListener{
            setLocale("zh")
            ft.detach(this).attach(this).commit();
        }


        val back_button = view.findViewById<ImageButton>(R.id.back_button)
        back_button.setOnClickListener{
            findNavController().navigate(R.id.action_optionsFragment_to_menuFragment)
        }

        return view
    }

    private fun setLocale(localeName: String) {
        if (localeName != currentLanguage) {
            locale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)
        }
    }
}