package com.example.dionaro.DataMaterial

import android.os.Parcel
import android.os.Parcelable

class Videos() : Parcelable{

    var nombreVideo : String = ""
    var descripcionCorta : String = ""
    var descripcionLarga : String = ""
    var link : String = ""
    var texto : String = ""
    var tema : String = ""
    var llaveVideo : String = ""
    var idVideo : String = ""

    constructor(parcel: Parcel) : this() {
        nombreVideo = parcel.readString().toString()
        descripcionCorta = parcel.readString().toString()
        descripcionLarga = parcel.readString().toString()
        link = parcel.readString().toString()
        texto = parcel.readString().toString()
        tema = parcel.readString().toString()
        llaveVideo = parcel.readString().toString()
        idVideo = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombreVideo)
        parcel.writeString(descripcionCorta)
        parcel.writeString(descripcionLarga)
        parcel.writeString(link)
        parcel.writeString(texto)
        parcel.writeString(tema)
        parcel.writeString(llaveVideo)
        parcel.writeString(idVideo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Videos> {
        override fun createFromParcel(parcel: Parcel): Videos {
            return Videos(parcel)
        }

        override fun newArray(size: Int): Array<Videos?> {
            return arrayOfNulls(size)
        }
    }

}