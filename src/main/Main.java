package main;

import security.Gestor;
public class Main {

    public static void main(String[] args) {
        boolean validacion;
        
        do{
            validacion = Gestor.iniciarSesion();
        } while (!validacion);
        
        Menus.menuOpciones();
    }
}