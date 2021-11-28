package com.example.dionaro.Notas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dionaro.DataMaterial.Videos
import com.example.dionaro.DataMaterial.VideosViewModel
import com.example.dionaro.DataUser.Nota
import com.example.dionaro.DataUser.NotaViewModel
import com.example.dionaro.R

private const val ARG_PARAM1 = "inventario"
private const val ARG_PARAM2 = "param2"

class ListaNotas : Fragment() {
    private var param1: ArrayList<Nota> = arrayListOf()
    private var param2: String? = null
    private lateinit var listaParRecyclerView: RecyclerView
    private lateinit var listaImparRecyclerView: RecyclerView
    private var adaptadorPar : NotaParAdapter? = null
    private var adaptadorImpar : NotaImparAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelableArrayList<Nota>(ARG_PARAM1) as ArrayList<Nota>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_lista_notas, container, false)
        listaParRecyclerView = vista.findViewById(R.id.recyclerViewNotasPar) as RecyclerView
        listaParRecyclerView.layoutManager = LinearLayoutManager(context)
        listaImparRecyclerView = vista.findViewById(R.id.recyclerViewNotasImpar) as RecyclerView
        listaImparRecyclerView.layoutManager = LinearLayoutManager(context)
        val inventario = param1
        adaptadorPar =  NotaParAdapter(inventario)
        adaptadorImpar = NotaImparAdapter(inventario)
        listaImparRecyclerView.adapter = adaptadorImpar
        listaParRecyclerView.adapter = adaptadorPar
        //Toast.makeText(context, "${inventario.size}", Toast.LENGTH_SHORT).show()

        return vista
    }

    companion object {
        fun newInstance(inventario: ArrayList<Nota>) =
            ListaNotas().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_PARAM1,inventario)
                }
            }
    }

    //Adapter y holder para el RecyclerView de lado Derecho
    private inner class NotaParAdapter(var inventario: List<Nota>): RecyclerView.Adapter<TarjetaHolderPar>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetaHolderPar {
            val holder = layoutInflater.inflate(R.layout.tarjera_nota_layout,parent,false)
            return TarjetaHolderPar(holder)
        }

        override fun onBindViewHolder(holder: TarjetaHolderPar, position: Int) {
            val tarjeta = inventario[position]
            holder.binding(tarjeta)
        }

        override fun getItemCount(): Int {
            return inventario.size
        }

    }

    private inner class TarjetaHolderPar(vista : View) : RecyclerView.ViewHolder(vista),View.OnClickListener{
        var tituloNota : TextView = itemView.findViewById(R.id.textViewTituloNotaLista)
        var descripcion : TextView = itemView.findViewById(R.id.textViewTextoNotaLista)
        var fecha : TextView = itemView.findViewById(R.id.textViewFechaNotaLista)
        private lateinit var nota: Nota
        fun binding(tarjeta : Nota){
            tituloNota.text = tarjeta.titulo
            descripcion.text = tarjeta.textoEscrito
            fecha.text = tarjeta.fecha
            nota =  tarjeta
        }

        override fun onClick(v: View?) {
        }
    }

    //Adapter y holder para el RecyclerView de lado Izquierdo
    private inner class NotaImparAdapter(var inventario: List<Nota>): RecyclerView.Adapter<TarjetaHolderImpar>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetaHolderImpar {
            val holder = layoutInflater.inflate(R.layout.tarjera_nota_layout,parent,false)
            return TarjetaHolderImpar(holder)
        }

        override fun onBindViewHolder(holder: TarjetaHolderImpar, position: Int) {
            val tarjeta = inventario[position]
            holder.binding(tarjeta)
        }

        override fun getItemCount(): Int {
            return inventario.size
        }

    }

    private inner class TarjetaHolderImpar(vista : View) : RecyclerView.ViewHolder(vista),View.OnClickListener{
        var tituloNota : TextView = itemView.findViewById(R.id.textViewTituloNotaLista)
        var descripcion : TextView = itemView.findViewById(R.id.textViewTextoNotaLista)
        var fecha : TextView = itemView.findViewById(R.id.textViewFechaNotaLista)
        private lateinit var nota: Nota
        fun binding(tarjeta : Nota){
            tituloNota.text = tarjeta.titulo
            descripcion.text = tarjeta.textoEscrito
            fecha.text = tarjeta.fecha
            nota =  tarjeta
        }

        override fun onClick(v: View?) {
        }
    }
}