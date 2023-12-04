package estructuras;

public class NodoPila {
    private String[] info;
    private NodoPila siguiente;

    public NodoPila(String[] valor) {
        this.info = valor;
        this.siguiente = null;
    }

    public String[] getInfo() {
        return info;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
}