package estructuras;

public class ListaCircular {
    NodoCircular top;

    public ListaCircular() {
        this.top = null;
    }

    public void push(String[] dato) {
        NodoCircular newNode = new NodoCircular(dato);

        if (top == null) {
            top = newNode;
        } else {
            NodoCircular nodosAnteriores = top.getAnterior();
            
            //Implementacion del nuevo nodo en la estructura
            nodosAnteriores.setSiguiente(newNode);
            newNode.setAnterior(nodosAnteriores);
            
            newNode.setSiguiente(top);
            top.setAnterior(newNode);
        }
    }

    public boolean isEmpty(){
        return top == null;
    }
    
    public void pop(){
        top = top.getSiguiente();
    }
    
    public void cleanPila(){
        while(!isEmpty()){
            pop();
        }
    }
    
    // - - - - - - Moverse entre la lista - - - - - - //
    public void avanzar() {
        if (top != null) {
            top = top.getSiguiente();
        }
    }

    public void retroceder() {
        if (top != null) {
            top = top.getAnterior();
        }
    }
    
    // - - - - - - Metodo para debuggear - - - - - - //
    public void showNodes() {
        if (isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            NodoCircular recorrido = top;
            
            do {
                for (String dato : recorrido.getInfo()){
                    System.out.print(dato + ", ");
                }
                
                System.out.println();
                recorrido = recorrido.getSiguiente();
            } while (recorrido != top);
        }
    }
}
