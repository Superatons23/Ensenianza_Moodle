package Dominio

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Curso: Parcelable {
    var id:Int?=-1
     var nombre: String?=""
    var parciales:ArrayList<Parcial> = ArrayList()

    constructor(nombre:String,parciales:ArrayList<Parcial>) {
        this.nombre=nombre;
        this.parciales=parciales
    }





    constructor(){

    }
    override fun writeToParcel(p0: Parcel?, p1: Int) {
        id?.let { p0?.writeInt(it) }
        p0?.writeString(nombre)
        p0?.writeTypedList(parciales)

    }

    constructor(source:Parcel):this() {
        id=source.readInt()
        nombre = source.readString()
        parciales=source.createTypedArrayList(Parcial.CREATOR)!!

    }

    override fun describeContents(): Int {
        return 0
    }


    companion object CREATOR : Parcelable.Creator<Curso> {
        override fun createFromParcel(parcel: Parcel): Curso {
            return Curso(parcel)
        }

        override fun newArray(size: Int): Array<Curso?> {
            return arrayOfNulls(size)
        }
    }
}