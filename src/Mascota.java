package src;
public class Mascota {
    private String nombre;
    private String raza;
    private int numeroMascota;
    private String[] vacunasAplicadas;

    // Constructor
    public Mascota(String nombre, String raza, int numeroMascota, String[] vacunasAplicadas){
        this.nombre = nombre;
        this.raza = raza;
        this.numeroMascota = numeroMascota;
        this.vacunasAplicadas = vacunasAplicadas;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getNumeroMascota() {
        return numeroMascota;
    }

    public void setNumeroMascota(int numeroMascota) {
        this.numeroMascota = numeroMascota;
    }

    public String[] getVacunasAplicadas() {
        return vacunasAplicadas;
    }

    public void setVacunasAplicadas(String[] vacunasAplicadas) {
        this.vacunasAplicadas = vacunasAplicadas;
    }
}