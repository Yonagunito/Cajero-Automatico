import javax.swing.*;

public class ConsultarSaldo {

    private Usuario usuario;

    public ConsultarSaldo(Usuario usuario) {
        this.usuario = usuario;
    }

    public void mostrarSaldo() {

        // Validación básica
        if (usuario == null) {
            JOptionPane.showMessageDialog(null,
                    "Debe iniciar sesión para consultar el saldo.");
            return;
        }

        try {
            JOptionPane.showMessageDialog(null,
                    "Saldo actual: $" + usuario.getSaldo());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al obtener el saldo. Intente nuevamente.");
        }
    }
}
