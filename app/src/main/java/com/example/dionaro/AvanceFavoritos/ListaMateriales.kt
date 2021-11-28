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
import com.example.dionaro.DataUser.NotaViewModel
import com.example.dionaro.R
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class ListaMateriales : Fragment() {

    private val db = FirebaseFirestore.getInstance().collection("favoritos").get().addOnSuccessListener {
            resultado ->
        if(resultado != null){
            for (fav in resultado){
                val nuevoFav = Favoritos()
                nuevoFav.fecha = fav.data["fecha"] as String
                nuevoFav.tipoMaterial = fav.data["tipoMaterial"] as String
                nuevoFav.idMaterial = fav.id
                dataFavoritosViewModel.agregaNota(nuevoFav)
            }
            val inventario =dataFavoritosViewModel.favoritosRegistrados
            adaptador = TarjetaAdapter(inventario)
            tarjetaFavRecyclerView.adapter = adaptador
        }
    }

    private lateinit var tarjetaFavRecyclerView: RecyclerView
    private var adaptador : TarjetaAdapter? = null
    private var callbackinterfaz : InterfazMateriales? = null
    private val dataFavoritosViewModel : FavoritosViewModel by lazy {
        ViewModelProvider(this).get(FavoritosViewModel::class.java)
    }
    private val dataVideosViewModel : VideosViewModel by lazy {
        ViewModelProvider(this).get(VideosViewModel::class.java)
    }
    private val dataDocsViewModel : ArticulosViewModel by lazy {
        ViewModelProvider(this).get(ArticulosViewModel::class.java)
    }

    interface InterfazMateriales{
        fun videoSeleccionado(video:Videos)
        fun docSeleccionado(doc : Articulos)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbackinterfaz = context as InterfazMateriales?
    }

    override fun onDetach() {
        super.onDetach()
        callbackinterfaz = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_lista_materiales, container, false)
        tarjetaFavRecyclerView = vista.findViewById(R.id.tarjetaFavRecyclerView) as RecyclerView
        tarjetaFavRecyclerView.layoutManager = LinearLayoutManager(context)
        val inventario =dataFavoritosViewModel.favoritosRegistrados
        adaptador = TarjetaAdapter(inventario)
        tarjetaFavRecyclerView.adapter = adaptador
        return vista
    }

    companion object;

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
        val inventario = dataVideosViewModel.videosRegistrados
        for (material in inventario){
            if (material.idVideo == idMaterial){
                video = material
            }
        }
        return video
    }

    private fun buscarMaterialDoc(idMaterial : String): Articulos{
        var doc = Articulos()
        val inventario = dataDocsViewModel.articulosRegistrados
        for (material in inventario){
            if (material.idArticulo == idMaterial){
                doc = material
            }
        }
        return doc
    }

}