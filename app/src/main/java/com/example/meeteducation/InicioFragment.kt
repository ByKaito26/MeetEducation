package com.example.meeteducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class InicioFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root= inflater.inflate(R.layout.fragment_inicio, container, false)
        val btnLogin = root.findViewById<Button>(R.id.btn_login)
        val textSign = root.findViewById<TextView>(R.id.sign_up)

        btnLogin.setOnClickListener{
            findNavController().navigate(R.id.action_inicioFragment_to_loginFragment)
        }
        textSign.setOnClickListener{
            findNavController().navigate(R.id.action_inicioFragment_to_registerFragment)
        }
        return root
    }




}