package src;
import java.util.Date;

public class Tarjeta {
    private long numeroTarjeta;
    private Date fechaVencimiento;
    private short cvc;

    // Constructor
    public Tarjeta(long numeroTarjeta, Date fechaVencimiento, short cvc) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvc = cvc;
    }

    // Getters y Setters
    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public short getCvc() {
        return cvc;
    }

    public void setCvc(short cvc) {
        this.cvc = cvc;
    }
}