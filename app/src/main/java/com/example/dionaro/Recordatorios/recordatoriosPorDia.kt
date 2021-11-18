package com.example.dionaro.Recordatorios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dionaro.R


class recordatoriosPorDia : Fragment() {

    private lateinit var recordatorioRecyclerView: RecyclerView
    private var adaptador: RecordatorioAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_recordatorios_por_dia, container, false)
        recordatorioRecyclerView =
            vista.findViewById(R.id.recordatoriosRecyclerView) as RecyclerView
        recordatorioRecyclerView.layoutManager = LinearLayoutManager(context)
        val inventario = mutableListOf<String>("Recordatorio 1", "Recordatorio 2", "Recordatorio 3","Recordatorio 4","Recordatorio 5")
        adaptador = RecordatorioAdapter(inventario)
        recordatorioRecyclerView.adapter = adaptador
        return vista
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            recordatoriosPorDia().apply {
            }
    }

    private inner class RecordatorioAdapter(var inventario: List<String>) :
        RecyclerView.Adapter<RecordatorioHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordatorioHolder {
            val holder = layoutInflater.inflate(R.layout.recordatorio_layout, parent, false)
            return RecordatorioHolder(holder)
        }

        override fun onBindViewHolder(holder: RecordatorioHolder, position: Int) {
            val recordatorio = inventario[position]
            holder.binding(recordatorio)
        }

        override fun getItemCount(): Int {
            return inventario.size
        }
    }

    private inner class RecordatorioHolder(vista: View) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {
        val radioButton : RadioButton = itemView.findViewById(R.id.radioButtonRecordatorio)
        fun binding(recordatorio : String){
            radioButton.text = recordatorio
        }
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

    }
}