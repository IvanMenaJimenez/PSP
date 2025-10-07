package EJ_1;

import java.io.Serializable;

public class Alumno implements Serializable{
    String nombre;
    double notaMedia;

    public Alumno(String nombre, double notaMedia) {
        this.nombre = nombre;
        this.notaMedia = notaMedia;
    }
    
    
}
