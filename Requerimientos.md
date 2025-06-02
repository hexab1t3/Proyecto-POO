# Requerimientos del Proyecto

## 1. Menú de operaciones  
Debe existir un menú que permita:  
1. Alta de cliente 
2. Alta de mascota  
3. Alta y baja de veterinarios o asistente personal  
4. Alta de gerente en sucursal  
5. Registro de citas de veterinarios a domicilio  
6. Alta de paquetes (corte, baño, desparasitación, esterilización, etc.)  
7. Adopción o devolución de mascotas  
8. Pago de paquetes (corte, baño, desparasitación, esterilización, etc.)  
9. Consulta de citas de veterinarios  
10. Consulta de paquetes  
11. Consulta de adopciones  
12. Consulta de veterinarios  
13. Escritura a archivo de citas (todas o de una fecha específica)

---

## 2. Enumeración  (listo)
- **Enum `Sucursal`**: definir nombre de la sucursal y manejar diferentes zonas.

---

## 3. Modelo de clases  

### 3.1. Clase `Persona`  (listo)
- `nombre` (String)  
- `paterno` (String)  
- `materno` (String)  
- `fecha_nacimiento` (Date)  
- `CURP` (String)  

### 3.2. Clase `Cliente` extends `Persona`  (listo)
- `numeroCliente` (int)  
- Relación “has-a” con `Mascota`  

### 3.3. Clase `Veterinario` extends `Persona`  (listo)
- `numeroCedula` (int)  

### 3.4. Clase `Asistente` extends `Persona`  

### 3.5. Clase `Gerente` extends `Persona`  (listo)
- Relación “has-a” con `Sucursal`  
- `numeroGerente` (int)  

### 3.6. Clase `Mascota`  (listo)
- `nombre` (String)  
- `raza` (String)  
- `numeroMascota` (int)  
- Arreglo de vacunas aplicadas  

### 3.7. Clase `Paquete`  
- (para cortes, baño, desparasitación, esterilización, etc.)  

### 3.8. Clase `Tarjeta`  
- `numeroTarjeta` (long)  
- `fechaVencimiento` (Date)  
- `cvc` (short)  

### 3.9. Clase `Cita`  
- `numeroCita` (int)  
- `fechaHora` (Date)  
- `cliente` (Cliente)  
- `mascota` (Mascota)  
- `veterinario` (Veterinario) y/o `asistente` (Asistente)  
- `descripcionServicio` (String)  
- Arreglo de `Paquete` contratados  

---

## 4. Reglas de negocio  

- **Citas**  
  - No agendar dos citas en la misma fecha y hora (duración 1 hora).  
  - Excepción en conflicto:  
    > “No puede agendar la cita, ya se encuentra ocupada”.  

- **Pago de paquetes**  
  - Buscar cliente por número.  
  - Cada cliente posee un atributo `Tarjeta`.  
  - Monto total = suma de precios de paquetes.  
  - Aplicar cargo a la tarjeta.

- **Adopciones y devoluciones**  
  - Colección de mascotas disponibles.  
  - Al adoptar:  
    - Registrar en colección cliente→mascota.  
    - Remover mascota de disponibles.  
    - Si no tiene vacunas → excepción:  
      > “No tiene vacunas suministradas”.  
    - Sin cobro de adopción.  
  - Al devolver:  
    - Quitar registro de adopción.  
    - Devolver mascota a disponibles.  
    - Si presenta lesiones o maltrato → cobrar al cliente (cargo a tarjeta).

---

## 5. Consultas y reportes  

- **Listado de citas**  
  1. Submenú de ordenamiento: fecha, nombre, apellido paterno, apellido materno.  
  2. Implementar `Comparable` o `Comparator`.  
  3. Al finalizar, preguntar si desea descargar a archivo (uso de `java.io`).  

- **Consulta de paquetes, adopciones y veterinarios**  
  - Orden ascendente o descendente.

- **Escritura de citas a archivo**  
  - Todas o por fecha específica (opción del menú principal).

---

## 6. Persistencia / Base de datos  

- Tablas SQL:  
  - `Cliente` (id_cliente, …)  
  - `Mascota` (id_mascota, …)  
  - `Veterinario` (id_veterinario, …)  
  - `Cita` (id_cita, id_cliente, id_mascota, id_veterinario, fechaHora, descripción)  

---

## 7. Interfaces y excepciones  

- **Interfaz `RevisionDeCitas`**  
  - `boolean asistenteDisponible(String nombre, String paterno, String materno)`  
  - `boolean veterinarioDisponible(String nombre, String paterno, String materno)`  
  - `boolean mascotaVacunada(int numeroMascota)`  
  - `boolean revisarDisponibilidad(Date fechaCita)`

- **Excepciones**  
  - Personalizada para cita ocupada.  
  - Para mascota sin vacunas.

---

## 8. Paradigma y buenas prácticas  

- Uso de POO: herencia, polimorfismo, colecciones, enums, excepciones, interfaces/abstractas, estáticos.  
- **Opcionales** (extras): genéricos, wildcards, clases internas, persistencia, hilos, GUI, eventos.  
- Métodos sobrecargados y sobrescritos donde corresponda (comentar en código).

---

## 9. Estructura de archivos y documentación  

- Cada clase en archivo separado.  
- En la clase principal (`main`):  
  - Comentarios con nombres de todos los alumnos.  
  - Comentarios en métodos indicando su función.  
- **README.txt** con nombre del alumno y la leyenda:  
  > “El código que realizó es autoría propia y no es tomado de algún otro lugar o hecho por otra persona”.

---

## 10. Entrega  

1. Empaquetar todo en un `.zip` con todos los archivos del proyecto.  
2. Indicar la clase principal (`main`) en la plataforma.  
3. Un miembro del equipo sube el .zip a Moodle y envía el mensaje de entrega.  
