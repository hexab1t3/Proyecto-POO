package src;
import java.util.Date;

public class Gerente extends Persona{
    private int numeroGerente;
    private SucursalC sucursal;

    // Constructor completo
    public Gerente(String nombre, String paterno, String materno, Date fecha_nacimiento, String Curp, int numeroGerente, SucursalC sucursal){
        super(nombre, paterno, materno, fecha_nacimiento, Curp);
        this.numeroGerente = numeroGerente;
        this.sucursal = sucursal;
    }

    // Constructor en caso de que no tenga apellido materno
    public Gerente(String nombre, String paterno, Date fecha_nacimiento, String Curp, int numeroGerente, SucursalC sucursal){
        super(nombre, paterno, fecha_nacimiento, Curp);
        this.numeroGerente = numeroGerente;
        this.sucursal = sucursal;
    }

    // Getters y Setters
    public int getNumeroGerente() {
        return numeroGerente;
    }

    public void setNumeroGerente(int numeroGerente) {
        this.numeroGerente = numeroGerente;
    }

    public SucursalC getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalC sucursal) {
        this.sucursal = sucursal;
    }
}