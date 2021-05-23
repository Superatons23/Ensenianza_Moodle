package apps.moviles.enseanza

import Dominio.Alumno
import Dominio.Clase
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import apps.moviles.enseanza.model.ConversacionDatos
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_pantalla_mensaje.view.*
import kotlinx.android.synthetic.main.activity_pantalla_mensajes.*

class PantallaMensajes : AppCompatActivity() {
    var adapter: MensajesAdapter? = null
    var mensajes = ArrayList<Mensaje>()
    var alumno: Alumno? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_mensajes)
        var bundle= intent.extras
        if(bundle!=null) {

            alumno = bundle.get("alumno") as Alumno
            var clases= bundle.get("clases") as java.util.ArrayList<Clase>

            cargarMensajes(clases, alumno!!)
        }


        adapter=MensajesAdapter(this, mensajes,alumno!!)
        gridview.adapter=adapter
    }

    fun cargarMensajes(clases :ArrayList<Clase>,alumno: Alumno){

        for (c in clases){
            mensajes.add(Mensaje(c.nombreProfesor,alumno.nombre + " " + alumno.apellido,"Ver conversacion"))
        }
    }
}


class MensajesAdapter: BaseAdapter {
    var mensajes= ArrayList<Mensaje>()
    var contexto: Context? =null
    var usuario: Alumno? =null
    constructor(contexto: Context, mensajes: ArrayList<Mensaje>, usuario: Alumno){
        this.contexto=contexto
        this.mensajes=mensajes
        this.usuario=usuario
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var mensaje=mensajes[p0]
        var inflador=contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista=inflador.inflate(R.layout.activity_pantalla_mensaje, null)
        vista.setOnClickListener(){
            val database = FirebaseDatabase.getInstance()

            val conversacion = database.getReference("conversaciones");

            val alumno: String? = usuario?.nombre + " " + usuario?.apellido
            val profesor: String? = mensaje.from
            var encontrado: Boolean = false
            var fetched = false
            var key: String = ""
            conversacion.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.

                    for (i in dataSnapshot.children) {

                        //obtener nombre(se peude obtener mas elementos)
                        var nombreAlumno = i.child("nombreAlumno").getValue(String::class.java)
                        var nombreProfe = i.child("nombreProfe").getValue(String::class.java)
                        if (alumno.equals(nombreAlumno) && profesor.equals(nombreProfe)) {
                            encontrado = true
                            key = i.key.toString();
                            Log.d("Conversacion", "id de conversacion: $key")

                            break;
                        }
                        println("o no")
                    }
                    if (!encontrado) {
                        var nuevaconvo= ConversacionDatos(profesor,alumno)
                        val myRef = database.getReference("conversaciones").push();

                        myRef.child("nombreAlumno").setValue(nuevaconvo.nombreAlumno);
                        myRef.child("nombreProfe").setValue(nuevaconvo.nombreProfe);
                        key=myRef.key.toString()
                        Log.d("Conversacion", "id de conversacion nueva: $key")
                    }

                    if (!fetched) {

                        var intent = Intent(contexto, MainActivity::class.java)
                        intent.putExtra("usuario", usuario)
                        intent.putExtra("maestro", mensaje.from)
                        intent.putExtra("key", key)
                        contexto!!.startActivity(intent)
                        fetched=true
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                    Log.w("Conversacion", "Failed to read value.", error.toException())
                }

            })





        }
        vista.tv_mensaje.setText(mensaje.mensaje)
        vista.tv_nombre.setText(mensaje.from)


        return vista
    }

    override fun getItem(p0: Int): Any {
        return mensajes[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return mensajes.size
    }
}