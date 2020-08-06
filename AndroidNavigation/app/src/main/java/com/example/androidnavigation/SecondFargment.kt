package com.example.androidnavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_second_fargment.view.*

/**
 * A simple [Fragment] subclass.
 */
class SecondFargment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_second_fargment, container, false)
        root.btprevius.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_secondFargment_to_firstFargment)

        }
        return root
    }


}
