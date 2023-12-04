package main;

public class Contadores {
    private static int ClientesRegistrados = 0;
    private static int AutosVendidos = 0;
    private static int AutosReservados = 0;
    private static int AutosDisponibles = 0;

    //- - - - - - - - - - - - - Getters - - - - - - - - - - - - -//
    
     public static int getClientesRegistrados() {
        return ClientesRegistrados;
    }
    
    public static int getAutosVendidos() {
        return AutosVendidos;
    }

    public static int getAutosReservados() {
        return AutosReservados;
    }
    
    public static int getAutosDisponibles() {
        return AutosDisponibles;
    }
    
    //- - - - - - - - - - - - - Adders - - - - - - - - - - - - -//
    
    public static void addClienteRegistrado() {
        ClientesRegistrados++;
    }
    
    public static void addAutosVendidos() {
        AutosVendidos++;
    }

    public static void addAutosReservados() {
        AutosReservados++;
    }

    public static void addAutosDisponibles() {
        AutosDisponibles++;
    }
    
    //- - - - - - - - - - - - - Removers - - - - - - - - - - - - -//

    public static void removeClienteRegistrado() {
        ClientesRegistrados--;
    }
    
    public static void removeAutoDisponible() {
        AutosDisponibles--;
    }
    





}
