package AccesoDatos

import android.content.Context

class FachadaDatos : iAccesoDatos {
    override fun iniciarSesion(
        usuario: String?,
        contrasenia: String?
    ): String? {
        var acceso:AccesoDatosTutor= AccesoDatosTutor();
        return acceso.iniciarSesion(usuario,contrasenia);
    }

    override fun cerrarSesion(): Boolean {
        return false
    }

    override fun subirTarea(): Boolean {
        return false
    }
}