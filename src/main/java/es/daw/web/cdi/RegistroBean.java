package es.daw.web.cdi;

import es.daw.web.entities.Usuario;
import es.daw.web.repositories.CrudRepositoryUsuario;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

@Model
public class RegistroBean {
    
    @Inject
    CrudRepositoryUsuario repoUsuario;

    Usuario nuevoUsuario;

    private String nombre;
    private String email;

    //GETTERS AND SETTERS 
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    // ====== MÉTODO PARA GUARDAR ======
    public void guardarUsuario(){
        try {
            nuevoUsuario.setEmail(email);
            nuevoUsuario.setNombre(nombre);
            repoUsuario.save(nuevoUsuario);

        } catch (Exception e) {
            
        }
    }
}
