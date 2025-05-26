import java.util.Date;

public class Cliente extends Persona{
    private int numeroCliente;
    private Mascota mascota;
    //Metodo constructor
    public Cliente(String nombre, String paterno, String materno, Date fecha_nacimiento, String Curp,int numeroCliente,Mascota mascota){
        super(nombre,paterno,materno,fecha_nacimiento,Curp);
        this.numeroCliente=numeroCliente;
        this.mascota=mascota;
    }
    //agregar pa cuando no tiene mama

}
