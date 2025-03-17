import java.util.Scanner;

public class TesteListaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaArrayString lista = criarLista(scanner);

        while (true) {
            int opcao = exibirMenu(scanner);
            processarOpcao(opcao, lista, scanner);
        }
    }

    private static ListaArrayString criarLista(Scanner scanner) {
        System.out.print("Digite a capacidade da lista: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        return new ListaArrayString(capacidade);
    }

    private static int exibirMenu(Scanner scanner) {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Adicionar nome");
        System.out.println("2 - Remover nome por posição");
        System.out.println("3 - Buscar nome");
        System.out.println("4 - Imprimir lista");
        System.out.println("5 - Sair");
        return scanner.nextInt();
    }

    private static void processarOpcao(int opcao, ListaArrayString lista, Scanner scanner) {
        scanner.nextLine(); // Consumir a quebra de linha após a escolha da opção
        switch (opcao) {
            case 1:
                adicionarNome(lista, scanner);
                break;
            case 2:
                removerNome(lista, scanner);
                break;
            case 3:
                buscarNome(lista, scanner);
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

    private static void adicionarNome(ListaArrayString lista, Scanner scanner) {
        System.out.print("Digite o nome a adicionar: ");
        String nome = scanner.nextLine();
        lista.adicionar(nome);
    }

    private static void removerNome(ListaArrayString lista, Scanner scanner) {
        System.out.print("Digite a posição a remover: ");
        int posicao = scanner.nextInt();
        lista.remover(posicao);
    }

    private static void buscarNome(ListaArrayString lista, Scanner scanner) {
        System.out.print("Digite o nome a buscar: ");
        String nome = scanner.nextLine();
        if (lista.buscar(nome)) {
            System.out.println("Nome encontrado na lista.");
        } else {
            System.out.println("Nome não encontrado.");
        }
    }
}

class ListaArrayString {
    private String[] array;
    private int tamanho;

    public ListaArrayString(int capacidade) {
        this.array = new String[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(String elemento) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        array[tamanho++] = elemento;
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

    public boolean buscar(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i].equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public void imprimirLista() {
        System.out.print("Lista de Nomes: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
