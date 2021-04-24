package Negocio

import AccesoDatos.FabricaDatos
import AccesoDatos.FachadaDatos

class CtrlTutor {

    private var accesoDatos:FachadaDatos;
    constructor(){
        accesoDatos=FabricaDatos.crearFachadaDatos();
    }

    fun iniciarSesion(): Boolean {

        var token= accesoDatos.iniciarSesion("javier","chuy");
        return true
    }

    fun cerrarSesion(): Boolean {
        return true
    }

    fun subirTarea(): Boolean {
        return true
    }
}