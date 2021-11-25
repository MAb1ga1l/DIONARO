@file:Suppress("ClassName")

package com.example.dionaro.DataMaterial

import androidx.lifecycle.ViewModel

class appsViewModel : ViewModel(){

    val appsRegitradas = mutableListOf<Apps>()
    private val descripciones = arrayOf("Experimente una nueva forma de administrar el dinero. " +
            "Alcance sus objetivos financieros.",
    "GESTIONA TUS CUENTAS BANCARIAS Y AHORRA DINERO FÁCILMENTE CON FINTONIC",
    "Money Manager lo ayuda a seguir su actividad financiera de manera eficiente. " +
            "Su diseño simple lo hace ligero, directo y muy fácil de usar. ",
    "Wallet lo ayuda a planificar y seguir su presupuesto y gastos de forma flexible, por lo que" +
            " puede tener el control y lograr sus objetivos.")
    private val links = arrayOf("https://play.google.com/store/apps/details?id=com.mint",
    "https://play.google.com/store/apps/details?id=com.fintonic.latam&hl=es_MX",
    "https://play.google.com/store/apps/details?id=money.expense.budget.wallet.manager.track.finance.tracker&hl=es_MX",
    "https://play.google.com/store/apps/details?id=com.droid4you.application.wallet&hl=es_MX&gl=US")
    private val linksFoto = arrayOf("https://play-lh.googleusercontent.com/NQJV8dxA3txJSrgBaXWn6wkg60P_dtHepcImRj7eL2-T8b-k8yAvkVZzFo_nxfYQnvw",
    "https://static.fintonic.com/favicon/social-fintonic.png",
    "https://play-lh.googleusercontent.com/6fnuIpYkS-CWwQhU6M7KQ5xk514Gip8DT3_-SigdTMmqeKGNRBbHwxilYbj55PtGZ3c",
    "data:image/jpeg;base64,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FE+an5Obvi6YZYvQY8nK4hycmIcnJiHJyYhycmIcnJiHJyYhycmIcnJiHJyYhycmIcnJiHJyYhycmIyri6ZTEcL5X8K1w4J0Os/82es1iI31xzzWtPw1xH/jGqcIaOn6RFq3NMeap0isao1Pg5tQEVAAEGy2EAAQAGP8UWjLS00vWdeO1Z4tolFprqonapnCYc1ovldpOOOJmw1zav56zyFp698fdqXF6lvW1URhcpxbO23/AFL/ADY8DF9t70dEm20eyX+bHgbRvejok22j2S/zY8DaN70dEm20eyX+bHgbRvejok22j2S/zY8DaN70dEpttHslvmx4G0b3o6JNto9kt82PA2je9HRJttHsl/mx4G0b3o6JNto9kv8ANjwNo3vR0SbbR7Jb5seBtG96OiTbaPZL/NjwNo3vR0SbbR7Jf5seBtQb3o6JNto9kv8ANjwNqDe9HRJtvHsl/mx4G1BvejolraX5ZaReOJhwVxa/5725e0dUc0ffrSa3yua2qmMLdOHu4C03vac+S03yWnXe1p1zMvnM4vLrrqrq2q5xlUYgCKgACDZbCAAIAAggAiakU1AmoBABAEDUCAAakDUCAAIIAAioAAg2WwgCAAAIIAAgAgIgAgCAACAIAIABKCAAIqAAINlsIAgAACCAAIAICIAIAgAAgCACAAIIAAioAAg2WwgACAAIIAAgAgIgAgCAACAIAIAAggACKgACDZbCAIAAAggACACAiACAIAAIAgAgACCAAIqAAINlsIAgAACCAAIAICIAIAgAAgCACAAIIAAioAAg2WwgCAAAIIAAggAIgAgCAACAIAIAAgkgAiKSAAg//9k=")
    private val nombres = arrayOf("Mint: Budget planner & tracker",
    "Fintonic Latinoamérica", "Administrador de dinero, Rastreador de gastos","Wallet - Maneje su dinero")
    private val valoraciones = arrayOf("4.4","4.5","4.8","4.5")
    private val idsApps = arrayOf("app1","app2","app3","app4")

    init {
        for (i in 0 until 3){
            val app = Apps()
            app.idApp = idsApps[i]
            app.nombre = nombres[i]
            app.linkFoto = linksFoto[i]
            app.link = links[i]
            app.descripcion = descripciones[i]
            app.puntuacion = valoraciones[i]
            appsRegitradas += app
        }
    }
}