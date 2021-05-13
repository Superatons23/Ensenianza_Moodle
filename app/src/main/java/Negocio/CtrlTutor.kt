package Negocio

import AccesoDatos.FabricaDatos
import AccesoDatos.FachadaDatos
import Dominio.Alumno
import android.content.Context
import Dominio.Clase

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

    fun obtenerAlumno(context: Context?, usuario: String?): Alumno? {
        var a: Alumno? =accesoDatos.obtenerAlumno(context,usuario);
        return a;
    }
    fun obtenerCursos(context: Context?, userid: Int?): List<Clase>? {
        var c: List<Clase>? = accesoDatos.obtenerCursos(context,userid);
        return c;
    }
}