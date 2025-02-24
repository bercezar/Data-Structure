class Nodo {
    int dado;
    Nodo proximo;

    public Nodo(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

class PilhaEncadeada {
    private Nodo topo;
    private int tamanho;

    public PilhaEncadeada() {
        this.topo = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(int elemento) {
        Nodo novoNodo = new Nodo(elemento);
        novoNodo.proximo = topo;
        topo = novoNodo;
        tamanho++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        int valor = topo.dado;
        topo = topo.proximo;
        tamanho--;
        return valor;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return topo.dado;
    }

    public int size() {
        return tamanho;
    }

    public void imprimirPilha() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia.");
            return;
        }
        Nodo temp = topo;
        System.out.print("Pilha: ");
        while (temp != null) {
            System.out.print(temp.dado + " ");
            temp = temp.proximo;
        }
        System.out.println();
    }
}

public class TestePilhaEncadeada {
    public static void main(String[] args) {
        PilhaEncadeada pilha = new PilhaEncadeada();
        pilha.push(5);
        pilha.push(15);
        pilha.push(25);
        pilha.imprimirPilha();

        System.out.println("Tamanho da pilha: " + pilha.size());
        System.out.println("Topo da pilha: " + pilha.peek());
        System.out.println("Removendo: " + pilha.pop());

        pilha.imprimirPilha();
        System.out.println("Tamanho da pilha: " + pilha.size());
    }
}
