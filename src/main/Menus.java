package main;

import javax.swing.JOptionPane;
import data.ConsultorDatos;
import data.GestorDatos;
import data.InfoEmpresa;


public class Menus {
    public static void opcionesPrincipales() {
        String opcionUsuario;

        do {
            opcionUsuario = JOptionPane.showInputDialog(null, "Bienvenido al sistema de inventario AzzaCar"
                    + "\nMenú Principal\nSeleccione una opción:"
                    + "\n1) Crear Usuario"
                    + "\n2) Consultar reportes"
                    + "\n3) Clientes"
                    + "\n4) Vehículos"
                    + "\n5) Info"
                    + "\n0) Salir");

            switch (opcionUsuario) {
                case "1":
                    GestorDatos.agregarElemento(1);
                    break;
                case "2":
                    menuReportes();
                    break;
                case "3":
                    menuClientes();
                    break;
                case "4":
                    menuVehiculos();
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Datos de la empresa:"
                            + "\n" + "Nombre: " + InfoEmpresa.getNombre()
                            + "\n" + "Teléfono: " + InfoEmpresa.getTelefono()
                            + "\n" + "Dirección: " + InfoEmpresa.getDireccion());
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Gracias por su visita!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (true);
    }
    
    private static void menuClientes(){
        String opcionUsuario;
        
        do {
            opcionUsuario = JOptionPane.showInputDialog("Menú de clientes\nSeleccione una opción:\n"
                    + "1) Crear cliente\n"
                    + "2) Consultar lista de clientes\n"
                    + "3) Datos del cliente\n"
                    + "0) Salir");
            
            switch (opcionUsuario) {
                case "1":
                    GestorDatos.agregarElemento(2);
                    break;
                case "2":
                    ConsultorDatos.consultarClienteID();
                    break;
                case "3":
                    ConsultorDatos.consultarDetallesUsuario();
                    break;
                case "0":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (!"0".equals(opcionUsuario));
    }
    
    private static void menuVehiculos() {
        String opcionUsuario;

        do {
            opcionUsuario = JOptionPane.showInputDialog("Seleccione una opción:\n"
                    + "1. Crear vehículo\n"
                    + "2. Consultar lista de vehículos\n"
                    + "3. Datos del vehículo\n"
                    + "0. Salir");

            switch (opcionUsuario) {
                case "1":
                    GestorDatos.agregarElemento(3);  // Tipo de elemento 3 para vehículos
                    break;
                case "2":
                    ConsultorDatos.consultarListaVehiculos();
                    break;
                case "3":
                    ConsultorDatos.consultarDetallesVehiculo();
                    break;
                case "0":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (!"0".equals(opcionUsuario));
    }
    
    private static void menuReportes(){
        String opcionUsuario;

        int opcion;

        do {
            opcionUsuario = JOptionPane.showInputDialog("Menú de reportes\nSeleccione una opción:\n"
                    + "1) Reporte de autos\n" //Cantidad total de autos vendidos, reservados y disponibles
                    + "2) Reporte de clientes\n" //Cantidad de clientes registrados, clientes que compraron un vehículo, clientes que reservaron un vehículo
                    + "3) Reporte de ventas\n" //Cantidad de vehículos vendidos por vendedor y cantidad de vehículos reservados por vendedor
                    + "4) Mejores ventas\n"  //Top 3 de clientes que más compraron vehículos
                    + "0) Salir");

            switch (opcionUsuario) {
                case "1":
                    JOptionPane.showMessageDialog(null,
                              "Total de autos vendidos: " + Contadores.getAutosVendidos() + "\n"
                            + "Total de autos reservados: " + Contadores.getAutosReservados() + "\n"
                            + "Total de autos disponibles: " + Contadores.getAutosDisponibles() + "\n");
                    break;
                case "2":
                    menuReporteClientes();
                    break;
                case "3":
                    // Lógica para el top 3 de clientes que más compraron vehículos
                    System.out.println("Opción 3 seleccionada");
                    break;
                case "4":
                    // Lógica para la cantidad de vehículos vendidos por vendedor
                    System.out.println("Opción 4 seleccionada");
                    break;
                case "5":
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (!"0".equals(opcionUsuario));
    }
    
    private static void menuReporteClientes() {
        String opcionUsuario;
       
        int opcion;

        do {
            opcionUsuario = JOptionPane.showInputDialog("Menú de reportes de clientes\nSeleccione una opción:\n"
                    + "1) Clientes registrados en el sistema\n"
                    + "2) Clientes que han comprado vehículos\n"
                    + "3) Clientes que han reservado vehículos\n"
                    + "0) Salir");

            switch (opcionUsuario) {
                case "1":
                    JOptionPane.showMessageDialog(null, "La cantidad de clientes registrados en el sistema es de: " + Contadores.getClientesRegistrados());
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Lista de clientes que han comprado vehículos");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Lista de clientes que han reservado vehículos");
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (!"0".equals(opcionUsuario));
    }
}
