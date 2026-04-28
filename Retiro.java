import javax.swing.*;

public class Retiro {

    private double saldo;

    public Retiro(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void mostrarSaldo() {
        JOptionPane.showMessageDialog(null,
                "Saldo actual: $" + saldo);
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
                JOptionPane.showMessageDialog(null,
                        "Retiro exitoso\nMonto: $" + monto);
                mostrarSaldo();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido");
        }
    }
}