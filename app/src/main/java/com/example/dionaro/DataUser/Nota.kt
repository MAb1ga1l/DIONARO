package com.example.dionaro.DataUser

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Nota() : Parcelable{

    var titulo : String = ""
    var fecha : String = ""
    var textoEscrito : String = ""
    var idNota : String = UUID.randomUUID().toString().substring(0,6)

    constructor(parcel: Parcel) : this() {
        titulo = parcel.readString().toString()
        fecha = parcel.readString().toString()
        textoEscrito = parcel.readString().toString()
        idNota = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeString(fecha)
        parcel.writeString(textoEscrito)
        parcel.writeString(idNota)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Nota> {
        override fun createFromParcel(parcel: Parcel): Nota {
            return Nota(parcel)
        }

        override fun newArray(size: Int): Array<Nota?> {
            return arrayOfNulls(size)
        }
    }
}