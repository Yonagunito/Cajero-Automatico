import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// --- CLASE DE APOYO PARA CONSULTAR SALDO ---
class Usuario {
    private double saldo;
    public Usuario(double saldoInicial) { this.saldo = saldoInicial; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
}

// --- CLASES ORIGINALES (FRAGMENTOS UNIDOS) ---

class Retiro {
    private double saldo;
    public Retiro(double saldoInicial) { this.saldo = saldoInicial; }
    public double getSaldoActualizado() { return saldo; }

    public void mostrarSaldo() {
        JOptionPane.showMessageDialog(null, "Saldo actual: $" + saldo);
    }

    public void retirar() {
        String montoStr = JOptionPane.showInputDialog("Ingrese monto a retirar:");
        try {
            double monto = Double.parseDouble(montoStr);
            if (monto <= 0) {
                JOptionPane.showMessageDialog(null, "Monto inválido");
            } else if (monto > saldo) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente");
            } else {
                saldo -= monto;
                JOptionPane.showMessageDialog(null, "Retiro exitoso\nMonto: $" + monto);
                mostrarSaldo();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido");
        }
    }
}

class Transferencia {
    private double saldo;
    public Transferencia(double saldoInicial) { this.saldo = saldoInicial; }
    public double getSaldoActualizado() { return saldo; }

    public void mostrarSaldo() {
        JOptionPane.showMessageDialog(null, "Saldo actual: $" + saldo);
    }

    public void transferir() {
        String cuentaDestino = JOptionPane.showInputDialog("Ingrese cuenta destino:");
        String montoStr = JOptionPane.showInputDialog("Ingrese monto a transferir:");
        try {
            double monto = Double.parseDouble(montoStr);
            if (monto <= 0) {
                JOptionPane.showMessageDialog(null, "Monto inválido");
            } else if (monto > saldo) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente");
            } else {
                saldo -= monto;
                JOptionPane.showMessageDialog(null, "Transferencia realizada a la cuenta " + cuentaDestino + "\nMonto: $" + monto);
                mostrarSaldo();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido");
        }
    }
}

class ConsultarSaldo {
    public void mostrarSaldo(Usuario usuario, boolean sesionActiva, List<String> movimientos) {
        if (!sesionActiva) {
            System.out.println("Debe iniciar sesión para consultar su saldo.");
            return;
        }
        try {
            System.out.println("Saldo actual: $" + usuario.getSaldo());
            if (movimientos != null && !movimientos.isEmpty()) {
                System.out.println("Últimos movimientos:");
                for (String movimiento : movimientos) {
                    System.out.println("- " + movimiento);
                }
            } else {
                System.out.println("No hay movimientos recientes.");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el saldo. Intente nuevamente.");
        }
    }
}

// --- CLASE PRINCIPAL (LOGIN Y MENÚ) ---

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario user = new Usuario(1000.0); // Saldo inicial
        List<String> movimientos = new ArrayList<>();
        boolean sesionActiva = false;
        int opcion;

        // Bucle principal
        do {
            System.out.println("=== CAJERO AUTOMÁTICO ===");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar");
            System.out.println("3. Transferir");
            System.out.println("4. Ingresar (Login)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ConsultarSaldo consulta = new ConsultarSaldo();
                    consulta.mostrarSaldo(user, sesionActiva, movimientos);
                    break;

                case 2:
                    if (sesionActiva) {
                        Retiro r = new Retiro(user.getSaldo());
                        r.retirar();
                        user.setSaldo(r.getSaldoActualizado()); // Sincronizar saldo
                        movimientos.add("Retiro realizado");
                    } else {
                        System.out.println("Inicie sesión primero.");
                    }
                    break;

                case 3:
                    if (sesionActiva) {
                        Transferencia t = new Transferencia(user.getSaldo());
                        t.transferir();
                        user.setSaldo(t.getSaldoActualizado()); // Sincronizar saldo
                        movimientos.add("Transferencia realizada");
                    } else {
                        System.out.println("Inicie sesión primero.");
                    }
                    break;

                case 4:
                    // Lógica del Login
                    String usuarioInput = JOptionPane.showInputDialog("Ingrese Usuario:");
                    String passwordInput = JOptionPane.showInputDialog("Ingrese Contraseña:");

                    if ("admin".equals(usuarioInput) && "admin".equals(passwordInput)) {
                        JOptionPane.showMessageDialog(null, "Bienvenido al Cajero Automático");
                        sesionActiva = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida");
            }
            System.out.println();
        } while (true);
    }
}