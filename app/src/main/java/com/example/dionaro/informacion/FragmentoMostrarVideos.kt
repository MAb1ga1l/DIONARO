package com.example.dionaro.informacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dionaro.dataMaterial.VideosViewModel
import com.example.dionaro.R

private const val ARG_PARAM1 = "idVideo"

 class FragmentoMostrarVideos : Fragment() {

     private var param1: String? = null

     private lateinit var texto : TextView
    //private lateinit var video:YouTubePlayerView
    private lateinit var videoView: VideoView

    private val dataVideosViewModel : VideosViewModel by lazy {
        ViewModelProvider(this).get(VideosViewModel::class.java)
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
        val vista = inflater.inflate(R.layout.fragment_fragmento_mostrar_videos, container, false)
        val inventario = dataVideosViewModel.videosRegistrados
        texto = vista.findViewById(R.id.textViewTextoMostrarVideo)
        videoView = vista.findViewById(R.id.videoViewVideo)
        for (video in inventario){
            if(param1 == video.idVideo){
                texto.text = video.texto
            }
        }

        return vista
    }

    companion object {
        fun newInstance(param1: String) =
            FragmentoMostrarVideos().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}