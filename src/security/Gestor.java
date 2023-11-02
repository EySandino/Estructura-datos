package security;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Gestor {
    /* Tipos de elementos:
       1: Usuarios
       2: Clientes */
    
    public static final String USUARIOS = Archivos.rutaUsuarios();
    public static final String CLIENTES = Archivos.rutaClientes();
    
    public static boolean iniciarSesion(){
        JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema de inventario AzzaCar!");
        
        String username = JOptionPane.showInputDialog(null, "Por favor indique su nombre de usuario");
        String password = JOptionPane.showInputDialog(null, "Contraseña:");
        
        boolean usuarioValido = validarCredenciales(username, password);
        
        if (usuarioValido){
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña no validos", "Credenciales incorrectas",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
 
    public static boolean validarCredenciales(String username, String password) {
        try  {
            FileReader archivo = new FileReader(Archivos.rutaUsuarios());
            BufferedReader lector = new BufferedReader(archivo);
            String linea = lector.readLine();

            while ((linea = lector.readLine()) != null) {
                String usuarioArchivo = linea.split(",")[5];
                String passwordArchivo = linea.split(",")[6];
                
                if (usuarioArchivo.equals(username) && passwordArchivo.equals(password)) {
                    lector.close();
                    return true;
                }
                else{
                    lector.close();
                }
            }
        }
        catch (IOException e) {}
        return false;
    }
    
    public static void consultarDetallesUsuario(){
        String detallesCliente = "";
        boolean clienteEncontrado = false;
        String inputUsuario = JOptionPane.showInputDialog(null, "Digite el número de identificación del cliente que deasea consultar:");
        
        try  {
            FileReader archivo = new FileReader(Archivos.rutaClientes());
            BufferedReader lector = new BufferedReader(archivo);
            String linea = lector.readLine();

            while ((linea = lector.readLine()) != null) {
                if (linea.split(",")[2].equals(inputUsuario)){
                    clienteEncontrado = true;
                    detallesCliente = linea;
                    break;
                }
            }

            lector.close();
        }
        catch (IOException e) {}
        
        if (clienteEncontrado) {
            JOptionPane.showMessageDialog(null, "Detalles del cliente solicitado:"
                    + "\n" + "Nombre Completo: " + detallesCliente.split(",")[0] + " " + detallesCliente.split(",")[1]
                    + "\n" + "Número de identificación: " + detallesCliente.split(",")[2]
                    + "\n" + "Correo electrónico: " + detallesCliente.split(",")[3]
                    + "\n" + "Número de teléfono: " + detallesCliente.split(",")[4]);
        }
        else {
            JOptionPane.showMessageDialog(null, "Número de identificación incorreco... Intente nuevamente.", "Entrada inválida",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void clienteID(){
        int contador = 0;
        String listaClientes = "";
        
        try {
            FileReader archivo = new FileReader(Archivos.rutaClientes());
            BufferedReader lector = new BufferedReader(archivo);
            String linea = lector.readLine();

            while ((linea = lector.readLine()) != null) {
                contador++;
                listaClientes += contador + ") Nombre: " + linea.split(",")[0] + ", id: " + linea.split(",")[2] + "\n";
            }
            
            if (contador != 0) {
                JOptionPane.showMessageDialog(null, listaClientes.trim());
            } 
            else {
                JOptionPane.showMessageDialog(null, "No se encontraron clientes existentes", "Lista Vacia!",JOptionPane.ERROR_MESSAGE);
            }
            
            lector.close();
        }
        catch (IOException e) {}
    }
    
    public static void agregarElemento(int tipoElemento){
        String nuevoElemento = "";
        String rutaArchivos = "";
        String elemento = "";
        
        if (tipoElemento == 1) {
            rutaArchivos = Archivos.rutaUsuarios();
            elemento = "Usuario";
            
            nuevoElemento += JOptionPane.showInputDialog(null, "Ingrese el nombre:")
                    + "," + JOptionPane.showInputDialog(null, "Ingrese los apellidos:")
                    + "," + JOptionPane.showInputDialog(null, "Ingrese el número de identificación:")
                    + "," + JOptionPane.showInputDialog(null, "Ingrese el correo de usuario:")
                    + "," + JOptionPane.showInputDialog(null, "Ingrese el número de teléfono:")
                    + "," + JOptionPane.showInputDialog(null, "Ingrese el nombre de usuario:")
                    + "," + JOptionPane.showInputDialog(null, "Ingrese la contraseña:");
        } 
        else if (tipoElemento == 2){
            rutaArchivos = Archivos.rutaClientes();
            elemento = "Cliente";
            
            nuevoElemento += JOptionPane.showInputDialog(null, "Ingrese el nombre:")
                    + "," + JOptionPane.showInputDialog(null, "Ingrese los apellidos:")
                    + "," + JOptionPane.showInputDialog(null, "Ingrese el número de identificación:")
                    + "," + JOptionPane.showInputDialog(null, "Ingrese el correo de usuario:")
                    + "," + JOptionPane.showInputDialog(null, "Ingrese el número de teléfono:");
        }
        
        try  {
            String listaElementos = extraerElementos(1);
            
            FileWriter escritor = new FileWriter(rutaArchivos);
            
            escritor.append(listaElementos + "\n" + nuevoElemento);
            escritor.close();

            JOptionPane.showMessageDialog(null, elemento + " agregado correctamente");
        }
        catch (IOException e) {}
    }
    
    private static String extraerElementos(int tipoElemento){
        String muestra = "";
        String rutaArchivos = "";
        
        if (tipoElemento == 1) {
            rutaArchivos = Archivos.rutaUsuarios();
        } 
        else if (tipoElemento == 2){
            rutaArchivos = Archivos.rutaClientes();
        }
        
        try  {
            FileReader archivo = new FileReader(rutaArchivos);
            BufferedReader lector = new BufferedReader(archivo);
            String linea;

            while ((linea = lector.readLine()) != null) {
                muestra += linea + "\n";
            }
            
            lector.close();
        }
        catch (IOException e) {}
        
        return muestra.trim();
    }
}
