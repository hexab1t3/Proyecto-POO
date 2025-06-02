import java.util.Date;

public class Persona {
    //Atributos
    private String nombre;
    private String paterno;
    private String materno;//opcional
    private Date fecha_nacimiento;
    private String Curp;
    //metodo constructor Completo
    public Persona(String nombre,String paterno,String materno,Date fecha_nacimiento,String Curp){
        this.nombre=nombre;
        this.paterno=paterno;
        this.materno=materno;
        this.fecha_nacimiento=fecha_nacimiento;
        this.Curp=Curp;
    }
    //Constructor en caso de no tener apellido Materno
    public Persona(String nombre,String paterno,Date fecha_nacimiento,String Curp){
        this.nombre=nombre;
        this.paterno=paterno;
        this.fecha_nacimiento=fecha_nacimiento;
        this.Curp=Curp;
    }
    //Metodos set y get

}
