package AccesoDatos

import Dominio.Curso
import Dominio.Parcial
import Dominio.Tarea
import android.content.Context
import apps.moviles.enseanza.repository.Repository
import java.util.*

class AccesoDatosMtro {

    //este metodo obtiene los cursos de un mtro
    fun obtenerCursos(context: Context?, userid: Int?): ArrayList<Curso>? {
        var repository = Repository();
        var cursosRepo = repository.getCursos(userid)
        var cursosData = cursosRepo.execute().body();


        var cursos = ArrayList<Curso>()

        if (cursosData != null) {
            for (c in cursosData) {
                // var m=obtenerMaestros(c.id) as Maestro
                cursos.add(Curso(c.fullname,obtenerParciales(context,c.id,userid)))
            }
        }



        return cursos;
    }

    fun obtenerParciales(context: Context?, courseid: Int?,userdId:Int?): ArrayList<Parcial> {
        var repository = Repository();
        var parcialRepo = repository.getParcial(courseid)
        var parcialData = parcialRepo.execute().body();


        var parciales= ArrayList<Parcial>()
        var actividades=ArrayList<Tarea>()
        if (parcialData != null) {
            for (p in parcialData){
                for(t in p.modules){
                    actividades.add(Tarea(t.instance,courseid,userdId,t.name,"Descripcion de la actividad"))
                }
                parciales.add(Parcial(p.id,p.name,actividades))
                actividades= ArrayList()
            }
        }

        return parciales;
    }
}