@file:Suppress("unused")

package com.example.dionaro.AvanceFavoritos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dionaro.BusquedaDescubrimiento.listaTarjetasBusqueda
import com.example.dionaro.DataMaterial.Articulos
import com.example.dionaro.DataMaterial.ArticulosViewModel
import com.example.dionaro.DataMaterial.Videos
import com.example.dionaro.DataMaterial.VideosViewModel
import com.example.dionaro.DataUser.Favoritos
import com.example.dionaro.DataUser.FavoritosViewModel
import com.example.dionaro.R
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

private const val ARG_PARAM1 = "textoBusqueda"
private const val ARG_PARAM2 = "filtro"
class ListaMateriales : Fragment() {

    private var param2: String? = null
    private val db = FirebaseFirestore.getInstance().collection("favoritos").get().addOnSuccessListener {
            resultado ->
        if(resultado != null){
            for (fav in resultado){
                val nuevoFav = Favoritos()
                nuevoFav.fecha = fav.data["fecha"] as String
                nuevoFav.tipoMaterial = fav.data["tipoMaterial"] as String
                nuevoFav.idMaterial = fav.id
                dataFViewModel.agregaNota(nuevoFav)
            }
            val inventario =dataFViewModel.favoritosRegistrados
            val inventarioN = filtrarinventario(inventario)
            adaptador = TarjetaAdapter(inventarioN)
            tarjetaFavRecyclerView.adapter = adaptador
        }
    }
    private var param1: String? = null
    private lateinit var tarjetaFavRecyclerView: RecyclerView
    private var adaptador : TarjetaAdapter? = null
    private var callbackinterfaz : InterfazMaterialesFavoritos? = null
    private val dataFViewModel : FavoritosViewModel by lazy {
        ViewModelProvider(this).get(FavoritosViewModel::class.java)
    }
    private val dataVViewModel : VideosViewModel by lazy {
        ViewModelProvider(this).get(VideosViewModel::class.java)
    }
    private val dataDViewModel : ArticulosViewModel by lazy {
        ViewModelProvider(this).get(ArticulosViewModel::class.java)
    }

    interface InterfazMaterialesFavoritos{
        fun videoSeleccionado(video:Videos)
        fun docSeleccionado(doc : Articulos)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbackinterfaz = context as InterfazMaterialesFavoritos?
    }

    override fun onDetach() {
        super.onDetach()
        callbackinterfaz = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_lista_materiales, container, false)
        tarjetaFavRecyclerView = vista.findViewById(R.id.tarjetaFavRecyclerView) as RecyclerView
        tarjetaFavRecyclerView.layoutManager = LinearLayoutManager(context)
        val inventario =dataFViewModel.favoritosRegistrados
        adaptador = TarjetaAdapter(inventario)
        tarjetaFavRecyclerView.adapter = adaptador
        return vista
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            ListaMateriales().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1,param1)
                    putString(ARG_PARAM2,param2)
                }
            }
    }

    private fun filtrarinventario(inventario: List<Favoritos>):List<Favoritos>{
        var inventarioNuevo = mutableListOf<Favoritos>()
        arguments = Bundle().apply {
            putString(ARG_PARAM1,param1)
            putString(ARG_PARAM2,param2)
        }
        if(param2 == "Tema"){
            for (material in inventario){
                if (material.tipoMaterial == "Video"){
                    val video: Videos = buscarMaterialVideo(material.idMaterial)
                    if(video.tema == param1){
                        inventarioNuevo += material
                    }
                }else{
                    val doc : Articulos = buscarMaterialDoc(material.idMaterial)
                    if (doc.tema == param1){
                        inventarioNuevo += material
                    }
                }
            }
        }
        else{
            inventarioNuevo = inventario as MutableList<Favoritos>
        }

        return inventarioNuevo
    }

    private inner class TarjetaAdapter(var inventario: List<Favoritos>): RecyclerView.Adapter<TarjetaHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetaHolder {
            val holder = layoutInflater.inflate(R.layout.fragment_tarjeta_favoritos,parent,false)
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
        var tituloMaterial : TextView = itemView.findViewById(R.id.tituloTarjetaFavoritos)
        var imagenMaterial : CircleImageView = itemView.findViewById(R.id.imageViewLogoTarjetaFav)
        var fecha : TextView = itemView.findViewById(R.id.textViewFechaTarjetaFav)
        var descipcion : TextView = itemView.findViewById(R.id.textoTarjetaFavoritos)
        private lateinit var videos: Videos
        private lateinit var doc : Articulos
        private lateinit var tipoMaterial : String
        fun binding(tarjeta :  Favoritos){
            fecha.text = tarjeta.fecha
            tipoMaterial = tarjeta.tipoMaterial
            if(tarjeta.tipoMaterial == "Video"){
                videos = buscarMaterialVideo(tarjeta.idMaterial)
                tituloMaterial.text = videos.nombreVideo
                descipcion.text = videos.descripcionCorta
            }else{
                doc = buscarMaterialDoc(tarjeta.idMaterial)
                tituloMaterial.text = doc.nombreArticulo
                descipcion.text = doc.descripcionCorta
                val foto = "https://static.vecteezy.com/system/resources/previews/001/877/838/non_2x/paper-document-with-pen-flat-style-icon-free-vector.jpg"
                Picasso.get().load(foto).into(imagenMaterial)
            }
        }

        override fun onClick(v: View?) {
            if(tipoMaterial == "Video"){
                callbackinterfaz?.videoSeleccionado(videos)
            }else{
                callbackinterfaz?.docSeleccionado(doc)
            }
        }

        init {
            itemView.setOnClickListener(this)
        }
    }

    private fun buscarMaterialVideo(idMaterial : String): Videos{
        var video = Videos()
        val inventario = dataVViewModel.videosRegistrados
        for (material in inventario){
            if (material.idVideo == idMaterial){
                video = material
            }
        }
        return video
    }

    private fun buscarMaterialDoc(idMaterial : String): Articulos{
        var doc = Articulos()
        val inventario = dataDViewModel.articulosRegistrados
        for (material in inventario){
            if (material.idArticulo == idMaterial){
                doc = material
            }
        }
        return doc
    }

}