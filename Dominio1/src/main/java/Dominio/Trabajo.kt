package Dominio

import java.util.*

class Trabajo(
    nombre: String?,
    fechaInicio: String?,
    fechaEntrega: String?
) : Actividad(nombre!!, fechaInicio!!, fechaEntrega!!) 