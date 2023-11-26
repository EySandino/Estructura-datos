package main;

public class Contadores {
    private static int AutosVendidos = 0;
    private static int AutosReservados = 0;
    private static int AutosDisponibles = 0;
    private static int ClientesRegistrados = 0;
    private static int ComprasClientes = 0;
    private static int ReservasClientes = 0;

    public static int getAutosVendidos() {
        return AutosVendidos;
    }

    public static void addAutosVendidos() {
        AutosVendidos++;
    }

    public static int getAutosReservados() {
        return AutosReservados;
    }

    public static void addAutosReservados() {
        AutosReservados++;
    }

    public static int getAutosDisponibles() {
        return AutosDisponibles;
    }

    public static void addAutosDisponibles() {
        AutosDisponibles++;
    }
    
    public static void removeAuto() {
        AutosDisponibles--;
    }

    public static int getClientesRegistrados() {
        return ClientesRegistrados;
    }

    public static void addClientesRegistrados() {
        ClientesRegistrados++;
    }
    
    public static void removeCliente() {
        ClientesRegistrados--;
    }

    public static int getComprasClientes() {
        return ComprasClientes;
    }

    public static void addComprasClientes() {
        ComprasClientes++;
    }

    public static int getClientesReservaron() {
        return ReservasClientes;
    }

    public static void addClientesReservaron() {
        ReservasClientes++;
    }
}
