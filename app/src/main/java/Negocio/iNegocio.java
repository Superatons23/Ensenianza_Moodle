package Negocio;

public interface iNegocio {

    public boolean iniciarSesion(String usuario,String contrasenia);

    public boolean iniciarSesion();
    public boolean subirTarea();
}
