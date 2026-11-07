import java.util.ArrayList;

/**
 * Representa una venta de la cafetería.
 *
 * Esta clase utiliza composición porque contiene un Cliente, un Camarero y
 * un array de objetos Producto.
 */
public class Ticket {

    // Contador compartido por todos los tickets para generar números únicos
    // dentro de cada ejecución del programa.
    private static int siguienteNumero = 1;

    private final int numeroTicket;
    private Cliente cliente;
    private Camarero camarero;
    private ArrayList<Producto> productos;

    /**
     * Crea un ticket con una capacidad máxima de productos.
     *
     * @param cliente cliente asociado al ticket
     * @param camarero camarero que atiende la venta
     */
    public Ticket(Cliente cliente, Camarero camarero) {
        this.numeroTicket = siguienteNumero++;
        this.cliente = cliente;
        this.camarero = camarero;
        this.productos = new ArrayList<>();

    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero camarero) {
        this.camarero = camarero;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public int getContadorProductos() {
        return productos.size();
    }
    public boolean eliminarProducto(Producto producto) {
        return productos.remove(producto);
    }

    /**
     * Añade un producto al array si hay espacio disponible.
     *
     * @return true si se añade correctamente; false en caso contrario
     */
    public boolean agregarProducto(Producto producto) {
        if (producto == null) {
            return false;
        }

        productos.add(producto);
        return true;
    }

    /**
     * Recorre el array con un bucle y suma los precios de los productos
     * realmente añadidos al ticket.
     */
    public double calcularTotal() {
        double total = 0;

        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio();
        }

        return total;
    }

    /**
     * Devuelve el ticket completo como texto.
     *
     * Tener este método separado resulta útil porque el mismo texto se puede
     * mostrar en consola y también guardar en un archivo.
     */
    public String generarTextoTicket() {
        StringBuilder texto = new StringBuilder();

        texto.append("==============================\n");
        texto.append("       CAFETERÍA JAVA\n");
        texto.append("==============================\n");
        texto.append("Ticket nº: ").append(numeroTicket).append("\n");

        if (cliente != null) {
            texto.append("Cliente: ").append(cliente.getNombre()).append("\n");
        } else {
            texto.append("Cliente: no asignado\n");
        }

        if (camarero != null) {
            texto.append("Camarero: ")
                    .append(camarero.getNombre())
                    .append(" - Código: ")
                    .append(camarero.getCodigoEmpleado())
                    .append("\n");
        } else {
            texto.append("Camarero: no asignado\n");
        }

        texto.append("Productos:\n");

        if (productos.isEmpty()) {
            texto.append("No hay productos en el ticket.\n");
        } else {
            for (int i = 0; i < productos.size(); i++) {
                texto.append(i + 1)
                        .append(". ")
                        .append(productos.get(i).mostrarInformacion())
                        .append("\n");
            }
        }

        texto.append(String.format("Total: %.2f €%n", calcularTotal()));
        texto.append("==============================\n");

        return texto.toString();
    }

    /**
     * Muestra por consola toda la información del ticket.
     */
    public void mostrarTicket() {
        System.out.print(generarTextoTicket());
    }
}
