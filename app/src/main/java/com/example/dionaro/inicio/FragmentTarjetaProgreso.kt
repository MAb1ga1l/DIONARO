package com.example.dionaro.inicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dionaro.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

private const val ARG_PARAM1 = "tituloMaterial"
private const val ARG_PARAM2 = "tipoMaterial"
private const val ARG_PARAM3 = "progreso"
private const val ARG_PARAM4 = "fecha"

class FragmentTarjetaProgreso : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: String? = null
    private lateinit var tituloMaterial : TextView
    private lateinit var imagenMaterial : CircleImageView
    private lateinit var fecha : TextView
    private lateinit var progreso : ProgressBar

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
        val vista = inflater.inflate(R.layout.fragment_tarjeta_progreso, container, false)
        tituloMaterial = vista.findViewById(R.id.tituloTarjetaProgresoInicio)
        tituloMaterial.text = param1
        imagenMaterial = vista.findViewById(R.id.logoMaterialProgreso)
        fecha = vista.findViewById(R.id.textoTarjetaProgresoInicio)
        fecha.text = param4
        progreso = vista.findViewById(R.id.progressBarTarjetaInicio)
        val numProgreso = param3
        if (numProgreso != null) {
            progreso.progress = numProgreso.toInt()
        }
        if(param2 != "Video"){
            val foto = "https://static.vecteezy.com/system/resources/previews/001/877/838/non_2x/paper-document-with-pen-flat-style-icon-free-vector.jpg"
            Picasso.get().load(foto).into(imagenMaterial)
        }
        return vista
    }

    companion object {
        fun newInstance(param1: String, param2: String,param3: String,param4: String) =
            FragmentTarjetaProgreso().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)
                    putString(ARG_PARAM4, param4)
                }
            }
    }
}