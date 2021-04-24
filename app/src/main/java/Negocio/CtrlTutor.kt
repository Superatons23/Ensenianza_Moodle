package Negocio

import AccesoDatos.FabricaDatos
import AccesoDatos.FachadaDatos
import android.content.Context

class CtrlTutor {

    private var accesoDatos:FachadaDatos;
    constructor(){
        accesoDatos=FabricaDatos.crearFachadaDatos();
    }

    fun iniciarSesion(context: Context?,usuario:String?,password:String?): Boolean? {

        var token= accesoDatos.iniciarSesion(context,usuario,password);
        println("tooken pero en ctrlTutor")
        println(token)
        return token?.isNotEmpty();
    }

    fun cerrarSesion(): Boolean {
        return true
    }

    fun subirTarea(): Boolean {
        return true
    }
}