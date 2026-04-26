import javax.swing.*;

public class LoginCajero {

    public static void main(String[] args) {

        // Pedir usuario
        String usuario = JOptionPane.showInputDialog("Ingrese Usuario:");

        // Pedir contraseña
        String password = JOptionPane.showInputDialog("Ingrese Contraseña:");

        // Verificar datos
        if (usuario.equals("admin") && password.equals("admin")) {

            JOptionPane.showMessageDialog(null,
                    "Bienvenido al Cajero Automático");

        } else {

            JOptionPane.showMessageDialog(null,
                    "Usuario o contraseña incorrectos");

        }

    }
}