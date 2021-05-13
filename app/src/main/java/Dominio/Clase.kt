package Dominio

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Clase : Parcelable{
    var id:Int?=-1
    var nombreClase: String?=""
    var descripcion:String?=""
    var nombreProfesor: String?=""
    var icono: Int=-1
    var parciales:ArrayList<Parcial> = ArrayList()


    constructor(){

    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        id?.let { p0?.writeInt(it) }
        p0?.writeString(nombreClase)
        p0?.writeString(descripcion)
        p0?.writeString(nombreProfesor)
        p0?.writeInt(icono)
        p0?.writeTypedList(parciales)
    }

    constructor(source:Parcel):this() {
        id=source.readInt()
        nombreClase = source.readString()
        descripcion = source.readString()
        nombreProfesor = source.readString()
        icono = source.readInt()
        parciales=source.createTypedArrayList(Parcial.CREATOR)!!
    }

    constructor(id:Int?,nombreClase: String?, nombreProfesor: String?,icono: Int,descripcion:String?,parciales:ArrayList<Parcial>) {
        this.id=id
        this.nombreClase = nombreClase
        this.descripcion = descripcion
        this.nombreProfesor = nombreProfesor
        this.icono = icono
        this.parciales=parciales
    }


    override fun describeContents(): Int {
        return 0
    }



    companion object CREATOR : Parcelable.Creator<Clase> {
        override fun createFromParcel(parcel: Parcel): Clase {
            return Clase(parcel)
        }

        override fun newArray(size: Int): Array<Clase?> {
            return arrayOfNulls(size)
        }
    }
}