import java.util.ArrayList;
import java.util.Map;

public class TicketJson {

    private String cliente;
    private String camarero;
    private ArrayList<Map<String, Object>> productos;
    private double total;

    public TicketJson(String cliente, String camarero, ArrayList<Map<String, Object>> productos, double total) {
        this.cliente = cliente;
        this.camarero = camarero;
        this.productos = productos;
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCamarero() {
        return camarero;
    }

    public void setCamarero(String camarero) {
        this.camarero = camarero;
    }

    public ArrayList<Map<String, Object>> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Map<String, Object>> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
