package Dominio

import java.util.*

class Asignacion(
    nombre: String?,
    fechaInicio: String?,
    fechaEntrega: String?
) : Actividad(nombre!!, fechaInicio!!, fechaEntrega!!) 