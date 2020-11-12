package com.example.friendsr

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.layout_perfil.view.*

class Adapter(private val ccontext: Context, private val listaperfil: List<Perfil>) :
    ArrayAdapter<Perfil>(ccontext, 0, listaperfil) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutperfil = LayoutInflater.from(ccontext).inflate(R.layout.layout_perfil, parent, false)

        val perfil = listaperfil[position]

        layoutperfil.nombre.text = perfil.nombre

        layoutperfil.imagen.setImageResource(perfil.imagen)

        return layoutperfil
    }
}