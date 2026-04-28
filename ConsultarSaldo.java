import java.util.List;

public class ConsultarSaldo {

    // Método principal
    public void mostrarSaldo(Usuario usuario, boolean sesionActiva, List<String> movimientos) {

        // Validar sesión
        if (!sesionActiva) {
            System.out.println("Debe iniciar sesión para consultar su saldo.");
            return;
        }

        try {
            // Mostrar saldo
            System.out.println("Saldo actual: $" + usuario.getSaldo());

            // Mostrar movimientos si existen
            if (movimientos != null && !movimientos.isEmpty()) {
                System.out.println("Últimos movimientos:");
                for (String movimiento : movimientos) {
                    System.out.println("- " + movimiento);
                }
            } else {
                System.out.println("No hay movimientos recientes.");
            }

        } catch (Exception e) {
            // Manejo de error
            System.out.println("Error al obtener el saldo. Intente nuevamente.");
        }
    }
}