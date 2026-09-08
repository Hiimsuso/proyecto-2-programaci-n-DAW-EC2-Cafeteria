/**
 * Representa al empleado que atiende el ticket.
 */
public class Camarero {

    private String nombre;
    private String codigoEmpleado;

    public Camarero(String nombre, String codigoEmpleado) {
        setNombre(nombre);
        setCodigoEmpleado(codigoEmpleado);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            this.nombre = "Camarero sin nombre";
        } else {
            this.nombre = nombre.trim();
        }
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        if (codigoEmpleado == null || codigoEmpleado.isBlank()) {
            this.codigoEmpleado = "SIN-CODIGO";
        } else {
            this.codigoEmpleado = codigoEmpleado.trim();
        }
    }

    public String mostrarInformacion() {
        return "Camarero: " + nombre + " - Código: " + codigoEmpleado;
    }
}
