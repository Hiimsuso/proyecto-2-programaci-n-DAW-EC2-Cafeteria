/**
 * Interfaz que define el comportamiento de un objeto al que se le puede
 * aplicar un descuento porcentual.
 */
public interface Descontable {

    /**
     * Calcula el precio final después de aplicar un descuento.
     *
     * @param porcentaje porcentaje de descuento entre 0 y 100
     * @return precio final después del descuento
     */
    double aplicarDescuento(double porcentaje);
}
