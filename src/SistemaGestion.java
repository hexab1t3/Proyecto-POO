package src;
import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import java.io.*;


public class SistemaGestion implements RevisionDeCitas {
    // Conexión a la base de datos
    private Connection conexion;
    private Scanner scanner = new Scanner(System.in);

    // Listas simples para datos que no van en BD
    private List<Paquete> paquetes = new ArrayList<>();
    private List<Asistente> asistentes = new ArrayList<>();
    private List<Gerente> gerentes = new ArrayList<>();
    private Map<Integer, Integer> adopciones = new HashMap<>(); // clienteId y mascotaId

    public SistemaGestion() {
        conectarBaseDatos();
        inicializarDatos();
    }

    // Método para conectar a MySQL 
    private void conectarBaseDatos() {
        try {
            String url = "jdbc:mysql://localhost:3306/Mascotas";
            String usuario = "root"; // usuario por defecto
            String password = "731313"; // cambiar según tu configuración

            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión a BD exitosa");
        } catch (SQLException e) { // Excepcion en caso de no poder conectar
            System.out.println("Error conectando a BD: " + e.getMessage());
        }
    }

    // Inicializar algunos datos de ejemplo
    private void inicializarDatos() {
        paquetes.add(new Paquete("Corte", "Corte de pelo", 200.0));
        paquetes.add(new Paquete("Baño", "Baño completo", 150.0));
        paquetes.add(new Paquete("Vacunas", "Aplicación de vacunas", 300.0));
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== SISTEMA DE MASCOTAS ===");
            System.out.println("1. Alta de cliente");
            System.out.println("2. Alta de mascota");
            System.out.println("3. Alta/baja de veterinarios o asistente");
            System.out.println("4. Alta de gerente");
            System.out.println("5. Registrar cita");
            System.out.println("6. Alta de paquetes");
            System.out.println("7. Adopción/devolución");
            System.out.println("8. Pago de paquetes");
            System.out.println("9. Consulta de citas");
            System.out.println("10. Consulta de paquetes");
            System.out.println("11. Consulta de adopciones");
            System.out.println("12. Consulta de veterinarios");
            System.out.println("13. Guardar citas en archivo");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: altaCliente(); break;
                case 2: altaMascota(); break;
                case 3: gestionPersonal(); break;
                case 4: altaGerente(); break;
                case 5: registrarCita(); break;
                case 6: altaPaquete(); break;
                case 7: adopcionDevolucion(); break;
                case 8: pagoPaquetes(); break;
                case 9: consultaCitas(); break;
                case 10: consultaPaquetes(); break;
                case 11: consultaAdopciones(); break;
                case 12: consultaVeterinarios(); break;
                case 13: guardarCitasArchivo(); break;
                case 0: 
                    cerrarConexion();
                    System.out.println("¡Adiós!");
                    return;
                default: System.out.println("Opción inválida");
            }
        }
    }

    // 1. Alta de cliente - guarda en BD
    private void altaCliente() {
        System.out.println("\n--- Alta de Cliente ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido paterno: ");
        String paterno = scanner.nextLine();
        System.out.print("Apellido materno (opcional): ");
        String materno = scanner.nextLine();
        if (materno.isEmpty()) materno = null;

        System.out.print("CURP: ");
        String curp = scanner.nextLine();
        System.out.print("Número de tarjeta: ");
        long tarjeta = scanner.nextLong();
        System.out.print("CVC: ");
        short cvc = scanner.nextShort();

        try {
            String sql = "INSERT INTO Cliente (nombre, paterno, materno, curp, numero_tarjeta, cvc) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, paterno);
            ps.setString(3, materno);
            ps.setString(4, curp);
            ps.setLong(5, tarjeta);
            ps.setShort(6, cvc);

            ps.executeUpdate();
            System.out.println("Cliente guardado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 2. Alta de mascota - guarda en BD
    private void altaMascota() {
        System.out.println("\n--- Alta de Mascota ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Raza: ");
        String raza = scanner.nextLine();
        System.out.print("Vacunas (separadas por coma): ");
        String vacunas = scanner.nextLine();

        try {
            String sql = "INSERT INTO Mascota (nombre, raza, vacunas) VALUES (?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, raza);
            ps.setString(3, vacunas);

            ps.executeUpdate();
            System.out.println("Mascota guardada exitosamente");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 3. Gestión de personal - veterinarios en BD, asistentes en memoria
    private void gestionPersonal() {
        System.out.println("\n--- Gestión de Personal ---");
        System.out.println("1. Alta veterinario");
        System.out.println("2. Alta asistente");
        System.out.println("3. Baja veterinario");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1: altaVeterinario(); break;
            case 2: altaAsistente(); break;
            case 3: bajaVeterinario(); break;
        }
    }

    private void altaVeterinario() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido paterno: ");
        String paterno = scanner.nextLine();
        System.out.print("CURP: ");
        String curp = scanner.nextLine();
        System.out.print("Número de cédula: ");
        int cedula = scanner.nextInt();

        try {
            String sql = "INSERT INTO Veterinario (nombre, paterno, curp, numero_cedula) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, paterno);
            ps.setString(3, curp);
            ps.setInt(4, cedula);

            ps.executeUpdate();
            System.out.println("Veterinario guardado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void altaAsistente() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido paterno: ");
        String paterno = scanner.nextLine();
        System.out.print("CURP: ");
        String curp = scanner.nextLine();
        System.out.print("Número de asistente: ");
        int numero = scanner.nextInt();

        // Los asistentes se guardan en memoria
        Asistente asistente = new Asistente(nombre, paterno, new java.util.Date(), curp, numero);
        asistentes.add(asistente); // se guarda en la array list
        System.out.println("Asistente guardado exitosamente");
    }

    private void bajaVeterinario() {
        System.out.print("Número de cédula: ");
        int cedula = scanner.nextInt();

        try {
            String sql = "DELETE FROM Veterinario WHERE numero_cedula = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, cedula);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Veterinario eliminado");
            } else {
                System.out.println("Veterinario no encontrado");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 4. Alta de gerente - en memoria con enum Sucursal
    private void altaGerente() {
        System.out.println("\n--- Alta de Gerente ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido paterno: ");
        String paterno = scanner.nextLine();
        System.out.print("CURP: ");
        String curp = scanner.nextLine();
        System.out.print("Número de gerente: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Sucursales:");
        for (Sucursal s : Sucursal.values()) {
            System.out.println("- " + s);
        }
        System.out.print("Sucursal: ");
        String sucStr = scanner.nextLine().toUpperCase();

        try {
            Sucursal sucursal = Sucursal.valueOf(sucStr);
            SucursalC sucursalClass = new SucursalC(sucursal);
            Gerente gerente = new Gerente(nombre, paterno, new java.util.Date(), curp, numero, sucursalClass);
            gerentes.add(gerente);
            System.out.println("Gerente guardado exitosamente");
        } catch (IllegalArgumentException e) {
            System.out.println("Sucursal inválida");
        }
    }

    // 5. Registrar cita - guarda en BD con validaciones
    private void registrarCita() {
        System.out.println("\n--- Registrar Cita ---");

        try {
            System.out.print("ID del cliente: ");
            int clienteId = scanner.nextInt();
            System.out.print("ID de la mascota: ");
            int mascotaId = scanner.nextInt();
            System.out.print("ID del veterinario: ");
            int vetId = scanner.nextInt();
            scanner.nextLine();

            // Verificar que la mascota tenga vacunas
            if (!mascotaVacunada(mascotaId)) {
                throw new MascotaSinVacunasException("La mascota no tiene vacunas");
            }

            System.out.print("Fecha y hora (yyyy-MM-dd HH:mm): ");
            String fechaStr = scanner.nextLine();
            LocalDateTime fechaHora = LocalDateTime.parse(fechaStr.replace(" ", "T"));

            // Verificar disponibilidad
            java.util.Date fecha = java.util.Date.from(fechaHora.atZone(java.time.ZoneId.systemDefault()).toInstant());
            if (!revisarDisponibilidad(fecha)) {
                throw new CitaOcupadaException("No puede agendar la cita, ya se encuentra ocupada");
            }

            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();

            String sql = "INSERT INTO Cita (id_cliente, id_mascota, id_veterinario, fecha_hora, descripcion) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, clienteId);
            ps.setInt(2, mascotaId);
            ps.setInt(3, vetId);
            ps.setTimestamp(4, Timestamp.valueOf(fechaHora));
            ps.setString(5, descripcion);

            ps.executeUpdate();
            System.out.println("Cita registrada exitosamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 6. Alta de paquetes - en memoria
    private void altaPaquete() {
        System.out.println("\n--- Alta de Paquete ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        Paquete paquete = new Paquete(nombre, descripcion, precio);
        paquetes.add(paquete);
        System.out.println("Paquete guardado exitosamente");
    }

    // 7. Adopción/devolución
    private void adopcionDevolucion() {
        System.out.println("\n--- Adopción/Devolución ---");
        System.out.println("1. Adopción");
        System.out.println("2. Devolución");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();

        if (opcion == 1) {
            procesarAdopcion();
        } else if (opcion == 2) {
            procesarDevolucion();
        }
    }

    private void procesarAdopcion() {
        try {
            System.out.print("ID del cliente: ");
            int clienteId = scanner.nextInt();
            System.out.print("ID de la mascota: ");
            int mascotaId = scanner.nextInt();

            if (!mascotaVacunada(mascotaId)) {
                throw new MascotaSinVacunasException("No tiene vacunas suministradas");
            }

            // Marcar mascota como no disponible
            String sql = "UPDATE Mascota SET disponible = FALSE WHERE id_mascota = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, mascotaId);
            ps.executeUpdate();

            adopciones.put(clienteId, mascotaId);
            System.out.println("Adopción procesada exitosamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void procesarDevolucion() {
        System.out.print("ID del cliente: ");
        int clienteId = scanner.nextInt();

        if (!adopciones.containsKey(clienteId)) {
            System.out.println("Cliente no tiene adopciones");
            return;
        }

        int mascotaId = adopciones.get(clienteId);

        System.out.print("¿Presenta lesiones? (s/n): ");
        scanner.nextLine();
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Monto del cargo: ");
            double cargo = 100000000.0;
            System.out.println("Cobrando $" + cargo + " por maltrato");
        }

        try {
            // Marcar mascota como disponible
            String sql = "UPDATE Mascota SET disponible = TRUE WHERE id_mascota = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, mascotaId);
            ps.executeUpdate();

            adopciones.remove(clienteId);
            System.out.println("Devolución procesada exitosamente");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 8. Pago de paquetes
    private void pagoPaquetes() {
        System.out.println("\n--- Pago de Paquetes ---");
        System.out.print("ID del cliente: ");
        int clienteId = scanner.nextInt();

        System.out.println("Paquetes disponibles:");
        for (int i = 0; i < paquetes.size(); i++) {
            Paquete p = paquetes.get(i);
            System.out.println((i+1) + ". " + p.getNombrePaquete() + " - $" + p.getPrecio());
        }

        System.out.print("Seleccione paquete: ");
        int indice = scanner.nextInt() - 1;

        if (indice >= 0 && indice < paquetes.size()) {
            double precio = paquetes.get(indice).getPrecio();
            System.out.println("Cobrando $" + precio + " al cliente " + clienteId);
            System.out.println("Pago procesado exitosamente");
        } else {
            System.out.println("Paquete inválido");
        }
    }

    // 9. Consulta de citas - con ordenamiento
    private void consultaCitas() {
        System.out.println("\n--- Consulta de Citas ---");
        System.out.println("1. Por fecha");
        System.out.println("2. Por nombre cliente");
        System.out.print("Ordenar por: ");

        int opcion = scanner.nextInt();
        String orderBy = (opcion == 1) ? "fecha_hora" : "c.nombre";

        try {
            String sql = "SELECT cita.id_cita, c.nombre, c.paterno, m.nombre as mascota, cita.fecha_hora " +
                        "FROM Cita cita " +
                        "JOIN Cliente c ON cita.id_cliente = c.id_cliente " +
                        "JOIN Mascota m ON cita.id_mascota = m.id_mascota " +
                        "ORDER BY " + orderBy;

            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n--- CITAS ---"); 
            while (rs.next()) {
                System.out.println("Cita #" + rs.getInt("id_cita") + 
                                 " - " + rs.getString("nombre") + " " + rs.getString("paterno") +
                                 " - Mascota: " + rs.getString("mascota") +
                                 " - " + rs.getString("fecha_hora"));
            }

            System.out.print("¿Guardar en archivo? (s/n): ");
            scanner.nextLine();
            String resp = scanner.nextLine();
            if (resp.equalsIgnoreCase("s")) {
                guardarCitasArchivo();
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 10. Consulta de paquetes
    private void consultaPaquetes() {
        System.out.println("\n--- Consulta de Paquetes ---");
        paquetes.sort((p1, p2) -> p1.getNombrePaquete().compareTo(p2.getNombrePaquete()));

        for (Paquete p : paquetes) {
            System.out.println(p.getNombrePaquete() + " - $" + p.getPrecio());
        }
    }

    // 11. Consulta de adopciones
    private void consultaAdopciones() {
        System.out.println("\n--- Consulta de Adopciones ---");
        for (Map.Entry<Integer, Integer> entry : adopciones.entrySet()) {
            System.out.println("Cliente ID: " + entry.getKey() + " - Mascota ID: " + entry.getValue());
        }
    }

    // 12. Consulta de veterinarios
    private void consultaVeterinarios() {
        System.out.println("\n--- Consulta de Veterinarios ---");

        try {
            String sql = "SELECT * FROM Veterinario ORDER BY nombre";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Dr. " + rs.getString("nombre") + " " + rs.getString("paterno") +
                                 " - Cédula: " + rs.getInt("numero_cedula"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 13. Guardar citas en archivo
    private void guardarCitasArchivo() {
        System.out.println("\n--- Guardar Citas en Archivo ---");

        try (PrintWriter writer = new PrintWriter(new FileWriter("citas.txt"))) {
            String sql = "SELECT cita.id_cita, c.nombre, c.paterno, m.nombre as mascota, cita.fecha_hora, cita.descripcion " +
                        "FROM Cita cita " +
                        "JOIN Cliente c ON cita.id_cliente = c.id_cliente " +
                        "JOIN Mascota m ON cita.id_mascota = m.id_mascota";

            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            writer.println("=== REPORTE DE CITAS ===");
            writer.println("Fecha: " + new java.util.Date());
            writer.println();

            while (rs.next()) {
                writer.println("Cita #" + rs.getInt("id_cita"));
                writer.println("Cliente: " + rs.getString("nombre") + " " + rs.getString("paterno"));
                writer.println("Mascota: " + rs.getString("mascota"));
                writer.println("Fecha: " + rs.getString("fecha_hora"));
                writer.println("Descripción: " + rs.getString("descripcion"));
                writer.println("---");
            }

            System.out.println("Archivo guardado: citas.txt");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Implementación de la interfaz RevisionDeCitas
    @Override
    public boolean asistenteDisponible(String nombre, String paterno, String materno) {
        return asistentes.stream().anyMatch(a -> 
            a.getNombre().equals(nombre) && a.getPaterno().equals(paterno));
    }

    @Override
    public boolean veterinarioDisponible(String nombre, String paterno, String materno) {
        try {
            String sql = "SELECT COUNT(*) FROM Veterinario WHERE nombre = ? AND paterno = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, paterno);

            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean mascotaVacunada(int numeroMascota) {
        try {
            String sql = "SELECT vacunas FROM Mascota WHERE id_mascota = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, numeroMascota);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String vacunas = rs.getString("vacunas");
                return vacunas != null && !vacunas.trim().isEmpty();
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean revisarDisponibilidad(java.util.Date fechaCita) {
        try {
            String sql = "SELECT COUNT(*) FROM Cita WHERE DATE(fecha_hora) = DATE(?) AND HOUR(fecha_hora) = HOUR(?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(fechaCita.getTime()));
            ps.setTimestamp(2, new Timestamp(fechaCita.getTime()));

            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1) == 0;
        } catch (SQLException e) {
            return false;
        }
    }

    private void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error cerrando conexión: " + e.getMessage());
        }
    }
}