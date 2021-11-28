package com.example.dionaro.Notas

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dionaro.BusquedaDescubrimiento.listaTarjetasBusqueda
import com.example.dionaro.DataMaterial.Articulos
import com.example.dionaro.DataMaterial.Videos
import com.example.dionaro.DataMaterial.VideosViewModel
import com.example.dionaro.DataUser.Nota
import com.example.dionaro.DataUser.NotaViewModel
import com.example.dionaro.R
import com.google.firebase.firestore.FirebaseFirestore

class ListaNotas : Fragment() {
    private val db = FirebaseFirestore.getInstance().collection("notas").get().addOnSuccessListener {
            resultado ->
        if(resultado != null){
            for(notas in resultado){
                Log.d("ListaNotas", notas.id)
                val nuevaNota = Nota()
                nuevaNota.idNota = notas.id
                nuevaNota.titulo = notas.data["titulo"] as String
                nuevaNota.fecha = notas.data["fecha"] as String
                nuevaNota.textoEscrito = notas.data["textoEscrito"] as String
                dataNotasViewModel.agregaNota(nuevaNota)
            }
            val inventario = dataNotasViewModel.notasRegistradas
            val inventarioPar = inventarioPar(inventario)
            val inventarioImpar = inventarioImpar(inventario)
            adaptadorPar =  NotaParAdapter(inventarioPar)
            adaptadorImpar = NotaImparAdapter(inventarioImpar)
            listaImparRecyclerView.adapter = adaptadorImpar
            listaParRecyclerView.adapter = adaptadorPar
        }
    }

    private lateinit var listaParRecyclerView: RecyclerView
    private lateinit var listaImparRecyclerView: RecyclerView
    private var adaptadorPar : NotaParAdapter? = null
    private var adaptadorImpar : NotaImparAdapter? = null
    private var callbackinterfaz : InterfazNotas? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    private val dataNotasViewModel : NotaViewModel by lazy {
        ViewModelProvider(this).get(NotaViewModel::class.java)
    }

    interface InterfazNotas{
        fun idNotaSelecionado(id : String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbackinterfaz = context as InterfazNotas?
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
        val vista = inflater.inflate(R.layout.fragment_lista_notas, container, false)
        listaParRecyclerView = vista.findViewById(R.id.recyclerViewNotasPar) as RecyclerView
        listaParRecyclerView.layoutManager = LinearLayoutManager(context)
        listaImparRecyclerView = vista.findViewById(R.id.recyclerViewNotasImpar) as RecyclerView
        listaImparRecyclerView.layoutManager = LinearLayoutManager(context)
        val inventario = dataNotasViewModel.notasRegistradas
        adaptadorPar =  NotaParAdapter(inventario)
        adaptadorImpar = NotaImparAdapter(inventario)
        listaImparRecyclerView.adapter = adaptadorImpar
        listaParRecyclerView.adapter = adaptadorPar
        //Toast.makeText(context, "${inventario.size}", Toast.LENGTH_SHORT).show()

        return vista
    }

    //identificar notas de lado derecho
    fun inventarioPar(inventario: List<Nota>) : List<Nota>{
        val nuevoInventario = mutableListOf<Nota>()
        var iterador = 1
        for(nota in inventario){
            if (iterador % 2 == 0){
                nuevoInventario += nota
            }
            iterador+=1
        }
        return nuevoInventario
    }
    //identificar notas de lado izquierda
    fun inventarioImpar(inventario: List<Nota>) : List<Nota>{
        val nuevoInventario = mutableListOf<Nota>()
        var iterador = 1
        for(nota in inventario){
            if (iterador % 2 != 0){
                nuevoInventario += nota
            }
            iterador+=1
        }
        return nuevoInventario
    }

    companion object {
        fun newInstance() =
            ListaNotas().apply {
                arguments = Bundle().apply {
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
            callbackinterfaz?.idNotaSelecionado(nota.idNota)
        }

        init {
            itemView.setOnClickListener(this)
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
            callbackinterfaz?.idNotaSelecionado(nota.idNota)
        }

        init {
            itemView.setOnClickListener(this)
        }
    }
}