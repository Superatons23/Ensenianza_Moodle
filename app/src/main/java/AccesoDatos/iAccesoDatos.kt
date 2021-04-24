package AccesoDatos

import android.content.Context

interface iAccesoDatos {
    fun iniciarSesion(usuario: String?, contrasenia: String?): String?
    fun cerrarSesion(): Boolean
    fun subirTarea(): Boolean
}