package src;
import java.util.Date;

public class Veterinario extends Persona{
    private int numeroCedula;

    // Constructor completo
    public Veterinario(String nombre, String paterno, String materno, Date fecha_nacimiento, String Curp, int numeroCedula){
        super(nombre, paterno, materno, fecha_nacimiento, Curp);
        this.numeroCedula = numeroCedula;
    }

    // Constructor cuando no tiene apellido materno
    public Veterinario(String nombre, String paterno, Date fechaNacimiento, String Curp, int numeroCedula) {
        super(nombre, paterno, fechaNacimiento, Curp);
        this.numeroCedula = numeroCedula;
    }

    // Getters y Setters
    public int getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(int numeroCedula) {
        this.numeroCedula = numeroCedula;
    }
}