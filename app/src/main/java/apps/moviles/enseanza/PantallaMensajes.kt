package apps.moviles.enseanza

import Dominio.Alumno
import Dominio.Clase
import Dominio.Usuario
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat.startActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pantalla_mensaje.view.*
import kotlinx.android.synthetic.main.activity_pantalla_mensajes.*
import kotlinx.android.synthetic.main.activity_pantalla_mensajes.view.*
import kotlinx.android.synthetic.main.activity_pantalla_perfil.*
import kotlinx.android.synthetic.main.activity_pantalla_principal.*

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
    var alumno: Alumno? =null
    constructor(contexto: Context, mensajes: ArrayList<Mensaje>, usuario: Alumno){
        this.contexto=contexto
        this.mensajes=mensajes
        this.alumno=usuario
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var mensaje=mensajes[p0]
        var inflador=contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista=inflador.inflate(R.layout.activity_pantalla_mensaje, null)
        vista.setOnClickListener(){
            var intent=Intent(contexto, MainActivity::class.java)
            intent.putExtra("usuario",alumno)
            intent.putExtra("nombreProfesor", mensaje.to)
            contexto!!.startActivity(intent)
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