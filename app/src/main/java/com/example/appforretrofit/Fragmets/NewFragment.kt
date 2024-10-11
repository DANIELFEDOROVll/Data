package com.example.appforretrofit.Fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.appforretrofit.R
import com.example.appforretrofit.Retrofit.Osnova
import com.example.appforretrofit.Retrofit.ProductApi
import com.example.appforretrofit.Vmodel
import com.example.appforretrofit.databinding.FragmentNewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NewFragment : Fragment(R.layout.fragment_new) {
    private var bd: FragmentNewBinding? = null
    lateinit var product: Osnova

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bd = FragmentNewBinding.bind(view)

        val retrofit = Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val productapi = retrofit.create(ProductApi::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            product = productapi.getProductById()
        }

        bd?.buttonSearch?.setOnClickListener {
            val id = bd?.edittext1?.text.toString().toInt()
            val comment = product.comments[id-1]

            val com = Com(comment.id, comment.user.username, comment.body)

            val sharedModel = ViewModelProvider(requireActivity()).get(Vmodel::class.java)
            sharedModel.com = com

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, SecondFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bd = null
    }

    companion object{
        val baseurl = "https://dummyjson.com/"
    }

}