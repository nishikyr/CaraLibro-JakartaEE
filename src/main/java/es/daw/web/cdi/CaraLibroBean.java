package es.daw.web.cdi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.daw.web.entities.Publicacion;
import es.daw.web.entities.Usuario;
import es.daw.web.repositories.CrudRepository;
import es.daw.web.repositories.CrudRepositoryUsuario;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

@Model
public class CaraLibroBean {

    @Inject
    private CrudRepository<Usuario> repoUsuario;


    private String nombreUsuario;

    private Set<Usuario> usuarios;
    private Set<Publicacion> publicaciones;

    //GETTERS AND SETTERS
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Set<Usuario> getUsuarios() {
        try {
            usuarios = repoUsuario.select();
            System.out.println("PINTAMOS POR CONSOLA");
            for(Usuario usu: usuarios){
                System.out.println("\t" + usu);
                if(!usu.getPublicaciones().isEmpty()){
                    List<Publicacion> lista = usu.getPublicaciones();
                    publicaciones = new HashSet<>(lista);
                }
            }
            System.out.println(usuarios);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public Set<Publicacion> getPublicaciones() {
        return publicaciones;
    }
    public void setPublicaciones(Set<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    


}
