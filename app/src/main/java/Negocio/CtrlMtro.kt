package Negocio

import AccesoDatos.FabricaDatos
import AccesoDatos.FachadaDatos
import Dominio.Clase
import Dominio.Curso
import android.content.Context

class CtrlMtro {


    private var accesoDatos: FachadaDatos;
    constructor(){
        accesoDatos= FabricaDatos.crearFachadaDatos();
    }

    fun obtenerCursos(context: Context?, userid: Int?): List<Curso>? {
        var c: List<Curso>? = accesoDatos.obtenerCursosMtro(context,userid);
        return c;
    }
}