import java.util.Date;

public class Gerente extends Persona{
    private int numeroGerente;
    private SucursalClass sucursal;
    //Metodo constructor completo
    public Gerente(String nombre, String paterno, String materno, Date fecha_nacimiento, String Curp,int numeroGerente,SucursalClass sucursal){
        super(nombre, paterno, materno, fecha_nacimiento, Curp);
        this.numeroGerente=numeroGerente;
        this.sucursal=sucursal;
    }
    //Metodo constructor en caso de que no tenga mama
    public Gerente(String nombre, String paterno, Date fecha_nacimiento, String Curp,int numeroGerente,SucursalClass sucursal){
        super(nombre, paterno, fecha_nacimiento, Curp);
        this.numeroGerente=numeroGerente;
        this.sucursal=sucursal;
    }
    //Metodos set y get
}
