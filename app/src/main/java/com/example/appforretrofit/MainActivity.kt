// Идея mini app
/*
* На экране будут 2 фрагмента, в одном фрагменте мы вводим данные для поиска
* коммента, в другом мы выводим эти данные
* */

package com.example.appforretrofit

import com.example.appforretrofit.Retrofit.ProductApi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.appforretrofit.Fragmets.NewFragment
import com.example.appforretrofit.Fragmets.SecondFragment
import com.example.appforretrofit.Retrofit.Osnova
import com.example.appforretrofit.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    lateinit var product: Osnova
    lateinit var bd: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bd = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bd.root)

        bd.button.setOnClickListener {
            //запускаем фрагмент NewFragment
            openFragment(NewFragment(), savedInstanceState)
        }

        bd.button2.setOnClickListener {
            openFragment(SecondFragment(), savedInstanceState)
        }
    }

    fun openFragment(f: Fragment, s: Bundle?){
        if(s == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, f)
                .commit()
        }
    }
}