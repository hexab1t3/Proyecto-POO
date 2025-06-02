import java.util.Date;

public class Asistente extends Persona{
    private int numeroAsistente;//atributo adicional para identificar al empleado

    //Constructor Completo
    Asistente(String nombre, String paterno, String materno, Date fecha_nacimiento, String Curp,int numeroAsistente){
        super(nombre, paterno,materno, fecha_nacimiento, Curp);
        this.numeroAsistente=numeroAsistente;

    }
    //Constructor en caso de no tener apellido materno o un solo apellido
    Asistente(String nombre, String paterno, Date fecha_nacimiento, String Curp,int numeroAsistente){
        super(nombre, paterno, fecha_nacimiento, Curp);
        this.numeroAsistente=numeroAsistente;
    }
    //Metodos set y get

}
