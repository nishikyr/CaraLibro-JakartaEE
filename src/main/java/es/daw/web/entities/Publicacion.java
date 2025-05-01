package es.daw.web.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String contenido;
    
    @Column(name = "fecha_publicacion")
    private LocalDateTime fecha;

    private int likes;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    //================ MÉTODOS GETTERS AND SETTERS ======================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // ===================== MÉTODO TO STRING ================================
    @Override
    public String toString() {
        return "Publicacion [id=" + id + ", contenido=" + contenido + ", fecha=" + fecha + ", likes=" + likes + "]";
    }

}
