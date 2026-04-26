import java.util.Scanner;

 public class CajeroAutomatico {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("=== CAJERO AUTOMÁTICO ===");

            System.out.println("1. Consultar saldo");

            System.out.println("2. Retirar");

            System.out.println("3. Transferir");

            System.out.println("4. Ingresar");


            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("Consultando saldo...");

                    break;

                case 2:

                    System.out.println("Retirando dinero...");

                    break;

                case 3:

                    System.out.println("Transfiriendo...");

                    break;

                case 4:

                    System.out.println("Ingresando usuario...");

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