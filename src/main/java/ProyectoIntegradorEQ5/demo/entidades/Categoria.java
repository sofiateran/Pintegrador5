package ProyectoIntegradorEQ5.demo.entidades;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Categoria {
    int id;
    String titulo;
    String descripcion;
    String urlImagen;
}
