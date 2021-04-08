package apps.moviles.enseanza

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val clases: ArrayList<Clase>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_pantalla_principal_clase, parent, false);
     // view.setBackgroundResource(R.drawable.rounded_edit_text);
        return ViewHolder(view);
    }

    override fun getItemCount() = clases.size;

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombreClase.text = clases[position].nombreClase;
        holder.nombreProfesor.text = clases[position].nombreProfesor;
        holder.icono.setImageResource(clases[position].icono);

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nombreClase: TextView = itemView.findViewById(R.id.prin_nombre_clase);
        val nombreProfesor: TextView = itemView.findViewById(R.id.prin_nombre_profesor);
        val icono: ImageView = itemView.findViewById(R.id.prin_icono);
    }

}