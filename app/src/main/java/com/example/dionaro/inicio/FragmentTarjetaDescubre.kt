package com.example.dionaro.inicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import com.example.dionaro.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

private const val ARG_PARAM1 = "nombre"
private const val ARG_PARAM2 = "foto"
private const val ARG_PARAM3 = "descripcion"
private const val ARG_PARAM4 = "puntuacion"


class FragmentTarjetaDescubre : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: String? = null

    private lateinit var titulo : TextView
    private lateinit var logo : CircleImageView
    private lateinit var puntuacion : RatingBar
    private lateinit var descripcion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
            param4 = it.getString(ARG_PARAM4)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_tarjeta_descubre, container, false)
        titulo = vista.findViewById(R.id.tituloTarjetaDescubreDes)
        titulo.text = param1
        logo = vista.findViewById(R.id.logoMaterialTarjetaDescubre)
        Picasso.get().load(param2).into(logo)
        puntuacion = vista.findViewById(R.id.ratingBarTarjetaDescubre)
        val newNum = param4?.toFloat()
        if (newNum != null) {
            puntuacion.rating = newNum
        }
        descripcion = vista.findViewById(R.id.textoTarjetaDescubreDes)
        descripcion.text = param3
        return vista
    }

    companion object {
        fun newInstance(param1: String, param2: String,param3: String,param4: String) =
            FragmentTarjetaDescubre().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)
                    putString(ARG_PARAM4, param4)
                }
            }
    }
}
