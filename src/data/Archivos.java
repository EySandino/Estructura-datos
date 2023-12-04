package data;

public class Archivos {
    private final static String ARCHIVO_USUARIOS = "src\\files\\users.txt";
    private final static String ARCHIVO_CLIENTES = "src\\files\\clientes.txt";
    private final static String ARCHIVO_VEHICULOS = "src\\files\\vehiculos.txt";
    
    public static String getRutaUsuarios(){
        return ARCHIVO_USUARIOS;
    }

    public static String getRutaClientes() {
        return ARCHIVO_CLIENTES;
    }
    
    public static String getRutaVehiculos() {
        return ARCHIVO_VEHICULOS;
    }
}
