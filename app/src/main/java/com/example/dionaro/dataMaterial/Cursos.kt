package com.example.dionaro.dataMaterial

import android.os.Parcel
import android.os.Parcelable

class Cursos() : Parcelable {

    var descripcion : String = ""
    var link : String = ""
    var linkFoto : String = ""
    var nombre : String = ""
    var idCurso : String = ""
    var puntuacion : String = ""

    constructor(parcel: Parcel) : this() {
        descripcion = parcel.readString().toString()
        link = parcel.readString().toString()
        linkFoto = parcel.readString().toString()
        nombre = parcel.readString().toString()
        idCurso = parcel.readString().toString()
        puntuacion = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(descripcion)
        parcel.writeString(link)
        parcel.writeString(linkFoto)
        parcel.writeString(nombre)
        parcel.writeString(idCurso)
        parcel.writeString(puntuacion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cursos> {
        override fun createFromParcel(parcel: Parcel): Cursos {
            return Cursos(parcel)
        }

        override fun newArray(size: Int): Array<Cursos?> {
            return arrayOfNulls(size)
        }
    }

}