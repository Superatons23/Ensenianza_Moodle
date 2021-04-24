package AccesoDatos

import android.content.Context

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
}