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

        }

    }
}
