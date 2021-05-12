package Negocio

import Dominio.Alumno
import android.content.Context

interface iNegocio {
    fun iniciarSesion(context:Context?,usuario: String?, contrasenia: String?): Boolean?
    fun cerrarSesion(): Boolean
    fun subirTarea(): Boolean
    fun obtenerAlumno(context: Context?, usuario: String?): Alumno?
}