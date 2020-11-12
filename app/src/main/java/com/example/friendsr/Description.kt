package com.example.friendsr

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_description.*

class Description : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val descripcion = intent.getSerializableExtra("despcripcion") as Perfil

        nombrep.text = descripcion.nombre
        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUSer -> rating() }

        val preferences = getPreferences(Context.MODE_PRIVATE)
        ratingBar.setRating(preferences.getFloat(descripcion.nombre, 1.0f))


       descriptionp.text = descripcion.descripcion
        imagenp.setImageResource(descripcion.imagen)

    }

    fun rating(): Boolean {

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val description = intent.getSerializableExtra("despcripcion") as Perfil
        with(preferences.edit()) {
            putFloat(description.nombre, ratingBar.rating)
            commit()
        }
        return true
    }
}