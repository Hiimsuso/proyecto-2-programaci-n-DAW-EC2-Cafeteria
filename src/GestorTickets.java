import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Se encarga de guardar y consultar los tickets finalizados.
 *
 * Los tickets se almacenan en un archivo de texto llamado "tickets.txt".
 * De esta forma el historial permanece disponible aunque cerremos el programa
 * y volvamos a ejecutarlo más tarde.
 */
public class GestorTickets {

    private static final String NOMBRE_ARCHIVO = "tickets.txt";
    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * Guarda un ticket al final del archivo.
     *
     * FileWriter con el parámetro true trabaja en modo "añadir", por lo que
     * no borra los tickets guardados anteriormente.
     *
     * @return true si se ha guardado correctamente
     */
    public boolean guardarTicket(Ticket ticket) {
        if (ticket == null || ticket.getContadorProductos() == 0) {
            return false;
        }

        try (BufferedWriter escritor = new BufferedWriter(
                new FileWriter(NOMBRE_ARCHIVO, true))) {

            escritor.write(ticket.generarTextoTicket());
            escritor.write("\n");
            return true;

        } catch (IOException e) {
            System.out.println("Error al guardar el ticket: " + e.getMessage());
            return false;
        }
    }

    /**
     * Lee el archivo línea a línea y muestra todos los tickets almacenados.
     */
    public void mostrarTicketsGuardados() {
        File archivo = new File(NOMBRE_ARCHIVO);

        if (!archivo.exists() || archivo.length() == 0) {
            System.out.println("Todavía no hay tickets guardados.");
            return;
        }

        System.out.println("\n========== HISTORIAL DE TICKETS ==========");

        try (BufferedReader lector = new BufferedReader(
                new FileReader(archivo))) {

            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Error al leer los tickets: " + e.getMessage());
        }
    }

    public void exportarTicketsJson(Path ruta, Ticket tickets){
        try{
            MAPPER.writeValue(ruta.toFile(), tickets);

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
