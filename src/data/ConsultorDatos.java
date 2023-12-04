package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ConsultorDatos {
    /* Tipos de elementos:
       1: Usuarios
       2: Clientes 
       3: Vehiculos */
    
    public static final String USUARIOS = Archivos.getRutaUsuarios();
    public static final String CLIENTES = Archivos.getRutaClientes();
    public static final String VEHICULOS = Archivos.getRutaVehiculos();
    
    public static void consultarDetallesUsuario(){
        String detallesCliente = "";
        boolean clienteEncontrado = false;
        String inputUsuario = JOptionPane.showInputDialog(null, "Digite el número de identificación del cliente que deasea consultar:");
        
        try  {
            FileReader archivo = new FileReader(CLIENTES);
            BufferedReader lector = new BufferedReader(archivo);
            String linea = lector.readLine(); // Saltar CSV Header

            while ((linea = lector.readLine()) != null) {
                if (linea.split(",")[2].equals(inputUsuario)){
                    clienteEncontrado = true;
                    detallesCliente = linea;
                    break;
                }
            }
            
            lector.close();
        } catch (IOException e) {}
        
        if (clienteEncontrado) {
            JOptionPane.showMessageDialog(null, "Detalles del cliente solicitado:"
                    + "\n" + "Nombre Completo: " + detallesCliente.split(",")[0] + " " + detallesCliente.split(",")[1]
                    + "\n" + "Número de identificación: " + detallesCliente.split(",")[2]
                    + "\n" + "Correo electrónico: " + detallesCliente.split(",")[3]
                    + "\n" + "Número de teléfono: " + detallesCliente.split(",")[4]);
        } else {
            JOptionPane.showMessageDialog(null, "Número de identificación incorreco... Intente nuevamente.", "Entrada inválida",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void consultarClienteID(){
        int contador = 0;
        String listaClientes = "";
        
        try {
            FileReader archivo = new FileReader(CLIENTES);
            BufferedReader lector = new BufferedReader(archivo);
            String linea = lector.readLine(); // Saltar CSV Header

            while ((linea = lector.readLine()) != null) {
                listaClientes += contador + ") Nombre: " + linea.split(",")[0] + ", id: " + linea.split(",")[2] + "\n";
                contador++;
            }
            
            if (contador != 0) {
                JOptionPane.showMessageDialog(null, listaClientes.trim());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron clientes existentes", "Lista Vacia!",JOptionPane.ERROR_MESSAGE);
            }
            
            lector.close();
        } catch (IOException e) {}
    }
    
    public static void consultarDetallesVehiculo() {
        String detallesVehiculo = "";
        boolean vehiculoEncontrado = false;
        String inputPlaca = JOptionPane.showInputDialog(null, "Digite la placa del vehículo que desea consultar:");

        try {
            FileReader archivo = new FileReader(VEHICULOS);
            BufferedReader lector = new BufferedReader(archivo);
            String linea = lector.readLine(); // Saltar CSV Header

            while ((linea = lector.readLine()) != null) {
                if (linea.split(",")[0].equals(inputPlaca)) {
                    vehiculoEncontrado = true;
                    detallesVehiculo = linea;
                    break;
                }
            }

            lector.close();
        } catch (IOException e) {}

        if (vehiculoEncontrado) {
            JOptionPane.showMessageDialog(null, "Detalles del vehículo solicitado:"
                    + "\n" + "Placa: " + detallesVehiculo.split(",")[0]
                    + "\n" + "Color: " + detallesVehiculo.split(",")[1]
                    + "\n" + "Año: " + detallesVehiculo.split(",")[2]
                    + "\n" + "Cilindraje: " + detallesVehiculo.split(",")[3]
                    + "\n" + "Marca: " + detallesVehiculo.split(",")[4]
                    + "\n" + "Modelo: " + detallesVehiculo.split(",")[5]
                    + "\n" + "Kilometraje: " + detallesVehiculo.split(",")[6]
                    + "\n" + "Tipo: " + detallesVehiculo.split(",")[7]
                    + "\n" + "Características: " + detallesVehiculo.split(",")[8]
                    + "\n" + "Estado: " + detallesVehiculo.split(",")[9]
                    + "\n" + "Cliente: " + detallesVehiculo.split(",")[10]
                    + "\n" + "Vendedor: " + detallesVehiculo.split(",")[11]);
        } else {
            JOptionPane.showMessageDialog(null, "Placa incorrecta. Intente nuevamente.", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void consultarListaVehiculos() {
        int contador = 0;
        String listaVehiculos = "";

        try {
            FileReader archivo = new FileReader(VEHICULOS);
            BufferedReader lector = new BufferedReader(archivo);
            String linea = lector.readLine();

            while ((linea = lector.readLine()) != null) {
                listaVehiculos += contador + ") Placa: " + linea.split(",")[0] + ", Estado: " + linea.split(",")[9] + "\n";
                contador++;
            }

            if (contador != 0) {
                JOptionPane.showMessageDialog(null, listaVehiculos.trim());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron vehículos existentes", "Lista Vacia!", JOptionPane.ERROR_MESSAGE);
            }

            lector.close();
        } catch (IOException e) {}
    }
}
