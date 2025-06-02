package src;
import java.util.Date;

public class Asistente extends Persona{
    private int numeroAsistente; // atributo adicional para identificar al empleado

    // Constructor completo
    public Asistente(String nombre, String paterno, String materno, Date fecha_nacimiento, String Curp, int numeroAsistente){
        super(nombre, paterno, materno, fecha_nacimiento, Curp);
        this.numeroAsistente = numeroAsistente;
    }

    // Constructor en caso de no tener apellido materno o un solo apellido
    public Asistente(String nombre, String paterno, Date fecha_nacimiento, String Curp, int numeroAsistente){
        super(nombre, paterno, fecha_nacimiento, Curp);
        this.numeroAsistente = numeroAsistente;
    }

    // Getters y Setters
    public int getNumeroAsistente() {
        return numeroAsistente;
    }

    public void setNumeroAsistente(int numeroAsistente) {
        this.numeroAsistente = numeroAsistente;
    }
}