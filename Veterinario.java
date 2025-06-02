import java.util.Date;

public class Veterinario extends Persona{
    private int numeroCedula;
    //metodoConstructor
    public Veterinario(String nombre, String paterno,String materno, Date fecha_nacimiento, String Curp,int numeroCedula){
    super(nombre, paterno, materno, fecha_nacimiento, Curp);
    this.numeroCedula=numeroCedula;
    }
    //metodo Constructor cuando no tiene apellido materno
    public Veterinario(String nombre, String paterno, Date fechaNacimiento, String Curp,int numeroCedula) {
        super(nombre, paterno, fechaNacimiento, Curp);
        this.numeroCedula=numeroCedula;
    }
}
