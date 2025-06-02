package src;
import java.util.Date;

public class Persona {
    // Atributos
    private String nombre;
    private String paterno;
    private String materno; // opcional
    private Date fecha_nacimiento;
    private String Curp;

    // Constructor completo
    public Persona(String nombre, String paterno, String materno, Date fecha_nacimiento, String Curp){
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.Curp = Curp;
    }

    // Constructor en caso de no tener apellido materno
    public Persona(String nombre, String paterno, Date fecha_nacimiento, String Curp){
        this.nombre = nombre;
        this.paterno = paterno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.Curp = Curp;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCurp() {
        return Curp;
    }

    public void setCurp(String curp) {
        Curp = curp;
    }
}