/**
 * Clase hija de Producto que representa una comida.
 */
public class Comida extends Producto {

    // Atributo propio de la clase hija.
    private boolean esCaliente;

    public Comida(String nombre, double precio, String categoria, boolean esCaliente) {
        super(nombre, precio, categoria);
        this.esCaliente = esCaliente;
    }

    public boolean isEsCaliente() {
        return esCaliente;
    }

    public void setEsCaliente(boolean esCaliente) {
        this.esCaliente = esCaliente;
    }

    /**
     * Sobrescritura del método de Producto.
     */
    @Override
    public String mostrarInformacion() {
        String temperatura = esCaliente ? "caliente" : "frío";
        return String.format("%s %s - %.2f €",
                getNombre(), temperatura, getPrecio());
    }
}
