package Dominio

import android.os.Parcel
import android.os.Parcelable

class Tarea() :Parcelable{
    var id:Int?=-1
    var courseid: Int?=-1
    var userid: Int?=-1
    var nombre:String?=""
    var summary:String?=""
    var calificacion:Float?=-1.0f


    constructor(source: Parcel) : this() {
        id=source.readInt()
        courseid=source.readInt()
        userid=source.readInt()
        nombre=source.readString()
        summary=source.readString()
        calificacion=source.readFloat()
    }

    constructor(id:Int?,courseid:Int?,userid:Int?,nombre:String?,summary:String?) : this() {
        this.id=id
        this.courseid=courseid
        this.userid=userid
        this.nombre=nombre
        this.summary=summary
        this.calificacion=100.0f

    }


    override fun writeToParcel(p0: Parcel?, p1: Int) {
        id?.let { p0?.writeInt(it) }
        courseid?.let { p0?.writeInt(it) }
        userid?.let { p0?.writeInt(it) }
        p0?.writeString(nombre)
        p0?.writeString(summary)
        calificacion?.let { p0?.writeFloat(it) }

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tarea> {
        override fun createFromParcel(parcel: Parcel): Tarea {
            return Tarea(parcel)
        }

        override fun newArray(size: Int): Array<Tarea?> {
            return arrayOfNulls(size)
        }
    }
}