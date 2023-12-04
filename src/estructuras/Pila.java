package estructuras;

public class Pila {
    private NodoPila top;

    public Pila() {
        this.top = null;
    }
    
    public void push(String[] node){
        NodoPila newNode = new NodoPila(node);
        newNode.setSiguiente(top);
        top = newNode;
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
    
    // - - - - - - Metodo para debuggear - - - - - - //
    public void showNodes(){
        if (isEmpty()){
            System.out.println("La lista está vacía");
        } else {
            NodoPila recorrido = this.top;

            while (recorrido != null){
                for (String dato : recorrido.getInfo()){
                    System.out.print(dato + ", ");
                }

                System.out.println();
                recorrido = recorrido.getSiguiente();
            }
        }
    }
}