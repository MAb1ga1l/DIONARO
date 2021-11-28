package com.example.dionaro.DataUser

import android.os.Parcel
import android.os.Parcelable

class Favoritos() : Parcelable{
    var idMaterial : String = ""
    var fecha : String = ""
    var tipoMaterial : String = ""

    constructor(parcel: Parcel) : this() {
        idMaterial = parcel.readString().toString()
        fecha = parcel.readString().toString()
        tipoMaterial = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(idMaterial)
        parcel.writeString(fecha)
        parcel.writeString(tipoMaterial)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Favoritos> {
        override fun createFromParcel(parcel: Parcel): Favoritos {
            return Favoritos(parcel)
        }

        override fun newArray(size: Int): Array<Favoritos?> {
            return arrayOfNulls(size)
        }
    }

}