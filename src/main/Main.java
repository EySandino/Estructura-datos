package main;

import data.GeneradorEscructuras;
import data.GestorDatos;
public class Main {

    public static void main(String[] args) {
        GeneradorEscructuras.generarPilaClientes();
        GeneradorEscructuras.generarListaVehiculos();
        
        boolean validacion;
        
        do{
            validacion = GestorDatos.iniciarSesion();
        } while (!validacion);
        
        Menus.opcionesPrincipales();
    }
}