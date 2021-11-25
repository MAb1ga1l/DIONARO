package com.example.dionaro.Descubrimiento

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dionaro.DataMaterial.*
import com.example.dionaro.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

private const val ARG_PARAM1 = "seccionBusqueda"

class ListaTarjetasDescubre : Fragment() {

    private lateinit var tarjetasDescubreRecyclerView: RecyclerView
    private var adaptador : TarjetaAdapter? = null
    private var param1: String? = null

    private val dataAppViewModel : appsViewModel by lazy {
        ViewModelProvider(this).get(appsViewModel::class.java)
    }
    private val dataCursosViewModel : CursoViewModel by lazy {
        ViewModelProvider(this).get(CursoViewModel::class.java)
    }
    private val dataSoftwareViewModel : SoftwareViewModel by lazy {
        ViewModelProvider(this).get(SoftwareViewModel::class.java)
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
        val vista = inflater.inflate(R.layout.fragment_lista_tarjetas_descubre, container, false)
        tarjetasDescubreRecyclerView = vista.findViewById(R.id.recyclerViewTarjetasDescubre) as RecyclerView
        tarjetasDescubreRecyclerView.layoutManager = LinearLayoutManager(context)
        adaptador = TarjetaAdapter()
        tarjetasDescubreRecyclerView.adapter = adaptador
        return vista
    }

    companion object {
        fun newInstance(param1: String) =
            ListaTarjetasDescubre().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

    private inner class TarjetaAdapter : RecyclerView.Adapter<TarjetaHolder>(){
        val inventarioApps = dataAppViewModel.appsRegitradas
        val inventarioCursos = dataCursosViewModel.cursosRegistrados
        val inventarioSoftware = dataSoftwareViewModel.softwaresRegistrados
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetaHolder {
            val holder = layoutInflater.inflate(R.layout.fragment_tarjeta_descubre,parent,false)
            return TarjetaHolder(holder)
        }

        override fun onBindViewHolder(holder: TarjetaHolder, position: Int) {
            when (param1) {
                "Apps" -> {
                    val tarjeta = inventarioApps[position]
                    holder.bindingApps(tarjeta)
                }
                "Cursos" -> {
                    val tarjeta = inventarioCursos[position]
                    holder.bindingCursos(tarjeta)
                }
                else -> {
                    val tarjeta = inventarioSoftware[position]
                    holder.bindingSoft(tarjeta)
                }
            }
        }

        override fun getItemCount(): Int {
            return when (param1) {
                "Apps" -> {
                    inventarioApps.size
                }
                "Cursos" -> {
                    inventarioCursos.size
                }
                else -> {
                    inventarioSoftware.size
                }
            }
        }

    }

    private inner class TarjetaHolder(vista : View) : RecyclerView.ViewHolder(vista),View.OnClickListener{
        var tituloMaterial : TextView = itemView.findViewById(R.id.tituloTarjetaDescubreDes)
        var logo : CircleImageView = itemView.findViewById(R.id.logoMaterialTarjetaDescubre)
        var ratingBar : RatingBar =itemView.findViewById(R.id.ratingBarTarjetaDescubre)
        val descripcion : TextView = itemView.findViewById(R.id.textoTarjetaDescubreDes)
        private lateinit var apps: Apps
        private lateinit var curso: Cursos
        private lateinit var softwares: Softwares

        fun bindingApps(tarjeta :  Apps){
            tituloMaterial.text = tarjeta.nombre
            Picasso.get().load(tarjeta.linkFoto).into(logo)
            ratingBar.rating = tarjeta.puntuacion.toFloat()
            descripcion.text = tarjeta.descripcion
            apps = tarjeta
        }
        fun bindingCursos(tarjeta :  Cursos){
            tituloMaterial.text = tarjeta.nombre
            Picasso.get().load(tarjeta.linkFoto).into(logo)
            ratingBar.rating = tarjeta.puntuacion.toFloat()
            descripcion.text = tarjeta.descripcion
            curso = tarjeta
        }
        fun bindingSoft(tarjeta :  Softwares){
            tituloMaterial.text = tarjeta.nombre
            Picasso.get().load(tarjeta.linkFoto).into(logo)
            ratingBar.rating = tarjeta.puntuacion.toFloat()
            descripcion.text = tarjeta.descripcion
            softwares = tarjeta
        }

        override fun onClick(v: View?) {
            val url = when (param1) {
                "Apps" -> {
                    apps.link
                }
                "Cursos" -> {
                    curso.link
                }
                else -> {
                    softwares.link
                }
            }
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        init {
            itemView.setOnClickListener(this)
        }
    }
}