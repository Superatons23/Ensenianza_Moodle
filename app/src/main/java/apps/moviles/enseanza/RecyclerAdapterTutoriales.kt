package apps.moviles.enseanza

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterTutoriales (val tutoriales: ArrayList<Tutorial>) :
    RecyclerView.Adapter<RecyclerAdapterTutoriales.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterTutoriales.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_pantalla_tutoria, parent, false);
        view.setBackgroundResource(R.drawable.rounded_edit_text);
        return ViewHolder(view);
    }

    override fun getItemCount() = tutoriales.size;

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombreClase.text = tutoriales[position].nombreClase;
        holder.icono.setImageResource(tutoriales[position].thumbnail);

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nombreClase: TextView = itemView.findViewById(R.id.tuto_nombreClase);
        val icono: ImageView = itemView.findViewById(R.id.tuto_icono);
    }

}

