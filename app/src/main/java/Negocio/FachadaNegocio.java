package Negocio;

public class FachadaNegocio implements iNegocio{
    @Override
    public boolean iniciarSesion(String usuario, String contrasenia) {
        return false;
    }

    @Override
    public boolean iniciarSesion() {
        return false;
    }

    @Override
    public boolean subirTarea() {
        return false;
    }
}
