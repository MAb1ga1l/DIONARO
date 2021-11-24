package com.example.dionaro.DataMaterial

import androidx.lifecycle.ViewModel

class SoftwareViewModel : ViewModel(){

    val softwaresRegistrados = mutableListOf<Softwares>()
    private val descripciones = arrayOf("Quicken ofrece una familia de herramientas de software de " +
            "administración de dinero que van desde la versión Principiante hasta la versión Hogar &" +
            " Negocios.",
    "No tienes que ser rico para comenzar a invertir tu dinero con esta útil herramienta de software de finanzas personales.",
    "Desarrolla un presupuesto basado en tus metas, siendo lo suficientemente flexible como para cubrir gastos inesperados.")
    private val links = arrayOf("https://www.quicken.com/",
    "https://www.acorns.com/","https://www.youneedabudget.com/")
    private val linksFoto = arrayOf("https://img2.freepng.es/20180520/cb/kisspng-quicken-logo-intuit-netflix-quickbooks-5b0199996bce83.7383703015268315134416.jpg",
    "https://www.fintechfutures.com/files/2021/05/Acorns-Grow-Inc.jpg",
    "https://play-lh.googleusercontent.com/3670OMYEbgCVyV1fGdkErGmYIpLtQ7_70LPcXKRQCjfbd819VzSk3b5rYVcQ8aOoCAM")
    private val nombres = arrayOf("Quicken","Acorns","YNAB")
    private val valoraciones = arrayOf("4","4.5","4.8")
    private val idsSoftwares = arrayOf("Soft1","Soft2","Soft3")

    init {
        for (i in 0 until 3){
            val software = Softwares()
            software.idSoftware = idsSoftwares[i]
            software.nombre = nombres[i]
            software.linkFoto = linksFoto[i]
            software.link = links[i]
            software.descripcion = descripciones[i]
            software.puntuacion = valoraciones[i]
            softwaresRegistrados += software
        }
    }

}