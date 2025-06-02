public class Paquete {

    private String nombrePaquete;
    private String descripcion;
    //Metodo constructor con una exepcion que inpide nombre nulo
    public Paquete(String nombrePaquete, String descripcion){
        if(nombrePaquete==null) {
            throw new IllegalArgumentException("Nombre de paquete no valido");
        }
        this.nombrePaquete = nombrePaquete;
        this.descripcion=descripcion;
    }
    //Metodos set y get




}
