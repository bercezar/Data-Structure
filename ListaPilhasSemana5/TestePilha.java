import java.util.Scanner;

public class TestePilha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Pilha pilha = criarPilha(scanner);

        while (true) {
            int opcao = exibirMenu(scanner);
            processarOpcao(opcao, pilha, scanner);
        }
    }

    private static Pilha criarPilha(Scanner scanner) {
        System.out.print("Digite a capacidade da pilha: ");
        int capacidade = scanner.nextInt();
        return new Pilha(capacidade);
    }

    private static int exibirMenu(Scanner scanner) {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Empilhar elemento");
        System.out.println("2 - Desempilhar elemento");
        System.out.println("3 - Consultar topo");
        System.out.println("4 - Imprimir pilha");
        System.out.println("5 - Sair");
        return scanner.nextInt();
    }

    private static void processarOpcao(int opcao, Pilha pilha, Scanner scanner) {
        switch (opcao) {
            case 1:
                empilharElemento(pilha, scanner);
                break;
            case 2:
                desempilharElemento(pilha);
                break;
            case 3:
                consultarTopo(pilha);
                break;
            case 4:
                pilha.imprimirPilha();
                break;
            case 5:
                System.out.println("Saindo...");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void empilharElemento(Pilha pilha, Scanner scanner) {
        System.out.print("Digite o elemento a empilhar: ");
        int elemento = scanner.nextInt();
        pilha.push(elemento);
    }

    private static void desempilharElemento(Pilha pilha) {
        int removido = pilha.pop();
        if (removido != -1) {
            System.out.println("Elemento removido: " + removido);
        }
    }

    private static void consultarTopo(Pilha pilha) {
        int topo = pilha.peek();
        if (topo != -1) {
            System.out.println("Topo da pilha: " + topo);
        }
    }
}

class Pilha {
    private int topo;
    private int[] elementos;
    private int capacidade;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.topo = -1; 
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == capacidade - 1;
    }

    public void push(int elemento) {
        if (isFull()) {
            System.out.println("Erro: Pilha cheia!");
            return;
        }
        elementos[++topo] = elemento;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo];
    }

    public void imprimirPilha() {
        System.out.print("Pilha: ");
        for (int i = 0; i <= topo; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
}
