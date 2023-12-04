package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import main.Contadores;

public class GestorDatos {
    /* Tipos de elementos:
       1: Usuarios
       2: Clientes 
       3: Vehiculos */
    
    public static final String USUARIOS = Archivos.getRutaUsuarios();
    public static final String CLIENTES = Archivos.getRutaClientes();
    public static final String VEHICULOS = Archivos.getRutaVehiculos();
    
    public static boolean iniciarSesion(){
        JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema de inventario AzzaCar!");
        
        String username = JOptionPane.showInputDialog(null, "Por favor, indique su nombre de usuario");
        String password = JOptionPane.showInputDialog(null, "Contraseña:");
        
        boolean usuarioValido = validarCredenciales(username, password);
        
        if (usuarioValido){
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña no válidos", "Credenciales incorrectas",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
 
    public static boolean validarCredenciales(String username, String password) {
        try  {
            FileReader archivo = new FileReader(USUARIOS);
            BufferedReader lector = new BufferedReader(archivo);
            String linea = lector.readLine(); // Saltar CSV heading

            while ((linea = lector.readLine()) != null) {
                String usuarioArchivo = linea.split(",")[5];
                String passwordArchivo = linea.split(",")[6];
                
                if (usuarioArchivo.equals(username) && passwordArchivo.equals(password)) {
                    return true;
                }
            }
            
            lector.close();
        } catch (IOException e) {}

        return false;
    }
    
    public static void agregarElemento(int tipoElemento){
        String nuevoElemento;
        String rutaArchivos;
        String elemento;
        String header;

        switch (tipoElemento) {
            case 1:
                rutaArchivos = USUARIOS;
                elemento = "Usuario";
                header = "Nombre,Apellidos,id,correo,telefono,usuario,password";
                
                nuevoElemento = JOptionPane.showInputDialog(null, "Ingrese el nombre:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese los apellidos:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese el número de identificación:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese el correo de usuario:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese el número de teléfono:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese el nombre de usuario:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese la contraseña:");
                break;
            case 2:
                rutaArchivos = CLIENTES;
                elemento = "Cliente";
                header = "Nombre,Apellidos,id,correo,telefono";
                
                nuevoElemento = JOptionPane.showInputDialog(null, "Ingrese el nombre:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese los apellidos:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese el número de identificación:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese el correo de usuario:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese el número de teléfono:");

                GeneradorEscructuras.clientes.push(nuevoElemento.split(","));
                Contadores.addClienteRegistrado();
                break;
            case 3:
                rutaArchivos = VEHICULOS;
                elemento = "Vehículo";
                header = "Color,Año,Cilindraje,Marca,Modelo,Kilometraje,Tipo,Características,Estado,Cliente,Vendedor";
                
                nuevoElemento = JOptionPane.showInputDialog(null, "Ingrese la placa:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese el color:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese el año:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese el cilindraje:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese la marca:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese el modelo:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese el kilometraje:")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese el tipo (suv, sedan, hatchback):")
                        + "," + JOptionPane.showInputDialog(null, "Ingrese las características:")
                        + "," + "disponible"  // Estado por defecto al crear un vehículo
                        + "," + "null"  // Cliente por defecto al crear un vehículo
                        + "," + "null";  // Vendedor por defecto al crear un vehículo
                
                Contadores.addAutosReservados();
                break;
            default:
                nuevoElemento = null;
                rutaArchivos = null;
                elemento = null;
                header = null;
                break;
        }

        try {
            FileWriter escritor = new FileWriter(rutaArchivos);
            
            String listaElementos = extraerElementos(tipoElemento);
            String inputArchivo = header + "\n" + listaElementos + "\n" + nuevoElemento;
            
            escritor.append(inputArchivo);
            escritor.close();
        } catch (IOException e){}
        
        JOptionPane.showMessageDialog(null, elemento + " agregado correctamente");
    }
    
    public static String extraerElementos(int tipoElemento){
        String muestra = "";
        String rutaArchivos;
        
        switch (tipoElemento) {
            case 1:
                rutaArchivos = USUARIOS;
                break;
            case 2:
                rutaArchivos = CLIENTES;
                break;
            case 3:
                rutaArchivos = VEHICULOS;
                break;
            default:
                rutaArchivos = null;
                break;
        }
        
        try  {
            FileReader archivo = new FileReader(rutaArchivos);
            BufferedReader lector = new BufferedReader(archivo);
            String linea = lector.readLine(); // Saltar CSV Header

            while ((linea = lector.readLine()) != null) {
                muestra += linea + "\n";
            }

            lector.close();
        } catch (IOException e) {}
        return muestra.trim();
    }
}