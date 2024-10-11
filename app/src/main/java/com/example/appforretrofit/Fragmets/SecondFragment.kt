package com.example.appforretrofit.Fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.appforretrofit.R
import com.example.appforretrofit.Vmodel
import com.example.appforretrofit.databinding.FragmentSecondBinding


class SecondFragment : Fragment(R.layout.fragment_second) {
    private var bd: FragmentSecondBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bd = FragmentSecondBinding.bind(view)

        var sharedModel = ViewModelProvider(requireActivity()).get(Vmodel::class.java)

        bd?.textID?.text = "id: " + sharedModel.com?.id.toString()
        bd?.textUSERNAME?.text = "username: "+ sharedModel.com?.username.toString()
        bd?.textBODY?.text = "text of comment: " + sharedModel.com?.body.toString()
    }



    override fun onDestroy() {
        super.onDestroy()
        bd = null
    }
}