package AccesoDatos

import Dominio.Alumno
import android.content.Context
import Dominio.Clase
import Dominio.Curso

interface iAccesoDatos {
    fun iniciarSesion(context:Context?,usuario: String?, contrasenia: String?): String?
    fun cerrarSesion(): Boolean
    fun subirTarea(): Boolean
    fun obtenerAlumno(context:Context?,usuario: String?): Alumno?
    fun obtenerCursos(context:Context?,userid: Int?): List<Clase>?
    fun obtenerCursosMtro(context:Context?,userid: Int?): List<Curso>?
}