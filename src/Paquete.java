package src;
public class Paquete {
    private String nombrePaquete;
    private String descripcion;
    private double precio;

    // Constructor con validación
    public Paquete(String nombrePaquete, String descripcion, double precio){
        if(nombrePaquete == null) {
            throw new IllegalArgumentException("Nombre de paquete no valido");
        }
        this.nombrePaquete = nombrePaquete;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters y Setters
    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setNombrePaquete(String nombrePaquete) {
        if(nombrePaquete == null) {
            throw new IllegalArgumentException("Nombre de paquete no valido");
        }
        this.nombrePaquete = nombrePaquete;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
