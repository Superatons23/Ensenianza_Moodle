package Negocio

interface iNegocio {
    fun iniciarSesion(usuario: String?, contrasenia: String?): Boolean
    fun iniciarSesion(): Boolean
    fun subirTarea(): Boolean
}