package com.example.dionaro.DataMaterial

import android.os.Parcel
import android.os.Parcelable

class Apps(): Parcelable {

    var descripcion : String = ""
    var link : String = ""
    var linkFoto : String = ""
    var nombre : String = ""
    var idApp : String = ""
    var puntuacion : String = ""

    constructor(parcel: Parcel) : this() {
        descripcion = parcel.readString().toString()
        link = parcel.readString().toString()
        linkFoto = parcel.readString().toString()
        nombre = parcel.readString().toString()
        idApp = parcel.readString().toString()
        puntuacion = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(descripcion)
        parcel.writeString(link)
        parcel.writeString(linkFoto)
        parcel.writeString(nombre)
        parcel.writeString(idApp)
        parcel.writeString(puntuacion)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Apps> {
        override fun createFromParcel(parcel: Parcel): Apps {
            return Apps(parcel)
        }

        override fun newArray(size: Int): Array<Apps?> {
            return arrayOfNulls(size)
        }
    }

}