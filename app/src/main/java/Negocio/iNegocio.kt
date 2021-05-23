package Negocio

import Dominio.Alumno
import Dominio.Clase
import Dominio.Curso
import android.content.Context

interface iNegocio {
    fun iniciarSesion(context:Context?,usuario: String?, contrasenia: String?): Boolean?
    fun cerrarSesion(): Boolean
    fun subirTarea(): Boolean
    fun obtenerAlumno(context: Context?, usuario: String?): Alumno?
    fun obtenerCursos(context: Context?, userid: Int?): List<Clase>?
    fun obtenerCursosMtro(context: Context?, userid: Int?): List<Curso>?
}