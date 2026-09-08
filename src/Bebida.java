/**
 * Clase hija de Producto que representa una bebida.
 */
public class Bebida extends Producto {

    // Atributo propio de la clase hija.
    private String tamanio;

    public Bebida(String nombre, double precio, String categoria, String tamanio) {
        super(nombre, precio, categoria);
        setTamanio(tamanio);
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        if (tamanio == null || tamanio.isBlank()) {
            this.tamanio = "normal";
        } else {
            this.tamanio = tamanio.trim();
        }
    }

    /**
     * Sobrescritura del método de Producto para mostrar también el tamaño.
     */
    @Override
    public String mostrarInformacion() {
        return String.format("%s %s - %.2f €",
                getNombre(), tamanio, getPrecio());
    }
}
