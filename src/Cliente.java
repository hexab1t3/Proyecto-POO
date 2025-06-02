package src;
import java.util.Date;

public class Cliente extends Persona{
    private int numeroCliente;
    private Mascota mascota;
    private Tarjeta tarjeta;

    // Constructor completo
    public Cliente(String nombre, String paterno, String materno, Date fecha_nacimiento, String Curp, int numeroCliente, Mascota mascota, Tarjeta tarjeta){
        super(nombre, paterno, materno, fecha_nacimiento, Curp);
        this.numeroCliente = numeroCliente;
        this.mascota = mascota;
        this.tarjeta = tarjeta;
    }

    // Constructor cuando carece de apellido materno
    public Cliente(String nombre, String paterno, Date fecha_nacimiento, String Curp, int numeroCliente, Mascota mascota, Tarjeta tarjeta){
        super(nombre, paterno, fecha_nacimiento, Curp);
        this.numeroCliente = numeroCliente;
        this.mascota = mascota;
        this.tarjeta = tarjeta;
    }

    // Getters y Setters
    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}