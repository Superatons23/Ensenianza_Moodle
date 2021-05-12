package Dominio

import android.os.Parcel
import android.os.Parcelable

class Alumno : Parcelable{

    var nombre: String?=""
    var apellido: String?=""
    var email: String?=""
    var foto: String?=""


    constructor(){

    }



    constructor(source:Parcel):this() {
        nombre = source.readString()
        apellido = source.readString()
        email = source.readString()
        foto = source.readString()
    }

    constructor(nombre: String?, apellido: String?, email: String?,foto:String?) {
        this.nombre = nombre
        this.apellido = apellido
        this.email = email
        this.foto = foto
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(nombre)
        p0?.writeString(apellido)
        p0?.writeString(email)
        p0?.writeString(foto)
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