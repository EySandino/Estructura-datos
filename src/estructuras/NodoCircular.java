package estructuras;

class NodoCircular {
    private String[] info;
    private NodoCircular siguiente;
    private NodoCircular anterior;

    public NodoCircular(String[] info) {
        this.info = info;
        this.siguiente = this;
        this.anterior = this;
    }

    public String[] getInfo() {
        return info;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

    public NodoCircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircular siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCircular getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCircular anterior) {
        this.anterior = anterior;
    }
}
