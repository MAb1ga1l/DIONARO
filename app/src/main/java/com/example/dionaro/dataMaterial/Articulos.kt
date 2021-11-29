package com.example.dionaro.dataMaterial

import android.os.Parcel
import android.os.Parcelable

class Articulos() : Parcelable{

    var nombreArticulo : String = ""
    var descripcionCorta : String = ""
    var descripcionLarga : String = ""
    var link : String = ""
    var texto1 : String = ""
    var texto2 : String = ""
    var tema : String = ""
    var idArticulo: String = ""

    constructor(parcel: Parcel) : this() {
        nombreArticulo = parcel.readString().toString()
        descripcionCorta = parcel.readString().toString()
        descripcionLarga = parcel.readString().toString()
        link = parcel.readString().toString()
        texto1 = parcel.readString().toString()
        texto2 = parcel.readString().toString()
        tema = parcel.readString().toString()
        idArticulo = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombreArticulo)
        parcel.writeString(descripcionCorta)
        parcel.writeString(descripcionLarga)
        parcel.writeString(link)
        parcel.writeString(texto1)
        parcel.writeString(texto2)
        parcel.writeString(tema)
        parcel.writeString(idArticulo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Articulos> {
        override fun createFromParcel(parcel: Parcel): Articulos {
            return Articulos(parcel)
        }

        override fun newArray(size: Int): Array<Articulos?> {
            return arrayOfNulls(size)
        }
    }
}