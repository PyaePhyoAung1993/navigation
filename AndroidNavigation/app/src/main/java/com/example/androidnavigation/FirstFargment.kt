package com.example.androidnavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_first_fargment.view.*

/**
 * A simple [Fragment] subclass.
 */
class FirstFargment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var root = inflater.inflate(R.layout.fragment_first_fargment, container, false)

        root.btnNext.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_firstFargment_to_secondFargment)

        }
        // Inflate the layout for this fragment
        return root
    }


}
