package Dominio

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Maestro : Parcelable {

    var id: Int? =-1
    var nombre: String?=""
    var apellido: String?=""


    constructor(){

    }


    override fun writeToParcel(p0: Parcel?, p1: Int) {
        id?.let { p0?.writeInt(it) }
        p0?.writeString(nombre)
        p0?.writeString(apellido)
    }
    constructor(source: Parcel):this() {
        id=source.readInt()
        nombre = source.readString()
        apellido = source.readString()
    }

    constructor(id:Int?, nombre: String?, apellido: String?) {
        this.id=id
        this.nombre = nombre
        this.apellido = apellido
    }

    override fun describeContents(): Int {
        return 0
    }



    companion object CREATOR : Parcelable.Creator<Alumno> {
        override fun createFromParcel(parcel: Parcel): Alumno {
            return Alumno(parcel)
        }

        override fun newArray(size: Int): Array<Alumno?> {
            return arrayOfNulls(size)
        }
    }
}