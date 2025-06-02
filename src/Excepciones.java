package src;
// Excepción personalizada para citas ocupadas
class CitaOcupadaException extends Exception {
    public CitaOcupadaException(String mensaje) {
        super(mensaje);
    }
}

// Excepción personalizada para mascotas sin vacunas
class MascotaSinVacunasException extends Exception {
    public MascotaSinVacunasException(String mensaje) {
        super(mensaje);
    }
}

// Excepción personalizada para clientes no encontrados
class ClienteNoEncontradoException extends Exception {
    public ClienteNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}

// Excepción personalizada para mascotas no disponibles
class MascotaNoDisponibleException extends Exception {
    public MascotaNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}