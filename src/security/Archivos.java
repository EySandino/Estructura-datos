package security;

public class Archivos {
    private final static String ARCHIVO_USUARIOS = "src\\files\\users.txt";
    private final static String ARCHIVO_CLIENTES = "src\\files\\clientes.txt";
    
    public static String rutaUsuarios(){
        return ARCHIVO_USUARIOS;
    }

    public static String rutaClientes() {
        return ARCHIVO_CLIENTES;
    }
}
