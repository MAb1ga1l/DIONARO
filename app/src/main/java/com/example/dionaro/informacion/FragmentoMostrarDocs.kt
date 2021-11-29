package com.example.dionaro.informacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.dionaro.dataMaterial.ArticulosViewModel
import com.example.dionaro.R

private const val ARG_PARAM1 = "idMaterial"

class FragmentoMostrarDocs : Fragment() {

    private var param1: String? = null
    private lateinit var texto : TextView
    private val dataDocsViewModel : ArticulosViewModel by lazy {
        ViewModelProvider(this).get(ArticulosViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_fragmento_mostrar_docs, container, false)
        texto = vista.findViewById(R.id.textViewTextoMostrarDoc)
        val inventario = dataDocsViewModel.articulosRegistrados
        for (doc in inventario){
            if(param1 == doc.idArticulo){
                texto.text = doc.texto1
            }
        }
        return vista
    }

    companion object {
        fun newInstance(param1: String) =
            FragmentoMostrarDocs().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}