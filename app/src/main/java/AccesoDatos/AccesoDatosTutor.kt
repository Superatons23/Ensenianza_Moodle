package AccesoDatos


import Dominio.Alumno
import android.content.Context
import android.widget.Toast
import apps.moviles.enseanza.repository.Repository




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
        var a=Alumno(alumnoData?.firstname, alumnoData?.lastname, alumnoData?.email, alumnoData?.profileimageurl)
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


    fun cerrarSesion(): Boolean {
        return true
    }

    fun subirTarea(): Boolean {
        return true
    }
}