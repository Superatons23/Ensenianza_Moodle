package Negocio

import Dominio.Alumno
import android.content.Context
import Dominio.Clase
import Dominio.Curso

class FachadaNegocio:iNegocio {
    override fun iniciarSesion(context: Context?, usuario: String?, contrasenia: String?): Boolean? {
        var negocio:CtrlTutor  = CtrlTutor();
        return negocio.iniciarSesion(context,usuario,contrasenia);
    }

    override fun cerrarSesion(): Boolean {
        TODO("Not yet implemented")
    }

    override fun subirTarea(): Boolean {
        TODO("Not yet implemented")
    }

    override fun obtenerAlumno(context: Context?, usuario: String?): Alumno? {
        var negocio:CtrlTutor  = CtrlTutor();
        return negocio.obtenerAlumno(context,usuario);
    }

    override fun obtenerCursos(context: Context?, userid: Int?): List<Clase>? {
        var negocio:CtrlTutor  = CtrlTutor();
        return negocio.obtenerCursos(context,userid);
    }

    override fun obtenerCursosMtro(context: Context?, userid: Int?): List<Curso>? {
        var negocio:CtrlMtro  = CtrlMtro();
        return negocio.obtenerCursos(context,userid);
    }

}