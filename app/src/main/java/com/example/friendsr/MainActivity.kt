package com.example.friendsr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val perfil = Perfil("andres", "ingeniero", R.drawable.andresimg)
        val perfil1 = Perfil("Daniela", "arquitecta", R.drawable.daniela)
        val perfil2 = Perfil("Marga", "Constructora", R.drawable.c)
        val perfil3 = Perfil("Cristian", "Escritor", R.drawable.m)
        val perfil4 = Perfil("Luisa", "MOdelo", R.drawable.l)
        val listaperfil = listOf(perfil,perfil4,perfil3,perfil2,perfil1)

        val adapter = Adapter(this, listaperfil)
        listview.adapter = adapter
        listview.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(this, Description::class.java)
            intent.putExtra("despcripcion", listaperfil[position])
            startActivity(intent)

        }
    }
}