package data;

import estructuras.ListaCircular;
import estructuras.Pila;
import javax.swing.JOptionPane;

public class GeneradorEscructuras {
    public static Pila clientes = new Pila();
    public static ListaCircular autos = new ListaCircular();
    
    public static void generarPilaClientes() {
        String[] muestraDatos = GestorDatos.extraerElementos(2).split("\n");
        
        if (muestraDatos.length != 0){
            for (String cliente : muestraDatos) {
                clientes.push(cliente.split(","));
            }
            
            clientes.showNodes();
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentran clientes registrados!", "Lista Vacia!",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void generarListaVehiculos() {
        String[] muestraDatos = GestorDatos.extraerElementos(3).split("\n");
        
        if (muestraDatos.length != 0){
            for (String auto : muestraDatos) {
                autos.push(auto.split(","));
            }
            
            autos.showNodes();
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentran autos registrados!", "Lista Vacia!",JOptionPane.ERROR_MESSAGE);
        }
    }
}