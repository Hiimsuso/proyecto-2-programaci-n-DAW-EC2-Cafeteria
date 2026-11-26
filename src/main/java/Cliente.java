/**
 * Representa al cliente que realiza la compra.
 */
public class Cliente {

    private String nombre;
    private String telefono;

    public Cliente(String nombre, String telefono) {
        setNombre(nombre);
        setTelefono(telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            this.nombre = "Cliente sin nombre";
        } else {
            this.nombre = nombre.trim();
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isBlank()) {
            this.telefono = "No indicado";
        } else {
            this.telefono = telefono.trim();
        }
    }

    public String mostrarInformacion() {
        return "Cliente: " + nombre + " - Teléfono: " + telefono;
    }
}
