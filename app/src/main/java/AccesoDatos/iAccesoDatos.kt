package AccesoDatos

import android.content.Context

interface iAccesoDatos {
    fun iniciarSesion(context:Context?,usuario: String?, contrasenia: String?): String?
    fun cerrarSesion(): Boolean
    fun subirTarea(): Boolean
}