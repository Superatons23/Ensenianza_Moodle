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
        println("token en ctrl")
        println(token);
        println("to")
        println(token != "null");
        return token != "null"

    }

    fun cerrarSesion(): Boolean {
        return true
    }

    fun subirTarea(): Boolean {
        return true
    }
}