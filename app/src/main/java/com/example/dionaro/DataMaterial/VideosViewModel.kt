package com.example.dionaro.DataMaterial

import androidx.lifecycle.ViewModel

class VideosViewModel : ViewModel() {

    val videosRegistrados = mutableListOf<Videos>()
    private val nombresVideo = arrayOf("¿Qué es un seguro de Gastos Médicos y cómo funciona?",
    "3 Métodos para pagar tus deudas más rápido",
    "Cómo crear un presupuesto personal en Excel. Te doy la plantilla.",
    "6 hacks para ahorrar más dinero",
    "ENCONTRÉ LAS MEJORES TARJETAS DE CRÉDITO EN MÉXICO (2021)",
    "La Estrategia de Inversión FÁCIL para Principiantes",
    "INGRESO O UTILIDAD | CONCEPTOS EN MATERIA FISCAL | FINANZAS",
    "Deducciones Personales para 2021 | Declaración Anual 2020",
    "Lo que debes saber de tu jubilación, pensión y Afore")
    private val descripcionesCorta = arrayOf("Aprende sobre el seguro de  gastos médicos mayores",
    "La forma en que pagas tus deudas puede definir si pagas más o menos intereses, es también importante considerar el ahorro aún cuando estás pagando deudas.",
    "Hay varios pasos que debemos completar para tener unas finanzas sanas, ¡pero crear un presupuesto es el primer paso que debemos de tomar! ",
    " 6 hacks te podrían servir",
    "La mejor tarjeta de crédito para ti seguro es diferente que la de alguien más.",
    "Esta estrategia de inversión es ideal para principiantes, además de que es fácil de implementar y adaptar conforme se gana experiencia.",
    "principales diferencias entre utilidad e ingresos.",
    " deducciones personales que pueden utilizar las personas físicas para su declaración anual",
    "aspectos más importantes de la jubilación, la pensión y el #Afore de los mexicanos.")
    private val descripcionesLarga = arrayOf("El seguro de gastos médicos mayores es un producto bastante complejo por lo que te preparé este video para ayudarte a entender mejor su funcionamiento! Preguntas y dudas en comentarios abajo del video!!",
    "La forma en que pagas tus deudas puede definir si pagas más o menos intereses, es también importante considerar el ahorro aún cuando estás pagando deudas. En este video describo 3 métodos que puedes seguir para pagar de la forma que mejor te acomode, pero que asegure que tus deudas decrecen tan rápido como se pueda.",
    "Entonces en este video compartiré contigo la herramienta que necesitas para hacer tu presupuesto (una hoja de cálculo, aka excel) y para el final deberás ya tener una idea muy cercana a la realidad de cuánto dinero gastas y en dónde.",
    "Si has intentado ahorrar sin mucho éxito, o quieres incrementar tu ahorro mensual, o quieres dejar de gastar en cosas no tan importantes, estos 6 hacks te podrían servir (a mi me han ayudado a ahorrar el 50% de mis ingresos).",
    "La mejor tarjeta de crédito para ti seguro es diferente que la de alguien más, entonces en este video cubro las que considero son las mejores en 6 diferentes categorías, para ayudarte a encontrar la que mejor se adapte a tus necesidades.",
    "Esta estrategia de inversión es ideal para principiantes, además de que es fácil de implementar y adaptar conforme se gana experiencia. Iniciando con dos sencillos pasos y dando una idea para el seguimiento",
    "En el siguiente video explicamos las principales diferencias entre utilidad e ingresos. Posteriormente se explican qué son los ingresos en materia fiscal y por qué es importante entender la definición.",
    "En este video explicamos a detalle las deducciones personales que pueden utilizar las personas físicas para su declaración anual y de ese modo poder disminuir su saldo a cargo e incluso poder obtener saldo a favor y poder solicitar la devolución.",
    "Orlando Corona Lara, integrante de la Comisión Técnica Seguridad Social del Colegio, participa en la mesa de análisis de #ElUniversal para comentar los aspectos más importantes de la jubilación, la pensión y el #Afore de los mexicanos. ")
    private val links = arrayOf("https://www.youtube.com/watch?v=Y8qfqu9GsJw",
    "https://www.youtube.com/watch?v=GPfIjso9hlc",
        "https://www.youtube.com/watch?v=6X6ryiZvAf8",
    "https://www.youtube.com/watch?v=Ti1rmnJXBT0",
    "https://www.youtube.com/watch?v=wIoF94Xs9c0",
    "https://www.youtube.com/watch?v=WjtUnFl0tlY",
    "https://www.youtube.com/watch?v=jwa1FegbSQc",
    "https://www.youtube.com/watch?v=JHZVJnhGvzk",
    "https://www.youtube.com/watch?v=yA0ug78h_aI")
    private val textos = arrayOf("El seguro de gastos médicos mayores es un producto bastante complejo por lo que te preparé este video para ayudarte a entender mejor su funcionamiento! Preguntas y dudas en comentarios abajo del video!! Obtén la hoja de cálculo: https://mailchi.mp/01ca9348412b/pagan...  Ahora, la forma correcta de pagar una deuda no es ningún secreto: pagas lo que te cobran cada mes y listo. Si se trata de tarjetas de crédito, utilizas lo que aprendiste en mi video de tarjetas de crédito y siempre pagas el monto para no generar intereses, nunca sólo el mínimo.  Pero quizás te preocupa saber si pagando más rápido pagarías menos intereses, ¿cómo lo harías? Si tienes más de una deuda, ¿cuál pagas primero? Y si quieres ahorrar al mismo tiempo, ¿a qué le das prioridad? Esto lo resolveremos en este video, y te compartiré una hoja de cálculo donde puedes ir registrando la evolución de tu deuda.  Antes de empezar toma en cuenta que pagar tu deuda lo más rápido posible no siempre es necesario. Si tus deudas no te cobran intereses, no hay porque pagarlas pronto, solo sigue pagando lo que tienes que pagar para no generar intereses. En su lugar, puedes destinar tu dinero extra a una inversión donde crezca, y no al pago de una deuda que de todos modos no iba a crecer.",
    "Obtén la hoja de cálculo: https://mailchi.mp/01ca9348412b/pagan...  Ahora, la forma correcta de pagar una deuda no es ningún secreto: pagas lo que te cobran cada mes y listo. Si se trata de tarjetas de crédito, utilizas lo que aprendiste en mi video de tarjetas de crédito y siempre pagas el monto para no generar intereses, nunca sólo el mínimo.  Pero quizás te preocupa saber si pagando más rápido pagarías menos intereses, ¿cómo lo harías? Si tienes más de una deuda, ¿cuál pagas primero? Y si quieres ahorrar al mismo tiempo, ¿a qué le das prioridad? Esto lo resolveremos en este video, y te compartiré una hoja de cálculo donde puedes ir registrando la evolución de tu deuda.  Antes de empezar toma en cuenta que pagar tu deuda lo más rápido posible no siempre es necesario. Si tus deudas no te cobran intereses, no hay porque pagarlas pronto, solo sigue pagando lo que tienes que pagar para no generar intereses. En su lugar, puedes destinar tu dinero extra a una inversión donde crezca, y no al pago de una deuda que de todos modos no iba a crecer.",
    "Básicamente será una lista de gastos que deberás repasar con mucha atención para asegurarte de que no se te escapa nada. Con la plantilla de excel (google sheets en realidad) podrás identificar todos los gastos que puedes llegar tener de forma mensual y así conocer perfectamente qué debes de gastar y no gastar más de lo que ganas.  Esto solo es un documento, solito no resolverá nada, tienes que tomar acción. Asegúrate de que te apegas a tu presupuesto.",
    "0:00 Introducción 1:01 Crea una cuenta de ahorro separada 3:39 Paga con efectivo 5:35 Espera unos días 7:19 Utiliza la prueba del extraño 8:39 Cada que no gastes, recompénsate 10:15 Automatiza",
    "0:00 Introducción 1:35 PARA PRINCIPIANTES 1:42 Sin anualidad 4:27 Sin historial 6:25 PARA EXPERIMENTADOS 6:54 Con recompensas 9:46 Con beneficios 12:22 PARA EXPERTOS 12:56 Exclusivas 14:44 Sin intereses",
    " 0:00 Introducción 1:16 Todos podemos invertir exitosamente 2:48 Primer paso 5:57 Segundo paso 7:38 Comprando el ETF VT * 9:38 Sorteo de GBM+ 10:49 Diversifica 12:41 Definiendo los porcentajes 15:13 Siguientes pasos",
    "En el siguiente video explicamos las principales diferencias entre utilidad e ingresos. Posteriormente se explican qué son los ingresos en materia fiscal y por qué es importante entender la definición.  Ingresos Nominales Ingresos acumulables Ingresos efectivamente percibidos",
    "En este video explicamos a detalle las deducciones personales que pueden utilizar las personas físicas para su declaración anual y de ese modo poder disminuir su saldo a cargo e incluso poder obtener saldo a favor y poder solicitar la devolución.  Una de las principales preguntas que se hacen los contribuyentes es: \"¿Qué gastos puedo deducir en mi declaración anual para recibir saldo a favor?\" Aquí explicamos estos y más detalles.",
    "Contenido relacionado: https://bit.ly/38LnIYR  El Colegio de Contadores Públicos de México agrupa a consultores integrales de negocios, especialistas en áreas fiscales, comercio exterior, prevención de lavado de dinero, fintech, capital humano, planeación estratégica, auditoría, gobierno corporativo, dirección de empresas, entre otras. Los representa ante las autoridades para la generación de propuestas en beneficio de la sociedad.")
    private val temas = arrayOf("seguros","deudas","presupuesto", "ahorro","credito","inversión","ingresos","gastos","jubilación")
    private val idsVideo = arrayOf("video1","video2","video3","video4","video5","video6","video7","video8","video9")

    init {
        for (i in 0 until 8) {
            val videos = Videos()
            videos.nombreVideo = nombresVideo[i]
            videos.descripcionCorta = descripcionesCorta[i]
            videos.descripcionLarga = descripcionesLarga[i]
            videos.link = links[i]
            videos.texto = textos[i]
            videos.tema = temas[i]
            videos.idVideo = idsVideo[i]
            videosRegistrados += videos
        }
    }

}