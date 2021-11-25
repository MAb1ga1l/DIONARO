package com.example.dionaro.BusquedaDescubrimiento

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dionaro.AvanceFavoritos.ListaMateriales
import com.example.dionaro.DataMaterial.*
import com.example.dionaro.R

private const val ARG_PARAM1 = "textoBusqueda"
private const val ARG_PARAM2 = "seleccion"
private const val ARG_PARAM3 = "tipoBusqueda"

class listaTarjetasBusqueda : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null

    private lateinit var tarjetaBusquedaRecyclerView: RecyclerView
    private var adaptadorVideos : TarjetaAdapterVideo? = null
    private var adaptadorDoc : TarjetaAdapterDoc? = null

    private val dataVideosViewModel : VideosViewModel by lazy {
        ViewModelProvider(this).get(VideosViewModel::class.java)
    }
    private val dataDocsViewModel : ArticulosViewModel by lazy {
        ViewModelProvider(this).get(ArticulosViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_lista_tarjetas_busqueda, container, false)
        tarjetaBusquedaRecyclerView = vista.findViewById(R.id.recyclerViewBusqueda) as RecyclerView
        tarjetaBusquedaRecyclerView.layoutManager = LinearLayoutManager(context)
        if(param2=="Videos"){
            val inventario = dataVideosViewModel.videosRegistrados
            adaptadorVideos = TarjetaAdapterVideo(inventario)
            tarjetaBusquedaRecyclerView.adapter = adaptadorVideos
        }else{
            val inventario = dataDocsViewModel.articulosRegistrados
            adaptadorDoc = TarjetaAdapterDoc(inventario)
            tarjetaBusquedaRecyclerView.adapter=adaptadorDoc
        }

        return vista
    }

    companion object {
        fun newInstance(param1: String, param2: String, param3: String) =
            listaTarjetasBusqueda().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)
                }
            }
    }

    private inner class TarjetaAdapterVideo(var inventario: List<Videos>): RecyclerView.Adapter<TarjetaHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetaHolder {
            val holder = layoutInflater.inflate(R.layout.tarjeta_material_busqueda_layout,parent,false)
            return TarjetaHolder(holder)
        }

        override fun onBindViewHolder(holder: TarjetaHolder, position: Int) {
            val tarjeta = inventario[position]
            holder.binding(tarjeta)
        }

        override fun getItemCount(): Int {
            return inventario.size
        }

    }

    private inner class TarjetaHolder(vista : View) : RecyclerView.ViewHolder(vista),View.OnClickListener{
        var tituloMaterial : TextView = itemView.findViewById(R.id.tituloTarjetaMaterialBusqueda)
        var descripcion : TextView = itemView.findViewById(R.id.textoTarjetaMaterialBusqueda)
        fun binding(tarjeta :  Videos){
            tituloMaterial.text = tarjeta.nombreVideo
            descripcion.text = tarjeta.descripcionLarga
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    private inner class TarjetaAdapterDoc(var inventario: List<Articulos>): RecyclerView.Adapter<TarjetaHolderDoc>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetaHolderDoc {
            val holder = layoutInflater.inflate(R.layout.tarjeta_material_busqueda_layout,parent,false)
            return TarjetaHolderDoc(holder)
        }

        override fun onBindViewHolder(holder: TarjetaHolderDoc, position: Int) {
            val tarjeta = inventario[position]
            holder.binding(tarjeta)
        }

        override fun getItemCount(): Int {
            return inventario.size
        }

    }

    private inner class TarjetaHolderDoc(vista : View) : RecyclerView.ViewHolder(vista),View.OnClickListener{
        var tituloMaterial : TextView = itemView.findViewById(R.id.tituloTarjetaMaterialBusqueda)
        var descripcion : TextView = itemView.findViewById(R.id.textoTarjetaMaterialBusqueda)
        fun binding(tarjeta :  Articulos){
            tituloMaterial.text = tarjeta.nombreArticulo
            descripcion.text = tarjeta.descripcionLarga
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }
}