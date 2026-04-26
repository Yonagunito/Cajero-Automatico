import javax.swing.*;

public class Transferencia {

    private double saldo;
  
    public Transferencia(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void mostrarSaldo() {
        JOptionPane.showMessageDialog(null,
                "Saldo actual: $" + saldo);
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
                JOptionPane.showMessageDialog(null,
                        "Transferencia realizada a la cuenta " + cuentaDestino +
                        "\nMonto: $" + monto);
                mostrarSaldo();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido");
        }
    }
}
