package com.example.dionaro.DataMaterial

import androidx.lifecycle.ViewModel

class CursoViewModel : ViewModel(){

    val cursosRegistrados = mutableListOf<Cursos>()
    private val descripciones = arrayOf("Cambia tu mentalidad y comienza a pensar. Sana tu relación con el " +
            "dinero aprendiendo a organizar tus finanzas personales",
    "Entiende cuál es tu perfil de riesgo y aprende a realizar análisis fundamental, técnico y económico para tomar decisiones de inversión.",
    "Aprende a usar las herramientas básicas para controlar tus finanzas personales.",
    "Aprende a manejar tus finanzas personales y organiza tus ingresos y gastos para optimizar tu dinero y sacarle un mayor rendimiento")
    private val links = arrayOf("https://www.udemy.com/course/curso-de-finanzas-personales/?utm_source=adwords&utm_medium=udemyads&utm_campaign=LongTail_la.ES_cc.MX&utm_term=_._ag_124493948387_._ad_517970074742_._kw__._de_c_._dm__._pl__._ti_dsa-1231786816213_._li_1010097_._pd__._&matchtype=&gclid=CjwKCAiAnO2MBhApEiwA8q0HYSOXGGZ0f8wC19mFc5rFAF_2STyliLYLx0vzwD4IopCciQMTMwu-BBoCbIIQAvD_BwE",
    "https://www.crehana.com/mx/cursos-online-emprendimiento/trading-como-invertir-en-bolsa/",
    "https://www.udemy.com/course/finanzas-personales-para-principiantes/",
    "https://www.crehana.com/mx/cursos-online-ventas/introduccion-a-las-finanzas/?utm_source=google&utm_medium=cpc&utm_campaign=search-non-brand&utm_content=sale-payg&utm_term=cursos&gclid=CjwKCAiAnO2MBhApEiwA8q0HYZedtt2UQSGZY_EAtnwG1oHWuf960SCpUSG516ASMNd_pTFR8EiJHxoCEsYQAvD_BwE")
    private val linksFoto = arrayOf("https://pbs.twimg.com/profile_images/1415324297304977411/p9kTpGac_400x400.png",
    "https://pbs.twimg.com/profile_images/1410690552429953034/ADkHmSdj_400x400.jpg",
    "https://pbs.twimg.com/profile_images/1410690552429953034/ADkHmSdj_400x400.jpg",
    "https://pbs.twimg.com/profile_images/1410690552429953034/ADkHmSdj_400x400.jpg")
    private val nombres = arrayOf("Curso de Finanzas Personales","¿Cómo invertir en bolsa?",
    "Finanzas Personales para Principiantes","Curso online de Introducción a las finanzas")
    private val valoraciones = arrayOf("4","4.8","4.4","4.2")
    private val idsCursos = arrayOf("Curso1","Curso2","Curso3","Curso4")

    init {
        for (i in 0 until 3){
            val curso = Cursos()
            curso.idCurso = idsCursos[i]
            curso.nombre = nombres[i]
            curso.linkFoto = linksFoto[i]
            curso.link = links[i]
            curso.descripcion = descripciones[i]
            curso.puntuacion = valoraciones[i]
            cursosRegistrados += curso
        }
    }

}