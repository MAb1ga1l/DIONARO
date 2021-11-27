package com.example.dionaro.DataUser

import android.os.Parcel
import android.os.Parcelable

class Recordatorios() : Parcelable {
    var fecha : String = ""
    var idRecordatio : String = ""
    var titulo : String = ""
    var notas : String = ""
    var hora : String = ""
    var colorR : String = ""

    constructor(parcel: Parcel) : this() {
        fecha = parcel.readString().toString()
        idRecordatio = parcel.readString().toString()
        titulo = parcel.readString().toString()
        notas = parcel.readString().toString()
        hora = parcel.readString().toString()
        colorR = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recordatorios> {
        override fun createFromParcel(parcel: Parcel): Recordatorios {
            return Recordatorios(parcel)
        }

        override fun newArray(size: Int): Array<Recordatorios?> {
            return arrayOfNulls(size)
        }
    }
}