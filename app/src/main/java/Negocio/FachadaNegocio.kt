package Negocio

import AccesoDatos.AccesoDatosTutor

class FachadaNegocio : iNegocio {
    override fun iniciarSesion(
        usuario: String?,
        contrasenia: String?
    ): Boolean {
        return false
    }

    override fun iniciarSesion(): Boolean {
        var negocio:CtrlTutor  = CtrlTutor();
        return negocio.iniciarSesion();
    }

    override fun subirTarea(): Boolean {
        return false
    }
}