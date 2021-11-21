package com.example.dionaro.AvanceFavoritos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dionaro.R

class ListaMateriales : Fragment() {

    private lateinit var tarjetaFavRecyclerView: RecyclerView
    private var adaptador : TarjetaAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_lista_materiales, container, false)
        tarjetaFavRecyclerView = vista.findViewById(R.id.tarjetaFavRecyclerView) as RecyclerView
        tarjetaFavRecyclerView.layoutManager = LinearLayoutManager(context)
        val inventario = mutableListOf("Material A","Material B","Material C","Material D")
        adaptador = TarjetaAdapter(inventario)
        tarjetaFavRecyclerView.adapter = adaptador
        return vista
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            ListaMateriales().apply {
            }
    }

    private inner class TarjetaAdapter(var inventario: List<String>): RecyclerView.Adapter<TarjetaHolder>(){
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
        fun binding(tarjeta :  String){
            tituloMaterial.text = tarjeta
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

}