package AccesoDatos


import Dominio.Alumno
import android.content.Context
import Dominio.Clase
import Dominio.Parcial
import Dominio.Tarea
import apps.moviles.enseanza.R
import apps.moviles.enseanza.repository.Repository
import java.util.*


class AccesoDatosTutor {

    fun iniciarSesion(context: Context?, usuario: String?, password: String?): String? {
        println("acceso datos tutor")
        var token: String = "";
        println("usuario")
        println(usuario)
        println("password")
        println(password)



        var repository = Repository();
        var authUser = repository.authUser(usuario,password)
        token = authUser.execute().body()?.token.toString();



        return token;
    }

    fun obtenerAlumno(context: Context?, usuario: String?): Alumno? {
        var repository = Repository();
        var alumno = repository.getAlumno(usuario)
        var alumnoData = alumno.execute().body()?.get(0);
        var a=Alumno(alumnoData?.id,alumnoData?.firstname, alumnoData?.lastname, alumnoData?.email, alumnoData?.profileimageurl)
        println("nombre")
        println(a.nombre)
        println("apellido")
        println(a.apellido)
        println("email")
        println(a.email)
        println("foto")
        println(a.foto)


        return a;
    }

    fun obtenerCursos(context: Context?, userid: Int?): ArrayList<Clase>? {
        var repository = Repository();
        var cursosRepo = repository.getCursos(userid)
        var cursosData = cursosRepo.execute().body();


        var cursos= ArrayList<Clase>()

        if (cursosData != null) {
            for (c in cursosData){
                cursos.add(Clase(c.id,c.fullname,"Nombre profesor", R.drawable.cienciasmateria,c.summary,obtenerParciales(context,c.id,userid)))
            }
        }



        return cursos;
    }

    fun obtenerParciales(context: Context?, courseid: Int?,userid: Int?): ArrayList<Parcial> {
        var repository = Repository();
        var parcialRepo = repository.getParcial(courseid)
        var parcialData = parcialRepo.execute().body();


        var parciales= ArrayList<Parcial>()
        var actividades=ArrayList<Tarea>()
        if (parcialData != null) {
            for (p in parcialData){
                for(t in p.modules){
                     actividades.add(Tarea(t.instance,courseid,userid,t.name,"Descripcion de la actividad"))
                }
                parciales.add(Parcial(p.id,p.name,actividades))
                actividades= ArrayList()
            }
        }

        return parciales;
    }



    fun cerrarSesion(): Boolean {
        return true
    }

    fun subirTarea(): Boolean {
        return true
    }
}
