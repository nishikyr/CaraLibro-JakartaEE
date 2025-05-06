package es.daw.web.cdi;

import java.util.Optional;

import es.daw.web.entities.Usuario;
import es.daw.web.exceptions.JPAException;
import es.daw.web.repositories.CrudRepositoryUsuario;
import es.daw.web.repositories.JpaManagerCdi;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

@Model
public class RegistroBean {
    
    @Inject
    CrudRepositoryUsuario repoUsuario;

    private String mensajeError;

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
    
    public String getMensajeError() {
        return mensajeError;
    }
    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    //#region ====== MÉTODO PARA GUARDAR ======
    public String guardarUsuario(){
        try {
            System.out.println("===== Esta pasando para GUARDARSE AQUI =======");
            Optional<Usuario> usuarioRegistrado = repoUsuario.selectByEmail(email);
            System.out.println("Encontré esto ......" +  usuarioRegistrado);
            if(usuarioRegistrado.isEmpty()){
                System.out.println("======Usuario vacio!!!!!!!!!!!");
                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.setEmail(email);
                nuevoUsuario.setNombre(nombre);
                repoUsuario.save(nuevoUsuario); // Aqui guardamos
            }else{
                mensajeError = "Usuario con email ya registrado";
                return "error";
            }
            

        } catch (JPAException e) {
            System.out.println("********** ERROR AL REGISTRAR USUARIO ****************");
            mensajeError = JpaManagerCdi.getMessageError(e);

            return "error";
        }
        return "index?faces-redirect=true";
    }
    //#endregion ===================================
}
