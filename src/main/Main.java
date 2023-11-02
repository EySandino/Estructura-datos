package main;

import javax.swing.JOptionPane;
import security.Gestor;
import security.InfoEmpresa;
public class Main {

    public static void main(String[] args) {
        boolean validacion;
        do{
            validacion = Gestor.iniciarSesion();
        }while (!validacion);
        
        menuOpciones();
    }

    private static void menuOpciones() {
        String opcionUsuario;

        do {
            String[] opciones = {"Opción 1", "Opción 2", "Opción 3", "Salir"};
            opcionUsuario = JOptionPane.showInputDialog(null, "Bienvenido al sistema de inventario AzzaCar"
                    + "\nSeleccione una opción:"
                    + "\n1) Crear Usuario"
                    + "\n2) Datos de la empresa"
                    + "\n3) Clientes"
                    + "\n"
                    + "\n0) Salir");

            switch (opcionUsuario) {
                case "0":
                    JOptionPane.showMessageDialog(null, "Gracias por su visita!");
                    System.exit(0);
                    break;
                case "1":
                    Gestor.agregarElemento(1);
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Datos de la empresa:"
                            + "\n" + "Nombre: " + InfoEmpresa.getNombre()
                            + "\n" + "Teléfono: " + InfoEmpresa.getTelefono()
                            + "\n" + "Dirección: " + InfoEmpresa.getDireccion());
                    break;
                case "3":
                    menuClientes();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }

        }while (true);
    }
    
    private static void menuClientes(){
        String opcionUsuario;
        
        do {
            opcionUsuario = JOptionPane.showInputDialog("Seleccione una opción:\n"
                    + "1. Crear cliente\n"
                    + "2. Consultar lista de clientes\n"
                    + "3. Datos del cliente\n"
                    + "0. Salir");
            
            switch (opcionUsuario) {
                case "1":
                    Gestor.agregarElemento(2);
                    break;
                case "2":
                    Gestor.clienteID();
                    break;
                case "3":
                    Gestor.consultarDetallesUsuario();
                    break;
                case "0":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (!"0".equals(opcionUsuario));
    }
}
    