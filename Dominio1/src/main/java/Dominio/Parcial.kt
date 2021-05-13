package Dominio

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Parcial : Parcelable{
    var id:Int?=-1
    var nombre: String?=""
    var actividades:ArrayList<Tarea> = ArrayList()


    constructor(){

    }



    constructor(source:Parcel):this() {
        id=source.readInt()
        nombre = source.readString()
        actividades=source.createTypedArrayList(Tarea.CREATOR)!!

    }

    constructor(id:Int?,nombre: String?, actividades:ArrayList<Tarea>) {
        this.id=id
        this.nombre = nombre
        this.actividades=actividades
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        id?.let { p0?.writeInt(it) }
        p0?.writeString(nombre)
        p0?.writeTypedList(actividades)
    }

    companion object CREATOR : Parcelable.Creator<Parcial> {
        override fun createFromParcel(parcel: Parcel): Parcial {
            return Parcial(parcel)
        }

        override fun newArray(size: Int): Array<Parcial?> {
            return arrayOfNulls(size)
        }
    }
}