package Dominio

import android.os.Parcel
import android.os.Parcelable

class Alumno : Parcelable{

    var id: Int? =-1
    var nombre: String?=""
    var userName: String?=""
    var apellido: String?=""
    var email: String?=""
    var foto: String?=""


    constructor(){

    }


    override fun writeToParcel(p0: Parcel?, p1: Int) {
        id?.let { p0?.writeInt(it) }
        p0?.writeString(nombre)
        p0?.writeString(apellido)
        p0?.writeString(email)
        p0?.writeString(foto)
    }
    constructor(source:Parcel):this() {
        id=source.readInt()
        nombre = source.readString()
        apellido = source.readString()
        email = source.readString()
        foto = source.readString()
    }

    constructor(userName:String?,id:Int?, nombre: String?, apellido: String?, email: String?,foto:String?) {
     this.userName=userName;
        this.id=id
        this.nombre = nombre
        this.apellido = apellido
        this.email = email
        this.foto = foto
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