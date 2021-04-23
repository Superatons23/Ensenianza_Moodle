package apps.moviles.enseanza

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import apps.moviles.enseanza.repository.Repository
import kotlinx.android.synthetic.main.activity_pantalla_login.btnRegistro
import kotlinx.android.synthetic.main.activity_pantalla_login_2.*
import java.net.URL


class PantallaLogin_2 : AppCompatActivity() {

    private lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_login_2)

        btnRegistro.setOnClickListener(){
            startActivity(Intent(this, PantallaRegistrate::class.java))
        }

        val repository=Repository()
        var viewModelFactory=MainViewModelFactory(repository)
        viewModel=ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response  ->
            if(response.isSuccessful){
                Log.d("Response",response.body()?.title!!)
            }else{
                Log.d("Response", response.errorBody().toString())
                Log.d("Response", response.code().toString())
            }
        })

        btnIngresar.setOnClickListener(){
            //startActivity(Intent(this, PantallaRecordarUsuario::class.java))
            var user=et_correo
            var pass=et_contrasenia



        }
    }
}