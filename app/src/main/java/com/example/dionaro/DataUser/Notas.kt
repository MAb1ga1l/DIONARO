package com.example.dionaro.DataUser

import android.os.Parcel
import android.os.Parcelable

class Notas() : Parcelable{

    var titulo : String = ""
    var fecha : String = ""
    var textoEscrito : String = ""
    var idNota : String = ""

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

    companion object CREATOR : Parcelable.Creator<Notas> {
        override fun createFromParcel(parcel: Parcel): Notas {
            return Notas(parcel)
        }

        override fun newArray(size: Int): Array<Notas?> {
            return arrayOfNulls(size)
        }
    }
}