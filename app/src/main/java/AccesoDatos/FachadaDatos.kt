package AccesoDatos

import Dominio.Alumno
import android.content.Context
import Dominio.Clase

class FachadaDatos : iAccesoDatos {
    override fun iniciarSesion(
        context:Context?,
        usuario: String?,
        contrasenia: String?
    ): String? {
        var acceso:AccesoDatosTutor= AccesoDatosTutor();
        return acceso.iniciarSesion(context,usuario,contrasenia);
    }

    override fun cerrarSesion(): Boolean {
        return false
    }

    override fun subirTarea(): Boolean {
        return false
    }

    override fun obtenerAlumno(
        context:Context?,
        usuario: String?
    ): Alumno? {
        var acceso:AccesoDatosTutor= AccesoDatosTutor();
        return acceso.obtenerAlumno(context,usuario);
    }

    override fun obtenerCursos(
        context:Context?,
        userid: Int?
    ): List<Clase>? {
        var acceso:AccesoDatosTutor= AccesoDatosTutor();
        return acceso.obtenerCursos(context,userid);
    }
}