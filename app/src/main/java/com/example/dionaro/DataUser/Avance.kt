@file:Suppress("unused")

package com.example.dionaro.DataUser

import android.os.Parcel
import android.os.Parcelable

class Avance() : Parcelable{

    var idMaterial : String = ""
    var progreso : String = ""
    var fecha : String = ""
    var tipoMaterial : String = ""
    var nombreMaterial : String = ""

    constructor(parcel: Parcel) : this() {
        idMaterial = parcel.readString().toString()
        progreso = parcel.readString().toString()
        fecha = parcel.readString().toString()
        tipoMaterial = parcel.readString().toString()
        nombreMaterial = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(idMaterial)
        parcel.writeString(progreso)
        parcel.writeString(fecha)
        parcel.writeString(tipoMaterial)
        parcel.writeString(nombreMaterial)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Avance> {
        override fun createFromParcel(parcel: Parcel): Avance {
            return Avance(parcel)
        }

        override fun newArray(size: Int): Array<Avance?> {
            return arrayOfNulls(size)
        }
    }
}