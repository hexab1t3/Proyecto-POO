package src;
public class Main {
    // Autores:
    // Alarcon Garcia Leonardo
    // Patoni Velazquez Josue
    // Martinez de los Santos Edwin Isaac
    // Miranda Romero Fernando Uriel
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("    SISTEMA DE GESTIÓN DE MASCOTAS");
        System.out.println("==========================================");
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Crear instancia del sistema y mostrar menú
            SistemaGestion sistema = new SistemaGestion();
            sistema.mostrarMenu();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Error cargando driver de MySQL: " + e.getMessage());
        }
    }
}