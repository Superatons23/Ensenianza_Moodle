package apps.moviles.enseanza


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_pantalla_principal.*

class PantallaPrincipal : AppCompatActivity() {


    var clases = ArrayList<Clase>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal);

        var recycler: RecyclerView? = null
        // asignar recycler
        recycler = findViewById(R.id.print_recycler_view);

        //crear array de datos
        cargarClases();

        //horizontal layout
        var layoutManager: LinearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        //asignar layout al recycler view
        recycler.layoutManager=layoutManager;
        recycler.adapter=RecyclerAdapter(clases);
        recycler.itemAnimator=DefaultItemAnimator();


    }

    fun cargarClases() {
        clases.add(Clase("Geografia", "Mtra. Ana Marquez", R.drawable.geografiawhite))
        clases.add(Clase("Geografia", "Mtra. Ana Marquez", R.drawable.geografiawhite))
        clases.add(Clase("Geografia", "Mtra. Ana Marquez", R.drawable.geografiawhite))
        clases.add(Clase("Geografia", "Mtra. Ana Marquez", R.drawable.geografiawhite))
        clases.add(Clase("Geografia", "Mtra. Ana Marquez", R.drawable.geografiawhite))
        clases.add(Clase("Geografia", "Mtra. Ana Marquez", R.drawable.geografiawhite))
        clases.add(Clase("Geografia", "Mtra. Ana Marquez", R.drawable.geografiawhite))
        clases.add(Clase("Geografia", "Mtra. Ana Marquez", R.drawable.geografiawhite))
        clases.add(Clase("Geografia", "Mtra. Ana Marquez", R.drawable.geografiawhite))
    }


}


