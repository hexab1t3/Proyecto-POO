package src;
import java.time.LocalDateTime;

public class Cita {
    private int numeroCita;
    private LocalDateTime fechaHora;
    private Cliente cliente;
    private Mascota mascota;
    private Persona encargado; // Puede ser Veterinario o Asistente
    private String descripcion;

    // Constructor
    public Cita(int numeroCita, LocalDateTime fechaHora, Cliente cliente, Mascota mascota, 
                Persona encargado, String descripcion) {
        this.numeroCita = numeroCita;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.mascota = mascota;
        this.encargado = encargado;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getNumeroCita() {
        return numeroCita;
    }

    public void setNumeroCita(int numeroCita) {
        this.numeroCita = numeroCita;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Persona getEncargado() {
        return encargado;
    }

    public void setEncargado(Persona encargado) {
        this.encargado = encargado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
