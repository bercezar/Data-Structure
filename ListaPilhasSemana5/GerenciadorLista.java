import java.util.Scanner;

public class GerenciadorLista {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a capacidade da lista: ");
        int capacidade = scanner.nextInt();
        ListaArray lista = new ListaArray(capacidade);

        while (true) {
            int opcao = exibirMenu(scanner);
            processarOpcao(opcao, lista, scanner);
        }
    }

    private static int exibirMenu(Scanner scanner) {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Adicionar elemento");
        System.out.println("2 - Adicionar elemento em posição específica");
        System.out.println("3 - Remover elemento");
        System.out.println("4 - Imprimir lista");
        System.out.println("5 - Sair");
        return scanner.nextInt();
    }

    private static void processarOpcao(int opcao, ListaArray lista, Scanner scanner) {
        switch (opcao) {
            case 1:
                adicionarElemento(lista, scanner);
                break;
            case 2:
                adicionarElementoPosicao(lista, scanner);
                break;
            case 3:
                removerElemento(lista, scanner);
                break;
            case 4:
                lista.imprimirLista();
                break;
            case 5:
                System.out.println("Saindo...");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void adicionarElemento(ListaArray lista, Scanner scanner) {
        System.out.print("Digite o elemento a adicionar: ");
        int elemento = scanner.nextInt();
        lista.adicionar(elemento);
    }

    private static void adicionarElementoPosicao(ListaArray lista, Scanner scanner) {
        System.out.print("Digite o elemento a adicionar: ");
        int elemento = scanner.nextInt();
        System.out.print("Digite a posição: ");
        int posicao = scanner.nextInt();
        lista.adicionar(elemento, posicao);
    }

    private static void removerElemento(ListaArray lista, Scanner scanner) {
        System.out.print("Digite a posição a remover: ");
        int posicao = scanner.nextInt();
        lista.remover(posicao);
    }
}

class ListaArray {
    private int[] array;
    private int tamanho;

    public ListaArray(int capacidade) {
        this.array = new int[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(int elemento) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        array[tamanho++] = elemento;
    }

    public void adicionar(int elemento, int posicao) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        if (posicao < 0 || posicao > tamanho) {
            System.out.println("Erro: Posição inválida!");
            return;
        }
        for (int i = tamanho; i > posicao; i--) {
            array[i] = array[i - 1];
        }
        array[posicao] = elemento;
        tamanho++;
    }

    public void remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Erro: Posição inválida!");
            return;
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }
        tamanho--;
    }

    public void imprimirLista() {
        System.out.print("Lista: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
